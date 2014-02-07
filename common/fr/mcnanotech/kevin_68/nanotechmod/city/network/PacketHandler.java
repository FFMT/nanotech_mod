package fr.mcnanotech.kevin_68.nanotechmod.city.network;

import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntitySpotLight;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.EnumMap;

import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.FMLEmbeddedChannel;
import cpw.mods.fml.common.network.FMLIndexedMessageToMessageCodec;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.internal.FMLProxyPacket;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Thanks to @author cpw
 */
public enum PacketHandler
{
	INSTANCE;

	/**
	 * Our channel "pair" from {@link NetworkRegistry}
	 */
	private EnumMap<Side, FMLEmbeddedChannel> channels;

	/**
	 * Make our packet handler, and add an {@link IronChestCodec} always
	 */
	private PacketHandler()
	{
		// request a channel pair for IronChest from the network registry
		// Add the IronChestCodec as a member of both channel pipelines
		this.channels = NetworkRegistry.INSTANCE.newChannel("NTMC|SpotLight", new SpotLightCodec());
		if(FMLCommonHandler.instance().getSide() == Side.CLIENT)
		{
			addClientHandler();
		}
	}

	/**
	 * This is only called on the client side - it adds an
	 * {@link IronChestMessageHandler} to the client side pipeline, since the
	 * only place we expect to <em>handle</em> messages is on the client.
	 */
	@SideOnly(Side.CLIENT)
	private void addClientHandler()
	{
		FMLEmbeddedChannel clientChannel = this.channels.get(Side.CLIENT);
		// These two lines find the existing codec (Ironchestcodec) and insert
		// our message handler after it
		// in the pipeline
		String codec = clientChannel.findChannelHandlerNameForType(SpotLightCodec.class);
		clientChannel.pipeline().addAfter(codec, "ClientHandler", new SpotLightMessageHandler());
	}

	/**
	 * This class simply handles the {@link IronChestMessage} when it's received
	 * at the client side It can contain client only code, because it's only run
	 * on the client.
	 * 
	 * @author cpw
	 * 
	 */
	private static class SpotLightMessageHandler extends SimpleChannelInboundHandler<SpotLightMessage>
	{
		@Override
		protected void channelRead0(ChannelHandlerContext ctx, SpotLightMessage msg) throws Exception
		{
			World world = FMLClientHandler.instance().getClient().theWorld;
			TileEntity te = world.getTileEntity(msg.x, msg.y, msg.z);
			if(te instanceof TileEntitySpotLight)
			{
				TileEntitySpotLight tile = (TileEntitySpotLight)te;
				tile.setRedValue(msg.red);
			}
		}
	}

	/**
	 * This is our "message". In fact, {@link FMLIndexedMessageToMessageCodec}
	 * can handle many messages on the same channel at once, using a
	 * discriminator byte. But for IronChest, we only need the one message, so
	 * we have just this.
	 * 
	 * @author cpw
	 * 
	 */
	public static class SpotLightMessage
	{
		int x;
		int y;
		int z;
		int red;
		
	}

	/**
	 * This is the codec that automatically transforms the
	 * {@link FMLProxyPacket} which wraps the client and server custom payload
	 * packets into a message we care about.
	 * 
	 * @author cpw
	 * 
	 */
	private class SpotLightCodec extends FMLIndexedMessageToMessageCodec<SpotLightMessage>
	{
		/**
		 * We register our discriminator bytes here. We only have the one type,
		 * so we only register one.
		 */
		public SpotLightCodec()
		{
			addDiscriminator(0, SpotLightMessage.class);
		}

		@Override
		public void encodeInto(ChannelHandlerContext ctx, SpotLightMessage msg, ByteBuf target) throws Exception
		{
			target.writeInt(msg.x);
			target.writeInt(msg.y);
			target.writeInt(msg.z);
			target.writeInt(msg.red);
		}

		@Override
		public void decodeInto(ChannelHandlerContext ctx, ByteBuf dat, SpotLightMessage msg)
		{
			msg.x = dat.readInt();
			msg.y = dat.readInt();
			msg.z = dat.readInt();
			msg.red = dat.readInt();
		}

	}

	/**
	 * This is a utility method called to transform a packet from a custom
	 * packet into a "system packet". We're called from
	 * {@link TileEntity#getDescriptionPacket()} in this case, but there are
	 * others. All network packet methods in minecraft have been adapted to
	 * handle {@link FMLProxyPacket} but general purpose objects can't be
	 * handled sadly.
	 * 
	 * This method uses the {@link IronChestCodec} to transform a custom packet
	 * {@link IronChestMessage} into an {@link FMLProxyPacket} by using the
	 * utility method {@link FMLEmbeddedChannel#generatePacketFrom(Object)} on
	 * the channel to do exactly that.
	 * 
	 * @param tileEntityIronChest
	 * @return
	 */
	public static Packet getPacket(TileEntitySpotLight tileEntity)
	{
		SpotLightMessage msg = new SpotLightMessage();
		msg.x = tileEntity.xCoord;
		msg.y = tileEntity.yCoord;
		msg.z = tileEntity.zCoord;
		msg.red = tileEntity.getRedValue();
		return INSTANCE.channels.get(Side.SERVER).generatePacketFrom(msg);
	}
}
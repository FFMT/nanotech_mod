package fr.mcnanotech.kevin_68.nanotechmod.main.network;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerJumper;
import fr.mcnanotech.kevin_68.nanotechmod.main.container.ContainerSmoker;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;
import fr.mcnanotech.kevin_68.nanotechmod.main.items.ItemLightSaber;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntityJumper;
import fr.mcnanotech.kevin_68.nanotechmod.main.tileentity.TileEntitySmoker;

public class PacketHandler implements IPacketHandler
{
	@Override
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
	{
		EntityPlayer playerSender = (EntityPlayer)player;

		if(packet.channel.equals("NTM|smoker"))
		{
			handleSmokerPacket(packet, playerSender);
		}
		else if(packet.channel.equals("NTM|jumper"))
		{
			handleJumperPacket(packet, playerSender);
		}
		else if(packet.channel.equals("NTM|saber"))
		{
			handleSaberPacket(packet, playerSender);
		}
	}

	private void handleSmokerPacket(Packet250CustomPayload packet, EntityPlayer player)
	{
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
		int smokePower;
		try
		{
			data = new DataInputStream(new ByteArrayInputStream(packet.data));
			smokePower = data.readInt();
			ContainerSmoker containersmoker = (ContainerSmoker)player.openContainer;
			TileEntitySmoker tileSmoker = containersmoker.getSmoker();
			tileSmoker.setSmokeInt(smokePower);
			player.worldObj.markBlockForUpdate(tileSmoker.xCoord, tileSmoker.yCoord, tileSmoker.zCoord);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			NanotechMod.nanoLog.severe("Failed to handle smoker packet");
		}
	}

	private void handleJumperPacket(Packet250CustomPayload packet, EntityPlayer player)
	{
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
		int jumpHeith;
		try
		{
			data = new DataInputStream(new ByteArrayInputStream(packet.data));
			jumpHeith = data.readInt();
			ContainerJumper containerJumper = (ContainerJumper)player.openContainer;
			TileEntityJumper tileJumper = containerJumper.getJumper();
			tileJumper.setJumpHeight(jumpHeith);
			player.worldObj.markBlockForUpdate(tileJumper.xCoord, tileJumper.yCoord, tileJumper.zCoord);
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			NanotechMod.nanoLog.severe("Failed to handle jumper packet");
		}
	}

	private void handleSaberPacket(Packet250CustomPayload packet, EntityPlayer player)
	{
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
		int type;
		int color;
		try
		{
			data = new DataInputStream(new ByteArrayInputStream(packet.data));
			type = data.readInt();
			color = data.readInt();
			ItemStack saberStack = player.getCurrentEquippedItem();
			if(!saberStack.hasTagCompound() || !(saberStack.getItem() instanceof ItemLightSaber))
			{
				saberStack.setTagCompound(new NBTTagCompound());
				NanotechMod.nanoLog.severe("A saber packet is erroned");
			}
			switch(type)
			{
			case 0:
				saberStack.getTagCompound().setInteger("red", color);
				break;
			case 1:
				saberStack.getTagCompound().setInteger("green", color);
				break;
			case 2:
				saberStack.getTagCompound().setInteger("blue", color);
				break;
			default:
				NanotechMod.nanoLog.severe("A saber packet has a bad type, this is a bug");
			}
			player.inventory.onInventoryChanged();
		}
		catch(Exception exception)
		{
			exception.printStackTrace();
			NanotechMod.nanoLog.severe("Failed to handle saber packet");
		}
	}
}
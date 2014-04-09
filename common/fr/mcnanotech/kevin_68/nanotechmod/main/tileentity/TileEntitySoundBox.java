/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.tileentity;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import fr.mcnanotech.kevin_68.nanotechmod.main.utils.UtilListerJukebox;

@SuppressWarnings("rawtypes")
public class TileEntitySoundBox extends TileEntity
{
	private int modidSelected, categorySelected, redText, greenText, blueText, redCateg, greenCateg, blueCateg, lastSlotSelected;
	private String txt, txtCateg, dir;
	
	public boolean isUseableByPlayer(EntityPlayer player)
	{
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
	}
	
	@Override
	public void updateEntity()
	{
		//playSound(UtilListerJukebox.getAllSoundsDirectory().get(get(8)));
	}

	public void playSound(String dir)
	{
//		if(worldObj.isRemote)
//		{
//			Minecraft.getMinecraft().getSoundHandler().stopSounds();
//		}

		if(dir != null)
		{
			worldObj.playSound(xCoord, yCoord, zCoord, dir, 1.0F, 1.0F, true);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbtTagCompound)
	{
		super.writeToNBT(nbtTagCompound);
		nbtTagCompound.setInteger("ModidSelected", modidSelected);
		nbtTagCompound.setInteger("CategorySelected", categorySelected);
		nbtTagCompound.setInteger("RedText", redText);
		nbtTagCompound.setInteger("GreenText", greenText);
		nbtTagCompound.setInteger("BlueText", blueText);
		nbtTagCompound.setInteger("RedCategory", redCateg);
		nbtTagCompound.setInteger("GreenCategory", greenCateg);
		nbtTagCompound.setInteger("BlueCategory", blueCateg);
		nbtTagCompound.setInteger("LastSlotSelected", lastSlotSelected);
		if(txt != null && !txt.isEmpty())
		{
			nbtTagCompound.setString("NameTyped", txt);
		}
		if(txtCateg != null && !txtCateg.isEmpty())
		{
			nbtTagCompound.setString("CategoryTyped", txtCateg);
		}
		if(dir != null && !dir.isEmpty())
		{
			nbtTagCompound.setString("DirectoryTyped", dir);
		}
	}

	@Override
	public void readFromNBT(NBTTagCompound nbtTagCompound)
	{
		super.readFromNBT(nbtTagCompound);
		modidSelected = nbtTagCompound.getInteger("ModidSelected");
		categorySelected = nbtTagCompound.getInteger("CategorySelected");
		redText = nbtTagCompound.getInteger("RedText");
		greenText = nbtTagCompound.getInteger("GreenText");
		blueText = nbtTagCompound.getInteger("BlueText");
		redCateg = nbtTagCompound.getInteger("RedCategory");
		greenCateg = nbtTagCompound.getInteger("GreenCategory");
		blueCateg = nbtTagCompound.getInteger("BlueCategory");
		lastSlotSelected = nbtTagCompound.getInteger("LastSlotSelected");
		txt = nbtTagCompound.getString("NameTyped");
		txtCateg = nbtTagCompound.getString("CategoryTyped");
		dir = nbtTagCompound.getString("DirectoryTyped");
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt)
	{
		readFromNBT(pkt.func_148857_g());
	}

	@Override
	public Packet getDescriptionPacket()
	{
		NBTTagCompound nbt = new NBTTagCompound();
		this.writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 3, nbt);
	}

	public void set(int index, int value)
	{
		switch(index)
		{
		case 0:
		{
			modidSelected = value;
			break;
		}
		case 1:
		{
			categorySelected = value;
			break;
		}
		case 2:
		{
			redText = value;
			break;
		}
		case 3:
		{
			greenText = value;
			break;
		}
		case 4:
		{
			blueText = value;
			break;
		}
		case 5:
		{
			redCateg = value;
			break;
		}
		case 6:
		{
			greenCateg = value;
			break;
		}
		case 7:
		{
			blueCateg = value;
			break;
		}
		case 8:
		{
			lastSlotSelected = value;
			break;
		}
		}
		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	public void set(int index, String text)
	{
		switch(index)
		{
		case 0:
		{
			txt = text;
			break;
		}
		case 1:
		{
			txtCateg = text;
			break;
		}
		case 2:
		{
			dir = text;
			break;
		}
		}
		this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
	}

	public int get(int index)
	{
		switch(index)
		{
		case 0:
		{
			return modidSelected;

		}
		case 1:
		{
			return categorySelected;
		}
		case 2:
		{
			return redText;
		}
		case 3:
		{
			return greenText;
		}
		case 4:
		{
			return blueText;
		}
		case 5:
		{
			return redCateg;
		}
		case 6:
		{
			return greenCateg;
		}
		case 7:
		{
			return blueCateg;
		}
		case 8:
		{
			return lastSlotSelected;
		}
		default:
		{
			return -1;
		}
		}
	}

	public String getName(int index)
	{
		switch(index)
		{
		case 0:
		{
			return txt;
		}
		case 1:
		{
			return txtCateg;
		}
		case 2:
		{
			return dir;
		}
		default:
		{
			return "";
		}
		}
	}
}
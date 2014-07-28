/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import net.minecraft.client.Minecraft;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.common.util.Constants;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod.BaseNTMEntry;

public class UtilSoundBox
{
    private static File mcDir;
    private static File mainDir;
    private static File dataFile;
    private static File mcServerDir;
    private static File mainServerDir;
    private static File serverDataFile;

    public static void init()
    {
        mcDir = Minecraft.getMinecraft().mcDataDir;
        mainDir = new File(new File(mcDir, "nanotechmod"), "jukebox");
        if(!mainDir.exists())
        {
            mainDir.mkdirs();
        }
        dataFile = new File(mainDir, "sounds.dat");
    }

    public static void serverInit()
    {
        mcServerDir = new File(MinecraftServer.getServer().getFolderName());
        mainServerDir = new File(new File(mcServerDir, "nanotechmod"), "jukebox");
        if(!mainServerDir.exists())
        {
            mainServerDir.mkdirs();
        }
        serverDataFile = new File(mainDir, "sounds.dat");

        System.out.println(mcServerDir);
        System.out.println(mainServerDir);
        System.out.println(serverDataFile);
    }

    @SideOnly(Side.CLIENT)
    public static String getPlyN(Minecraft mc)
    {
        return mc.thePlayer.getCommandSenderName();
    }

    private static NBTTagCompound getData()
    {
        try
        {
            FileInputStream fileinputstream = new FileInputStream(dataFile);
            NBTTagCompound compound = CompressedStreamTools.readCompressed(fileinputstream);
            fileinputstream.close();
            return compound;
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
            NBTTagCompound compound = new NBTTagCompound();
            saveData(compound);
            return compound;
        }
    }

    private static NBTTagCompound getServerData()
    {
        try
        {
            FileInputStream fileinputstream = new FileInputStream(serverDataFile);
            NBTTagCompound compound = CompressedStreamTools.readCompressed(fileinputstream);
            fileinputstream.close();
            return compound;
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
            NBTTagCompound compound = new NBTTagCompound();
            saveServerData(compound);
            return compound;
        }
    }

    private static void saveData(NBTTagCompound compound)
    {
        try
        {
            FileOutputStream fileoutputstream = new FileOutputStream(dataFile);
            CompressedStreamTools.writeCompressed(compound, fileoutputstream);
            fileoutputstream.close();
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
    }

    private static void saveServerData(NBTTagCompound compound)
    {
        try
        {
            FileOutputStream fileoutputstream = new FileOutputStream(serverDataFile);
            CompressedStreamTools.writeCompressed(compound, fileoutputstream);
            fileoutputstream.close();
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
    }

    public static void setSound(String player, int id, String dir, String name, CategoryEntry category, int color)
    {
        NBTTagCompound compoundBase = getData();
        NBTTagCompound compound = compoundBase.hasKey("sounds") ? compoundBase.getCompoundTag("sounds") : new NBTTagCompound();
        NBTTagList playerList = compound.hasKey(player) ? compound.getTagList(player, Constants.NBT.TAG_COMPOUND) : new NBTTagList();
        NBTTagCompound playerTag = new NBTTagCompound();
        playerTag.setString("dir", dir);
        playerTag.setString("name", name);
        playerTag.setString("category", category.getId());
        playerTag.setInteger("color", color);
        playerTag.setInteger("id", id);
        playerList.appendTag(playerTag);
        compound.setTag(player, playerList);
        compoundBase.setTag("sounds", compound);
        saveData(compoundBase);
    }

    public static SoundEntry getSound(String player, int id)
    {
        NBTTagCompound compoundBase = getData();
        NBTTagCompound compound = compoundBase.getCompoundTag("sounds");
        NBTTagList playerList = compound.getTagList(player, Constants.NBT.TAG_COMPOUND);
        NBTTagCompound playerTag = playerList.getCompoundTagAt(id);
        return new SoundEntry(playerTag.getString("dir"), playerTag.getString("name"), playerTag.getString("category"), playerTag.getInteger("color"), playerTag.getInteger("id"));
    }

    public static ArrayList<BaseNTMEntry> getSoundsList(String player)
    {
        ArrayList<BaseNTMEntry> list = new ArrayList();
        NBTTagCompound compoundBase = getData();
        NBTTagCompound compound = compoundBase.getCompoundTag("sounds");
        NBTTagList playerList = compound.getTagList(player, Constants.NBT.TAG_COMPOUND);
        for(int i = 0; i < playerList.tagCount(); i++)
        {
            NBTTagCompound playerTag = playerList.getCompoundTagAt(i);
            list.add(i, new SoundEntry(playerTag.getString("dir"), playerTag.getString("name"), playerTag.getString("category"), playerTag.getInteger("color"), playerTag.getInteger("id")));
        }
        return list;
    }

    public static void deleteSound(String player, int id)
    {
        NBTTagCompound compoundBase = getData();
        NBTTagCompound compound = compoundBase.getCompoundTag("sounds");
        NBTTagList playerList = compound.getTagList(player, Constants.NBT.TAG_COMPOUND);
        playerList.removeTag(id);
        for(int i = id; i < playerList.tagCount(); i++)
        {
            NBTTagCompound playerTag = playerList.getCompoundTagAt(i);
            playerTag.setInteger("id", playerTag.getInteger("id") - 1);
        }
        saveData(compoundBase);
    }

    public static ArrayList<BaseNTMEntry> getSoundsByCategory(CategoryEntry entry)
    {
        ArrayList<BaseNTMEntry> list = new ArrayList();
        NBTTagCompound compoundBase = getData();
        NBTTagCompound compound = compoundBase.getCompoundTag("sounds");
        NBTTagList playerList = compound.getTagList(entry.getOwner(), Constants.NBT.TAG_COMPOUND);
        for(int i = 0; i < playerList.tagCount(); i++)
        {
            NBTTagCompound playerTag = playerList.getCompoundTagAt(i);
            if((playerTag.getString("category").toString()).equals(entry.getId().toString()))
            {
                list.add(new SoundEntry(playerTag.getString("dir"), playerTag.getString("name"), playerTag.getString("category"), playerTag.getInteger("color"), playerTag.getInteger("id")));
            }
        }
        return list;
    }

    public static void editSound(SoundEntry entry, String player)
    {
        NBTTagCompound compoundBase = getData();
        NBTTagCompound compound = compoundBase.getCompoundTag("sounds");
        NBTTagList playerList = compound.getTagList(player, Constants.NBT.TAG_COMPOUND);
        for(int i = 0; i < playerList.tagCount(); i++)
        {
            NBTTagCompound sound = playerList.getCompoundTagAt(i);
            if(sound.getInteger("id") == entry.getId())
            {
                sound.setString("dir", entry.getDir());
                sound.setString("name", entry.getName());
                sound.setString("category", entry.getCategoryId());
                sound.setInteger("color", entry.color);
                break;
            }
        }
        saveData(compoundBase);
    }

    public static void setCategory(String player, String id, String name, int color)
    {
        setCategory(player, id, name, color, false);
    }

    public static void setCategory(String player, String id, String name, int color, boolean isServer)
    {
        NBTTagCompound compoundBase = isServer ? getServerData() : getData();
        NBTTagList compound = compoundBase.hasKey("categories") ? compoundBase.getTagList("categories", Constants.NBT.TAG_COMPOUND) : new NBTTagList();
        NBTTagCompound category = new NBTTagCompound();
        category.setString("owner", player);
        category.setString("name", name);
        category.setInteger("color", color);
        category.setString("id", id);
        compound.appendTag(category);
        compoundBase.setTag("categories", compound);
        if(isServer)
        {
            saveServerData(compoundBase);
        }
        else
        {
            saveData(compoundBase);
        }
    }

    public static CategoryEntry getCategory(String id)
    {
        NBTTagCompound compoundBase = getData();
        NBTTagList compound = compoundBase.getTagList("categories", Constants.NBT.TAG_COMPOUND);
        for(int i = 0; i < compound.tagCount(); i++)
        {
            NBTTagCompound category = compound.getCompoundTagAt(i);
            if(category.getString("id").toString().equals(id))
            {
                return new CategoryEntry(category.getString("name"), category.getString("owner"), category.getInteger("color"), category.getString("id"));
            }
        }
        return null;
    }

    public static ArrayList<BaseNTMEntry> getCategoryList()
    {
        return getCategoryList(getData());
    }

    public static ArrayList<BaseNTMEntry> getCategoryList(NBTTagCompound compoundBase)
    {
        ArrayList<BaseNTMEntry> list = new ArrayList();
        NBTTagList compound = compoundBase.getTagList("categories", Constants.NBT.TAG_COMPOUND);
        for(int i = 0; i < compound.tagCount(); i++)
        {
            NBTTagCompound category = compound.getCompoundTagAt(i);
            list.add(i, new CategoryEntry(category.getString("name"), category.getString("owner"), category.getInteger("color"), category.getString("id")));
        }
        return list;
    }

    public static void deleteCategory(String player, String id)
    {
        NBTTagCompound compoundBase = getData();
        NBTTagList compound = compoundBase.getTagList("categories", Constants.NBT.TAG_COMPOUND);
        for(int i = 0; i < compound.tagCount(); i++)
        {
            if((compound.getCompoundTagAt(i).getString("id")).toString().equals(id))
            {
                if(compound.getCompoundTagAt(i).getString("owner").toString().equals(player.toString()))
                {
                    compound.removeTag(i);
                }
            }
        }
        saveData(compoundBase);
    }

    public static void editCategory(CategoryEntry entry, String player)
    {
        NBTTagCompound compoundBase = getData();
        NBTTagList compound = compoundBase.getTagList("categories", Constants.NBT.TAG_COMPOUND);
        for(int i = 0; i < compound.tagCount(); i++)
        {
            if((compound.getCompoundTagAt(i).getString("id")).toString().equals((entry.getId()).toString()))
            {
                if(compound.getCompoundTagAt(i).getString("owner").toString().equals(player.toString()))
                {
                    NBTTagCompound category = compound.getCompoundTagAt(i);
                    category.setString("owner", entry.getOwner());
                    category.setString("name", entry.getName());
                    category.setInteger("color", entry.getColor());
                }
            }
        }
        saveData(compoundBase);
    }

    public static int getNextSoundId(String player)
    {
        NBTTagCompound compoundBase = getData();
        if(compoundBase.hasKey("sounds"))
        {
            NBTTagCompound compound = compoundBase.getCompoundTag("sounds");
            NBTTagList playerList = compound.getTagList(player, Constants.NBT.TAG_COMPOUND);
            int maxId = 0;
            for(int i = 0; i < playerList.tagCount(); i++)
            {
                int id = playerList.getCompoundTagAt(i).getInteger("id");
                if(id > maxId)
                {
                    maxId = id;
                }
            }
            return(maxId + 1);
        }
        else
        {
            return 0;
        }
    }

    public static String getNextCategoryId(String player)
    {
        NBTTagCompound compoundBase = getData();
        if(compoundBase.hasKey("categories"))
        {
            NBTTagList compound = compoundBase.getTagList("categories", Constants.NBT.TAG_COMPOUND);
            int maxId = 0;
            for(int i = 0; i < compound.tagCount(); i++)
            {
                String id = compound.getCompoundTagAt(i).getString("id");
                if(id.contains(player))
                {
                    String[] idsplited = id.split("_");
                    int idNumber = Integer.valueOf(idsplited[idsplited.length - 1]);
                    if(idNumber > maxId)
                    {
                        maxId = idNumber;
                    }
                }
            }
            return player + "_" + (maxId + 1);
        }
        else
        {
            return player + "_0";
        }
    }

    public static void importCategoryToServer(CategoryEntry entry)
    {
        NBTTagCompound compoundBase = getServerData();
        ArrayList<BaseNTMEntry> list = getCategoryList(compoundBase);
        if(list.contains(entry))
        {
            System.out.println("true");
        }
        else
        {
            setCategory(entry.getOwner(), entry.getId(), entry.getName(), entry.getColor(), true);
            System.out.println("false");
        }
        saveServerData(compoundBase);
    }

    public static class SoundEntry extends BaseNTMEntry
    {
        private final String dir, categoryId;
        private final int color, id;

        public SoundEntry(String dir, String name, String categoryId, int color, int id)
        {
            super(name);
            this.dir = dir;
            this.categoryId = categoryId;
            this.color = color;
            this.id = id;
        }

        public String getDir()
        {
            return dir;
        }

        public String getCategoryId()
        {
            return categoryId;
        }

        public CategoryEntry getCategory()
        {
            return UtilSoundBox.getCategory(categoryId);
        }

        public int getColor()
        {
            return color;
        }

        public int getId()
        {
            return id;
        }
    }

    public static class CategoryEntry extends BaseNTMEntry
    {
        private final String owner, id;
        private final int color;

        public CategoryEntry(String name, String owner, int color, String id)
        {
            super(name);
            this.owner = owner;
            this.color = color;
            this.id = id;
        }

        public String getOwner()
        {
            return owner;
        }

        public int getColor()
        {
            return color;
        }

        public String getId()
        {
            return id;
        }
    }
}
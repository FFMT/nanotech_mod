package fr.mcnanotech.kevin_68.nanotechmod.compatibility.core.forgemultipart.Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import net.minecraft.client.Minecraft;

public class UtilMicroBlocks
{
	public static void addBlocksToMicroBlocksList()
	{
		File confile = new File(Minecraft.getMinecraft().mcDataDir + "/config/microblocks.cfg");
		if(confile.exists())
		{
			/*try
            {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(confile));
                    for(int i = 1; i < 17; i++)
                    {
                            bw.write("cd information" + i);
                            bw.newLine();
                    }
                    bw.close();
            }
            catch(IOException e)
            {}*/
		}
	}
}
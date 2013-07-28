package fr.mcnanotech.FFMT.FFMTAPI;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import net.minecraft.client.Minecraft;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author elias54
 */
public class FFMTVersionChecker
{
  static Minecraft minecraft;

  public static void checkerSimpleSSP(String name, double version, String versiondoc, String download, Minecraft mc)
  {
	    minecraft = mc;
	    System.out.println("");
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    System.out.println("");
	    System.out.println("LOADING VERSION CHECKER");
	    System.out.println("Checking if " + name + " is up-to-date");
	    try
	    {
	      URL url = new URL(versiondoc);
	      BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
	
	      double newversion = 0.0D;
	      String str;
	      while ((str = in.readLine()) != null)
	      {
	        if (str.contains("Version"))
	        {
	          newversion = Double.parseDouble(str.replaceAll("Version:", "").trim());
	        }
	
	      }
	
	      if (newversion > version)
	      {
	        System.out.println(name + " is out-of-date");
	        window(name, download);
	      }
	      else
	      {
	        System.out.println(name + " is up-to-date");
	      }
	
	      in.close();
	    }
	    catch (MalformedURLException e)
	    {
	    }
	    catch (IOException e)
	    {
	    }
	
	    System.out.println("");
	    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	    System.out.println("");
  }

  public static void checkerXMLSSP(String name, double version, String versiondoc, String download, Minecraft mc)
  {
    minecraft = mc;
    System.out.println("");
    System.out.println("----------------------------------------");
    System.out.println("");
    System.out.println("Executing version checker with metadata...");
    System.out.println("Checking if " + name + " is up-to-date");
    try
    {
      URL url = new URL(versiondoc);
      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
      DocumentBuilder db = dbf.newDocumentBuilder();
      Document doc = db.parse(url.openStream());
      doc.getDocumentElement().normalize();
      NodeList nList = doc.getElementsByTagName(name.replace(" ", "").trim());
      String nValue = "";

      for (int temp = 0; temp < nList.getLength(); temp++)
      {
        Node nNode = nList.item(temp);

        if (nNode.getNodeType() == 1)
        {
          Element eElement = (Element)nNode;
          nValue = eElement.getElementsByTagName("version").item(0).getChildNodes().item(0).getNodeValue();
        }
      }

      double newversion = Double.parseDouble(nValue);

      if (newversion > version)
      {
        System.out.println(name + " is out-of-date");
        window(name, download);
      }
      else
      {
        System.out.println(name + " is up-to-date");
      }
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }

    System.out.println("");
    System.out.println("----------------------------------------");
    System.out.println("");
  }

  private static void window(String name, String download)
  {
    String url2 = download;
    JFrame frame32 = new JFrame();
    frame32.setVisible(true);
    frame32.setDefaultCloseOperation(2);

    if (JOptionPane.showConfirmDialog(frame32, name + " is out-of-date, would you like to update now?", "FFMT Update Checker", 2) == 0)
    {
      frame32.setVisible(false);
      frame32.dispose();
      minecraft.getMinecraft();
      try
      {
        Desktop.getDesktop().browse(URI.create(url2));
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
    else
    {
      frame32.setVisible(false);
      frame32.dispose();
    }
  }
}
package fr.mcnanotech.FFMT.FFMTAPI;

/**
 * @author elias54
 */
public class FFMTColor {

	/** RED **/
	public static int redInt;
	public static String red;
	
	/** LIGHT RED **/
	public static int redLightInt;
	public static String redLight;
	
	/** WHITE **/
	public static int whiteInt;
	public static String white;
	
	/** GREEN **/
	public static int greenInt;
	public static String green;

	/** LIGHT GREEN **/
	public static int greenLightInt;
	public static String greenLight;
	
	/** BLUE **/
	public static int blueInt;
	public static String blue;
	
	/** LIGHT BLUE **/
	public static int blueLightInt;
	public static String blueLight;
	
	/** DARK BLUE **/
	public static int blueDarkInt;
	public static String blueDark;
	
	/** BLUE-GREEN **/
	public static int blueGreenInt;
	public static String blueGreen;
	
	/** GRAY **/
	public static int grayGuiInt;
	public static String gray;
	
	/** BLACK **/
	public static int blackInt;
	public static String black;
	
	/** YELLOW **/
	public static int yellowInt;
	public static String yellow;
	
	/** BRIGHT YELLOW **/
	public static int yellowBrightInt;
	public static String yellowBright;
	
	/** ORANGE **/
	public static int orangeInt;
	public static String orange;
	
	/** BROWN **/
	public static int brownInt;
	public static String brown;
	
	/** PINK **/
	public static int pinkInt;
	public static String pink;
	
	public FFMTColor()
	{
		/** RED **/
		red = "\247c";
		redInt = 16711680;
		
		/** LIGHT RED **/
		redLight = "/247c";
		redLightInt = 0;
		
		/** WHITE **/
		whiteInt = 16777215;
		white = "\247f";
		
		/** GREEN **/
		greenInt = 652820;
		green = "o";
		
		/** LIGHT GREEN **/
		greenLightInt = 0x00FF08;
		greenLight = "\247a";
		
		/** BLUE **/
		blueInt = 255;
		blue = "o";
		
		/** LIGHT BLUE **/
		blueLightInt = 65535;
		blueLight = "\247b";
		
		/** DARK BLUE **/
		blueDarkInt = 0;
		blueDark = "\2471";
		
		/** BLUE-GREEN **/
		blueGreenInt = 46220;
		blueGreen = "o";
		
		/** GRAY (GUI) **/
		grayGuiInt = 0x404040;
		gray = "\2477";
		
		/** BLACK **/
		blackInt = 0;
		black = "\2478";
		
		/** YELLOW **/
		yellowInt = 16776960;
		yellow = "o";
		
		/** YELLOW BRIGHT**/
		yellowBrightInt = 0;
		yellowBright = "/247e";
		
		/** ORANGE **/
		orangeInt = 16744448;
		orange = "o";
		
		/** BROWN **/
		brownInt = 8404992;
		brown = "o";
		
		/** PINK **/
		pinkInt = 16711808;
		pink = "/247d";
	}
	
	public static FFMTColor instance()
	{
		return new FFMTColor();
	}
	
}

package fr.mcnanotech.FFMT.FFMTAPI;

/**
 * @author elias54, kevin_68
 */
public class FFMTColor
{

	/** BLACK **/
	public static int blackInt;
	public static String black;

	/** DARK BLUE **/
	public static int darkBlueInt;
	public static String darkBlue;

	/** DARK GREEN **/
	public static int darkGreenInt;
	public static String darkGreen;

	/** DARK AQUA **/
	public static int darkAquaInt;
	public static String darkAqua;

	/** DARK RED **/
	public static int darkRedInt;
	public static String darkRed;
	
	/** DARK PURPLE **/
	public static int darkPurpleInt;

	/** PURPLE **/
	public static int purpleInt;
	public static String purple;

	/** GOLD **/
	public static int goldInt;
	public static String gold;

	/** GRAY **/
	public static int grayInt;
	public static String gray;

	/** DARK GRAY **/
	public static int darkGrayInt;
	public static String darkGray;

	/** BLUE **/
	public static int blueInt;
	public static String blue;

	/** GREEN **/
	public static int greenInt;
	public static String green;

	/** AQUA **/
	public static int aquaInt;
	public static String aqua;

	/** RED **/
	public static int redInt;
	public static String red;

	/** LIGHT PURPLE **/
	public static int lightPurpleInt;
	public static String lightPurple;
	
	/** LIGHT RED **/
	public static int lightRedInt;
	
	/** LIGHT GREEN **/
	public static int lightGreenInt;
	
	/** LIGHT BLUE **/
	public static int lightBlueInt;

	/** YELLOW **/
	public static int yellowInt;
	public static String yellow;

	/** WHITE **/
	public static int whiteInt;
	public static String white;
	
	/** PINK **/
	public static int pinkInt;
	
	/** ORANGE **/
	public static int orangeInt;
	
	/** DARK ORANGE **/
	public static int darkOrangeInt;
	
	/** SPECIALS **/
	public static String obfuscated;
	public static String bold;
	public static String strike;
	public static String underline;
	public static String italic;

	public FFMTColor()
	{
		/** BLACK **/
		blackInt = 0;
		black = "\2470";

		/** DARK BLUE **/
		darkBlueInt = 170;
		darkBlue = "\2471";

		/** DARK GREEN **/
		darkGreenInt = 170000;
		darkGreen = "\2472";

		/** DARK AQUA **/
		darkAquaInt = 170170;
		darkAqua = "\2473";

		/** DARK RED **/
		darkRedInt = 170000000;
		darkRed = "\2474";

		/** PURPLE **/
		purpleInt = 170000170;
		purple = "\2475";
		
		/** DARK PURPLE **/
		darkPurpleInt = 122055139;

		/** GOLD **/
		goldInt = 255170000;
		gold = "\2476";

		/** GRAY **/
		grayInt = 170170170;
		gray = "\2477";

		/** DARK GRAY **/
		darkGrayInt = 85085085;
		darkGray = "\2478";

		/** BLUE **/
		blueInt = 85085255;
		blue = "\2479";

		/** GREEN **/
		greenInt = 85255085;
		green = "\247a";

		/** AQUA **/
		aquaInt = 85255255;
		aqua = "\247b";

		/** RED **/
		redInt = 255085085;
		red = "\247c";

		/** LIGHT PURPLE **/
		lightPurpleInt = 255085255;
		lightPurple = "\247d";
		
		/** LIGHT RED **/
		lightRedInt = 255099071;

		/** LIGHT GREEN **/
		lightGreenInt = 124252000;

		/** LIGHT BLUE **/
		lightBlueInt = 	135206250;

		/** YELLOW **/
		yellowInt = 255255085;
		yellow = "\247e";

		/** WHITE **/
		whiteInt = 255255255;
		white = "\247f";
		
		/** PINK **/
		pinkInt = 255192203;
		
		/** ORANGE **/
		orangeInt = 255165000;
		
		/** DARK ORANGE **/
		darkOrangeInt = 205102000;

		/** SPECIALS **/
		obfuscated = "\247k";
		bold = "\247l";
		strike = "\247m";
		underline = "\247n";
		italic = "\247o";
	}

	public static FFMTColor instance()
	{
		return new FFMTColor(); 
	}
	
	public static String test()
	{
		return black + "Black " + darkBlue + "Dark Blue " + darkGreen + "Dark Green " + darkAqua + "Dark Aqua " + darkRed + "Dark Red " + purple + "Purple " + gold + "Gold " + gray + "Gray " + darkGray + "Dark Gray " + blue + "Blue " + green + "Green " + aqua + "Aqua " + red + "Red " + lightPurple + "Light Purple " + yellow + "Yellow " + white + "White ";
	}

}

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
	public static int darkBlueIntB;
	public static String darkBlue;

	/** DARK GREEN **/
	public static int darkGreenInt;
	public static int darkGreenIntB;
	public static String darkGreen;

	/** DARK AQUA **/
	public static int darkAquaInt;
	public static int darkAquaIntB;
	public static String darkAqua;

	/** DARK RED **/
	public static int darkRedInt;
	public static int darkRedIntB;
	public static String darkRed;
	
	/** DARK PURPLE **/
	public static int darkPurpleInt;

	/** PURPLE **/
	public static int purpleInt;
	public static int purpleIntB;
	public static String purple;

	/** GOLD **/
	public static int goldInt;
	public static int goldIntB;
	public static String gold;

	/** GRAY **/
	public static int grayInt;
	public static int grayIntB;
	public static String gray;

	/** DARK GRAY **/
	public static int darkGrayInt;
	public static int darkGrayIntB;
	public static String darkGray;

	/** BLUE **/
	public static int blueInt;
	public static int blueIntB;
	public static String blue;

	/** GREEN **/
	public static int greenInt;
	public static int greenIntB;
	public static String green;

	/** AQUA **/
	public static int aquaInt;
	public static int aquaIntB;
	public static String aqua;

	/** RED **/
	public static int redInt;
	public static int redIntB;
	public static String red;

	/** LIGHT PURPLE **/
	public static int lightPurpleInt;
	public static int lightPurpleIntB;
	public static String lightPurple;
	
	/** LIGHT RED **/
	public static int lightRedInt;
	
	/** LIGHT GREEN **/
	public static int lightGreenInt;
	
	/** LIGHT BLUE **/
	public static int lightBlueInt;

	/** YELLOW **/
	public static int yellowInt;
	public static int yellowIntB;
	public static String yellow;

	/** WHITE **/
	public static int whiteInt;
	public static int whiteIntB;
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

	//(R*65536)+(G*256)+B
	/**
	 * ColorName = Foreground Color
	 * ColorNameB = Background Color
	 */
	public FFMTColor()
	{
		/** BLACK **/
		blackInt = (0*65536)+(0*256)+0;
		black = "\2470";

		/** DARK BLUE **/
		darkBlueInt = (0*65536)+(0*256)+170;
		darkBlueIntB = (0*65536)+(0*256)+42;
		darkBlue = "\2471";

		/** DARK GREEN **/
		darkGreenInt = (0*65536)+(170*256)+0;
		darkGreenIntB = (0*65536)+(42*256)+0;
		darkGreen = "\2472";

		/** DARK AQUA **/
		darkAquaInt = (0*65536)+(170*256)+170;
		darkAquaIntB = (0*65536)+(42*256)+42;
		darkAqua = "\2473";

		/** DARK RED **/
		darkRedInt = (170*65536)+(0*256)+0;
		darkRedIntB = (42*65536)+(0*256)+0;
		darkRed = "\2474";

		/** PURPLE **/
		purpleInt = (170*65536)+(0*256)+170;
		purpleIntB = (42*65536)+(0*256)+42;
		purple = "\2475";
		
		/** DARK PURPLE **/
		darkPurpleInt = (128*65536)+(0*256)+128;

		/** GOLD **/
		goldInt = (255*65536)+(170*256)+0;
		goldIntB = (42*65536)+(42*256)+0;
		gold = "\2476";

		/** GRAY **/
		grayInt = (170*65536)+(170*256)+170;
		grayIntB = (42*65536)+(42*256)+42;
		gray = "\2477";

		/** DARK GRAY **/
		darkGrayInt = (85*65536)+(85*256)+85;
		darkGrayIntB = (21*65536)+(21*256)+21;
		darkGray = "\2478";

		/** BLUE **/
		blueInt = (85*65536)+(85*256)+255;
		blueIntB = (21*65536)+(21*256)+63;
		blue = "\2479";

		/** GREEN **/
		greenInt = (85*65536)+(255*256)+85;
		greenIntB = (21*65536)+(63*256)+21;
		green = "\247a";

		/** AQUA **/
		aquaInt = (85*65536)+(255*256)+255;
		aquaIntB = (21*65536)+(63*256)+63;
		aqua = "\247b";

		/** RED **/
		redInt = (255*65536)+(85*256)+85;
		redIntB = (63*65536)+(21*256)+21;
		red = "\247c";

		/** LIGHT PURPLE **/
		lightPurpleInt = (255*65536)+(85*256)+255;
		lightPurpleIntB = (63*65536)+(21*256)+63;
		lightPurple = "\247d";
		
		/** LIGHT RED **/
		lightRedInt = (255*65536)+(99*256)+71;

		/** LIGHT GREEN **/
		lightGreenInt = (0*65536)+(255*256)+0;

		/** LIGHT BLUE **/
		lightBlueInt = 	(173*65536)+(216*256)+230;

		/** YELLOW **/
		yellowInt = (255*65536)+(255*256)+85;
		yellowIntB = (63*65536)+(63*256)+21;
		yellow = "\247e";

		/** WHITE **/
		whiteInt = (255*65536)+(255*256)+255;
		whiteIntB = (63*65536)+(63*256)+63;
		white = "\247f";
		
		/** PINK **/
		pinkInt = (255*65536)+(192*256)+203;
		
		/** ORANGE **/
		orangeInt = (255*65536)+(165*256)+0;
		
		/** DARK ORANGE **/
		darkOrangeInt = (255*65536)+(120*256)+0;

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

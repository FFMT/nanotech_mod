/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.utils;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.IBlockAccess;

public class CTHelper
{
	public static final int V = 0, N = 1, S = 2, E = 3, W = 4, VrN = 5, VrS = 6, VrE = 7, VrW = 8, VrNS = 9, VrNE = 10, VrNW = 11, VrSE = 12, VrSW = 13, VrEW = 14, VrNSE = 15, VrNSW = 16, VrNEW = 17, VrSEW = 18, VrNSEW = 19, NrS = 20, SrN = 21, ErW = 22, WrE = 23, NSrN = 24, NSrS = 25, EWrE = 26, EWrW = 27, NS = 28, NE = 29, NW = 30, SE = 31, SW = 32, EW = 33, NSE = 34, NSW = 35, NEW = 36,
			SEW = 37, NSEW = 38, NrN = 39, SrS = 40, ErE = 41, WrW = 42, NSrNS = 43, NErNE = 44, NWrNW = 45, SErSE = 46, SWrSW = 47, EWrEW = 48, NSErNSE = 49, NSWrNSW = 50, NEWrNEW = 51, SEWrSEW = 52, NSEWrNSEW = 53, NrNE = 54, NrNW = 55, SrSE = 56, SrSW = 57, ErNE = 58, ErSE = 59, WrNW = 60, WrSW = 61, tNrE = 62, tNrW = 63, tSrE = 64, tSrW = 65, tErN = 66, tErS = 67, tWrN = 68, tWrS = 69,
			tNrSE = 70, tNrSW = 71, tSrNE = 72, tSrNW = 73, tErNW = 74, tErSW = 75, tWrNE = 76, tWrSE = 77, tNErne = 78, tNWrnw = 79, tSErse = 80, tSWrsw = 81, tEWrN = 82, tEWrS = 83, tNSrE = 84, tNSrW = 85, tNSErE = 86, tNSWrW = 87, tSEWrS = 88, tNEWrN = 89, tNSErW = 90, tNSWrE = 91, tSEWrN = 92, tNEWrS = 93, tNSEWrN = 94, tNSEWrS = 95, tNSEWrE = 96, tNSEWrW = 97, tNrNSEW = 98, tSrNSEW = 99,
			tErNSEW = 100, tWrNSEW = 101, tNSrNSEW = 102, tEWrNSEW = 103, tNSErNSEW = 104, tNSWrNSEW = 105, tNEWrNSEW = 106, tSEWrNSEW = 107, tSrSEW = 108, tErSEW = 109, tWrSEW = 110, tNrNEW = 111, tErNEW = 112, tWrNEW = 113, tNrNSW = 114, tSrNSW = 115, tWrNSW = 116, tNrNSE = 117, tSrNSE = 118, tErNSE = 119, tNSrNSE = 120, tNSrNSW = 121, tEWrNEW = 122, tEWrSEW = 123, tSErSEW = 124, tSWrSEW = 125,
			tNErNSE = 126, tSErNSE = 127, tNWrNEW = 128, tNErNEW = 129, tNWrNSW = 130, tSWrNSW = 131, NrSEW = 132, SrNEW = 133, ErNSW = 134, WrNSE = 135, NSrEW = 136, EWrNS = 137, NErSW = 138, NWrSE = 139, SErNW = 140, SWrNE = 141, NSErW = 142, NSWrE = 143, NEWrS = 144, SEWrN = 145, tNrNS = 146, tSrNS = 147, tErEW = 148, tWrEW = 149;

	public static boolean[] get(IBlockAccess iba, int x, int y, int z, Block block)
	{
		boolean flag[] = new boolean[200];
		int[] cN = new int[] {x, y, z - 1}, cS = new int[] {x, y, z + 1}, cE = new int[] {x + 1, y, z}, cW = new int[] {x - 1, y, z}, cnw = new int[] {x - 1, y, z - 1}, cne = new int[] {x + 1, y, z - 1}, csw = new int[] {x - 1, y, z + 1}, cse = new int[] {x + 1, y, z + 1}, cNp1 = new int[] {x, y + 1, z - 1};

		flag[V] = (b(iba, cN, block) && b(iba, cS, block) && b(iba, cE, block) && b(iba, cW, block));
		flag[N] = (d(iba, cN, block) && b(iba, cS, block) && b(iba, cE, block) && b(iba, cW, block));
		flag[S] = (b(iba, cN, block) && d(iba, cS, block) && b(iba, cE, block) && b(iba, cW, block));
		flag[E] = (b(iba, cN, block) && b(iba, cS, block) && d(iba, cE, block) && b(iba, cW, block));
		flag[W] = (b(iba, cN, block) && b(iba, cS, block) && b(iba, cE, block) && d(iba, cW, block));
		flag[VrN] = (c(iba, cN) && b(iba, cS, block) && b(iba, cE, block) && b(iba, cW, block));
		flag[VrS] = (b(iba, cN, block) && c(iba, cS) && b(iba, cE, block) && b(iba, cW, block));
		flag[VrE] = (b(iba, cN, block) && b(iba, cS, block) && c(iba, cE) && b(iba, cW, block));
		flag[VrW] = (b(iba, cN, block) && b(iba, cS, block) && b(iba, cE, block) && c(iba, cW));
		flag[VrNS] = (c(iba, cN) && c(iba, cS) && b(iba, cE, block) && b(iba, cW, block));
		flag[VrEW] = (b(iba, cN, block) && b(iba, cS, block) && c(iba, cE) && c(iba, cW));
		flag[VrNE] = (c(iba, cN) && b(iba, cS, block) && c(iba, cE) && b(iba, cW, block));
		flag[VrNW] = (c(iba, cN) && b(iba, cS, block) && b(iba, cE, block) && c(iba, cW));
		flag[VrSE] = (b(iba, cN, block) && c(iba, cS) && c(iba, cE) && b(iba, cW, block));
		flag[VrSW] = (b(iba, cN, block) && c(iba, cS) && b(iba, cE, block) && c(iba, cW));
		flag[VrNSE] = (c(iba, cN) && c(iba, cS) && c(iba, cE) && b(iba, cW, block));
		flag[VrNSW] = (c(iba, cN) && c(iba, cS) && b(iba, cE, block) && c(iba, cW));
		flag[VrNEW] = (c(iba, cN) && b(iba, cS, block) && c(iba, cE) && c(iba, cW));
		flag[VrSEW] = (b(iba, cN, block) && c(iba, cS) && c(iba, cE) && c(iba, cW));
		flag[VrNSEW] = (c(iba, cN) && c(iba, cS) && c(iba, cE) && c(iba, cW));
		flag[NrS] = (d(iba, cN, block) && c(iba, cS) && b(iba, cE, block) && b(iba, cW, block));
		flag[SrN] = (c(iba, cN) && d(iba, cS, block) && b(iba, cE, block) && b(iba, cW, block));
		flag[ErW] = (b(iba, cN, block) && b(iba, cS, block) && d(iba, cE, block) && c(iba, cW));
		flag[WrE] = (b(iba, cN, block) && b(iba, cS, block) && c(iba, cE) && d(iba, cW, block));
		flag[NSrN] = (e(iba, cN, block) && d(iba, cS, block) && b(iba, cE, block) && b(iba, cW, block));
		flag[NSrS] = (d(iba, cN, block) && e(iba, cS, block) && b(iba, cE, block) && b(iba, cW, block));
		flag[EWrE] = (b(iba, cN, block) && b(iba, cS, block) && e(iba, cE, block) && d(iba, cW, block));
		flag[EWrW] = (b(iba, cN, block) && b(iba, cS, block) && d(iba, cE, block) && e(iba, cW, block));
		flag[NS] = (d(iba, cN, block) && d(iba, cS, block) && b(iba, cE, block) && b(iba, cW, block));
		flag[NE] = (d(iba, cN, block) && b(iba, cS, block) && d(iba, cE, block) && b(iba, cW, block));
		flag[NW] = (d(iba, cN, block) && b(iba, cS, block) && b(iba, cE, block) && d(iba, cW, block));
		flag[SE] = (b(iba, cN, block) && d(iba, cS, block) && d(iba, cE, block) && b(iba, cW, block));
		flag[SW] = (b(iba, cN, block) && d(iba, cS, block) && b(iba, cE, block) && d(iba, cW, block));
		flag[EW] = (b(iba, cN, block) && b(iba, cS, block) && d(iba, cE, block) && d(iba, cW, block));
		flag[NSE] = (d(iba, cN, block) && d(iba, cS, block) && d(iba, cE, block) && b(iba, cW, block));
		flag[NSW] = (d(iba, cN, block) && d(iba, cS, block) && b(iba, cE, block) && d(iba, cW, block));
		flag[NEW] = (d(iba, cN, block) && b(iba, cS, block) && d(iba, cE, block) && d(iba, cW, block));
		flag[SEW] = (b(iba, cN, block) && d(iba, cS, block) && d(iba, cE, block) && d(iba, cW, block));
		flag[NSEW] = (d(iba, cN, block) && d(iba, cS, block) && d(iba, cE, block) && d(iba, cW, block));
		flag[NrN] = (f(iba, cN, block) && b(iba, cS, block) && b(iba, cE, block) && b(iba, cW, block));
		flag[SrS] = (b(iba, cN, block) && f(iba, cS, block) && b(iba, cE, block) && b(iba, cW, block));
		flag[ErE] = (b(iba, cN, block) && b(iba, cS, block) && f(iba, cE, block) && b(iba, cW, block));
		flag[WrW] = (b(iba, cN, block) && b(iba, cS, block) && b(iba, cE, block) && f(iba, cW, block));
		flag[NSrNS] = (f(iba, cN, block) && f(iba, cS, block) && b(iba, cE, block) && b(iba, cW, block));
		flag[NErNE] = (f(iba, cN, block) && b(iba, cS, block) && f(iba, cE, block) && b(iba, cW, block));
		flag[NWrNW] = (f(iba, cN, block) && b(iba, cS, block) && b(iba, cE, block) && f(iba, cW, block));
		flag[SErSE] = (b(iba, cN, block) && f(iba, cS, block) && f(iba, cE, block) && b(iba, cW, block));
		flag[SWrSW] = (b(iba, cN, block) && f(iba, cS, block) && b(iba, cE, block) && f(iba, cW, block));
		flag[EWrEW] = (b(iba, cN, block) && b(iba, cS, block) && f(iba, cE, block) && f(iba, cW, block));
		flag[NSErNSE] = (f(iba, cN, block) && f(iba, cS, block) && f(iba, cE, block) && b(iba, cW, block));
		flag[NSWrNSW] = (f(iba, cN, block) && f(iba, cS, block) && b(iba, cE, block) && f(iba, cW, block));
		flag[NEWrNEW] = (f(iba, cN, block) && b(iba, cS, block) && f(iba, cE, block) && f(iba, cW, block));
		flag[SEWrSEW] = (b(iba, cN, block) && f(iba, cS, block) && f(iba, cE, block) && f(iba, cW, block));
		flag[NSEWrNSEW] = (f(iba, cN, block) && f(iba, cS, block) && f(iba, cE, block) && f(iba, cW, block));
		flag[NrNE] = (f(iba, cN, block) && b(iba, cS, block) && c(iba, cE) && b(iba, cW, block));
		flag[NrNW] = (f(iba, cN, block) && b(iba, cS, block) && b(iba, cE, block) && c(iba, cW));
		flag[SrSE] = (b(iba, cN, block) && f(iba, cS, block) && c(iba, cE) && b(iba, cW, block));
		flag[SrSW] = (b(iba, cN, block) && f(iba, cS, block) && b(iba, cE, block) && c(iba, cW));
		flag[ErNE] = (c(iba, cN) && b(iba, cS, block) && f(iba, cE, block) && b(iba, cW, block));
		flag[ErSE] = (b(iba, cN, block) && c(iba, cS) && f(iba, cE, block) && b(iba, cW, block));
		flag[WrNW] = (c(iba, cN) && b(iba, cS, block) && b(iba, cE, block) && f(iba, cW, block));
		flag[WrSW] = (b(iba, cN, block) && c(iba, cS) && b(iba, cE, block) && f(iba, cW, block));
		flag[tNrE] = (a(iba, cN, block) && b(iba, cS, block) && c(iba, cE) && b(iba, cW, block));
		flag[tNrW] = (a(iba, cN, block) && b(iba, cS, block) && b(iba, cE, block) && c(iba, cW));
		flag[tSrE] = (b(iba, cN, block) && a(iba, cS, block) && c(iba, cE) && b(iba, cW, block));
		flag[tSrW] = (b(iba, cN, block) && a(iba, cS, block) && b(iba, cE, block) && c(iba, cW));
		flag[tErN] = (c(iba, cN) && b(iba, cS, block) && a(iba, cE, block) && b(iba, cW, block));
		flag[tErS] = (b(iba, cN, block) && c(iba, cS) && a(iba, cE, block) && b(iba, cW, block));
		flag[tWrN] = (c(iba, cN) && b(iba, cS, block) && b(iba, cE, block) && a(iba, cW, block));
		flag[tWrS] = (b(iba, cN, block) && c(iba, cS) && b(iba, cE, block) && a(iba, cW, block));
		flag[tNrSE] = (a(iba, cN, block) && c(iba, cS) && c(iba, cE) && b(iba, cW, block));
		flag[tNrSW] = (a(iba, cN, block) && c(iba, cS) && b(iba, cE, block) && c(iba, cW));
		flag[tSrNE] = (c(iba, cN) && a(iba, cS, block) && c(iba, cE) && b(iba, cW, block));
		flag[tSrNW] = (c(iba, cN) && a(iba, cS, block) && b(iba, cE, block) && c(iba, cW));
		flag[tErNW] = (c(iba, cN) && b(iba, cS, block) && a(iba, cE, block) && c(iba, cW));
		flag[tErSW] = (b(iba, cN, block) && c(iba, cS) && a(iba, cE, block) && c(iba, cW));
		flag[tWrNE] = (c(iba, cN) && b(iba, cS, block) && c(iba, cE) && a(iba, cW, block));
		flag[tWrSE] = (b(iba, cN, block) && c(iba, cS) && c(iba, cE) && a(iba, cW, block));
		flag[tNErne] = (a(iba, cN, block) && b(iba, cS, block) && a(iba, cE, block) && b(iba, cW, block) && c(iba, cne));
		flag[tNWrnw] = (a(iba, cN, block) && b(iba, cS, block) && b(iba, cE, block) && a(iba, cW, block) && c(iba, cnw));
		flag[tSErse] = (b(iba, cN, block) && a(iba, cS, block) && a(iba, cE, block) && b(iba, cW, block) && c(iba, cse));
		flag[tSWrsw] = (b(iba, cN, block) && a(iba, cS, block) && b(iba, cE, block) && a(iba, cW, block) && c(iba, csw));
		flag[tEWrN] = (c(iba, cN) && b(iba, cS, block) && a(iba, cE, block) && a(iba, cW, block));
		flag[tEWrS] = (b(iba, cN, block) && c(iba, cS) && a(iba, cE, block) && a(iba, cW, block));
		flag[tNSrE] = (a(iba, cN, block) && a(iba, cS, block) && c(iba, cE) && b(iba, cW, block));
		flag[tNSrW] = (a(iba, cN, block) && a(iba, cS, block) && b(iba, cE, block) && c(iba, cW));
		flag[tNSErE] = (a(iba, cN, block) && a(iba, cS, block) && f(iba, cE, block) && b(iba, cW, block));
		flag[tNSWrW] = (a(iba, cN, block) && a(iba, cS, block) && b(iba, cE, block) && f(iba, cW, block));
		flag[tSEWrS] = (b(iba, cN, block) && f(iba, cS, block) && a(iba, cE, block) && a(iba, cW, block));
		flag[tNEWrN] = (f(iba, cN, block) && b(iba, cS, block) && a(iba, cE, block) && a(iba, cW, block));
		flag[tNSErW] = (a(iba, cN, block) && a(iba, cS, block) && a(iba, cE, block) && g(iba, cW, block));
		flag[tNSWrE] = (a(iba, cN, block) && a(iba, cS, block) && g(iba, cE, block) && a(iba, cW, block));
		flag[tSEWrN] = (g(iba, cN, block) && a(iba, cS, block) && a(iba, cE, block) && a(iba, cW, block));
		flag[tNEWrS] = (a(iba, cN, block) && g(iba, cS, block) && a(iba, cE, block) && a(iba, cW, block));
		flag[tNSEWrN] = (f(iba, cN, block) && a(iba, cS, block) && a(iba, cE, block) && a(iba, cW, block));
		flag[tNSEWrS] = (a(iba, cN, block) && f(iba, cS, block) && a(iba, cE, block) && a(iba, cW, block));
		flag[tNSEWrE] = (a(iba, cN, block) && a(iba, cS, block) && f(iba, cE, block) && a(iba, cW, block));
		flag[tNSEWrW] = (a(iba, cN, block) && a(iba, cS, block) && a(iba, cE, block) && f(iba, cW, block));
		flag[tNrNSEW] = (f(iba, cN, block) && g(iba, cS, block) && g(iba, cE, block) && g(iba, cW, block));
		flag[tSrNSEW] = (g(iba, cN, block) && f(iba, cS, block) && g(iba, cE, block) && g(iba, cW, block));
		flag[tErNSEW] = (g(iba, cN, block) && g(iba, cS, block) && f(iba, cE, block) && g(iba, cW, block));
		flag[tWrNSEW] = (g(iba, cN, block) && g(iba, cS, block) && g(iba, cE, block) && f(iba, cW, block));
		flag[tNSrNSEW] = (f(iba, cN, block) && f(iba, cS, block) && g(iba, cE, block) && g(iba, cW, block));
		flag[tEWrNSEW] = (g(iba, cN, block) && g(iba, cS, block) && f(iba, cE, block) && f(iba, cW, block));
		flag[tNSErNSEW] = (f(iba, cN, block) && f(iba, cS, block) && f(iba, cE, block) && g(iba, cW, block));
		flag[tNSWrNSEW] = (f(iba, cN, block) && f(iba, cS, block) && g(iba, cE, block) && f(iba, cW, block));
		flag[tNEWrNSEW] = (f(iba, cN, block) && g(iba, cS, block) && f(iba, cE, block) && f(iba, cW, block));
		flag[tSEWrNSEW] = (g(iba, cN, block) && f(iba, cS, block) && f(iba, cE, block) && f(iba, cW, block));
		flag[tSrSEW] = (b(iba, cN, block) && f(iba, cS, block) && g(iba, cE, block) && g(iba, cW, block));
		flag[tErSEW] = (b(iba, cN, block) && g(iba, cS, block) && f(iba, cE, block) && g(iba, cW, block));
		flag[tWrSEW] = (b(iba, cN, block) && g(iba, cS, block) && g(iba, cE, block) && f(iba, cW, block));
		flag[tNrNEW] = (f(iba, cN, block) && b(iba, cS, block) && g(iba, cE, block) && g(iba, cW, block));
		flag[tErNEW] = (g(iba, cN, block) && b(iba, cS, block) && f(iba, cE, block) && g(iba, cW, block));
		flag[tWrNEW] = (g(iba, cN, block) && b(iba, cS, block) && g(iba, cE, block) && f(iba, cW, block));
		flag[tNrNSW] = (f(iba, cN, block) && g(iba, cS, block) && b(iba, cE, block) && g(iba, cW, block));
		flag[tSrNSW] = (g(iba, cN, block) && f(iba, cS, block) && b(iba, cE, block) && g(iba, cW, block));
		flag[tWrNSW] = (g(iba, cN, block) && g(iba, cS, block) && b(iba, cE, block) && f(iba, cW, block));
		flag[tNrNSE] = (f(iba, cN, block) && g(iba, cS, block) && g(iba, cE, block) && b(iba, cW, block));
		flag[tSrNSE] = (g(iba, cN, block) && f(iba, cS, block) && g(iba, cE, block) && b(iba, cW, block));
		flag[tErNSE] = (g(iba, cN, block) && g(iba, cS, block) && f(iba, cE, block) && b(iba, cW, block));
		flag[tNSrNSE] = (f(iba, cN, block) && f(iba, cS, block) && g(iba, cE, block) && b(iba, cW, block));
		flag[tNSrNSW] = (f(iba, cN, block) && f(iba, cS, block) && b(iba, cE, block) && g(iba, cW, block));
		flag[tEWrNEW] = (g(iba, cN, block) && b(iba, cS, block) && f(iba, cE, block) && f(iba, cW, block));
		flag[tEWrSEW] = (b(iba, cN, block) && g(iba, cS, block) && f(iba, cE, block) && f(iba, cW, block));
		flag[tSErSEW] = (b(iba, cN, block) && f(iba, cS, block) && f(iba, cE, block) && g(iba, cW, block));
		flag[tSWrSEW] = (b(iba, cN, block) && f(iba, cS, block) && g(iba, cE, block) && f(iba, cW, block));
		flag[tNErNSE] = (f(iba, cN, block) && g(iba, cS, block) && f(iba, cE, block) && b(iba, cW, block));
		flag[tSErNSE] = (g(iba, cN, block) && f(iba, cS, block) && f(iba, cE, block) && b(iba, cW, block));
		flag[tNWrNEW] = (f(iba, cN, block) && b(iba, cS, block) && g(iba, cE, block) && f(iba, cW, block));
		flag[tNErNEW] = (f(iba, cN, block) && b(iba, cS, block) && f(iba, cE, block) && g(iba, cW, block));
		flag[tNWrNSW] = (f(iba, cN, block) && g(iba, cS, block) && b(iba, cE, block) && f(iba, cW, block));
		flag[tSWrNSW] = (g(iba, cN, block) && f(iba, cS, block) && b(iba, cE, block) && f(iba, cW, block));
		flag[NrSEW] = (a(iba, cN, block) && g(iba, cS, block) && g(iba, cE, block) && g(iba, cW, block));
		flag[SrNEW] = (g(iba, cN, block) && a(iba, cS, block) && g(iba, cE, block) && g(iba, cW, block));
		flag[ErNSW] = (g(iba, cN, block) && g(iba, cS, block) && a(iba, cE, block) && g(iba, cW, block));
		flag[WrNSE] = (g(iba, cN, block) && g(iba, cS, block) && g(iba, cE, block) && a(iba, cW, block));
		flag[NSrEW] = (a(iba, cN, block) && a(iba, cS, block) && g(iba, cE, block) && g(iba, cW, block));
		flag[EWrNS] = (g(iba, cN, block) && g(iba, cS, block) && a(iba, cE, block) && a(iba, cW, block));
		flag[NErSW] = (a(iba, cN, block) && g(iba, cS, block) && a(iba, cE, block) && g(iba, cW, block));
		flag[NWrSE] = (a(iba, cN, block) && g(iba, cS, block) && g(iba, cE, block) && a(iba, cW, block));
		flag[SErNW] = (g(iba, cN, block) && a(iba, cS, block) && a(iba, cE, block) && g(iba, cW, block));
		flag[SWrNE] = (g(iba, cN, block) && a(iba, cS, block) && g(iba, cE, block) && a(iba, cW, block));
		
		flag[NSErW] = (a(iba, cN, block) && a(iba, cS, block) && a(iba, cE, block) && g(iba, cW, block) && c(iba, cnw) && c(iba, cne) && c(iba, csw) && c(iba, cse));
		flag[NSWrE] = (a(iba, cN, block) && a(iba, cS, block) && g(iba, cE, block) && a(iba, cW, block) && c(iba, cnw) && c(iba, cne) && c(iba, csw) && c(iba, cse));
		flag[NEWrS] = (a(iba, cN, block) && g(iba, cS, block) && a(iba, cE, block) && a(iba, cW, block) && c(iba, cnw) && c(iba, cne) && c(iba, csw) && c(iba, cse));
		flag[SEWrN] = (g(iba, cN, block) && a(iba, cS, block) && a(iba, cE, block) && a(iba, cW, block) && c(iba, cnw) && c(iba, cne) && c(iba, csw) && c(iba, cse));
		
		flag[tNrNS] = (f(iba, cN, block) && g(iba, cS, block) && b(iba, cE, block) && b(iba, cW, block));
		flag[tSrNS] = (g(iba, cN, block) && f(iba, cS, block) && b(iba, cE, block) && b(iba, cW, block));
		flag[tErEW] = (b(iba, cN, block) && b(iba, cS, block) && f(iba, cE, block) && g(iba, cW, block));
		flag[tWrEW] = (b(iba, cN, block) && b(iba, cS, block) && g(iba, cE, block) && f(iba, cW, block));
		return flag;
	}

	private static boolean a(IBlockAccess iba, int[] c, Block block)
	{
		return iba.getBlock(c[0], c[1], c[2]) == block;
	}

	private static boolean b(IBlockAccess iba, int[] c, Block block)
	{
		return iba.getBlock(c[0], c[1], c[2]) != Blocks.air && iba.getBlock(c[0], c[1], c[2]) != block;
	}

	private static boolean c(IBlockAccess iba, int[] c)
	{
		return iba.getBlock(c[0], c[1], c[2]) == Blocks.air;
	}

	private static boolean d(IBlockAccess iba, int[] c, Block block)
	{
		return (iba.getBlock(c[0], c[1], c[2]) == block) || (iba.getBlock(c[0], c[1] + 1, c[2]) == block);
	}

	private static boolean e(IBlockAccess iba, int[] c, Block block)
	{
		return iba.getBlock(c[0], c[1] - 1, c[2]) == block;
	}

	private static boolean f(IBlockAccess iba, int[] c, Block block)
	{
		return iba.getBlock(c[0], c[1], c[2]) == Blocks.air && iba.getBlock(c[0], c[1] - 1, c[2]) == block;
	}

	private static boolean g(IBlockAccess iba, int[] c, Block block)
	{
		return iba.getBlock(c[0], c[1], c[2]) == Blocks.air && iba.getBlock(c[0], c[1] - 1, c[2]) != block;
	}
}
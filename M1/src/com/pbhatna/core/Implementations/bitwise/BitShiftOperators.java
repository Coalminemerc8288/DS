package com.pbhatna.core.Implementations.bitwise;

/**
 * There are three bit shift operators
 *  <<  -> Left shift operator
 *  >>> -> Unsigned right shift operator
 *  >>  -> Signed right shift operator
 *
 * 1.  <<  -> Left shift operator
 *  Example   6 -> 00000000 00000000 00000000 00000110
 *       6 << 1 -> 00000000 00000000 00000000 00001100        = equivalent 12(decimal)
 *      Inserts zero at the lower bits(right)
 *      Same effect as multiplication by powers of 2
 *      6 * 2^1 = 12
 *      6 * 2^3 = 48
 *
 *
 * 2.   >>> -> Unsigned right shift operator
 *  Example   12 -> 00000000 00000000 00000000 00001100
 *      12 >>> 1 -> 00000000 00000000 00000000 00000110        = equivalent 6 (decimal)
 *      Inserts zero at the higher bits(left)
 *       Same effect as division by power of 2
 *       12 / 2^1 = 6
 *
 *  3. >> -> Signed right shift operator
 *      Same as Unsigned right shift but padded with MSB(Most significant bits(left) sign is retained
 *      Example -2,147,483,552 -> 10000000 00000000 00000000 01100000
 *         -2,147,483,552 >> 4 -> 11111000 00000000 00000000 00000110    = -134,217,722
 */
public class BitShiftOperators {}
package com.pbhatna.problems.stringandarrays;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows <=1) {return s;}

        //initialize string builder array for number of rows given
        StringBuilder[] sb = new StringBuilder[numRows];
        for (int i =0; i< sb.length; i++) {
            sb[i] = new StringBuilder();   // initialize every row in teh string builder array
        }

        // Fill string builder array
        int increment = 1;
        int index = 0;
        for (int i=0; i < s.length(); i++) {
            sb[index].append(s.charAt(i));

            if (index == 0) {increment = 1;}
            if (index == numRows-1) {increment = -1;}
            index += increment;
        }

        String result = "";
        for (int i=0; i <sb.length; i++) {      // serialize the string builder array
            result += sb[i];
        }
        return result.toString();
    }
}

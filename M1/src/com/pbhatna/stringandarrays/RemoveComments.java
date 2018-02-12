package com.pbhatna.stringandarrays;
import java.util.List;
import java.util.ArrayList;

/**
 * RemoveComments
 *
 * Given a C++ program, remove comments from it.
 * The program source is an array where source[i] is the i-th line of the source code.
 * This represents the result of splitting the original source code string by the newline character \n.
 *
 * Solution: we only need to check following scenarios
 *  If we see ‘//’ we stop reading the current line, and add whatever characters we have seen to the result.
 *  If we see ‘/\’ then we start the multiline comment mode and we keep on ignoring characters until we see '\/’.
 *  If the current character is neither of the above two and the multiline comment mode is off,
 *  then we add that character to the current line.
 *  Once we parse one line (source[i]), then if the mode is off,
 *  we add the currently generated line (StringBuilder) to the result and repeat for source[i + 1].
 *
 *
 *  Input:
 *  source = ["/*Test program *\/", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing *\/", "a = b + c;", "}"]
 *       The line by line code is visualized as below:
 *       /*Test program *\/
 *       int main()
 *       {
 *       // variable declaration
 *       int a, b, c;
 *       /* This is a test
 *           multiline
 *           comment for
 *           testing *\/
 *           a = b + c;
 *       }
 *
 *       Output: ["int main()","{ ","  ","int a, b, c;","a = b + c;","}"]
 *
 *       The line by line code is visualized as below:
 *       int main()
 *       {
 *
 *       int a, b, c;
 *       a = b + c;
 *       }
 *
 *       Explanation:
 *       The string /* denotes a block comment, including line 1 and lines 6-9. The string // denotes line 4 as comments.
 *
 */
public class RemoveComments {
    public List<String> removeStrings(String[] sourceList) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean mode  = false;

        for (String s: sourceList) {
            // iterate over each string
            for (int i = 0; i <s.length(); i++) {

                if (mode) {
                    // case 3: close of multi comment block
                    if (s.charAt(i) == '*' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        mode = false;
                        i++;
                    }
                } else {

                    //case 1 : // variable declaration
                    if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '/') {
                        break; //ignore remaining characters on the line
                    } else if (s.charAt(i) == '/' && i < s.length() - 1 && s.charAt(i + 1) == '*') {
                        //case 2 :  open block for multiline comment
                        // /* This is a test
                        // multiline
                        // comment for
                        // testing *\
                        mode = true;
                        i++;
                    } else {
                        sb.append(s.charAt(i));  // clean values
                    }
                }
            }

            if (!mode && sb.length() > 0) {
                result.add(sb.toString());
                sb = new StringBuilder();
            }
        }
        return result;
    }
}

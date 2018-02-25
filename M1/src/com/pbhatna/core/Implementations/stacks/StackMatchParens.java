package com.pbhatna.core.Implementations.stacks;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class StackMatchParens {

    private static final Map<Character, Character> matchingParenMap = new HashMap<>();
    private static final Set<Character> openParenSet = new HashSet<>();

    static {
        matchingParenMap.put(')','(');
        matchingParenMap.put('}','{');
        matchingParenMap.put(']','[');
        openParenSet.addAll(matchingParenMap.values());
    }


    public static boolean hasMatchingParens(String input) {

        Stack<Character> parenStack = new Stack<>();
        for (int i=0; i < input.length(); i++) {
            char ch = input.charAt(i);
            try {
                if (openParenSet.contains(ch)) {
                    parenStack.push(ch);
                }

                if (matchingParenMap.containsKey(ch)) {
                    char lastParen = parenStack.pop();
                    if (lastParen != matchingParenMap.get(ch)) {
                        return false;
                    }
                }
              return parenStack.isEmpty();   // Must valid check, stack may have additional paren's lying around

            } catch (Stack.StackOverflowException soe) {
                System.err.println(soe.getMessage());
            } catch (Stack.StackUnderflowException sue) {
                System.err.println(sue.getMessage());
            }
        }
        return false;
    }
}

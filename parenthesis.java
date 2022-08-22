package DZ5;

import java.util.Stack;

public class parenthesis {
    public static void main(String[] args) {
        String str1 = "(){}[]";
        String str2 = "([{}])";
        String str3 = "({[})]";

        System.out.print(" => " + check(str3));
    }

    public static boolean check(String str) {
        System.out.print(str);
        if (str.length() % 2 != 0) { // если число символов нечётное то есть лишняя скобка
            return false;
        }
        Stack<Character> stack = new Stack<>();
       
        for (int i = 0; i < str.length(); i++) {
            char symbol = str.charAt(i);
            if (symbol == '(' || symbol == '{' || symbol == '[')
                stack.push(symbol); // кладем каждую открывающуюся скобку в стак
            else if (symbol == ']') { // а если скобка закрывающая - смотрим, соответствует ли ей "верхняя" в стаке
                if (stack.empty() || stack.pop() != '[')
                    return false;
            } 
            else if (symbol == '}') {
                if (stack.empty() || stack.pop() != '{')
                    return false;
            } 
            else if (symbol == ')') {
                if (stack.empty() || stack.pop() != '(')
                    return false;
            }
        }

        return true;
    }
}

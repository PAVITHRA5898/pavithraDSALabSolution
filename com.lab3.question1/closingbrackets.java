package com.lab3.question1;

import java.util.Stack;

public class closingbrackets {
    static boolean checkBracketsClosing(String bracketExpression){
        //Initialize Stack
		Stack<Character> stack = new Stack<Character>();

		//Traverse across each character in the bracket expression
		for (int i = 0; i < bracketExpression.length(); i++)
		{
			//Fetch each character
			char x = bracketExpression.charAt(i);
			
			//check if character is open bracket
			if (x == '(' || x == '[' || x == '{')
			{
				stack.push(x);
				continue;
			}

			if (stack.isEmpty())
				return false;
			
			char check = stack.pop();
			switch (x) 
			{
				case ')':
					if (check == '{' || check == '[')
						return false;
					break;
					
				case '}':
					if (check == '(' || check == '[')
						return false;
					break;

				case ']':
					if (check == '(' || check == '{')
						return false;
					break;
			}
		}

		return (stack.isEmpty());
    }

public static void main(String[] args) {

    String bracketExpression = "({[]})[]";

    Boolean result;

    result = checkBracketsClosing(bracketExpression);

    if (result)
        System.out.println("the entered string has balanced brackets");
    else
        System.out.println("the entered string is not balanced");
    }
}
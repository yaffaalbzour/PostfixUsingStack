/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfixusingstack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author yaffa
 */
public class PostfixUsingStack {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String infix, postfix;
        final File in_file = new File("/Users/yaffa/Desktop/input_file.txt");
        final File out_file = new File("/Users/yaffa/Desktop/output_file.txt");
        try{
            FileReader fileReader = new FileReader(in_file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            Stack<Integer> stack = new Stack();
            
            FileWriter fileWriter = new FileWriter(out_file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            while ((infix = bufferedReader.readLine()) != null) {
		postfix = toPostfixExpresion(infix);
                char currentChar;
                
                for(int i = 0; i < postfix.length(); i++){
                    currentChar=postfix.charAt(i);
                    
                    if(Character.isDigit(currentChar)){
                       int currentInt = Character.getNumericValue(currentChar);
                        stack.push(currentInt);
                    }else{
                        int operand_1 = stack.pop();
                        int operand_2 = stack.pop();
                        
                        switch (currentChar){
                            case '+': stack.push(operand_2 + operand_1); break;
                            case '-': stack.push(operand_2 - operand_1); break;
                            case '*': stack.push(operand_2 * operand_1); break;
                            case '/': stack.push(operand_2 / operand_1); break;
                        }
                        
                    }
                }
                fileWriter.write(stack.peek());
                System.out.println(" = " + stack.peek());
            }
            bufferedWriter.close();
            bufferedReader.close();
            
            //System.out.println(stringBuffer.toString());  
        }catch(IOException e){
        }
        
        Stack<Integer> stack = new Stack();
    }

    private static String toPostfixExpresion(String infix) {
        Stack<Character> post_stack = new Stack();
        String postfix = "";
        char currentChar;
        for (int i = 0; i<infix.length(); i++){
            currentChar = infix.charAt(i);
            if(Character.isDigit(currentChar)){
                postfix+=currentChar;
            }else {
                switch (currentChar){
                    case '(': post_stack.push('(');  break;
                    case ')':
                        while(post_stack.peek()!='(')
                            postfix+=post_stack.pop();
                        post_stack.pop();
                        break;
                    case '+': 
                        if(!post_stack.isEmpty())
                            if(!post_stack.isEmpty() && post_stack.peek() == '-' || post_stack.peek() == '+' 
                                    || post_stack.peek() == '/' || post_stack.peek() == '*'){
                                postfix += post_stack.pop();
                            }
                        post_stack.push('+');
                        break;
                    case '-': 
                        if(!post_stack.isEmpty())
                            if(!post_stack.isEmpty() && post_stack.peek() == '-' || post_stack.peek() == '+' 
                                    || post_stack.peek() == '/' || post_stack.peek() == '*'){
                                postfix+=post_stack.pop();
                            }
                        post_stack.push(currentChar);
                        break;
                    case '*': 
                        if(!post_stack.isEmpty())
                            if(post_stack.peek() == '/' || post_stack.peek() == '*'){
                                postfix+=post_stack.pop();
                            }
                        post_stack.push('*');
                        break;
                    case '/': 
                        if(!post_stack.isEmpty())
                            if(!post_stack.isEmpty() && post_stack.peek() == '/' || post_stack.peek() == '*'){
                                postfix+=post_stack.pop();
                            }
                        post_stack.push(currentChar);
                        break;
                }
            }     
        }
        while(!post_stack.isEmpty()){ //flush
            postfix+=post_stack.pop();
        }
        System.out.println(postfix);
        return postfix;
        
    }
    
}

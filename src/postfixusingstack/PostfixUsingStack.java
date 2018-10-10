/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfixusingstack;

import java.io.BufferedReader;
import java.io.FileReader;

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
        String line, postfix_line;
        try(BufferedReader br = new BufferedReader(new FileReader("/Users/yaffa/input.txt"))){
            do{
                line = br.readLine();
                
            }while(line != null);
        }catch(Exception e){
            
        }
        Stack stack = new Stack();
    }
    
}

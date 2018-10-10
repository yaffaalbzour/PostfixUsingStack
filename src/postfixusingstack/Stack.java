/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package postfixusingstack;

/**
 *
 * @author yaffa
 */
class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
}
public class Stack {
    private Node top;
    
    public void push(int num){
        Node node = new Node(num);
        node.next = top;
        top = node;
    }
    public int pop(){
        int data = top.data;
        top=top.next;
        return data;
    }
    public int peek(){
        return top.data;
    }
    public boolean isEmpty(){
        return top == null;
    }
}

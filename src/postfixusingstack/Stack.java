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
class Node<E>{
        E data;
        Node next;
        public Node(E data){
            this.data = data;
        }
}
public class Stack<E> {
    private Node top;
    
    public void push(E num){
        Node node = new Node(num);
        node.next = this.top;
        this.top = node;
    }
    public E pop(){
        E data = (E) top.data;
        top = top.next;
        return data;
    }
    public E peek(){
        return (E) this.top.data;
    }
    public boolean isEmpty(){
        return top == null;
    }
}

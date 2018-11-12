/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3a;

import java.util.Scanner;

/**
 *
 * @author Jinn
 */
public class TestPalindrome {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s;
        boolean isPalindrome = true;
        StackInterface<Character> stack = new ArrayStack();
        QueueInterface<Character> queue = new ArrayQueue();
        
        System.out.print("Enter a word: ");
        s = input.nextLine();
        
        for(int i = 0 ; i < s.length(); ++i){
            char sc = Character.toUpperCase(s.charAt(i));
            stack.push(sc);
            queue.enqueue(sc);
        }
        
        if(queue.isEmpty() || stack.isEmpty()){
            isPalindrome = false;
        }
        
        while(!queue.isEmpty()){
            if(stack.pop() != queue.dequeue()){
                isPalindrome = false;
                break;
            }
        }
        if(isPalindrome)
            System.out.println(s + " is a palindrome");
        else
            System.out.println(s + " is not a palindrome");
    }
    
}

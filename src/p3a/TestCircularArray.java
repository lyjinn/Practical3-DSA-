/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p3a;

/**
 *
 * @author Tarc
 */
public class TestCircularArray {
    public static void main(String[] args){
        String word = "abcd";
        QueueInterface<Character> cQueue = new CircularArrayQueue();
        for(int i = 0 ; i < word.length() ; ++i){
            cQueue.enqueue(word.charAt(i));
        }
        cQueue.dequeue();
        cQueue.enqueue('e');
        while(!cQueue.isEmpty()){
            System.out.print(cQueue.dequeue());
        }
    }
}

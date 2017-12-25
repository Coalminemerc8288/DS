package com.pbhatna.stringandarrays;
import java.util.Queue;
import java.util.LinkedList;
/**
 *
 * 346 MovingAverageFromDataStream
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 */
public class MovingAverageFromDataStream {
    private Queue<Integer> queue;
    private int size;
    double average;

    public MovingAverageFromDataStream(int size) {
        queue = new LinkedList();
        this.size = size;
    }

    public double getNext(int newValue) {
         if (queue.size() < size) {// If queue is not full
             queue.offer(newValue);
             int sum = 0;
             for (int i :queue) {sum+=i;}
             average = (double) sum / queue.size();
             return average;
         }  else { // if full
             int head = queue.poll();
             double minus = head/size;
             queue.offer(newValue);
             double add = newValue/size;
             average = average + add - minus;
             return average;
         }
    }
}

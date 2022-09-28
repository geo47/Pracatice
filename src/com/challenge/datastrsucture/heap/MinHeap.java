package com.challenge.datastrsucture.heap;

import java.util.*;

class MinHeap {

    public static void main(String args[])  {
        // Create priority queue object
        PriorityQueue<Integer> pQueue_heap = new PriorityQueue<>();
        // Add elements to the pQueue_heap using add()
        pQueue_heap.add(100);
        pQueue_heap.add(30);
        pQueue_heap.add(20);
        pQueue_heap.add(40);

        // Print the head (root node of min heap) using peek method
        System.out.println("Head (root node of min heap):" + pQueue_heap.peek());
        // Print min heap represented using PriorityQueue
        System.out.println("\n\nMin heap as a PriorityQueue:");
        Iterator<Integer> iter = pQueue_heap.iterator();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");

        // remove head (root of min heap) using poll method
        pQueue_heap.poll();
        System.out.println("\n\nMin heap after removing root node:");
        //print the min heap again
        Iterator<Integer> iter2 = pQueue_heap.iterator();
        while (iter2.hasNext())
            System.out.print(iter2.next() + " ");
    }
}
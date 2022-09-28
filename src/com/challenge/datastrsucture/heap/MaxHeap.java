package com.challenge.datastrsucture.heap;

import java.util.*;

class MaxHeap {
    public static void main(String args[])  {

        // Create the comparator logic to create a Max-heap
        Queue<Integer> comparator = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        // Create empty priority queue
        //with Collections.reverseOrder to represent max heap
//        PriorityQueue<Integer> pQueueHeap = new PriorityQueue<>(Collections.reverseOrder());

        //with Comparator.reverseOrder to represent max heap
        PriorityQueue<Integer> pQueueHeap = new PriorityQueue<>(Comparator.reverseOrder());
        //with comparator to represent max heap
//        PriorityQueue<Integer> pQueueHeap = new PriorityQueue<>(comparator);

        // Add items to the pQueue using add()
        pQueueHeap.add(10);
        pQueueHeap.add(90);
        pQueueHeap.add(20);
        pQueueHeap.add(40);

        // Printing all elements of max heap
        System.out.println("The max heap represented as PriorityQueue:");
        Iterator<Integer> iter = pQueueHeap.iterator();
        while (iter.hasNext())
            System.out.print(iter.next() + " ");

        // Print the highest priority element (root of max heap)
        System.out.println("\n\nHead value (root node of max heap):" +
                pQueueHeap.peek());

        // remove head (root node of max heap) with poll method
        pQueueHeap.poll();
        //print the max heap again
        System.out.println("\n\nMax heap after removing root: ");
        Iterator<Integer> iter2 = pQueueHeap.iterator();
        while (iter2.hasNext())
            System.out.print(iter2.next() + " ");
    }
}

package com.challenge.practice.flight;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * Flights                  maxFlights = 0, 1, 2, 2, 2, 3 (0, 1, 2, 1, 2, 3)
 *
 * (4, 8)   - 2             Flights in the air
 * (2, 5)   - 1             (2, 5)  - 1          (17, 20)   - 5
 * (17, 20) - 5             (4, 8)  - 2
 * (10, 21) - 4             (9, 18) - 3
 * (9, 18)  - 3             (10, 21)- 4
 *
 *
 * Algorithm:
 *
 * next_pair (start_time) > current_pair (start_time) && next_pair (start_time) < current_pair (end_time)
 * 1) Sort flights by start time.
 * 2) Loop through each flight
 *  2a) Remove any flight that have landed (Use Min-HEAP for this)
 *  2b) Add flights to the list of flights in the air
 *  2c) update maxFlights variable.
 * 3) return maxFlights
 *
 *
 * Data structure to be used is: MIN HEAP.
 *
 *                  1
 *               /     \
 *              3       2
 *             / \     /
 *            4   6   5
 * Min Heap is the collection of data where the minimum value can be retrieved in constant time.
 * So we don't have to loop through the entire list. The data structure is structured in a way
 * where we can instantly get the minimum number.
 * */

public class MaxFlight {

    public static void main(String[] args) {

        List<Flight> flights = new ArrayList<>();
        flights.add(new Flight(4, 8));
        flights.add(new Flight(2, 5));
        flights.add(new Flight(17, 20));
        flights.add(new Flight(10, 21));
        flights.add(new Flight(9, 18));

        System.out.println(maxPlanesInTheAir(flights));
    }

    public static int maxPlanesInTheAir(List<Flight> flightList) {

        int maxFlights = 0;

        // 1) sorting flightList by flight start time using Java built-in function
        flightList.sort(new Comparator<Flight>() {
            @Override
            public int compare(Flight o1, Flight o2) {
                return o1.start - o2.start;
            }
        });

        // In Java PriorityQueue has the functionality of Min-HEAP, We pass the variable that we need to get
        // the minimum of
        PriorityQueue<Flight> flightsInTheAir = new PriorityQueue<>(new Comparator<Flight>() {
            @Override
            public int compare(Flight o1, Flight o2) {
                return o1.end - o2.end;
            }
        });

        // 2) Loop through the flights
        for (Flight flight:flightList){

            while (!flightsInTheAir.isEmpty() && flightsInTheAir.peek().end < flight.start) {
                flightsInTheAir.poll();
            }

            flightsInTheAir.add(flight);
            maxFlights = Math.max(maxFlights, flightsInTheAir.size());
        }
        return maxFlights;
    }
    static class Flight {
        int start;
        int end;

        Flight(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
}

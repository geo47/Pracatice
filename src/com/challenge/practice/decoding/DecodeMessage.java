package com.challenge.practice.decoding;

/**
 *
 * 'a' -> 1         "ab" -> "12"
 * 'b' -> 2
 * 'c' -> 3         data = "12" -> "12" or "l"
 *  .
 *  .               num_ways(data) -> 2
 *  .
 * 'z' -> 26        "01" -> 0 (because there is no message that maps to '01')
 *
 * O(n): where n is the number of letters in a given message/text/data.
 *
 * We assume that the given data string has only  digits inside between 0 ~ 9.*/
public class DecodeMessage {
    
}

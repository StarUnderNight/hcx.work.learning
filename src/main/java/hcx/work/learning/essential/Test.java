package hcx.work.learning.essential;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class Test {
	public static void main(String[] args) {
		new Test().lengthOfLongestSubstring("pwwkew");
	}
	
	public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        char[] seq = s.toCharArray();
        int len = seq.length;
        for (int i = 0; i < len; i++) {
            if (map.get(seq[i]) == null) {
                map.put(seq[i],i);
                end++;
            } else {
                if (map.get(seq[i]) < start) {
                    // ¸üÐÂmap
                    start = map.get(seq[i]) + 1;
                    map.remove(seq[i]);
                    i--;
                } else {
                    max = max > end - start ? max : end - start;
                }
            }
        }
        return max > end - start ? max : end - start;
    }



}

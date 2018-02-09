package kr.hakin.algorithm.kakao;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

public class Solution {
	public static void main(String[] args) {
			LinkedList<String> a = new LinkedList();
			
			String h1 = "Alex";
			String h2 = "Ale";
			
			a.add(h1);
			a.add(h2);
			Collections.sort(a);
			String[] arr = {"Alee", "Ale"};
			
			Arrays.sort(arr);
			
			System.out.println(a.getLast());
			System.out.println(arr[arr.length-1]);
	}
}

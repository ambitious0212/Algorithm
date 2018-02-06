package kr.hakin.algorithm.kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class DartGame {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int testCaseNum = Integer.parseInt(br.readLine().trim());
			
			while((testCaseNum--) > 0) {
				String inputData = br.readLine().trim();
				
				String[] score = inputData.split("[SDT]\\*?\\#?");
				String[] operate = inputData.split("\\d");
				
				System.out.println(Arrays.toString(score));
				System.out.println(Arrays.toString(operate));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
//TEST CASE//

/*
 1S2D*3T
 1D2S#10S
*/
package kr.hakin.algorithm.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CLOCKSYNC {
	//private int[] input = {12,6,6,6,6,6,12,12,12,12,12,12,12,12,12,12};
	//private int[] input = {12,9,3,12,6,6,9,3,12,9,12,9,12,12,6,6};
	private int[] input;
	private int minValue = Integer.MAX_VALUE;
	private int[] clickNum = new int[10];
	private int[][] switches = {
			{0,1,2},
			{3,7,9,11},
			{4,10,14,15},
			{0,4,5,6,7},
			{6,7,8,10,12},
			{0,2,14,15},
			{3,14,15},
			{4,5,7,14,15},
			{1,2,3,4,5},
			{3,4,5,9,13}
	};
	
	private long cnt = 0;
	public CLOCKSYNC(String[] inputData) {
		input = new int[16];
		
		for(int i=0; i < inputData.length; i++) {
			input[i] = Integer.parseInt(inputData[i].trim());
		}
		
		sync(0, 0);
		
		if(minValue == Integer.MAX_VALUE) {
			System.out.println("-1");
		} else {
			System.out.println(minValue);
		}
	}
	
	public void sync(int clock, int total) {
		if(clock == 10) {
			int[] temp = new int[16];
			for(int i = 0; i < clickNum.length; i++) {
				for(int j = 0; j < switches[i].length; j++) {
					temp[switches[i][j]] += 3 * clickNum[i]; 
				}
			}
			
			boolean b = true;
			for(int i = 0; i < input.length; i++) {
				if(((temp[i] + input[i]) % 12) != 0){
					b = false;
					break;
				}
			}
			
			if(b) {
				//System.out.println(Arrays.toString(temp));
				//System.out.println(Arrays.toString(clickNum));
				//System.out.println(total);
				if(minValue>total) {
					minValue = total;
				}
			}
			
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			clickNum[clock] = i;
			sync(clock + 1, total + i);
		}
	}
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int numOfTestCase = Integer.parseInt(br.readLine());

			if(numOfTestCase > 30) {
				return;
			}
			
			while ((numOfTestCase--) > 0) {
				String[] inputDatas = br.readLine().trim().split(" ");
				CLOCKSYNC c = new CLOCKSYNC(inputDatas);
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

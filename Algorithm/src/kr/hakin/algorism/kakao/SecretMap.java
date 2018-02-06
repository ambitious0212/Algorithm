package kr.hakin.algorism.kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SecretMap {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int testCaseNum = Integer.parseInt(br.readLine().trim());

			while ((testCaseNum--) > 0) {
				int size = Integer.parseInt(br.readLine().trim());

				int[][] map = new int[2][size];

				for (int i = 0; i < 2; i++) {
					String[] inputDatas = br.readLine().trim().split(" ");

					for (int j = 0; j < size; j++) {
						map[i][j] = Integer.parseInt(inputDatas[j]);
					}
				}

				String[] result = new String[size];
				for (int i = 0; i < size; i++) {
					result[i] = Integer.toBinaryString(map[0][i] | map[1][i]);
					result[i] = result[i].replaceAll("1", "#");
					result[i] = result[i].replaceAll("0", " ");
					
				}
				
				System.out.println(Arrays.toString(result));
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

//// TEST CASE
/*
2
5
9 20 28 18 11
30 1 21 17 28
6
46 33 33 22 31 50
27 56 19 14 14 10 
  
 */


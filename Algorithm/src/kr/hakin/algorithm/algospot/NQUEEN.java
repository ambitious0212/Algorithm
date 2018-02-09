package kr.hakin.algorithm.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQUEEN {
	public static int[] positionsOfQueen;
	public static int sizeOfMatrix;
	public static int cnt;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int testCaseNum = Integer.parseInt(br.readLine().trim());

			while ((testCaseNum--) > 0) {
				sizeOfMatrix = Integer.parseInt(br.readLine().trim());
				positionsOfQueen = new int[sizeOfMatrix];
				cnt = 0;
				if (sizeOfMatrix == 1) {
					System.out.println("1");
				} else {
					tracking(0);
					System.out.println(cnt);
				}
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void tracking(int row) {
		if (row == sizeOfMatrix) {
			cnt++;
			return;
		}

		for (int i = 0; i < sizeOfMatrix; i++) {
			if (checking(i, row)) {
				positionsOfQueen[row] = i;
				tracking(row + 1);
			}
		}
	}

	public static boolean checking(int cur, int row) {
		if (row == 0) {
			return true;
		}

		for (int i = 0; i < row; i++) {
			if(cur == positionsOfQueen[i]) {
				return false;
			} else if((row - i) == Math.abs(cur - positionsOfQueen[i])) {
				return false;
			}
		}
		
		return true;
	}
}

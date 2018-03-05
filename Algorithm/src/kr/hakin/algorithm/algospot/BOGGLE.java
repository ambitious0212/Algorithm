package kr.hakin.algorithm.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOGGLE {
	private int sizeOfMatrix;
	private char[][] matrixOfWord;
	private int[] movementX = { -1, -1, -1, 0, 0, 1, 1, 1 };
	private int[] movementY = { -1, 0, 1, 1, -1, -1, 0, 1 };

	public BOGGLE(char[][] matrixOfWord) {
		this.sizeOfMatrix = 5;
		this.matrixOfWord = new char[sizeOfMatrix][sizeOfMatrix];
		this.matrixOfWord = matrixOfWord;
	}

	public boolean find(String keyword) {
		for (int i = 0; i < sizeOfMatrix; i++) {
			for (int j = 0; j < sizeOfMatrix; j++) {
				if(findWord(keyword, i, j)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean findWord(String keyword, int coordinateX, int coordinateY) {
		if (keyword.length() < 1) {
			return true;
		}
		
		if (coordinateX < 0 || coordinateY < 0 || coordinateX >= sizeOfMatrix || coordinateY >= sizeOfMatrix) {
			return false;
		}

		if (matrixOfWord[coordinateX][coordinateY] != keyword.charAt(0)) {
			return false;
		}

		for (int i = 0; i < 8; i++) {
			if(findWord(keyword.substring(1), coordinateX + movementX[i], coordinateY + movementY[i])) {
				return true;
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int numOfTestCase = Integer.parseInt(br.readLine().trim());

			if (numOfTestCase > 50) {
				return;
			}

			while ((numOfTestCase--) > 0) {
				char[][] matrixOfWord = new char[5][5];

				for (int i = 0; i < 5; i++) {
					matrixOfWord[i] = br.readLine().trim().toCharArray();
				}

				BOGGLE b = new BOGGLE(matrixOfWord);

				int numOfFindWords = Integer.parseInt(br.readLine().trim());
				
				for (int i = 0; i < numOfFindWords; i++) {
					String targetWord =br.readLine().trim();
					
					System.out.println(targetWord + " " + ((b.find(targetWord)) ? "YES" : "NO"));
				}
				/*
				 * for(int i = 0; i < 5; i++) {
				 * System.out.println(Arrays.toString(matrixOfWord[i])); }
				 */
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

package kr.hakin.algorithm.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class PICNIC {
	private HashMap<Integer, ArrayList<Integer>> mapOfPairInfo;
	private boolean[] isMatching;
	private int numOfStudents;
	private int numOfPair;
	private int countOfGroup;

	public PICNIC(int numOfStudents, int numOfPair, String[] pairInfo) {
		this.numOfStudents = numOfStudents;
		this.numOfPair = numOfPair;
		isMatching = new boolean[numOfStudents];
		mapOfPairInfo = new HashMap<>();

		for (int i = 0; i < numOfStudents; i++) {
			mapOfPairInfo.put(i, new ArrayList<>());
		}

		for (int j = 0; j < numOfPair; j++) {
			mapOfPairInfo.get(Integer.parseInt(pairInfo[2 * j])).add(Integer.parseInt(pairInfo[(2 * j) + 1]));
			mapOfPairInfo.get(Integer.parseInt(pairInfo[(2 * j) + 1])).add(Integer.parseInt(pairInfo[2 * j]));
		}

		/*
		 * for (Integer key : mapOfPairInfo.keySet()) {
		 * System.out.println(mapOfPairInfo.get(key));
		 * 
		 * }
		 */
		makeGroup();
		System.out.println(countOfGroup);
	}

	public void makeGroup() {
		int targetStudent = -1;

		for (int i = 0; i < numOfStudents; i++) {
			if(!isMatching[i]) {
				targetStudent = i;
				break;
			}
		}
		
		if(targetStudent == -1) {
			countOfGroup++;
			return;
		}
		
		for (int i = targetStudent + 1; i < numOfStudents; i++) {
			if(!isMatching[i] && mapOfPairInfo.get(targetStudent).contains(i)) {
				isMatching[targetStudent] = true;
				isMatching[i] = true;
				makeGroup();
				isMatching[i] = false;
				isMatching[targetStudent] = false;
			}
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int numOfTestCase = Integer.parseInt(br.readLine().trim());

			if (numOfTestCase > 50) {
				return;
			}

			while ((numOfTestCase--) > 0) {
				String[] inputDatas = br.readLine().trim().split(" ");
				int numOfStudents = Integer.parseInt(inputDatas[0]);
				if ((numOfStudents < 2) || (numOfStudents > 10)) {
					return;
				}

				int numOfPair = Integer.parseInt(inputDatas[1]);
				if ((numOfPair < 0) || (numOfPair > ((numOfStudents * (numOfStudents - 1)) / 2))) {
					return;
				}

				String[] pairInfo = br.readLine().trim().split(" ");

				PICNIC p = new PICNIC(numOfStudents, numOfPair, pairInfo);
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

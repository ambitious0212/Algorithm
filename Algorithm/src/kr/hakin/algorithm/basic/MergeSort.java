package kr.hakin.algorithm.basic;

import java.util.Arrays;

public class MergeSort {
	public static int result[];

	public static void main(String[] args) {
		int[] datas = { 2, 1, 6, 8, 3, 5, 7, 8, 10, 4, 9 };
		result = new int[datas.length];

		mergeSort(datas, 0, datas.length - 1);
	}

	public static void mergeSort(int[] data, int left, int right) {
		int mid;

		if (left < right) {
			mid = (right + left) / 2;
			mergeSort(data, left, mid);
			mergeSort(data, mid + 1, right);
			merge(data, left, mid, right);

			System.out.println(Arrays.toString(data));
		}
	}

	public static void merge(int[] data, int left, int mid, int right) {
		if (left == right) {
			return;
		}

		int i = left; // 순회 시 , Left부터 mid까지 증가 시 사용 변수
		int j = mid + 1; // 순회 시 , mid부터 right까지 순회하기 위한 변수
		int k = left; // ㅈㅓ장할 인덱스를 포함하기 위한 변수
		while (i <= mid && j <= right) {
			if (data[i] <= data[j]) {
				// 왼쪽 배열을 삽입 시는 왼쪽 배열 지칭 인덱스 증가
				result[k] = data[i++];
			} else {
				// 오른쪽 배열을 삽입 시는 오른쪽 배열 지칭 인덱스 증가
				result[k] = data[j++];
			}
			// 저장할 곳의 인덱스 증가
			k++;
		}

		if (i > mid) {
			for (int z = j; z <= right; z++) {
				result[k] = data[z];
				k++;
			}
		} else {
			for (int z = i; z <= mid; z++) {
				result[k] = data[z];
				k++;
			}
		}

		for (int z = left; z <= right; z++) {
			data[z] = result[z];
		}
	}

	public void mergeSort2(int[] data, int left, int right) {
		// ==경우는 하나까지 쪼갠 경우
		if (left < right) {
			int mid = (right + left) / 2;
			mergeSort2(data, left, mid);
			mergeSort2(data, mid + 1, right);
			merge2(data,left,mid,right);
		}
	}
	
	public static void merge2(int[] data, int left, int mid, int right) {
		// ==경우는 하나까지 쪼갠 경우
		//왼쪽 오른쪽 크기 동안만 정려
		int i = left;
		int j = mid + 1;
		int k = left;  //저장 위치를 나타내는 변수
		
		
		while ((i<=mid) && (j<=right)) {
			//이부분에 따라 오름 내림 차순 정렬
			if(left > mid) {
				result[k] = data[j++];
			} else {
				result[k] = data[i++];
			}
			k++;
		}
		
		if(i > mid) {
			for(int z = j; z <= right; z++) {
				data[k] = result[z];
				k++;
			}
		} else {
			for(int z = i; z <= mid; z++) {
				data[k] = result[z];
				k++;
			}
		}
		
		for(int z = left ; z < data.length; z++) {
			data[z] = result[z];
		}
	}
}

// O(nlogN)
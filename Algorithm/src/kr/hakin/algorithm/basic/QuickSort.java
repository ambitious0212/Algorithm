package kr.hakin.algorithm.basic;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] datas = { 2, 1, 6, 8, 3, 5, 7, 8, 10, 4, 9 };

		quickSort(datas, 0, datas.length - 1);
	}

	static int i = 0;

	public static void quickSort(int[] arr, int begin, int end) {
		if (begin < end) {
			int p = partition(arr, begin, end);
			quickSort(arr, begin, p - 1);
			quickSort(arr, p + 1, end);
		}
	}

	public static int partition(int arr[], int begin, int end) {
		int left = begin;
		int right = end;

		int pivot = (left + right) / 2;

		System.out.println("[퀵 정렬 " + ++i + "단계: pivot: " + arr[pivot]);

		while (left < right) {
			while ((arr[left] < arr[pivot]) && (left < right))
				// L 움직이는 부분
				left++;
			while ((arr[right] >= arr[pivot]) && (left < right))
				// R 움직이는 부분
				right--;

			if (left < right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}

		int temp = arr[pivot];
		arr[pivot] = arr[right];
		arr[right] = temp;

		System.out.println(Arrays.toString(arr));

		return left;
	}
}

// O(nlogN)

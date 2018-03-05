package kr.hakin.algorithm.basic;

import java.util.Arrays;

public class HeapSort {
	public static void main(String[] args) {
		int[] datas = { 2, 1, 6, 8, 3, 5, 7, 8, 10, 4, 9 };
		heapify(datas);
		System.out.println("완료 : " + Arrays.toString(datas));
	}

	public static void heapify(int[] datas) {
		//int lastLeap = (datas.length / 2) - 1;
		int lastLeap = (datas.length - 1);
		for (int i = lastLeap; i >= 0; i--) {
			siftdown(datas, i);
		}
	}
	
	public static void siftdown(int[] datas, int targetIndex) {
		int leftChild = (2 * targetIndex) + 1;
		int rightChild = (2 * targetIndex) + 1;

		//자식 보유 여부 판단을 위해, 완전 이진트리이기 때문에 왼쪽 자식이 없으면 오른쪽 자식도 없음
		if(leftChild >= (datas.length)) {
			return;
		}
		
		boolean isRightChild = false;
		if(rightChild < (datas.length)) {
			isRightChild = true;
		}
		
		int maxValueIndex = targetIndex;
		if(datas[maxValueIndex] < datas[leftChild]) {
			maxValueIndex = leftChild;
		}
		
		if(isRightChild && (datas[maxValueIndex] < datas[rightChild])) {
			maxValueIndex = rightChild;
		}
		
		if(maxValueIndex != targetIndex) {
			swap(datas, targetIndex, maxValueIndex);
		}
		
		siftdown(datas,leftChild);
		siftdown(datas,rightChild);
		

	}
	
	public static void swap(int[] datas, int indexA, int indexB) {
		int temp = datas[indexA];
		datas[indexA] = datas[indexB];
		datas[indexB] = temp;
	}
	
	public static void getTreeHeight() {
		
	}
}

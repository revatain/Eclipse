package net;

import java.util.Arrays;


public class 최댓값_만들기 {
	
	// 배열 오름차순
	// 배열 원소들 중 가장 큰 값 (max), 2번째로 큰 값 (second)
	// 제일 큰수와 두번째로 큰 수 곱하기
	class Solution {
	    public int solution(int[] numbers) {
	        int [] arr = new int[numbers.length];
	            Arrays.sort(arr);
	     
	        return numbers[numbers.length-2]*numbers[numbers.length-1];
	    }
	}
}

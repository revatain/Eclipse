package net;

import java.util.Arrays;


public class �ִ�_����� {
	
	// �迭 ��������
	// �迭 ���ҵ� �� ���� ū �� (max), 2��°�� ū �� (second)
	// ���� ū���� �ι�°�� ū �� ���ϱ�
	class Solution {
	    public int solution(int[] numbers) {
	        int [] arr = new int[numbers.length];
	            Arrays.sort(arr);
	     
	        return numbers[numbers.length-2]*numbers[numbers.length-1];
	    }
	}
}

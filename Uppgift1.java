package inlämningsuppgift3;

import java.util.*;

public class Uppgift1 {
	public static int findIndex(Comparable[] a , Comparable b) {
		int answer = -1;
		for (int i = 0; i < a.length; i++) {
			if (a[i].compareTo(b) == 0) {
				return i;
			} else {
				int low = 0;
				int high = a.length - 1;
				int mid;
				while (low <= high) {
					mid = (low + high / 2);
					if (b.compareTo(a[mid]) < 0) {
						low = mid + 1;
					} else if (b.compareTo(a[mid]) > 0) {
						high = mid - 1;
					} else {
						answer = mid;
					}

				}
			}
		}
		return answer;
	}
	public static Integer[] fillArray(Integer[] c){
		for(int i = 0; i < c.length; i++){
			c[i] = i;
		}
		return c;
	}

	public static int search ( Comparable[] a , Comparable b)
	 {

	 int not_found = -1;

	 for (int i = 0; i < a.length;i++)
	 {
	 if(a[i].compareTo(b) == 0)
	 return i;
	 }

	 return not_found;
	}
	
	public static int beginSearch(Comparable[] a , Comparable b)
	{
		if(a.length <=20){
			return  search(a, b);
		} else {
				return  findIndex(a, b);
		}
	}


	public static void main(String[] args) {

		Integer[] array1 = {1,2,3,4,5,6,7,8,9,10};
		Integer[] array2 = {8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
		System.out.println(beginSearch(array1,8));
		System.out.println(beginSearch(array2,26));
		
	
	}
}

package hcx.work.learning.essential;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Knowledge {

	public static void main(String[] args) {
		new Knowledge().learn();
	}

	public void learn() {

		// ArrayList & LinkedList
		ArrayList<Integer> al;
		LinkedList<Integer> ll;
		ArrayList<Integer[]> lis = new ArrayList<Integer[]>();

		// Ïß³Ì³Ø

//		ExecutorService pool = Executors.newCachedThreadPool();
		ExecutorService pool = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 20; i++) {
			pool.execute(new Task());
		}
		pool.shutdown();

		// Arrays.sort

		int[][] arr = { { 1, 2 }, { 5, 6 }, { 0, 1 }, { 3, 4 } };
		Arrays.sort(arr, (a, b) -> a[0] - b[0]);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i][0] + "-" + arr[i][1]);
		}
		for (int[] is : arr) {

		}
	}

}

class Task implements Runnable {

	public void run() {
		System.out.println(Thread.currentThread().getName() + " run...");

	}

}

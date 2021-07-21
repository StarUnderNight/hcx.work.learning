package hcx.work.learning.essential;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

// É¨ÃèÏßËã·¨

class Interval {
	int start, end;

	Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class Car {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int K = in.nextInt();
		List<Interval> airplanes = new ArrayList<Interval>();
		for (int i = 0; i < K; i++) {
			int start = in.nextInt();
			int up = in.nextInt();
			int down = in.nextInt();
			if (up == down) {
				continue;
			}
			int end = Math.min(N - down + up, down - up) + start;
			airplanes.add(new Interval(start, end));
		}
		int ans = new Car().countOfCar(airplanes);
		System.out.println(ans);
	}

	public int countOfCar(List<Interval> airplanes) {
		List<int[]> list = new ArrayList<>();
		for (Interval in : airplanes) {
			list.add(new int[] { in.start, 1 });
			list.add(new int[] { in.end, -1 });
		}
		list.sort(Comparator.comparing((int[] p) -> p[0]).thenComparing((int[] p) -> p[1]));
		int ans = 0;
		int cnt = 0;
		for (int[] in : list) {
			cnt += in[1];
			if (cnt > ans) {
				ans = cnt;
			}
		}
		return ans;
	}
}

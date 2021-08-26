package hcx.work.learning.essential;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Test {
	static class Student {
		int no;
		String name;

		public Student(int no, String name) {
			super();
			this.no = no;
			this.name = name;
		}

	}

	public static void main(String[] args) {
		int m = 3;
		int n = 3;
		// [0,1],[1,2],[2,1],[1,0],[0,2],[0,0],[1,1
		int[][] positions = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 1 }, { 1, 0 }, { 0, 2 }, { 0, 0 }, { 1, 1 } };

//	new Test().numIslands2(m, n, positions);

		stuQueue = new PriorityQueue<Test.Student>(10, (a, b) -> {
			return a.no - b.no;
		});

		stuQueue.add(new Student(10, "h"));
		stuQueue.add(new Student(8, "h"));
		stuQueue.add(new Student(4, "h"));
		stuQueue.add(new Student(7, "h"));
		stuQueue.add(new Student(8, "h"));
		stuQueue.add(new Student(1, "h"));
		stuQueue.add(new Student(4, "h"));

		while (!stuQueue.isEmpty()) {
			System.out.println(stuQueue.poll().no);
		}

	}

	private List<Integer> ansList;
	private Map<String, String> map; // hashMap保存节点关系
	private int islandNum; // 保存岛屿的根节点
	private int[][] island; // 岛屿布局
	private int[][] rank;
	private static PriorityQueue<Student> stuQueue;

	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		map = new HashMap<String, String>();
		island = new int[m][n];
		rank = new int[m][n];
		ansList = new ArrayList<Integer>();
		for (int i = 0; i < positions.length; i++) {
			addLand(positions[i]);

			ansList.add(islandNum);
			System.out.println(ansList.toString() + " ; " + islandNum);
		}
		System.out.println("final");
		System.out.println(ansList.toString());
		return ansList;
	}

	// private void init() 应该在加入的时候进行初始化
	private void addLand(int[] freshLand) {
		// 拿到下标值
		int rowIdx = freshLand[0];
		int colIdx = freshLand[1];

		islandNum++; // 目前加入了一个岛屿，数量加一，如果可以合并，后面合并的时候，会把数量减一
		island[rowIdx][colIdx] = 1; // 岛图添加一个元素

		map.put(rowIdx + "-" + colIdx, rowIdx + "-" + colIdx); // 设置其父节点为它自己

		// 判断freshLand周围是否有其他元素
		// 上
		if (rowIdx > 0 && island[rowIdx - 1][colIdx] == 1) {
			merge(freshLand, new int[] { rowIdx - 1, colIdx });
		}
		// 下
		if (rowIdx < island.length - 1 && island[rowIdx + 1][colIdx] == 1) {
			merge(freshLand, new int[] { rowIdx + 1, colIdx });
		}
		// 左
		if (colIdx > 0 && island[rowIdx][colIdx - 1] == 1) {
			merge(freshLand, new int[] { rowIdx, colIdx - 1 });
		}
		// 右
		if (colIdx < island[0].length - 1 && island[rowIdx][colIdx + 1] == 1) {
			merge(freshLand, new int[] { rowIdx, colIdx + 1 });
		}
	}

	// 合并两个集合
	private void merge(int[] aArr, int[] bArr) {
		// 判断是否是同一个集合
		String a = aArr[0] + "-" + aArr[1];
		String b = bArr[0] + "-" + bArr[1];

		if (map.get(a).equals(map.get(b))) {
			return; // 同一个集合，无需改变
		}
		// 比较rank值
		int randA = rank[aArr[0]][aArr[1]];
		int randB = rank[bArr[0]][bArr[1]];

		if (randA == randB) {
			map.put(b, map.get(a));
			int[] root = parse(map.get(a));
			rank[root[0]][root[1]]++; // 增加rank值
		} else if (randA > randB) {
			// b加入到a中
			map.put(b, map.get(a)); // rand值不变
		} else {
			map.put(a, map.get(b));
		}
		islandNum--; // 岛屿数量减一\

		for (String e : map.keySet()) {
			System.out.println(e + " : " + map.get(e));
		}
		System.out.println("------------------------ isLand = " + islandNum);

	}
	// // [[0,1],[1,2],[2,1],[1,0],[0,2],[0,0],[1,1]]

	private int[] parse(String str) {
		String[] arr = str.split("-");
		int[] res = new int[2];
		res[0] = Integer.parseInt(arr[0]);
		res[1] = Integer.parseInt(arr[1]);
		return res;
	}

}

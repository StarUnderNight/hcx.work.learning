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
	private Map<String, String> map; // hashMap����ڵ��ϵ
	private int islandNum; // ���浺��ĸ��ڵ�
	private int[][] island; // ���첼��
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

	// private void init() Ӧ���ڼ����ʱ����г�ʼ��
	private void addLand(int[] freshLand) {
		// �õ��±�ֵ
		int rowIdx = freshLand[0];
		int colIdx = freshLand[1];

		islandNum++; // Ŀǰ������һ�����죬������һ��������Ժϲ�������ϲ���ʱ�򣬻��������һ
		island[rowIdx][colIdx] = 1; // ��ͼ���һ��Ԫ��

		map.put(rowIdx + "-" + colIdx, rowIdx + "-" + colIdx); // �����丸�ڵ�Ϊ���Լ�

		// �ж�freshLand��Χ�Ƿ�������Ԫ��
		// ��
		if (rowIdx > 0 && island[rowIdx - 1][colIdx] == 1) {
			merge(freshLand, new int[] { rowIdx - 1, colIdx });
		}
		// ��
		if (rowIdx < island.length - 1 && island[rowIdx + 1][colIdx] == 1) {
			merge(freshLand, new int[] { rowIdx + 1, colIdx });
		}
		// ��
		if (colIdx > 0 && island[rowIdx][colIdx - 1] == 1) {
			merge(freshLand, new int[] { rowIdx, colIdx - 1 });
		}
		// ��
		if (colIdx < island[0].length - 1 && island[rowIdx][colIdx + 1] == 1) {
			merge(freshLand, new int[] { rowIdx, colIdx + 1 });
		}
	}

	// �ϲ���������
	private void merge(int[] aArr, int[] bArr) {
		// �ж��Ƿ���ͬһ������
		String a = aArr[0] + "-" + aArr[1];
		String b = bArr[0] + "-" + bArr[1];

		if (map.get(a).equals(map.get(b))) {
			return; // ͬһ�����ϣ�����ı�
		}
		// �Ƚ�rankֵ
		int randA = rank[aArr[0]][aArr[1]];
		int randB = rank[bArr[0]][bArr[1]];

		if (randA == randB) {
			map.put(b, map.get(a));
			int[] root = parse(map.get(a));
			rank[root[0]][root[1]]++; // ����rankֵ
		} else if (randA > randB) {
			// b���뵽a��
			map.put(b, map.get(a)); // randֵ����
		} else {
			map.put(a, map.get(b));
		}
		islandNum--; // ����������һ\

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

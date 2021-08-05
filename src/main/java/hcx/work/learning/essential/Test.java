package hcx.work.learning.essential;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class Test {

    public static void main(String[] args) {
//		int[] arr = new int[10];
//		System.out.println(int[].class);
//		System.out.println(double[].class);
//		System.out.println(double[][][].class);
//		System.out.println(float[].class);
//		System.out.println(short[].class);
//		System.out.println(Double[].class);
//		System.out.println(Integer[].class);
//
//		Arrays.copyOf(arr, 10);
//		String[] a = new String[10];
//		Object[] b = new Object[10];
//		Arrays.copyOf(b, 10);
//		Arrays.copyOf(a, 10);
//		System.out.println((Object) Object[].class);
//		System.out.println(Object[].class);
//		HashMap<Integer, Integer> map;
//		LinkedList<Integer> LList;
//
//		PriorityQueue<Integer> queue;
	new Test().threadPoolTest();

    }

    // AQS
    public void aqsTest() {
	AbstractQueuedSynchronizer aqs;
    }

    public void threadPoolTest() {
	ExecutorService es = Executors.newFixedThreadPool(1); // 创建一个线程池
	Integer ts1 = 0;
	Integer ts2 = 0;
	Future<Integer> f1 = es.submit(new MyCallable(100)); // Future用于接收call方法返回的值
	Future<Integer> f2 = es.submit(new MyCallable(40));

	List<Runnable> list = es.shutdownNow(); // 立即关闭所有正在执行的任务，并返回待执行的任务列表
	System.out.println("list size = " + list.size());
	try {
	    System.out.println(es.isShutdown() + ";" + es.isTerminated() + ";"
		    + es.awaitTermination(1, TimeUnit.SECONDS) + ";" + es.isTerminated());
	} catch (InterruptedException e2) {
	    // TODO Auto-generated catch block
	    e2.printStackTrace();
	}
	for (int i = 0; i < list.size(); i++) {
	    Runnable r = list.get(i);
	    System.out.println("h" + r.toString());
	}

	try {
	    int r1 = f1.get();
	    int r2 = f2.get();
	    System.out.println(r1);
	    System.out.println(r2);

	} catch (InterruptedException | ExecutionException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

	Executor e1; // 顶级接口 Executor
	ExecutorService es1; // 接口，继承Executor
	AbstractExecutorService aes; // 抽象类，实现ExecutorService接口
	ThreadPoolExecutor tpe; // 继承AbstractExecutorService

    }

    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
}

class MyCallable implements Callable<Integer> {
    private int number;

    public MyCallable(int number_) {
	// TODO Auto-generated constructor stub
	this.number = number_;
    }

    @Override
    public Integer call() throws Exception {
	// TODO Auto-generated method stub
	int sum = 0;
	for (int i = 0; i < this.number; i++) {
	    sum += i;
	}
	Thread.sleep(1000);
	return sum;
    }

}

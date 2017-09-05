package kpotapov.forkjoin;

import java.util.concurrent.ForkJoinPool;

public class ForkJoinSample {

	public static void main(String[] args) {
		final int FIB_INDEX =20;
		final int PARALLELISM = 10;
		Integer fibonacciNumber = getFibonacciNumber(FIB_INDEX, PARALLELISM);
		System.out.println(":> The fibonacciNumber is: " + fibonacciNumber + " with " + FIB_INDEX);
	}

	/**
	 * calculates fibonacciNumber by its position in fibonacci sequence and parallelism value
	 * DISCLAIMER: it's not the right way to calculate fibonacci sequence
	 */
	static Integer getFibonacciNumber(int fibIndex, int parallelism) {
		final ForkJoinPool pool      = new ForkJoinPool(parallelism);
		FibonacciTask      task      = new FibonacciTask(fibIndex);
		Integer            fibonacciNumber = (Integer) pool.invoke(task);
		System.out.println(":> Number of tasks is: " +FibonacciTask.getTaskCounter());
		return fibonacciNumber;
	}
}

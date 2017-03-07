import java.util.Random;

public class QuickSort {

	public static int[] generateid(int nbVals, int min, int max) {									// Method for random number generation
		int[] res = new int[nbVals];
		Random generator = new Random();
		for (int i = 0; i != nbVals; ++i) {
			res[i] = (int) (Math.abs(generator.nextLong() % ((long) max - min)) + min);
			System.out.print(" " + res[i]);
		}
		return res;
	}

	public static void swap(int[] data, int i, int j) { 											// Swapping method
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

	public static int partition(int[] data, int begin, int end, int pivotIdx) {						// Doing partition of an array
		swap(data, pivotIdx, --end);
		pivotIdx = end;
		int pivot = data[pivotIdx];
		// invariant is that everything before begin is known to be < pivot and everything after end is known to be >= pivot
		while (begin != end) {
			if (data[begin] >= pivot) {
				swap(data, begin, --end);
			} else {
				++begin;
			}
		}
		swap(data, pivotIdx, begin);
		return begin;
	}

	public static void sort(int[] data) {
		sort(data, 0, data.length);
	}

	public static void sort(int[] data, int begin, int end) {
		if ((end - begin) < 2) {
			return;
		}
		int m = partition(data, begin, end, (end + begin) / 2);
		sort(data, begin, m);
		sort(data, m + 1, end); // +1 for convergence
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Main Method
		for (int i = 10; i <= 490; i += 10) {
			System.out.println("Random array list length of " + i + " number");
			int[] random = generateid(i, 0, 500);
			long startTime = System.nanoTime();
			sort(random);
			System.out.println();
			System.out.println("Sorted list by Quick Sort is");
			for (int j : random) {
				System.out.print(j + " ");
			}
			long endTime = System.nanoTime();
			long totalTime = endTime - startTime;
			System.out.println();
			System.out.println("Sorting done in " + totalTime + " nanoseconds");
			System.out.println();
		}
	}

}

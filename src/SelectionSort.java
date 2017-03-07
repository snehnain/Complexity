import java.util.Random;

public class SelectionSort {

	public static int[] generateid(int nbVals, int min, int max) { 									// Method for random number generation
		int[] res = new int[nbVals];
		Random generator = new Random();
		for (int i = 0; i != nbVals; ++i) {
			res[i] = (int) (Math.abs(generator.nextLong() % ((long) max - min)) + min);
			System.out.print(" " + res[i]);
		}
		return res;
	}

	public static void swap(int[] data, int i, int j) {												//Swapping method
		int tmp = data[i];
		data[i] = data[j];
		data[j] = tmp;
	}

	public static int minimumIndex(int[] data, int begin, int end) { 								// Method for finding minimum number from a list																
		int res = begin;
		for (int i = begin + 1; i != end; ++i) {
			if (data[i] < data[res]) {
				res = i;
			}
		}
		return res;
	}

	public static void sort(int[] data) { 															// Sort method- Call swapping and minimum number method
		if (data.length < 2) {
			return;
		}
		for (int i = 0; i != data.length - 1; ++i) {
			swap(data, i, minimumIndex(data, i, data.length));
		}
	}

	public static void main(String[] args) {														// Main Method
		// TODO Auto-generated method stub
		for (int i = 10; i <= 490; i += 10) {
			System.out.println("Random array list length of " + i + " number");
			int[] random = generateid(i, 0, 500);
			long startTime = System.nanoTime();
			sort(random);
			System.out.println();
			System.out.println("Sorted list by Selection Sort is");
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

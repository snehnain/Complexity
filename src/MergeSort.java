import java.util.Random;

public class MergeSort {

	public static int[] generateid(int nbVals, int min, int max) { 						// Method for random number generation
		int[] res = new int[nbVals];
		Random generator = new Random();
		for (int i = 0; i != nbVals; ++i) {
			res[i] = (int) (Math.abs(generator.nextLong() % ((long) max - min)) + min);
			System.out.print(" " + res[i]);
		}
		return res;
	}

	public static void mergeSorted(int data[], int begin, int middle, int end) {		// Merge the sorted array
		int[] tmp = new int[middle - begin];
		System.arraycopy(data, begin, tmp, 0, tmp.length);
		int i = 0, j = middle, dest = begin;
		while ((i < tmp.length) && (j < end)) {
			data[dest++] = (tmp[i] < data[j]) ? tmp[i++] : data[j++];
		}
		while (i < tmp.length) {
			data[dest++] = tmp[i++];
		}
	}

	public static void sort(int[] data) {												// Sort Method
		sort(data, 0, data.length);
	}

	public static void sort(int[] data, int begin, int end) {							//Sort Method divide the array into 2 equal half
		if ((end - begin) < 2) {
			return;
		}
		int middle = (end + begin) / 2;
		sort(data, begin, middle);
		sort(data, middle, end);
		mergeSorted(data, begin, middle, end);
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
			System.out.println("Sorted list by Merge Sort is");
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

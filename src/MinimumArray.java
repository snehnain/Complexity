import java.util.Random;

public class MinimumArray {

	public static int[] generateid(int nbVals, int min, int max) {					 // Method for random number generation
		int[] res = new int[nbVals];
		Random generator = new Random();
		for (int i = 0; i != nbVals; ++i) {
			res[i] = (int) (Math.abs(generator.nextLong() % ((long) max - min)) + min);
			System.out.print(" " + res[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 10; i <= 500; i += 10) {
			System.out.println("Random array list length of " + i + " number");
			int[] random = generateid(i, 0, 500);
			findMin(random);

		}
	}

	public static void findMin(int[] res) {
		long startTime = System.nanoTime();
		int min = res[0];
		for (int i = 0; i < res.length; i++) {
			if (res[i] < min)

			{
				min = res[i];
			}
		}
		long endTime = System.nanoTime();
		System.out.print("\n" + "The minimum value in the array is " + min + "\n");
		long totalTime = endTime - startTime;
		System.out.println("It takes " + totalTime + " nanoseconds");
		System.out.println();
		/*
		 * long endTime = System.currentTimeMillis(); System.out.print("\n"+
		 * "The minimum value in the array::"+min+"\n"); System.out.println(
		 * "It takes "+(endTime-startTime)+" seconds"); //long endTime =
		 * System.nanoTime();System.out.print("\n"+
		 * "The minimum value in the array::"+min+"\n"); //
		 */
	}

}

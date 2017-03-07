import java.util.Random;
import java.util.Scanner;

public class RandomData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		System.out.print("How many random number you wants to generate. Enter the value ");
		int num = input.nextInt(); 																// getting an integer
		int[] random = generateid(num,0,500);
		for(int i : random){
			System.out.println("Random Numbers is " + i);
		}
	}
	public static int[] generateid(int nbVals, int min, int max) {
		int[] res = new int[nbVals];
		Random generator = new Random();
		for (int i = 0; i != nbVals; ++i) {
			res[i] = (int) (Math.abs(generator.nextLong() % ((long) max - min)) + min);
		}
		return res;
	}

}

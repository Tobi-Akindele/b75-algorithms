package binary;

public class SumOfTwoIntegers {

	public static void main(String[] args) {
		System.out.println(new SumOfTwoIntegers().getSum(2, 3)); // should return 5
	}

	public int getSum(int a, int b) {

		while(b != 0) {
			int tmp = (a & b) << 1;
			a = a ^ b;
			b = tmp;
		}
		return a;
	}
}

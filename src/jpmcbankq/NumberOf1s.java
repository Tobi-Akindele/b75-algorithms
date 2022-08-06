package jpmcbankq;

public class NumberOf1s {

	public static void main(String[] args) {
		System.out.println(numberOf1s(5)); // should return 1
		System.out.println(numberOf1s(13)); // should return 6
	}

	public static int numberOf1s(int n) {
		int count = 0;
		for(int i = 1; i <= n; i++) {
			String number = String.valueOf(i);
			count += number.split("1", -1).length - 1;
		}
		return count;
	}
}

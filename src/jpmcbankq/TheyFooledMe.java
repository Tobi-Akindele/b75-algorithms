package jpmcbankq;

public class TheyFooledMe {

	public static void main(String[] args) {
		foo(10);
	}

	private static void foo(int x) {
		if(x > 0) {
			foo(--x);
		}
		System.out.println(x);
	}
}
// 0
//
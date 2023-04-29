package test;

public class Test {

	public static void main (String[] args) {
		Test obj = new Test();
		
		int test = Test.numberOfZeros(10101);
		int test2 = Test.amethod("10101", 4);
		//System.out.println(test);
		System.out.println(test2);
	}
	
	public static int numberOfZeros(int n) {
		int counter;
		
		if (n == 0) {
			counter = 1 ; // 1
		} else if (n <= 9) {
			counter = 0;
		} else if (n % 10 == 0) {
			counter = 1 + numberOfZeros(n/10);
		} else {
			counter = numberOfZeros(n/10);
		}
		
		return counter;
	}
	
	public static int amethod(String s, int n) {
		if (n < 0) {
			return 0;
		}
		if (s.charAt(n) == '1') {
			return 2 * amethod(s,n-1);
		}
		return 1 + 2 * amethod(s,n-1);
	}
	
}

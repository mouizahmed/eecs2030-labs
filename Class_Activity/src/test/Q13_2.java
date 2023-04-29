package test;

public class Q13_2 {
	static int objectCount = 0;
	int objectCreatedTime;
	public void func0(int t) {
		Q13_2 obj = new Q13_2();
		obj.objectCount ++;
		obj.objectCreatedTime = t;
		obj.func1(t);
	}
	public void func1(int t) {
		objectCount++;
		objectCreatedTime = t;
	}
	
	public static void func2(int t) {
		objectCount ++;
		objectCreatedTime = t;
	}
	
	public static void func3(int t) {
		Q13_2 obj = new Q13_2();
		obj.objectCount++;
		obj.objectCreatedTime = t;
	}
	
	public static Q13_2 getInstance(int t) {
		Q13_2 obj = new Q13_2();
//		objectCount++;
//		obj.objectCreatedTime = t;
		obj.func0(t);
//		return obj;
		return new Q13_2.func3(t);
	}
}

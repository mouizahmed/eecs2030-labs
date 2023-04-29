package test;

class Superclass {
int first; int second; 

public Superclass() {
first = 0; second = 0; }
public Superclass(int f, int s) {
first = f; second = s; }
public Object[] mainMethod() {
Object [] obj = new Object[5];
obj[0] = this.methodA(5); obj[1] = this.methodB(4); obj[2] = this.methodc(); obj[3] = this.methodD(); obj[4] = this.methodE (3); return obj; }
public static int methodA(int x) {
return x + 1; }
private int methodB(int x){
return x + first; }
public final int methodc() {
return first + second; }
public int methodD() {
return first - second; }
public int methodE(int x) {
return first + second - x; } }
class Subclass extends Superclass {
	public Subclass(int f, int s) {
first = f; second = s; }
public static int methodA(int x) {
return x - 1; }
private int methodB(int x) {
return x-first; }
private final int method (int x){
return first - second + x; }
public int methodD() {
return first * second; }
public int methode (int x) {
return first * x; }
}

public class writtentestsuper {
	public static void main(String[] args) {
		Superclass obj1 = new Subclass(3, 4);
		Object[] obj2 = obj1.mainMethod();
		for (int i = 0; i < obj2.length; i++) {
			System.out.println(obj2[i]);
			
		}
		
	}

}

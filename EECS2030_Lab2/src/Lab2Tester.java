

import static org.junit.Assert.*;


import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;





@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Lab2Tester {

	
	// sum
	
	@Test
	public void testSum1() {
		int start = 0;
		int end = 5; 
		int  sum= 0;
		for (int i = start ; i <= end ; i++) 
			sum  += i;
		
		assertEquals("Failed at sum (" + start + ", " + end + ")", sum, Lab2.sum(start, end));
			
	}
	
	@Test
	public void testSum2() {
		int start = 1;
		int end = 1; 
		int  sum= 0;
		for (int i = start ; i <= end ; i++) 
			sum  += i;
		
		assertEquals("Failed at sum (" + start + ", " + end + ")", sum, Lab2.sum(start, end));
			
	}
	


	@Test
	public void testMakeString1() {
		char init = '*'; 
		int n = 5;
		String result = ""; 
		for (int i = 0 ; i < n ; i++)
			result += init;
		assertEquals("Failed at makeString(" + init + ", " + n + ")", result, Lab2.makeString(init, n));	
	}
	
	@Test
	public void testMakeString2() {
		char init = '*'; 
		int n = 0;
		String result = ""; 
		for (int i = 0 ; i < n ; i++)
			result += init;
		assertEquals("Failed at makeString(" + init + ", " + n + ")", result, Lab2.makeString(init, n));	
	}
	

	@Test
	public void testInterlace1() {

		String str = "";
		assertEquals("Failed: interlace(\"*\",\"-\",1)", str, Lab2.interlace("Hello ","World ",0));
	}
	
	
	@Test
	public void testInterlace2() {

		String str = "Hello World ";
		assertEquals("Failed: interlace(\"*\",\"-\",1)", str, Lab2.interlace("Hello ","World ",2));
	}
	
	// both enclosing characters included
	@Test
	public void testGetSubstring1() {

		String str1 = "x + y + z - ( y * z) / 3 * n ";
		String result = " y * z";
		char open = '(';
		char close = ')';
		assertEquals("Failed: getSubstring(\"x + y + z - ( y * z) / 3 * n \", \"(\", \")\")", result, Lab2.getSubstring("x + y + z - ( y * z) / 3 * n ", '(', ')'));
	}
	
	// both enclosing characters not included
	@Test
	public void testGetSubstring3() {

		String str1 = "This is [quite} an example!";
		String result = "This is [quite} an example!";
		char open = '[';
		char close = '}';
		//String actual = Lab2.getSubstring("This is [quite} an example!", '(', '}');
		assertEquals("Failed: getSubstring(\"x + y + z - ( y * z) / 3 * n \", \"(\", \")\")", result, Lab2.getSubstring("This is [quite} an example!", '*', '*'));
	}
	
	// opening character not included
	@Test
	public void testGetSubstring4() {

		String str1 = "This is [quite} an example!";
		String result = "This is [quite";
		char open = '[';
		char close = '}';
		//String actual = Lab2.getSubstring("This is [quite} an example!", '(', '}');
		assertEquals("Failed: getSubstring(\"x + y + z - ( y * z) / 3 * n \", \"(\", \")\")", result, Lab2.getSubstring("This is [quite} an example!", '*', '}'));
	}
	
	// ending character not included
	@Test
	public void testGetSubstring5() {

		String str1 = "This is [quite} an example!";
		String result = "quite} an example!";
		char open = '[';
		char close = '}';
		//String actual = Lab2.getSubstring("This is [quite} an example!", '(', '}');
		assertEquals("Failed: getSubstring(\"x + y + z - ( y * z) / 3 * n \", \"(\", \")\")", result, Lab2.getSubstring("This is [quite} an example!", '[', '*'));
	}
	

	@Test
	public void testDecimalToBinary4() {
		int decimal = 23; 
		String binary = "10111";
		assertEquals("Failed: decimalToBinary(23)", binary, Lab2.decimalToBinary(23));
	}
	

	@Test
	public void testDecimalToBinary3() {
		int decimal = 0; 
		String binary = "0";
		assertEquals("Failed: decimalToBinary(23)", binary, Lab2.decimalToBinary(0));
	}
	
	
	@Test
	public void testDecimalToBinary2() {
		int decimal = 1; 
		String binary = "1";
		assertEquals("Failed: decimalToBinary(23)", binary, Lab2.decimalToBinary(1));
	}

}
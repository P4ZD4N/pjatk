public class Exercise1 {
	public static void main(String[ ] args) {
		int int1 = 4;
		int int2 = 2;
		double double1 = 8.0;
		double double2 = 2.0;
		char char1 = '8';
		char char2 = '2';
		
		System.out.println(int1 + int2);
		System.out.println(int1 - int2);
		System.out.println(int1 * int2);
		System.out.println(int1 / int2);
		System.out.println(int1 % int2);
		
		System.out.println("");
		
		System.out.println(double1 + double2);
		System.out.println(double1 - double2);
		System.out.println(double1 * double2);
		System.out.println(double1 / double2);
		System.out.println(double1 % double2);
		
		System.out.println("");
		
		System.out.println(char1 + char2); // It doesn't work
		System.out.println(char1 - char2);
		System.out.println(char1 * char2); // It doesn't work
		System.out.println(char1 / char2); // It doesn't work
		System.out.println(char1 % char2); // It doesn't work
	}
}
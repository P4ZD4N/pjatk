public class Exercise6 {
	public static void main(String[ ] args) {
		System.out.println('a' + 2); // 'a' character is represented in ASCII code by value of 97, so in this case I added 2 to this value and printed sum
		System.out.println('a' + '2'); // 'a' character is represented in ASCII code by value of 97 and '2' character is represented by value of 50, so printed sum is 147
		System.out.println((char)('a' + 2)); // sum of 97 and 2 equals 99, and it was casted to char, so 99 was replaced by character from ASCII code. 'c' in ASCII code is represented by value of 99
		System.out.println("ppj" + 'a' + '2'); // 'a' and '2' characters was converted to strings and concatenated with "ppj" string
		System.out.println("ppj" + 'a' + '\t' + '2'); // 'a', '\t' (tabulation) and '2' characters was converted to strings and concatenated with "ppj" string
		System.out.println('a' + '2' + "ppj"); // sum of characters values in ASCII code was converted to string and concatenated to "ppj" string
	}
}
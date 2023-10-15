public class Program4 {
	public static void main(String[ ] args) {
		int literal1 = 1000000;
		int literal2 = 1_000_000;
		
		System.out.println(literal1 + " " + literal2);
		
		// When I compiled and ran the program, then it displayed the same values, despite I printed two different variables.
		// Underscore between digits in numerical literals enables to separate group of digits. It can improve the readability
		// of code. For example when variable contains phone number, credit card etc.
	}
}
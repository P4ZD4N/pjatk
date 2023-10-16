public class Exercise2 {
	public static void main(String[ ] args) {
		// 5-bit Gray code

		// decimal number ->
		// x = converted decimal number to binary ->
		// y = x >> 1 (shifting bits of x one position to right) ->
		// z = XOR(x, y)
		// z is next element of Gray code

		System.out.println("""
  			00000
			00001
			00011
			00010
			00110
			00111
			00101
			00100
			01100
			01101
			01111
			01110
			01010
			01011
			01001
			01000
			11000
			11001
			11011
			11010
			11110
			11111
			11101
			11100
			10100
			10101
			10111
			10110
			10011
			10001
			10000
		""");
	}
}
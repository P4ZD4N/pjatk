public class Exercise3 {
	public static void main(String[ ] args) {
		String studentsNumberToBinary = Integer.toBinaryString(0x30359);
		System.out.println(
			studentsNumberToBinary.substring(0, 2) +
			"_" + studentsNumberToBinary.substring(2, 6) +
			"_" + studentsNumberToBinary.substring(6, 10) +
			"_" + studentsNumberToBinary.substring(10, 14) +
			"_" + studentsNumberToBinary.substring(14, 18)
		);
	}
}
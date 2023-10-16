public class Exercise7 {
	public static void main(String[ ] args) {
		double x = 1, d = 1e-16, y = x + d;
		// I declared three double variables.
		// y equals 1.0 because of precision limits of float numbers. d is very small number, really close to zero
		// so if we add it to x, the sum would be really close to 1. finally java would round it to 1.0
		System.out.println(d > 0); // It prints true because 1.0E-16 is a bit bigger than 0
		System.out.println(x < y); // It prints false because 1.0 is equal to 1.0
		System.out.println(x == y); // It prints true because 1.0 is equal to 1.0
		System.out.println(x > y); // It prints false because 1.0 is equal to 1.0
	}	
}
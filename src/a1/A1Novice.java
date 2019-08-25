package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		// Your code follows here.
		int customer_count = scan.nextInt();
		String[] customer_firstname = new String[customer_count];
		String[] customer_lastname = new String[customer_count];
		double[] total_price = new double[customer_count];
		for (int i = 0; i < customer_count; i++) {
			customer_firstname[i] = scan.next();
			customer_lastname[i] = scan.next();
			int item_count = scan.nextInt();
			int[] item_number = new int[item_count];
			String[] item_name = new String[item_count];
			double[] item_price = new double[item_count];
			for (int j = 0; j < item_count; j++) {
				item_number[j] = scan.nextInt();
				item_name[j] = scan.next();
				item_price[j] = scan.nextDouble();
			}
			
			double sum = 0;
			for (int k = 0; k < item_count; k++) {
				sum = sum + item_number[k] * item_price[k];
			}
			total_price[i] = sum;
			}
		scan.close();
		for (int l = 0; l <customer_count; l++) {
			System.out.println(customer_firstname[l].substring(0, 1) + ". " + customer_lastname[l] + ": " + String.format("%.2f", total_price[l]));
		}
		
	}
}

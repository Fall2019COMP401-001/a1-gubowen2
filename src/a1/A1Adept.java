package a1;

import java.util.Scanner;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		int store_item = scan.nextInt();
		String[] item_name = new String[store_item];
		double[] price = new double[store_item];
		for (int i = 0; i < store_item; i++) {
			item_name[i] = scan.next();
			price[i] = scan.nextDouble();
		}
		int customer_count = scan.nextInt();
		String[] customer_firstname = new String[customer_count];
		String[] customer_lastname = new String[customer_count];
		double[] customer_total = new double[customer_count];
		for (int j = 0; j < customer_count; j++) {
			customer_firstname[j] = scan.next();
			customer_lastname[j] = scan.next();
			int item_count = scan.nextInt();
			int[] item_quantity = new int[item_count];
			String[] item_bought = new String[item_count];
			for (int k = 0; k < item_count; k++) {
				item_quantity[k] = scan.nextInt();
				item_bought[k] = scan.next();
			}
			double total_price = 0;
			for (int l = 0; l < item_count; l++) {
				String search_item = item_bought[l];
				for (int m = 0; m < store_item; m++) {
					if (search_item.equals(item_name[m])) {
						total_price = total_price + item_quantity[l] * price[m];
					}
				}
			}
			customer_total[j] = total_price;
		}
		scan.close();
		double biggest = findValueMax(customer_total)[0];
		String biggest_spender = customer_firstname[(int)findValueMax(customer_total)[1]] + " " + customer_lastname[(int)findValueMax(customer_total)[1]];
		double smallest = findValueMin(customer_total)[0];
		String smallest_spender = customer_firstname[(int)findValueMin(customer_total)[1]] + " " + customer_lastname[(int)findValueMin(customer_total)[1]];
		double average = calculateValueAverage(customer_total);
		System.out.println("Biggest: " + biggest_spender + " (" + String.format("%.2f", biggest) + ")");
		System.out.println("Smallest: " + smallest_spender + " (" + String.format("%.2f", smallest) + ")");
		System.out.println("Average: " + String.format("%.2f", average));
		}
	
		static double calculateValueAverage(double[] a) {
			double sum = 0;
			for (int n = 0; n < a.length; n++) {
				sum = sum + a[n];
			}
			sum = sum / a.length;
			return sum;
		}
		
		static double[] findValueMin(double[] a) {
			double min = a[0];
			double index = 0;
			for (int n = 0; n < a.length; n++) {
				if (min > a[n]) {
					min = a[n];
					index = n;
				}
			}
			double[] min_and_index = {min, index};
			return min_and_index;
		}
		
		static double[] findValueMax(double[] a) {
			double max = a[0];
			double index = 0;
			for (int n = 0; n < a.length; n++) {
				if (max < a[n]) {
					max = a[n];
					index = n;
				}
			}
			double[] max_and_index = {max, index};
			return max_and_index;
		}
}

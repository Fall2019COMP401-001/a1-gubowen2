package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		int store_item = scan.nextInt();
		String[] item_name = new String[store_item];
		double[] price = new double[store_item];
		int[] customer = new int[store_item];
		int[] item = new int[store_item];
		for (int i = 0; i < store_item; i++) {
			item_name[i] = scan.next();
			price[i] = scan.nextDouble();
			customer[i] = 0;
			item[i] = 0;
		}
		int customer_count = scan.nextInt();
		String[] customer_firstname = new String[customer_count];
		String[] customer_lastname = new String[customer_count];
		for (int j = 0; j < customer_count; j++) {
			int[] customer_old = new int[store_item];
			for (int a = 0; a < store_item; a++) {
				customer_old[a] = customer[a];
			}
			customer_firstname[j] = scan.next();
			customer_lastname[j] = scan.next();
			int item_count = scan.nextInt();
			int[] item_quantity = new int[item_count];
			String[] item_bought = new String[item_count];
			for (int k = 0; k < item_count; k++) {
				item_quantity[k] = scan.nextInt();
				item_bought[k] = scan.next();
				for (int l = 0; l < store_item; l++) {
					if (item_bought[k].equals(item_name[l])) {
						customer[l]++;
						item[l] += item_quantity[k];
					}
				}
			}
			for (int a = 0; a < store_item; a++) {
				if (customer[a] - customer_old[a] > 1) {
					customer[a] = customer_old[a] + 1;
				}
			}
		}
		scan.close();
		for (int m = 0; m < store_item; m++) {
			if (customer[m] == 0) {
				System.out.println("No customers bought " + item_name[m]);
			}
			else {
				System.out.println(customer[m] + " " + "customers bought " + item[m] + " " + item_name[m]); 
			}
		}
	}
}

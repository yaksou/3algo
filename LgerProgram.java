package inlämningsuppgift3;

import java.util.*;
import java.io.*;

public class LgerProgram {
	static Scanner scan = new Scanner(System.in);
	static ItemList inStore = new ItemList();
	static ItemList outStore = new ItemList();
	static long nr = 11;

	public static void main(String[] args) throws FileNotFoundException {
		try {
			Scanner filescan = new Scanner(new File(
					"C:\\Users\\Kemdee\\workspace\\inlämningsuppgift3\\src\\inlämningsuppgift3\\Verktyg.txt"));
			while (filescan.hasNext())
				System.out.println(filescan.next());
		}

		catch (IOException ex) {
			System.out.println("Filen finns inte");
		}
		printMenu();
		int choice = scan.nextInt();
		scan.nextLine();

		while (choice != 0) {
			dispatch(choice);
			printMenu();
			choice = scan.nextInt();
			scan.nextLine();

		}
		PrintWriter out = null;
		try {
			out = new PrintWriter(new FileOutputStream("data3.txt", true));
			inStore.saveList(out);
			outStore.saveList(out);
		}

		catch (IOException e) {
			System.out.println(e);
		}

		out.close();

	}

	public static String getRFID() {
		return "" + nr++;

	}

	public static void dispatch(int choice) throws FileNotFoundException {
		int loc;

		switch (choice) {
		case 0:
			System.out.println("EXIT");
			System.exit(0);
			break;

		case 1: {
			// Här bygger du upp lagret. Fyller inlager med Item-objekt vars
			// namn läser du från filen.
			// RFIDNR som du behöver till varje Item- kan skapas av metoden ge
			// Utlagret är i början tom
			Scanner indata = new Scanner(new File("C:\\Users\\Kemdee\\workspace\\inlämningsuppgift3\\src\\inlämningsuppgift3\\Verktyg.txt"));
			while (indata.hasNext()) {
				inStore.addSort(new Item(indata.nextLine(), getRFID()));
			}

			break;
		}
		case 2: {
			System.out.println("insert the RFIDNR of the item you want to lend!");
			Scanner input = new Scanner(System.in);
			String rNR = input.next();
			if (inStore.find(rNR)) {
				Item temp = inStore.remove(rNR);
				temp.setDeliverDate(new Date());
				outStore.addSort(temp);
			}

			else {
				System.out.println("The RFIDNR doesn´t exist!");
			}

			break;
		}
		case 3: {
			System.out.println("insert the RFIDNR you want to return");
			Scanner input = new Scanner(System.in);
			String rNR = input.next();
			if (outStore.find(rNR)) {
				Item temp = outStore.remove(rNR);
				temp.setDeliverDate(null);
				inStore.addSort(temp);
			} else {
				System.out.println("The item is not lent.");
			}

			break;
		}

		case 4: {
			System.out.println("Insert the name you are searching for:");
			Scanner input = new Scanner(System.in);
			String nameIn = input.next();

			int quantity = 0;
			quantity = inStore.countObjects(nameIn);

			System.out.println("There is " + quantity + "of your item in the store");

			break;
		}
		case 5: {
			System.out.println("This items are lent: " + "\n");
			outStore.printList();
			break;
		}

		case 6: {
			System.out.println("Items in store: " + "\n");
			inStore.printList();
			break;
		}

		default:
			System.out.println("Sorry, invalid choice");
		}
	}

	// ----------------------------
	// Skriver ut användar meny
	// ----------------------------
	public static void printMenu() {
		System.out.println("\n  Welcome");
		System.out.println("   ====");
		System.out.println("0: Exit");
		System.out.println("1: Setup Store");
		System.out.println("2: Lend");
		System.out.println("3: Return");
		System.out.println("4: quantity of the item");
		System.out.println("5: what's lent");
		System.out.println("6: what's in store");

		System.out.print("\nEnter your choice: ");
	}

}

/*
 * Exempel hur man läser från fil. try{ Scanner filescan=new Scanner(new
 * File("Verktyg.txt")); while( filescan.hasNext()) System.out.println(
 * filescan.next()); }
 * 
 * catch(IOException ex){System.out.println("Filen finns inte");
 */
package inlämningsuppgift3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

public class Item implements Comparable<Item> {
	public Date delivered; // utlånd datum, null när Item inte är utlånad
	public final String RFIDNR;
	public String name;

	public Item(String thename, String number) {
		name = thename;
		RFIDNR = number;
		delivered = null;
	}

	public void setDeliverDate(Date d) {
		delivered = d;
	}

	public Date getDeliverDate() {
		return delivered;
	}

	public String getItemNumber() {
		return RFIDNR;
	}

	public String getItemName() {
		return name;
	}

	public int compareTo(Item other) {

		return this.getItemName().compareTo(other.getItemName());
	}

	public boolean equals(Object other) {
		boolean ans = false;
		Item temp = (Item) (other);

		if (this.getItemNumber().compareTo(temp.getItemNumber()) == 0) {
			ans = true;
		}
		return ans;
	}

	public String toString() {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		if (delivered == null)
			return RFIDNR + " " + name + " " + "på lager";
		else
			return RFIDNR + " " + name + " " + df.format(delivered);
	}

	// See a simple program example to understand how Date class works;
	public static void main(String[] arg) {

		Calendar calendar = Calendar.getInstance();

		Date newDate = calendar.getTime();

		// Skapa item- object
		Item itm = new Item("Termometer", "1");
		Item bot = new Item("mobil", "2");
		Item bot2 = new Item("flaska", "3");
		itm.compareTo(bot);
		// Gör item-obj utlånad
		itm.setDeliverDate(newDate);
		bot.setDeliverDate(newDate);
		// bot2.setDeliverDate(newDate);
		System.out.println(itm.equals(itm));

		// System.out.println( itm);
		//
		// System.out.println( bot2);
		// System.out.println( bot);
		//

	}

}

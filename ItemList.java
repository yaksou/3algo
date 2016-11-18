package inlämningsuppgift3;

import java.io.PrintWriter;
import java.util.*;

/**
 * Klassen ItemList är en länkad lista som innehåller noder av Item-objekt.
 * Första noden i listan ( header) innehåller inget objekt.
 */

public class ItemList {
	public Node header;
	int size;

	public ItemList() {
		header = new Node(null);
	}

	public void addSort(Item newItem) {
		int count = 0;

		Node node = header;

		while (node.next != null) {
			node = node.next;
			if (node.itm.compareTo(newItem) < 0) {
				count++;
			} else {
				break;
			}
		}

		add(newItem, count);
	}

	/**
	 * Skapar ett ny Node-objekt med ett nytt Item objekt och lägger den i
	 * listan. Ökar värdet av variabel size;
	 */
	public void add(Item newItem) {
		if (newItem != null) {
			Node ny = new Node(newItem);
			ny.next = header.next;
			header.next = ny;

			size++;
		}
	}

	/**
	 * Skapar ett ny Node objekt med ett nytt Item-objekt och lägger den i
	 * listan på plats index, Ökar värdet av variabel size;
	 */
	public void add(Item newItem, int index) {
		Node node = header;

		if (index > size + 1)
			throw new ArrayIndexOutOfBoundsException("Tried to insert out of bounds.");

		while (true) {
			if (index == 0) {
				Node temp = new Node(newItem, node.next);
				node.next = temp;
				size++;
				break;
			}

			node = node.next;
			index--;
		}

	}

	/**
	 * Returnerar true om det finns ett Item-objekt vars RFIDNR är lika med
	 * metodens parametern id
	 */
	public boolean find(String id) {
		Node temp = header;
		while (temp.next != null) {
			if (temp.next.itm.getItemNumber().equals(id)) {
				return true;
			}
			temp = temp.next;
		}

		return false;
	}

	/**
	 * Ta bort noden som innehåller Item- objektet med viss id
	 */
	public Item remove(String id) {
		Node temp = header;
		while (temp.next != null) {
			if (temp.next.itm.getItemNumber().compareTo(id) == 0) {
				Item tempItem = temp.next.itm;
				temp.next = temp.next.next;
				return tempItem;
			}
			temp = temp.next;
		}

		return null;
	}

	/**
	 * Räknar och returnerar antalet Item- objekt med ett vis namn oavsett
	 * RFIDNR
	 */

	public int countObjects(String name) {
		Node temp = header;
		int count = 0;
		if (temp.next.itm.getItemName().compareTo(name) == 0) {
			count++;
		}

		return count;
	}

	/**
	 * Skriver ut innehållet i listan
	 */
	public void printList() {
		Node temp = header;
		while (temp.next != null) {
			System.out
					.println("item name: " + temp.next.itm.getItemName() + " RFIDNR: " + temp.next.itm.getItemNumber());
			temp = temp.next;
		}

	}

	public void saveList(PrintWriter out) {
		Node temp = header;
		while (temp.next != null) {
			out.println("item name: " + temp.next.itm.getItemName() + " RFIDNR: " + temp.next.itm.getItemNumber());
			temp = temp.next;
		}

	}

	/**
	 * Returnera true om listan är tom annars false
	 */
	public boolean isEmpty() {
		Node temp = header;
		int count = 0;
		while (temp.next != null) {
			count++;
		}

		if (count > 0) {
			return true;
		}
		return false;
	}

	/**
	 * Returnera antlet element i listan
	 */
	public int size() {
		int sizeList = 0;
		Node temp = header;
		while (temp.next != null) {
			sizeList++;

		}
		return sizeList;
	}

	public static void main(String[] args) {
		ItemList a = new ItemList();
		a.add(new Item("A", "1"));
		a.add(new Item("B", "2"));
		a.add(new Item("C", "3"));
		a.add(new Item("D", "4"));
		a.printList();
		System.out.println();
		a.remove("2");
		a.printList();

	}
}
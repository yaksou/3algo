package inlämningsuppgift3;

import java.util.*;

/**
 * Klassen SimpleLinkedList är en länkad lista som innehåller noder av objekt.
 * Första noden i listan innehåller inget objekt.
 */

public class SimpleLinkedList {
	private ListNode header;
	private static int counter;

	public SimpleLinkedList() {
		header = new ListNode(null);
	}

	/**
	 * Skapar en ny ListNode med ett nytt objekt och lägger den i listan
	 */
	public void insert(String theobj) {
		ListNode nynode = new ListNode(theobj);

		ListNode temp = header;
		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = nynode;
		counter++;
	}

	/*
	 * Ta bort noden som innehåller respektive objekt
	 */
	public void remove(String theobj) {
		ListNode node = header;

		while (node.next != null) {
			if (node.next.element.equals(theobj)) {
				node.next = node.next.next;
				counter--;
				break;
			}
			node = node.next;
		}
	}

	/**
	 * Skriver ut innehållet i listan
	 */
	public void print() {
		ListNode node = header.next;
		while (node != null) {
			System.out.println(node.element);
			node = node.next;
		}
	}

	public void insert2(String theobj) {
		ListNode nynode = new ListNode(theobj, header.next);
		header.next = nynode;
	}

	// Detta skall du göra
	private int count;

	public void insert(String obj, int index) {

		ListNode temp = header;
		while (temp.next != null) {
			if (index == counter) {
				ListNode mimi = new ListNode(obj, temp.next);
				temp.next = mimi;
				counter++;
			}
			temp = temp.next;
			count++;

		}

	}

	// Returnerar och tar bort ett objkt från lista
	public String remove(String obj, int index) {
		ListNode carry = header;
		int antal = 0;
		while (carry.next != null) {
			if (antal == index && carry.next.element.equals(obj)) {
				carry.next = carry.next.next;
				counter--;
				break;
			}
			carry = carry.next;
			antal++;

		}
		return obj;
	}

	// returnerar storleken på listan. Lägg till i klasssen en variabel för
	// detta
	// uppdatera variabeln när det är fallet

	public int size() {
		return counter;
	}

	public String toString() {
		ListNode carry = header;
		String bee = " ";
		
		while (carry.next != null) {
			carry = carry.next;
			bee = bee+ (carry.element);
		}
		return bee;
	}

	public static void main(String[] arg) {
		// testa metoderna från klassen SimpleLinkedList
		SimpleLinkedList klassLista = new SimpleLinkedList();
		klassLista.insert("Olle");
		klassLista.insert("Tyler");
		klassLista.insert("Josephine");
		klassLista.insert("Jimmy");
		klassLista.insert("Ramona");
		klassLista.print();
		System.out.println("");
		klassLista.remove("Jimmy",3);
		klassLista.print();
	}
}

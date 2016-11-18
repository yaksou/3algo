package inl�mningsuppgift3;

import java.util.*;

/**
 * Klassen SimpleLinkedList �r en l�nkad lista som inneh�ller noder av objekt.
 * F�rsta noden i listan inneh�ller inget objekt.
 */

public class SimpleLinkedList {
	private ListNode header;
	private static int counter;

	public SimpleLinkedList() {
		header = new ListNode(null);
	}

	/**
	 * Skapar en ny ListNode med ett nytt objekt och l�gger den i listan
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
	 * Ta bort noden som inneh�ller respektive objekt
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
	 * Skriver ut inneh�llet i listan
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

	// Detta skall du g�ra
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

	// Returnerar och tar bort ett objkt fr�n lista
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

	// returnerar storleken p� listan. L�gg till i klasssen en variabel f�r
	// detta
	// uppdatera variabeln n�r det �r fallet

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
		// testa metoderna fr�n klassen SimpleLinkedList
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

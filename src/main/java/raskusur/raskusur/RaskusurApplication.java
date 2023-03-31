package raskusur.raskusur;

import java.util.ArrayList;
import java.util.LinkedList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import raskusur.raskusur.controller.LedgerController;
import raskusur.raskusur.model.Item;
import raskusur.raskusur.model.Ledger;
import raskusur.raskusur.model.Person;

@SpringBootApplication
public class RaskusurApplication {

	// test
	static Person p1 = new Person("Pera");
	static Person p2 = new Person("Zdera");
	static Person p3 = new Person("Sera");
	static Person p4 = new Person("Mare");
	static Person p5 = new Person("Dare");
	static Person p6 = new Person("Sova");
	static Person p7 = new Person("Djole");
	static Person p8 = new Person("Grga");
	static Person p9 = new Person("Galeb");
	static Person p10 = new Person("Tozovac");

	static ArrayList<Person> l1 = new ArrayList<Person>() {
		{
			add(p1);
			add(p2);
		}
	};
	static ArrayList<Person> l2 = new ArrayList<Person>() {
		{
			add(p1);
		}
	};
	static ArrayList<Person> l3 = new ArrayList<Person>() {
		{
			add(p2);
		}
	};
	static ArrayList<Person> l4 = new ArrayList<Person>() {
		{
			add(p1);
			add(p3);
			add(p4);
		}
	};
	static ArrayList<Person> l5 = new ArrayList<Person>() {
		{
			add(p4);
		}
	};
	static ArrayList<Person> l6 = new ArrayList<Person>() {
		{
			add(p4);
			add(p5);
			add(p6);
			add(p7);
		}
	};
	static ArrayList<Person> l7 = new ArrayList<Person>() {
		{
			add(p1);
			add(p9);
		}
	};
	static ArrayList<Person> l8 = new ArrayList<Person>() {
		{
			add(p6);
		}
	};
	static ArrayList<Person> l9 = new ArrayList<Person>() {
		{
			add(p7);
			add(p1);
		}
	};
	static ArrayList<Person> l10 = new ArrayList<Person>() {
		{
			add(p7);
			add(p4);
			add(p5);
		}
	};
	static ArrayList<Person> l11 = new ArrayList<Person>() {
		{

		}
	};

	static Item i1 = new Item("Pizza", 1500.0, "Mare", l1);
	static Item i2 = new Item("Sushi", 1000.0, "Sera", l2);
	static Item i3 = new Item("Pivo", 500.0, "Mare", l3);
	static Item i4 = new Item("Vino", 2000.0, "Zdera", l4);
	static Item i5 = new Item("Pljuge", 300.0, "Pera", l5);
	static Item i6 = new Item("Cips", 500.0, "Tozovac", l6);
	static Item i7 = new Item("Lopta", 1200.0, "Tozovac", l7);
	static Item i8 = new Item("Skije", 2000.0, "Galeb", l8);
	static Item i9 = new Item("Sneg", 450.0, "Grga", l9);
	static Item i10 = new Item("Voda", 1000.0, "Tozovac", l10);
	static Item i11 = new Item("Gomboce", 1000.0, "Sera", l11);

	private static LinkedList<Item> listI = new LinkedList<>() {
		{
			add(i1);
			add(i2);
			add(i3);
			add(i4);
			add(i5);
			add(i6);
			add(i7);
			add(i8);
			add(i9);
			add(i10);
			add(i11);
		}
	};

	public static Ledger ledgerTest = new Ledger(1, listI);
	// test

	public static void main(String[] args) {
		SpringApplication.run(RaskusurApplication.class, args);
		LedgerController.getInstance().calculateDebt(ledgerTest);
	}

}

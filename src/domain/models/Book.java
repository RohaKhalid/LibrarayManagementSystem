package domain.models;

public class Book {
	int quantity;
	String name;
	int price;
	int price_loan;
	Author author;
	public Book(int quantity, String name, int price, int price_loan, Author author) {
		this.quantity = quantity;
		this.name = name;
		this.price = price;
		this.price_loan = price_loan;
		this.author = author;
	}

}

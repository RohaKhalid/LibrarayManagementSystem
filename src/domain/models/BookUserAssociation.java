package domain.models;

public class BookUserAssociation {
	int quantity;
	int price;
	User user;
	Book book;
	
	public BookUserAssociation(int quantity, int price, User user, Book book)
	{
		this.quantity = quantity;
		this.price =price;
		this.user = user;
		this.book = book;
	}
}

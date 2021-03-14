package domain.models;

public class User {
	String name;
	String email_address;
	UserType type;
	public User(String name, String email_address, UserType type) {
		this.name = name;
		this.email_address = email_address;
		this.type = type;
	}

}

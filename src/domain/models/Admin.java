package domain.models;

import java.time.LocalDate;

public class Admin {
	String userName;
	String password;
	LocalDate date_created = LocalDate.now();
	public Admin(String userName, String password, LocalDate date_created) {
		this.userName = userName;
		this.password = password;
		this.date_created = date_created;
	}

}

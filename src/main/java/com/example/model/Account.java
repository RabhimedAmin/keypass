package com.example.model;

import javax.persistence.*;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "Login")
	private String login;
	@Column(name = "password")
	private String password;
	
	private AccountType type;

	private enum AccountType {
		GUEST, ROOT, USER
	};

	/**
	 * 
	 */
	public Account() {
		super();
	}

	public Account(Long id, String login, String password) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
	}

	public long getId() {
		return id;
	}

	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setServer(Server myServer) {
		// this.server

	}

	public AccountType getType() {
		return type;
	}

	public void setType(AccountType type) {
		this.type = type;
	}
}

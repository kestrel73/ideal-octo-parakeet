package net.wuollet.jpa.domain.model.user;

import javax.persistence.*;

import org.springframework.data.jpa.domain.*;

@Entity
public class User extends AbstractAuditable<User, Integer>{

	private static final long serialVersionUID = 7290822960491365501L;

	@Column(nullable=false, unique=true)
	private String username;

	@Basic
	private String password;

	@Basic
	private String firstname;

	@Basic
	private String lastname;

	public User(String username) {
		this.username = username;
	}

	protected User() {}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "User: " + getUsername();
	}

}

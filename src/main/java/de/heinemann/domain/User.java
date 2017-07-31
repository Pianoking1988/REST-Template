package de.heinemann.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	private long id = 0;
	private String mail = null;
	private Calendar created = Calendar.getInstance();
	private String createdBy = null;

	public User() {}

	public User(long id, String mail, String createdBy) {
		setId(id);
		setMail(mail);
		setCreatedBy(createdBy);
	}

	public User(String mail) {
		this.mail = mail;
	}

	public User(long id, String mail, Calendar created, String createdBy) {
		this(mail);
		this.id = id;
		this.created = created;
		this.createdBy = createdBy;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Calendar getCreated() {
		return created;
	}

	public void setCreated(Calendar created) {
		this.created = created;
	}

	@Column(name = "createdby")
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
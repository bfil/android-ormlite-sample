package com.bfil.ormliterepo.models;

import com.bfil.ormliterepo.data.Repo;
import com.j256.ormlite.field.DatabaseField;

public class User {
	
	@DatabaseField(id = true) 
	String username;
	@DatabaseField
	String password;
	@DatabaseField
	String email;
	@DatabaseField
	String alias;
	
	public User() {
		// needed by ormlite
	}
	
	public User(String alias, String username, String password, String email) {
		this.alias = alias;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public String getAlias() {
		return alias;
	}
	
	
	public int save(Repo repo)
	{
		if(repo.Users.getByUsername(username) == null)
		{
			return repo.Users.create(this);
		}
		else
		{
			return repo.Users.update(this);
		}
	}
	
	public int delete(Repo repo)
	{
		return repo.Users.delete(this);
	}
	
	public String toString()
	{
		return alias;
	}
	
}

package by.bobruisk.konsov.game.model;

import java.io.Serializable;

public class Account implements Serializable{
	
	private static final long serialVersionUID = -1393484725958972615L;
	
	private String login; 
	private String password;
	private String name;
	private String parameters;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	
}
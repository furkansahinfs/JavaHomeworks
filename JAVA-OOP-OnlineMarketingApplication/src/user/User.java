package user;

import main.Wallet;

public abstract class User {
	
	private int type;
	private String username,password;
	private ContactInfo contactInfo;
	private Wallet wallet ;

	
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	public String getUsername() {
		return username;
	}
	public ContactInfo getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo contactInfo) {
		this.contactInfo = contactInfo;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	public String toString() 
	{
		return ("Username : " + username+ " ContactInfo : "+ contactInfo.toString());
	}
	

}

package user;

import java.util.ArrayList;

public class ContactInfo {

	private String telephone;
	private String email;
	private ArrayList<Address> addressList;
	
	public ContactInfo(String telephone,String email,ArrayList<Address> address) {
		this.addressList = address;
		this.email = email;
		this.setTelephone(telephone);
	}
	
	
	public ArrayList<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(ArrayList<Address> addressList) {
		this.addressList = addressList;
	}

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public String toString() {
		return ("Phone :"+telephone+ " Email :" +email+ " Addresses :" + addressList.toString());
	}
}

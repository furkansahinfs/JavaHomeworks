package user;

public class Address {
	private String addres_title,country,city,district,street,door_number;
	
	public Address(String addres_title,String country,String city,String district,String street, String door_number) {
		this.addres_title=addres_title;
		this.city = city;
		this.country = country;
		this.district = district;
		this.door_number = door_number;
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddres_title() {
		return addres_title;
	}

	public void setAddres_title(String addres_title) {
		this.addres_title = addres_title;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getDoor_number() {
		return door_number;
	}

	public void setDoor_number(String door_number) {
		this.door_number = door_number;
	}
	
	public String toString() {
		return (addres_title+ " " +country + " " + city + " " + district + " " + street + " " + door_number);
	}
}

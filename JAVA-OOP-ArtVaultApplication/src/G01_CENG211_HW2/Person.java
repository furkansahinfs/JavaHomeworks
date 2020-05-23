package G01_CENG211_HW2;

import Interfaces.IComparable;

public abstract class Person implements IComparable {
	private String name,nationality;
	private String born,died;
	
	// We create object with its variables taken from file.
	public Person(String name,String born,String died,String nationality) {
		this.name=name;
		this.nationality=nationality;
		this.born=born;
		this.died=died;
	}
	
	// We compare two string str1 and str2 which is taken from compareTo method of object according to sort choice.
	public int stringCompare(String str1, String str2) {
		int i1=str1.length();
		int i2=str2.length();
		int lmin = Math.min(i1, i2);
		
		for(int i=0;i<lmin;i++) {
			int str1_ch = (int) str1.charAt(i);
			int str2_ch = (int) str2.charAt(i);
			
			if(str1_ch != str2_ch) {
				return str1_ch-str2_ch;
			}
		}
		if(i1!=i2) {
			return i1-i2;
		}
		else {
		return 0;
	}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getBorn() {
		return born;
	}

	public void setBorn(String born) {
		this.born = born;
	}

	public String getDied() {
		return died;
	}

	public void setDied(String died) {
		this.died = died;
	}
	
}

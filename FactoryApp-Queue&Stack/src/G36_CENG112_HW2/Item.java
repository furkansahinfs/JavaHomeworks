package G36_CENG112_HW2;

public class Item {
	
	public String type;
	

	 public Item() {
		 
	 }
	 // I create a constructor which is taken two parameters which are name and type.
	 public Item(String type) {
	
		    this.type = type;
	 }
	 
	 public String toString() {
			return this.type;
			 
		 }
	 public boolean equals(Object obj) {
			 
			 // It controls that item and given object is equal to each other or not and it returns true or false.
			 
			 Item other = (Item) obj;
			 
			
			 if (this.type.equals(other.type))
			 {
				 return true;
			 }
			 else 
			 {
				 return false;
			 }
			 
			}
}

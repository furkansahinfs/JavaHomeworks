package G01_CENG211_HW2;

import java.util.ArrayList;


import Interfaces.IComparable;

public class ArrayListSorter {
	
	Vault vault; 
	ArrayList<Object> list;
	
	// We take vault object from main class to reach the lists of artworks and persons. 
	public ArrayListSorter(Vault vault) {
		this.vault = vault;
	}

	// sort method takes two parameter of integer. Choice is the list choice and choice2 is the sort choice.
	public ArrayList<Object> sort(int choice,int choice2) {
		ArrayList<Object> list = new ArrayList<Object>(); // list is created to use deep copy.
		
		switch (choice) {
		
		case 1: // painting list
			// Using deep copy, we create a painting list.
			 for(int i=0;i<vault.getPaintingList().size();i++) {
				 list.add(vault.getPaintingList().get(i));
			 }
			 
			// using bubble sort we make a swap. If ith object is bigger than the other objects using compare method, we make a swap between two object.  
			for(int i=0;i<list.size();i++) {
				for(int j=i+1;j<list.size();j++) {
					if(((IComparable) list.get(i)).compareTo(list.get(j),choice2)>0) { // compareto takes two parameters : Object and sort choice 
						Painting tempi =  (Painting) list.get(i);
						Painting tempj = (Painting) list.get(j);
						list.set(i, tempj);
						list.set(j,tempi);
						
					}
					
					// If objects are equal to each other, we compare them according to their names and make a swap between two objects.
					else if(((IComparable) list.get(i)).compareTo(list.get(j),choice2)==0) {
						if(((IComparable) list.get(i)).compareTo(list.get(j),1)>0) {
							Painting tempi =  (Painting) list.get(i);
							Painting tempj = (Painting) list.get(j);
							list.set(i, tempj);
							list.set(j,tempi);
						
					}
				}
			}
			}
			return list;
			
		case 2: // sculpture list
			// Using deep copy, we create a sculpture list.
			for(int i=0;i<vault.getSculptureList().size();i++) {
				 list.add(vault.getSculptureList().get(i));
			 }
			 
			// using bubble sort we make a swap. If ith object is bigger than the other objects using compare method, we make a swap between two object.
			for(int i=0;i<list.size();i++) {
				for(int j=i+1;j<list.size();j++) {
					if(((IComparable) list.get(i)).compareTo(list.get(j),choice2)>0) { // compareto takes two parameters : Object and sort choice 
						Sculpture tempi =  (Sculpture) list.get(i);
						Sculpture tempj = (Sculpture) list.get(j);
						list.set(i, tempj);
						list.set(j,tempi);
						
					}
					// If objects are equal to each other, we compare them according to their names and make a swap between two objects.
					else if(((IComparable) list.get(i)).compareTo(list.get(j),choice2)==0) { 
						if(((IComparable) list.get(i)).compareTo(list.get(j),1)>0) {
							Sculpture tempi =  (Sculpture) list.get(i);
							Sculpture tempj = (Sculpture) list.get(j);
							list.set(i, tempj);
							list.set(j,tempi);
						
					}
				}
			}
			}
			return list;
			
		case 3: // architecture list.
			// Using deep copy, we create an architecture list.
			for(int i=0;i<vault.getArchitectureList().size();i++) {
				 list.add(vault.getArchitectureList().get(i));
			 }
			 
			// using bubble sort we make a swap. If ith object is bigger than the other objects using compare method, we make a swap between two object.
			for(int i=0;i<list.size();i++) {
				for(int j=i+1;j<list.size();j++) {
					if(((IComparable) list.get(i)).compareTo(list.get(j),choice2)>0) { // compareto takes two parameters : Object and sort choice 
						Architecture tempi =  (Architecture) list.get(i);
						Architecture tempj = (Architecture) list.get(j);
						list.set(i, tempj);
						list.set(j,tempi);
						
					}
					// If objects are equal to each other, we compare them according to their names and make a swap between two objects.
					else if(((IComparable) list.get(i)).compareTo(list.get(j),choice2)==0) {
						if(((IComparable) list.get(i)).compareTo(list.get(j),1)>0) {
							Architecture tempi =  (Architecture) list.get(i);
							Architecture tempj = (Architecture) list.get(j);
							list.set(i, tempj);
							list.set(j,tempi);
						
					}
				}
			}
			}
			return list;
			
		case 4: // artist list
			// Using deep copy, we create an artist list.
			for(int i=0;i<vault.getArtistList().size();i++) {
				 list.add(vault.getArtistList().get(i));
			 }
			 
			// using bubble sort we make a swap. If ith object is bigger than the other objects using compare method, we make a swap between two object.
			for(int i=0;i<list.size();i++) {
				for(int j=i+1;j<list.size();j++) {
					if(((IComparable) list.get(i)).compareTo(list.get(j),choice2)>0) { // compareto takes two parameters : Object and sort choice 
						Artist tempi =  (Artist) list.get(i);
						Artist tempj = (Artist) list.get(j);
						list.set(i, tempj);
						list.set(j,tempi);
						
					}
					// If objects are equal to each other, we compare them according to their names and make a swap between two objects.
					else if(((IComparable) list.get(i)).compareTo(list.get(j),choice2)==0) {
						if(((IComparable) list.get(i)).compareTo(list.get(j),1)>0) {
							Artist tempi =  (Artist) list.get(i);
							Artist tempj = (Artist) list.get(j);
							list.set(i, tempj);
							list.set(j,tempi);
						
					}
				}
			}
			}
			return list;
			
		case 5: // architect list
			// Using deep copy, we create an architect list.
			for(int i=0;i<vault.getArchitectList().size();i++) {
				 list.add(vault.getArchitectList().get(i));
			 }
			 
			// using bubble sort we make a swap. If ith object is bigger than the other objects using compare method, we make a swap between two object.
			for(int i=0;i<list.size();i++) {
				for(int j=i+1;j<list.size();j++) {
					if(((IComparable) list.get(i)).compareTo(list.get(j),choice2)>0) { // compareto takes two parameters : Object and sort choice 
						Architect tempi =  (Architect) list.get(i);
						Architect tempj = (Architect) list.get(j);
						list.set(i, tempj);
						list.set(j,tempi);
						
					}
					// If objects are equal to each other, we compare them according to their names and make a swap between two objects.
					else if(((IComparable) list.get(i)).compareTo(list.get(j),choice2)==0) {
						if(((IComparable) list.get(i)).compareTo(list.get(j),1)>0) {
							Architect tempi =  (Architect) list.get(i);
							Architect tempj = (Architect) list.get(j);
							list.set(i, tempj);
							list.set(j,tempi);
						
					}
				}
			}
			}
			return list;
					
		default:
			return null;
			
		
		
		
		
	}
	}

	


	

	
	

}

package G01_CENG211_HW2;

import java.util.ArrayList;

public class Vault {
	
	// We create a list for each type.
	private ArrayList<Painting> paintingList = new ArrayList<Painting>();
	private ArrayList<Sculpture> sculptureList = new ArrayList<Sculpture>();
	private ArrayList<Architecture> architectureList = new ArrayList<Architecture>();
	private ArrayList<Artist> artistList = new ArrayList<Artist>();
	private ArrayList<Architect> architectList = new ArrayList<Architect>();
	
	private ArrayList<Artwork> artworkList =new ArrayList<Artwork>(); // artworkList holds tradeable artwork items.
	
	private ArrayList<Object> givenList = new ArrayList<Object>(); // givenlist is returned from FileIO which holds the string of each line of csv file.
	
	public Vault(ArrayList<Object> givenList) {
		this.givenList = givenList;
	}
	
	
	// In for loop, we travel the list and split each line. According to object number(1-2-3-4-5) we create the objects using their variables
	// and add them to necessary lists.
	public void split() {
		for(int i=0;i<givenList.size();i++) {
			String[] strs = givenList.get(i).toString().split(",");
			int objectNumber = Integer.parseInt(strs[0]);
			switch(objectNumber) {
			case 1 :
				Painting painting = new Painting(strs[1],strs[2],strs[3],Double.parseDouble(strs[4]),Double.parseDouble(strs[5]));
				this.getPaintingList().add(painting);
				if(painting.isTradeable()) {
				this.getArtworkList().add(painting);
				}
	
				break;
			case 2: 
				Sculpture sculpture = new Sculpture(strs[1],strs[2],strs[3],strs[4],Double.parseDouble(strs[5]));
				this.getSculptureList().add(sculpture);
				if(sculpture.isTradeable()) {
					this.getArtworkList().add(sculpture);
				}
				break;
			case 3:
				ArrayList<String> architects = new ArrayList<String>(); // there can be architects more than one, so we holds them in a list.
				for(int j=6;j<strs.length;j++) {
					architects.add(strs[j]);
				}
				Architecture architecture = new Architecture(strs[1],strs[2],Double.parseDouble(strs[3]),Double.parseDouble(strs[4]),Double.parseDouble(strs[5]),architects);
				this.getArchitectureList().add(architecture);
				if(architecture.isTradeable()) {
					this.getArtworkList().add(architecture);
				}
				break;
			case 4:	
				ArrayList<String> periods = new ArrayList<String>(); // there can be periods more than one, so we holds them in a list.
				for(int k=5;k<strs.length;k++) {
					periods.add(strs[k]);
				}
							    
				Artist artist = new Artist(strs[1],(strs[2]),(strs[3]),strs[4],periods); 
				this.getArtistList().add(artist);
				break;
			case 5:
				Architect architect = new Architect(strs[1],(strs[2]),(strs[3]),strs[4]); 
				this.getArchitectList().add(architect);
				
				break;
			}
		}
	}

	public ArrayList<Painting> getPaintingList() {
		return paintingList;
	}

	public void setPaintingList(ArrayList<Painting> paintingList) {
		this.paintingList = paintingList;
	}

	public ArrayList<Sculpture> getSculptureList() {
		return sculptureList;
	}

	public void setSculptureList(ArrayList<Sculpture> sculptureList) {
		this.sculptureList = sculptureList;
	}

	public ArrayList<Architecture> getArchitectureList() {
		return architectureList;
	}

	public void setArchitectureList(ArrayList<Architecture> architectureList) {
		this.architectureList = architectureList;
	}

	public ArrayList<Artist> getArtistList() {
		return artistList;
	}

	public void setArtistList(ArrayList<Artist> artistList) {
		this.artistList = artistList;
	}

	public ArrayList<Architect> getArchitectList() {
		return architectList;
	}

	public void setArchitectList(ArrayList<Architect> architectList) {
		this.architectList = architectList;
	}

	public ArrayList<Artwork> getArtworkList() {
		
		return artworkList;
	}

	public void setArtworkList(ArrayList<Artwork> artworkList) {
		this.artworkList = artworkList;
	}
	
	
	
}

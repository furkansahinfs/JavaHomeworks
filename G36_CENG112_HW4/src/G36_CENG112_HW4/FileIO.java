package G36_CENG112_HW4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileIO {
	
	


	public static <T> BinarySearchTree<T> readFile(){
		// I create binarysearchtree
		BinarySearchTree<T> bstree = new BinarySearchTree(null);
		
		
		FileReader dosyaOkuyucu;
		BufferedReader okuyucu;				
		
		// I try to read the file and its rows one by one.
		try {

			 dosyaOkuyucu = new FileReader("C:\\Users\\Furkan\\Desktop\\Media.txt");
			 okuyucu = new BufferedReader(dosyaOkuyucu);			 
					
			 String satir = okuyucu.readLine();
			 
			 while(satir!=null) 
			 {
				 
				 String[] strs = satir.split(",");
				 /* I split the satir and according to type(Book or Movie)
				 	I create a new object of Book/Movie which implements IMedia.
				 	And I create BinaryNode with type IMedia.
				 */
				 if(strs[0].equals("Book"))
				 {
						Book newBook= new Book(satir);				
						BinaryNode<IMedia> newBinaryNode = new BinaryNode<IMedia>(newBook);
						bstree.add((T) newBook);
				 }
				 
				 else if(strs[0].equals("Movie"))
				 {
						Movie newMovie = new Movie(satir);
						BinaryNode<IMedia> newBinaryNode = new BinaryNode<IMedia>(newMovie);
						bstree.add( (T) newMovie);
				 }
				 
					satir = okuyucu.readLine();
			}
				
			 	
			 	
			
		}
			 
			 
			 catch(FileNotFoundException ex){
				 System.out.println("File is not found.");
			 }
			 catch(IOException ex) {
				 System.out.println("Error is not found.");
			 }
		// I return tree.
		return (bstree);
		
	}

	
}
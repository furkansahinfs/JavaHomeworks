package G36_CENG112_HW4;

import java.util.ArrayList;
import java.util.Iterator;



public class BinarySearchTree<T> implements SearchTreeInterface<T>{

	private BinaryNode<T> root; // It is the node of tree.
	
	
	// I create my constructors.
	public BinarySearchTree() {
		root =null;
	}
	
	public BinarySearchTree(T rootData) {
		root = new BinaryNode<T>((IMedia) rootData); // I create a binaryNode which type of its data is IMedia.
	}
	
	public BinarySearchTree(T rootData,BinarySearchTree<T> leftTree, BinarySearchTree<T> rightTree) {
		privateSetTree(rootData,leftTree,rightTree); // In this constructor, I invoke a method.
	}
	
	
	

	public void setTree(T rootData)
	{
		root = new BinaryNode<T>((IMedia) rootData); // I create a binaryNode which type of its data is IMedia.
	}
	
	public void setTree(T rootData,SearchTreeInterface<T> leftTree, SearchTreeInterface<T> rightTree)
	{
		privateSetTree((T) rootData,(BinarySearchTree<T>) leftTree,(BinarySearchTree<T>) rightTree); // To set tree, I invoke a method.
	}

	private void privateSetTree(T rootData, BinarySearchTree<T> leftTree, BinarySearchTree<T> rightTree) {
			root = new BinaryNode<T>((IMedia) rootData); // I create a binaryNode which type of its data is IMedia.
			if(leftTree !=null)
			{ // If leftNode is not null, I set it.
				root.setLeftChild(leftTree.root);
			}
			if(rightTree !=null)
			{ // If rightNode is not null, I set it.
				root.setRightChild(rightTree.root);
			}
			
		}
		
	
	
	
	public T add(T newEntry)
	{
		T result = null;
		if(isEmpty())
		{ // If tree is empty, I create a rootNode which is a binaryNode with data IMedia.
			setRootNode(new BinaryNode<T>((IMedia) newEntry));
		}
		else
		{
			//If tree is not empty, I invoke a method.
			result = addEntry(getRootNode(),newEntry);
		}
		return  result;
	}
	
	private T addEntry(BinaryNode<T> rootNode, T newEntry) {
		/* If rootNode is not null, I create a new IMedia object to keep the data temporarily. 
		 * After that I compare the price of rootNode's data and given data.
		 * If prices are equal, I change the data. If roodNode's data is smaller than newEntry, I get left child of rootNode if it exits.
		 * I compare newEntry and LeftChild's data. If newEntry is bigger, again I get the left of left until find a bigger data from newEntry.
		 * If roodNode's data is bigger than newEntry, I get right child of rootNode if it exits.
		 * I compare newEntry and rightChild's data. If newEntry is smaller, again I get the right until find a smaller data from newEntry.
		 */
		assert rootNode !=null;
		T result = null;
		IMedia newMedia = (IMedia) rootNode.getData();
		if(newMedia.mediaPrice()== ((IMedia) newEntry).mediaPrice())
		{
			result = (T) rootNode.getData();
			rootNode.setData((IMedia) newEntry);
		}
		else if(newMedia.mediaPrice()<((IMedia) newEntry).mediaPrice())
		{
			if(rootNode.hasLeftChild())
			{
				result = (T) addEntry(rootNode.getLeftChild(),newEntry);
			}
			else
			{
				rootNode.setLeftChild(new BinaryNode<T>((IMedia) newEntry));
			}
		}
		else
		{
			assert (newMedia.mediaPrice()> ((IMedia) newEntry).mediaPrice());
			if(rootNode.hasRightChild())
			{
				result = addEntry(rootNode.getRightChild(),newEntry);
			}
			else
			{
				rootNode.setRightChild(new BinaryNode<T>((IMedia) newEntry));
			}
		}
		
		return result;
	}

	
	
	
	
	public boolean contains(T entry) {
		// If entry is in the tree, I return it through getEntry method
		return getEntry(entry)!=null;
	}

	
	public T getEntry(T entry) {
		// If entry is in the tree, I return it through findEntry method
		return findEntry((BinaryNode<T>) getRootNode(),entry);
	}


	private T findEntry(BinaryNode<T> rootNode, T entry) {
		T result =null;
		if(rootNode!=null)
		{
		 /* If given entry is smaller than rootNode, I compare leftChild of rootNode and given entry. 
		  * If given entry is bigger than rootNode, I compare rightChild of rootNode and given entry.
		  * Until find the equal data I investigate the rightChild or leftChild according to smaller/bigger condition.
		  * If there is not any equation, it returns null, else it returns data.
		  */
			IMedia rootEntry = (IMedia) rootNode.getData();
			
			if(entry.equals(rootEntry))
			{
				result = (T) rootEntry;
			}
			else if(rootEntry.mediaPrice()<((IMedia) entry).mediaPrice())
			{
				result = findEntry(rootNode.getLeftChild(),entry);
			}
			else
			{
				result = findEntry(rootNode.getRightChild(),entry);
			}
		}
		return result;
	}

	
	
	public void inorderTraverse(BinaryNode<T> node,int choice)
	{
		/* According to the choice in the main, I text the binaryTree.
		 *  For example descending media order ( choice 7 ), descending movie order ( choice 11 ), descending book order ( choice 9 )
		 *  ascending media order ( choice 8 ) , ascending movie order ( choice 12 ), ascending book order ( choice 10 )
		 */
		if(node!=null && choice == 7)
		{
			inorderTraverse(node.getLeftChild(),7);
			System.out.println(node.getData());
			inorderTraverse(node.getRightChild(),7);
			
		}
		else if(node!=null && choice == 8)
		{
			inorderTraverse(node.getRightChild(),8);
			System.out.println(node.getData());
			inorderTraverse(node.getLeftChild(),8);
		}
		else if(node!=null && choice ==9)
		{
			inorderTraverse(node.getLeftChild(),9);
			if(node.getData().mediaType().equalsIgnoreCase("Book"))
			{
			System.out.println(node.getData());
			}
			inorderTraverse(node.getRightChild(),9);
		}
		else if(node!=null && choice ==10)
		{
			inorderTraverse(node.getRightChild(),10);
			if(node.getData().mediaType().equalsIgnoreCase("Book"))
			{
			System.out.println(node.getData());
			}
			inorderTraverse(node.getLeftChild(),10);
		}
		else if(node!=null && choice ==11)
		{
			
			inorderTraverse(node.getLeftChild(),11);
			if(node.getData().mediaType().equalsIgnoreCase("Movie"))
			{
				System.out.println(node.getData());
			}
			inorderTraverse(node.getRightChild(),11);
		}
		else if(node!=null && choice ==12)
		{
			inorderTraverse(node.getRightChild(),12);
			if(node.getData().mediaType().equalsIgnoreCase("Movie"))
			{
			System.out.println(node.getData());
			}
			inorderTraverse(node.getLeftChild(),12);
		}
	}
	
	public void inorderTraversePrice(BinaryNode<T> node,int choice,int price)
	{
		/* According to the choice in the main and taken price, I text the binaryTree.
		 *  For example media whose prices are less or equal than the amount taken from console ( choice 5 )
		 *  media whose prices are greater or equal than the amount taken from console ( choice 6 )
		 */
		
		if(node!=null && choice == 5)
		{
			inorderTraversePrice(node.getLeftChild(),5,price);
			if(node.getData().mediaPrice()<=price)
			{
				System.out.println(node.getData());
			}
			inorderTraversePrice(node.getRightChild(),5,price);
			
		}
		
		if(node!=null && choice == 6)
		{
			inorderTraversePrice(node.getLeftChild(),6,price);
			if(price <= node.getData().mediaPrice())
			{
				System.out.println(node.getData());
			}
			inorderTraversePrice(node.getRightChild(),6,price);
			
		}
		
	}
	
	public T inorderTraverseName(BinaryNode<T> node,int choice, BinaryNode<T> tempNode,String name,int Price)
	{
		/* According to the choice in the main and taken name, I text the binaryTree.
		 *  For example minimum priced book whose author name is taken from console ( choice 1 )
		 *  maximum priced book whose author name is taken from console ( choice 2 )
		 * 	minimum priced movie whose director name is taken from console ( choice 1 )
		 * 	maximum priced movie whose director name is taken from console ( choice 2 )
		 */
		if(node!=null && choice == 1)
		{
			inorderTraverseName(node.getLeftChild(),1,tempNode,name,Price);
			/* If node's data equals to the taken name and node's data price is smaller than the specified price
			 * I set the tempNode data as current node data.
			 * and I make the specified price equals to current node data price.
			 */
			if(node.getData().mediaOwner().equalsIgnoreCase(name) && node.getData().mediaPrice()<Price)
			{
					tempNode.setData(node.getData());
					Price = node.getData().mediaPrice();
			}
			inorderTraverseName(node.getRightChild(),1,tempNode,name,Price);
			
		}
		
		else if(node!=null && choice == 2)
		{
			/* If node's data equals to the taken name and node's data price is greater than the specified price
			 * I set the tempNode data as current node data.
			 * and I make the specified price equals to current node data price.
			 */
			inorderTraverseName(node.getRightChild(),2,tempNode,name,Price);
			if(node.getData().mediaOwner().equalsIgnoreCase(name))
			{
				if(node.getData().mediaPrice()> Price)
				{
					tempNode.setData(node.getData());
					Price = node.getData().mediaPrice();
				}
			}
			inorderTraverseName(node.getLeftChild(),2,tempNode,name,Price);
			
		}
		return (T) tempNode.getData();
	}
	
	
	
	
	public IMedia getRootData()
	{
		// It returns rootNode's data
		IMedia rootData = null;
		if(root!=null)
		{
			rootData = root.getData();
		}
		return rootData;
	}
	
	
	public void setRootData(T rootData)
	{
		
		// It sets root's data to taken data.
		root.setData((IMedia) rootData);
	}
	
	public void setRootNode(BinaryNode<T> rootNode)
	{
		// ıt sets root tot taken Node.
		root = rootNode;
	}
	
	public BinaryNode<T> getRootNode()
	{
		// returns root.
		return root;
	}
	
	public boolean isEmpty()
	{
		// If root's data is null, it returns true.
		return root.getData()==null;
	}
	
	public void clear()
	{
		// To clear, I make root null.
		root =null;
	}

	
	
	
	@Override
	public T remove(T entry) {
	
		return null;
	}
	
	

	

	@Override
	public Iterator<T> getInorderIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	

}

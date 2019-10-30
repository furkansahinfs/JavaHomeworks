package G36_CENG112_HW4;

public class BinaryNode<T> {
	// I create my variables.
	private IMedia data; // My data type is IMedia.
	private BinaryNode<T> leftChild;
	private BinaryNode<T> rightChild;
	
	
	// I create my consturctors.
	public BinaryNode()
	{
		data = null;
	}
	public BinaryNode(IMedia dataPortion)
	{
		this(dataPortion,null,null);
	}
	public BinaryNode(IMedia dataPortion,BinaryNode<T> newLeftChild,BinaryNode<T> newRightChild)
	{
		data = dataPortion;
		leftChild = newLeftChild;
		rightChild = newRightChild;
	}
	
	
	public IMedia getData()
	{ // It returns node's data.
		return data;
	}
	
	
	public void setData(IMedia newData)
	{
		// It sets node's data to taken data.
		data=newData;
	}
	public BinaryNode<T> getLeftChild()
	{
		// It returns Node's leftChild.
		return leftChild;
	}
	public BinaryNode<T> getRightChild()
	{
		// It returns Node's rightChild.
		return rightChild;
	}
	public void setLeftChild(BinaryNode<T> newLeftChild)
	{
		// It sets node's leftChild to taken node.
		leftChild = newLeftChild;
	}
	public void setRightChild(BinaryNode<T> newRightChild)
	{
		// It sets node's rightChild to taken node.
		rightChild = newRightChild;
	}
	public boolean hasLeftChild()
	{
		// It returns true if leftChild is not null, else returns false.
		return leftChild !=null;
	}
	public boolean hasRightChild()
	{
		// It returns true if rightChild is not null, else returns false.
		return rightChild !=null;
	}
	public boolean isLeaf()
	{ 
		// It returns true if leftChild and rightChild is null, else returns false.
		return ((leftChild ==null)&&(rightChild == null));
	}

	
}

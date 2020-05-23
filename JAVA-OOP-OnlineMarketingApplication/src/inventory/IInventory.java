package inventory;

public interface IInventory<T> {
	
	public void addProduct(T product,int quantity);
	
	public boolean removeProduct(T product, int quantity);


}

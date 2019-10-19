package G36_CENG112_HW2;

public interface IProduct<T> {

	/*
	 * isManufactured function controls the production of the product
	 * @param T newItem a type of item for controlling production status
	 * @return if product is already produced return true, else return false
	 */
	public boolean isManufactured(T newItem);
	/*
	 * isManufactured function controls the storage of the product
	 * @param T newItem a type of item for controlling storage status
	 * @return if product is already stored in warehouse return true, else return false
	 */
	public boolean isStored(T newItem);
	/*
	 * isManufactured function controls the sales of the product
	 * @param T newItem a type of item for controlling sales status
	 * @return if product is already sold return true, else return false
	 */
	public boolean isSold(T newItem);


	
}

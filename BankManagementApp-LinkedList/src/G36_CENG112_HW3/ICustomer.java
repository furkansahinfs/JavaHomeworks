package G36_CENG112_HW3;

public interface ICustomer {
	public String getType(); // return customer type.

	public String getInfo(); // return customer transaction info

	public int getId(); // return customer id

	public String getDate(); // return customer transaction's date

	public int getPriority(); // return customer priority

	public String toString(); // return customer info as string

	public int getOccupation(); // return customer occupation.
}

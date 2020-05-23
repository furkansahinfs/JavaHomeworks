package Collections;


import Facilities.Facilities;

public interface IContainer {
	
	public <T> boolean add(T eleman) throws Exception ; // invokes the addControl method, according to situation returns true or false
	public <T> boolean addControl(T eleman) throws Exception ; // try to add item to the container, according to situation returns true or false

	public <T> boolean remove(T eleman) ; // try to remove item from the container, according to situation returns true or false

	public <T> boolean transferTo(T eleman, Facilities faci); // try to transfer item to the given facilities, according to situation returns true or false

}

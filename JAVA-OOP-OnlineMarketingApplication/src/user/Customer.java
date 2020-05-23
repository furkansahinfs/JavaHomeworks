package user;


import java.util.HashMap;

import exception.ProductNotFoundException;
import inventory.*;
import main.Wallet;
import product.Product;

public class Customer extends RegularUser
{
	private double basketCost;
	private Basket basket;
	private Inventory boughtInventory;
	
	/*
	 * constructer for customer
	 * 
	 */
	public <T> Customer(int type,String username,String password,Wallet wallet,ContactInfo contactInfo) 
	{
		boughtInventory = new Inventory<T>() {};
		setBasket(new Basket<T>());
		setWallet(wallet);
		setPassword(password);
		setType(type);
		setUsername(username);
		setContactInfo(contactInfo);
	}
	
	/*
	 * it adds product to customer's basket
	 * 
	 */
	public <T> void addToBasket(T product,int quantity) throws Exception 
	{
		if (product instanceof Product) 
		{
			basketCost= basketCost+ calculateCost(product, quantity);
			basket.addProduct(product, quantity);
		}
		else 
		{
			throw new ProductNotFoundException("No item such like that.");
		}
		
	}
	
	/*
	 * it removes a product where customer's basket
	 * 
	 */
	public <T> void removeFromBasket(T product,int quantity) throws Exception 
	{
		if (product instanceof Product)
		{
			if(basket.getBasketInventory().containsKey(product)) 
			{
				if(((Integer)basket.getBasketInventory().get(product))>=quantity) 
				{
					basketCost= basketCost - calculateCost(product, quantity);
					basket.removeProduct(product, quantity);
				}
				else 
				{
					throw new Exception("No enough item.");
				}
				
			}
			
			else 
			{
				throw new ProductNotFoundException("No item such like that.");
			}
			
		}
		else 
		{
			throw new ProductNotFoundException("No item such like that.");
		}
	}
	
	/*
	 * it calculates product cost
	 * 
	 */
	public <T> double calculateCost(T product,int quantity) 
	{	
		return (((Product) product).getPrice()+((Product) product).cargoPrice())*quantity;
	}
	
	public boolean addAddressToContactınfo(Address address) 
	{
		return getContactInfo().getAddressList().add(address);
	}
	
	/*
	 * it buys a product and add to product soled inventrory and remove from basket
	 * 
	 */
	public <T> HashMap<Product, Integer> buy() throws Exception 
	{
		if(basketCost<=getWallet().getActive_balance()) 
		{
			HashMap<Product,Integer> returnedProducts = new HashMap<Product, Integer>();
			Object[] valueList =  basket.getBasketInventory().values().toArray();
			Object[] productList = basket.getBasketInventory().keySet().toArray();
			
			
			for(int i=0;i<basket.getBasketInventory().size();i++) 
			{
				boughtInventory.addProduct((Product) productList[i],(Integer) valueList[i]);
				returnedProducts.put((Product) productList[i],(Integer) valueList[i]);			
			}
			
			getWallet().setActive_balance(getWallet().getActive_balance()-basketCost);
			basket.getBasketInventory().clear();
			basketCost = 0;
			return returnedProducts;
		}
		throw new Exception("No enough money");
	}
	
		
	
	
	
	public Basket getBasket() 
	{
		return basket;
	}
	public void setBasket(Basket basket) 
	{
		this.basket = basket;
	}

	public Inventory getBoughtInventory()
	{
		return boughtInventory;
	}

	public void setBoughtInventory(Inventory boughtInventory) 
	{
		this.boughtInventory = boughtInventory;
	}
	
}

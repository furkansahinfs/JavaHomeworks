package user;

import java.util.HashMap;
import java.util.Iterator;
import inventory.Shop;
import main.Wallet;
import product.Product;

public class Supplier extends RegularUser{
	private String shopCategory,shopTitle,taxNumber;
	private boolean approvedSeller = false;
	

	private Shop shop;
	private Shop soldProduct;
	private double processPrice;

	
	/*
	 * constructer for supplier
	 * 
	 */
	public <T> Supplier(int type,String username,String password,Wallet wallet,ContactInfo contactInfo,String shopCategory,String shopTitle,String taxNumber) 
	{
		shop = (new Shop<T>());
		soldProduct = (new Shop<T>());
		setWallet(wallet);
		setPassword(password);
		setType(type);
		setUsername(username);
		setContactInfo(contactInfo);
		this.shopCategory = shopCategory;
		this.shopTitle = shopTitle;
		this.taxNumber = taxNumber;
	}
	
	/*
	 * check for products which in form hashmap to this supplier sold anyone of these product which in this hasmap 
	 * 
	 */
	public boolean sold(HashMap<Product,Integer> returnedProducts )
	{
		boolean bool = false;
		Iterator<Product> iterator = returnedProducts.keySet().iterator();
		Product product;
		while(iterator.hasNext()) 
		{
			product = iterator.next();
			if(getShop().getShopInventory().containsKey(product)) 
			{
				if((Integer) getShop().getShopInventory().get(product)==returnedProducts.get(product)) 
				{
					getShop().getShopInventory().remove(product);
				}
				else 
				{
					getShop().getShopInventory().replace(product, (Integer) getShop().getShopInventory().get(product)-returnedProducts.get(product));
				}
				soldProduct.addProduct(product, returnedProducts.get(product));
				getWallet().setActive_balance(getWallet().getActive_balance()+(calculateCost(product, returnedProducts.get(product)))*0.98);
				processPrice = processPrice + (calculateCost(product, returnedProducts.get(product))*0.02);		
				bool = true;
			}

			
		}
		return bool;
	}
	
	/*
	 * calculate cost for product
	 * 
	 */
	public double calculateCost(Product product, int quantity) 
	{
		return (product.getPrice()+product.cargoPrice())*quantity;
	}
	
	/*
	 * it shows shop inventory for supplier
	 * 
	 */
	public void showShopInventory() 
	{
		System.out.println(getShop().getShopInventory().toString());
	}
	
	/*
	 * it shows soled inventory for supplier
	 * 
	 */
	public void showSoldInventory() 
	{
		System.out.println(soldProduct.getShopInventory().toString());
	}

	/*
	 * it getters double price of process
	 * 
	 */
	public double getProcessPrice() 
	{
		return processPrice;
	}

	public void setProcessPrice(double processPrice) {
		this.processPrice = processPrice;
	}
	
	public Shop getSoldProduct() {
		return soldProduct;
	}

	public void setSoldProduct(Shop soldProduct) {
		this.soldProduct = soldProduct;
	}


	public String getShopCategory() {
		return shopCategory;
	}
	public void setShopCategory(String shopCategory) {
		this.shopCategory = shopCategory;
	}
	public String getTaxNumber() {
		return taxNumber;
	}
	

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public String getShopTitle() {
		return shopTitle;
	}

	public void setShopTitle(String shopTitle) {
		this.shopTitle = shopTitle;
	}

	@SuppressWarnings("rawtypes")
	public Shop getShop() {
		return shop;
	}

	@SuppressWarnings("rawtypes")
	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public boolean isApprovedSeller() {
		return approvedSeller;
	}

	public void setApprovedSeller(boolean approvedSeller) {
		this.approvedSeller = approvedSeller;
	}
	
	public String toString() {
		return super.toString() + " " + shopCategory + " " + shopTitle + " " + taxNumber ;
		
	}
	
}

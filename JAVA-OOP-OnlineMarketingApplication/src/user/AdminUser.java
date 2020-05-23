package user;

import java.util.ArrayList;

import main.Wallet;

public class AdminUser extends User
{
	private ArrayList<Supplier> supplierList;
	private ArrayList<Supplier> notApprovedSupplierList;
	private ArrayList<Supplier> approvedSupplierList;


	public AdminUser(int type,String username,String password,Wallet wallet) 
	{
		this.approvedSupplierList = new ArrayList<Supplier>();
		this.notApprovedSupplierList= new ArrayList<Supplier>();
		this.supplierList = new ArrayList<Supplier>();
		setWallet(wallet);
		setPassword(password);
		setType(type);
		setUsername(username);
	}
	
	/*
	 * it returns all suppliers
	 * 
	 */
	public <T> ArrayList<Supplier> getAllSuppliers(ArrayList<T> list)
	{
		for (T elements : list)  
        { 
            if (((User) elements).getType() == 3) 
            { 
              supplierList.add((Supplier)  elements);
            } 
        } 
		return supplierList;
		
	}
	
	/*
	 * it returns not approved all suppliers
	 * 
	 */
	public <T> ArrayList<Supplier> getNotApprovedSuppliers(){
			
			for (Supplier elements : supplierList)  
	        { 
	            if (((Supplier) elements).isApprovedSeller() == false) 
	            { 
	              notApprovedSupplierList.add((Supplier)  elements);
	            } 
	        } 
			return notApprovedSupplierList;
			
		}
	
	/*
	 * it returns all approved suppliers
	 * 
	 */
	public <T> ArrayList<Supplier> getApprovedSuppliers()
	{
		for (Supplier elements : supplierList)  
	    { 
	        if (((Supplier) elements).isApprovedSeller() == true) 
	        { 
	          approvedSupplierList.add((Supplier)  elements);
	        } 
	    } 
		return approvedSupplierList;
		
	}
	
	/*
	 * it is approve a supplier
	 * 
	 */
	public boolean approved(int choice) 
	{
		if (choice> notApprovedSupplierList.size()) 
		{
			return false;
		}
		
		else 
		{
			notApprovedSupplierList.get(choice).setApprovedSeller(true); 
			approvedSupplierList.add(notApprovedSupplierList.get(choice));
			notApprovedSupplierList.remove(choice);
			return true;
		}
	}
	

	/*
	 * it shows approved suppliers
	 * 
	 */
	public void showApprovedSuppliers() 
	{
		for(int i = 0;i<getApprovedSupplierList().size();i++) 
		{
			System.out.println((i+1) + " "+ getApprovedSupplierList().get(i));
		}
	}
	
	/*
	 * it shows not approved suppliers
	 * 
	 */
	public void showNotApprovedSuppliers() 
	{
		for(int i = 0;i<getNotApprovedSupplierList().size();i++) 
		{
			System.out.println((i+1) + " "+ getNotApprovedSupplierList().get(i));
		}
	}
	
	/*
	 * shows all suppliers
	 * 
	 */
	public void showSuppliers() 
	{
		for(int i = 0;i<getSupplierList().size();i++) 
		{
			System.out.println((i+1) + " "+ getSupplierList().get(i));
		}
	}
	
	public ArrayList<Supplier> getSupplierList() {
		return supplierList;
	}
	public void setSupplierList(ArrayList<Supplier> supplierList) {
		this.supplierList = supplierList;
	}
	public ArrayList<Supplier> getNotApprovedSupplierList() {
		return notApprovedSupplierList;
	}
	public void setNotApprovedSupplierList(ArrayList<Supplier> notApprovedSupplierList) {
		this.notApprovedSupplierList = notApprovedSupplierList;
	}
	public ArrayList<Supplier> getApprovedSupplierList() {
		return approvedSupplierList;
	}
	public void setApprovedSupplierList(ArrayList<Supplier> approvedSupplierList) {
		this.approvedSupplierList = approvedSupplierList;
	}
	
	
	}


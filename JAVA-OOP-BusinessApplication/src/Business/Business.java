package Business;

import Collections.DryStorageContainer;
import Collections.OpenTopContainer;
import Collections.TankContainer;
import Exceptions.ItemNotUncountableException;
import Facilities.*;
import Item.ICountable;
import Item.IUncountable;

public class Business {
	
	private DryStorageContainer dry; // it is the dry storage container
	private OpenTopContainer open; // it is open top container
	private TankContainer tank; // it is the tank container
	private Warehouse war; // it is the warehouse
	private Factory fac; // it is the factory
	private DistributionCenter dis; // it is the distribution center
	private double para; // it is the money.
	
	public Business(double para)
	{
		dry = new DryStorageContainer();
		open = new OpenTopContainer();
		tank = new TankContainer();
		war = new Warehouse();
		fac = new Factory();
		dis = new DistributionCenter();
		this.para = para;
	}
	

	/**
	 * If given item is uncountable and there exists enough money then it invokes the buy method of warehouse.
	 *  According to situation buying process is executed and money is fixed.
	 */
	public <T> void buy(T eleman) throws ItemNotUncountableException
	{
		if(eleman instanceof IUncountable) 
		{
			if(calculateCost(eleman)<=para) 
			{
				if(war.buy((IUncountable) eleman))
				{
					para = para-calculateCost(eleman);
					System.out.println("Succesfull buying");
				}
			}
			else 
			{
				System.out.println("yetersiz bakiye");
			}
		}
	}
	
	
	/**
	 * It invokes the sell method of distribution center.
	 *  According to situation seling process is executed and money is fixed.
	 */
	public void sell(ICountable eleman) 
	{
		if(dis.sell( eleman)) 
		{
			double sellCost=calculateCost(eleman); // calculates the cost of given item
			para=para+sellCost;
			System.out.println("Succesfull selling");
		}
		else
		{
			System.out.println("No enough item to sell");
		}
	}
	
	
	/**
	 * It invokes the producing method of warehouse.
	 *  According to situation producing process is executed.
	 */
	public boolean üret(ICountable eleman)  
	{
		if(fac.produce(eleman)) 
		{
			System.out.println("Succesfull producing");
			return true;
		}
		else 
		{
			System.out.println("Producing error");
			return false;
		}
		
	}
	
	
	/**
	 * According to type of given item we calculate the cost of the given item according to its litre.
	 */
	public <T> double calculateCost(T eleman) 
	{
		switch (eleman.getClass().getSimpleName()) 
		{
		case "BoxedMilk":
			return (((ICountable) eleman).getLitre())*1;
			
		case "Yogurt":
			return (((ICountable) eleman).getLitre())*2;
			
		case "Chocolate":
			return (((ICountable) eleman).getLitre()*4.0);
		case "Milk":
			return (((IUncountable) eleman).getLitre())*(0.25);

			
		case "Yeast":
			return (((IUncountable) eleman).getLitre())*5;

			
		case "Cream":
			return (((IUncountable) eleman).getLitre())*(0.3);

			
		case "Cacao":
			return (((IUncountable) eleman).getLitre())*1;
		
		}
		return 0;
		
	}
	
	
	/**
	 * According to type of given item it invokes the transfer method of warehouse or factory.
	 * If item is milk or cream it invokes the warehouse transferTo method with tank container
	 * If item is cacao or yeast it invokes the warehouse transferTo method with open top container
	 * If item is product it invokes the factory transferTo method with dry storage container
	 * And according to container position cost is calculated and container position is set.
	 */
	public <T> void  transfer(T eleman ) throws Exception
	{	
		if(eleman instanceof IUncountable) 
		{
			switch (eleman.getClass().getSimpleName())
			{
				case "Milk":
					tankContainerCost(eleman);
					break;
		
				
				case "Yeast":
					openTopContainerCost(eleman);
					break;
		
				case "Cream":
					tankContainerCost(eleman);
					break;
		
				case "Cacao":
					openTopContainerCost(eleman);
					break;
			}
		}
		
		else if( eleman instanceof ICountable) 
		{
			/*
			 * If dry container is at the factory, we just send it to distribution with item
			 * If not we firstly bring the dry container to the factory and send it to the distribution with item.
			 * During these operations, each cost of set of position is calculated and money is fixed.
			 */
			if(dry.getPozisyon() == 2) 
			{
				if(para-100>=0) 
				{
					switch (eleman.getClass().getSimpleName())
					{
						case "Chocolate":
							if(fac.transferTo(eleman, dis, dry)) 
							{
								para=para-100;
								dry.setPozisyon(3);
								System.out.println("Succesfull transferring to the distribution");
							}
							break;
					
						case "BoxedMilk":
							if(fac.transferTo(eleman, dis, dry)) 
							{
								para=para-100;
								dry.setPozisyon(3);
								System.out.println("Succesfull transferring to the distribution");
							}
							break;
					
						case "Yogurt":
							if(fac.transferTo(eleman, dis, dry)) 
							{
								para=para-100;
								dry.setPozisyon(3);
								System.out.println("Succesfull transferring to the distribution");
							}
							break;
					}
				}
				
					else 
					{
						System.out.println("No enough money to transfer");
					}
					
			}
				
				else 
				{
					if(para-100>=0) 
					{
						para=para-100;
						dry.setPozisyon(2);
						transfer(eleman);
					}
					else 
					{
						System.out.println("No enough money to transfer");
					}
				}	
			}
			else 
			{
				System.out.println("Business transfer error ");
			}
		
	}
	
	
	/*
	 * If tank container is at the factory, we firstly bring the tank container to the warehouse
	 * If tank container is at the warehouse, we send it factory with item.
	 * During these operations, each cost of set of position is calculated and money is fixed.
	 */
	public <T> void tankContainerCost(T eleman) throws Exception {
		if(tank.getPozisyon() == 2) 
		{
			if(para-100>=0) 
			{
				if(war.transferTo(eleman, fac, tank)) 
				{
					para=para-100;
					tank.setPozisyon(1);
					System.out.println("Succesfull transferring to the factory");
				}
			}
		}
		
		else 
		{
			if(para-100>=0) 
			{
				para=para-100;
				tank.setPozisyon(2);
				transfer(eleman);
			}
			else 
			{
				System.out.println("No enough money to transfer");
			}
			
		}
	}
	
	
	/*
	 * If open top container is at the factory, we firstly bring the tank container to the warehouse
	 * If open top container is at the warehouse, we send it factory with item.
	 * During these operations, each cost of set of position is calculated and money is fixed.
	 */
	public <T> void openTopContainerCost(T eleman) throws Exception 
	{
		if(open.getPozisyon() == 2) 
		{
			if(para-100>=0) 
			{
				if(war.transferTo(eleman, fac, open)) 
				{
					para=para-100;
					open.setPozisyon(1);
					System.out.println("Succesfull transferring to the factory");
				}
			}
		}
		
		else 
		{
			if(para-100>=0) 
			{
				para=para-100;
				open.setPozisyon(2);
				transfer(eleman);
			}
			else 
			{
				System.out.println("No enough money to transfer");
			}
			
		}
	}
	
	public void display() {
		System.out.println("------------------------------------");
		System.out.println("Warehouse MilkTank: "+ war.getStorageTank().getMilkTank().getLitre() + " Litre");
		System.out.println("Warehouse CacaoTank: "+war.getStorageTank().getCacaoTank().getLitre() + " Litre");
		System.out.println("Warehouse YeastTank :"+war.getStorageTank().getYeastTank().getLitre() + " Litre");
		System.out.println("Warehouse CreamTank :"+war.getStorageTank().getCreamTank().getLitre() + " Litre");
		System.out.println("------------------------------------");
		System.out.println("Factory MilkTank: "+fac.getStorageTanks().getMilkTank().getLitre());
		System.out.println("Factory CacaoTank: "+fac.getStorageTanks().getCacaoTank().getLitre());
		System.out.println("Factory YeastTank: "+fac.getStorageTanks().getYeastTank().getLitre());
		System.out.println("Factory CreamTank: "+fac.getStorageTanks().getCreamTank().getLitre());
		System.out.println("Factory BoxedMilkArea: "+fac.getStorageArea().getSa_BoxedMilk().getLitre() + " Litre --- BoxedMilk count is : " +fac.getStorageArea().getSa_BoxedMilk().getLitre());
		System.out.println("Factory ChocolateArea: "+fac.getStorageArea().getSa_Chocolate().getLitre() + " Litre --- Chocolate count is : " +fac.getStorageArea().getSa_Chocolate().getLitre()*2);
		System.out.println("Factory YogurtArea: "+fac.getStorageArea().getSa_Yogurt().getLitre()+ "Litre --- Yogurt count is : " +fac.getStorageArea().getSa_Yogurt().getLitre()*0.5);
		System.out.println("------------------------------------");
		System.out.println("Distribution BoxedMilkArea: "+dis.getStorageArea().getSa_BoxedMilk().getLitre()+ " Litre --- BoxedMilk count is : " +dis.getStorageArea().getSa_BoxedMilk().getLitre());
		System.out.println("Distribution ChocolateArea: "+dis.getStorageArea().getSa_Chocolate().getLitre()+ " Litre --- Chocolate count is : " +dis.getStorageArea().getSa_Chocolate().getLitre()*2);
		System.out.println("Distribution YogurtArea: "+dis.getStorageArea().getSa_Yogurt().getLitre()+ "Litre --- Yogurt count is : " +dis.getStorageArea().getSa_Yogurt().getLitre()*0.5);
		System.out.println("------------------------------------");
		System.out.println("Money:"+para);
		System.out.println("------------------------------------");


	}
	public DryStorageContainer getDry() {
		return dry;
	}

	public void setDry(DryStorageContainer dry) {
		this.dry = dry;
	}

	public OpenTopContainer getOpen() {
		return open;
	}

	public void setOpen(OpenTopContainer open) {
		this.open = open;
	}

	public TankContainer getTank() {
		return tank;
	}

	public void setTank(TankContainer tank) {
		this.tank = tank;
	}

	
	public double getPara() {
		return para;
	}
	public void setPara(double para) {
		this.para = para;
	}
	public Warehouse getWar() {
		return war;
	}
	public void setWar(Warehouse war) {
		this.war = war;
	}
	public Factory getFac() {
		return fac;
	}
	public void setFac(Factory fac) {
		this.fac = fac;
	}
	public DistributionCenter getDis() {
		return dis;
	}
	public void setDis(DistributionCenter dis) {
		this.dis = dis;
	}
}

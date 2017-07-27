/**
 * main class that create menus and insert menu items in menu list 
 */
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


public class Main {

	/**
	 * 
	 * @return a main menu that contain whole structure  
	 */
	public static Menu createMenu(){
		Menu mainMenu=new Menu();
		
		MenuItem mi = new ActionableMenuItem(new Products());		// create an actionable menu that print products
		List<MenuItem> subMenu = mainMenu.getSubMenu();			//	a list of menu items 
		mi.setDisplayName("1. Display Products");
		subMenu.add(mi);										// add menu items to list 
		
		mi=new Menu();											
		mi.setDisplayName("2. Display Promotions");					// create a menu item which is not actionable	
		
		subMenu.add(mi);
		List<MenuItem> subPromoMenu=((Menu) mi).getSubMenu();		// create another list of menu items 
        
		mi=new ActionableMenuItem(new ProductPromo());				
        mi.setDisplayName("1. Display Product Promotions");			// add menu items	
        subPromoMenu.add(mi);
        
        mi=new ActionableMenuItem(new OrderPromo());
        mi.setDisplayName("2. Display OrderPromotions");			// add menu items
        subPromoMenu.add(mi);										// add menu items to another list of menu items


		mi=new ActionableMenuItem(new Shopping());								
		mi.setDisplayName("3. Enter your order and generate Bill");			// create an actionable menu that print bill 
		subMenu.add(mi);
		
		mi=new ActionableMenuItem(new Exit());							
		mi.setDisplayName("4. Exit");
		subMenu.add(mi);
		mainMenu.setSubMenu(subMenu);
		
		return mainMenu;
	}
	
	/**
	 * method to display list
	 * @param menu
	 */
	public static void display(Menu menu){
		Iterator<MenuItem> itr=menu.getSubMenu().iterator();
		while(itr.hasNext()){
			System.out.println(itr.next().getDisplayName());
		}	
	}
	
	/**
	 * method to take inputs
	 * @return
	 */
	public static int getInput(){
		Scanner scan= new Scanner(System.in);
		int choice=scan.nextInt();
		return choice-1;
	}
	
	/**
	 * method to display the main menu structure generated
	 * @param menu
	 */
	public static void displayAndPerformAction(Menu menu){
		
		display(menu);
		
		int choice=getInput();
		
		MenuItem menuItem= menu.getSelection(choice);
	
		
		if(menuItem==null){
			displayAndPerformAction(menu);
		}
		else if(menuItem instanceof ActionableMenuItem){
			
			((ActionableMenuItem)menuItem).triggerAction();			// action of actionable menu item is triggered
		}
		else{
			displayAndPerformAction((Menu)menuItem);
		}
		
	}
	
	public static void main(String args[]){
		Menu menu=createMenu();
		while(true){
		displayAndPerformAction(menu);
		}
	}
}

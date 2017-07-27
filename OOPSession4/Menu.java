/**
 * class that create a list of menu items 
 */
import java.util.ArrayList;
import java.util.List;


public class Menu extends MenuItem{
	
	private List<MenuItem> subMenu=new ArrayList<MenuItem>();

	/**
	 * 
	 * @return list of menu items
	 */
	public List<MenuItem> getSubMenu() {
		return subMenu;
	}

	/**
	 *
	 * @param list
	 */
	public void setSubMenu(List<MenuItem> list) {
		this.subMenu= list;
	}
	
	/**
	 * 
	 * @param choice
	 * @return menu item list at that index 
	 */
	public MenuItem getSelection(int choice){
		if(choice>=subMenu.size())return null;
		
		return subMenu.get(choice);
	}

	
}

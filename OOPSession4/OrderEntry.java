/**
 * get and set quantity of products  
 * @author User21
 *
 */
public class OrderEntry extends Products {
	int quantity;
	/**
	 * set quantity
	 * @param value
	 */
	public void setQuantity(int value){
		this.quantity = value;
	}
	/**
	 * get quantity
	 * @return
	 */
	public int getQuantity(){
		return this.quantity;
	}
}

/**
 * 
 * @author Shubham
 *get and set the various fields of products like name, ID,prize
 */
public class Products {
	String productName;
	int productID;
	double productPrize;
	/**
	 * set product name
	 * @param name
	 */
	public void setProductName(String name){
		this.productName = name;
	}
	/**
	 * set product ID
	 * @param id
	 */
	public void setProductID(int id){
		this.productID = id;
	}
	/**
	 * set prize of product 
	 * @param prize
	 */
	public void setProductPrize(double prize){
		this.productPrize = prize;
	}
	/**
	 * get product name
	 * @return
	 */
	public String getProductName(){
		return this.productName;
	}
	/**
	 * get product ID
	 * @return
	 */
	public int getProductID(){
		return this.productID;
	}
	/**
	 * get product Prize
	 * @return
	 */
	public double getProductPrize(){
		return this.productPrize;
	}
}

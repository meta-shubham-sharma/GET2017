import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;



class Products implements Action{

	@Override
	public void performAction() {
		// TODO Auto-generated method stub
		try{
			String str ="";
			FileInputStream fstream= new FileInputStream("C:/Users/User21/Desktop/ProductsList.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
			System.out.println();
			}catch(Exception e){
				
			}
	}
	
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
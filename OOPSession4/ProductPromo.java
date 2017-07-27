import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;


/**
 * 
 * @author Shubham
 *get and set various fields of promotions like type,discount/percentage , codes
 */
public class ProductPromo implements Action{
	String promotionType;
	int productIDs[];
	double discount,percentage;
	/**
	 * set promotion type
	 * @param type
	 */
	public void setPromotionType(String type){
		this.promotionType = type;
	}
	/**
	 * get promotion type
	 * @return
	 */
	public String getPromotionType(){
		return this.promotionType;
	}
	/**
	 * set discount
	 * @param discount
	 */
	public void setDiscount(double discount){
		this.discount = discount;
	}
	/**
	 * get discount
	 * @return
	 */
	public double getDiscount(){
		return this.discount;
	}
	/**
	 * set percentage
	 * @param percentage
	 */
	public void setPercentage(double percentage){
		this.percentage = percentage;
	}
	/**
	 * get percentage
	 * @return
	 */
	public double getPercentage(){
		return this.percentage;
	}
	/**
	 * set product IDs on which discount is applicable
	 * @param id
	 */
	public void setProductIDs(int id[]){
		this.productIDs = id;
	}
	/**
	 * get product IDs on which discount is applicable
	 * @return
	 */
	public int[] getProductIDs(){
		return this.productIDs;
	}
	@Override
	public void performAction() {
		// TODO Auto-generated method stub
		try{
		String str ="";
		FileInputStream fstream= new FileInputStream("C:/Users/User21/Desktop/ProductPromo.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		while ((str = br.readLine()) != null) {
			System.out.println(str);
		}
		System.out.println();
		}catch(Exception e){
			
		}
	}
}

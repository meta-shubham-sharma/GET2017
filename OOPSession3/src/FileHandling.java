/**
 * class to read data from files and return lists having data 
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class FileHandling {
	FileInputStream fstream;
	BufferedReader br;
	String str = "";
	/**
	 * 
	 * @param filePath
	 * @return list of objects of product class having all details of products
	 */
	public List<Products> printProducts(String filePath) {
		Products prod;
		List<Products> products = new ArrayList<Products>();
		try {
			fstream = new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fstream));
			while ((str = br.readLine()) != null) {
				prod = new Products();
				String string[] = str.split(",");
				prod.setProductID(Integer.parseInt(string[0]));					// set product id		
				prod.setProductName(string[1]);									// set product name
				prod.setProductPrize(Double.parseDouble(string[2]));			// set product prize
				products.add(prod);
			}
			br.close();
			System.out.println();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return products;
	}

	/**
	 * 
	 * @param filePath
	 * @return list of objects of product promos class having all details of promos of products
	 */
	public List<ProductPromo> printPromos(String filePath) {
		ProductPromo promo;
		List<ProductPromo> promoProduct = new ArrayList<ProductPromo>();
		try {
			fstream = new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fstream));
			while ((str = br.readLine()) != null) {
				promo = new ProductPromo();
				String string[] = str.split(",");
				promo.setPromotionType(string[0]);								// set promotion type	
				if (string[0].equals("ProductFixedAmountPromotion")) {
					promo.setDiscount(Double.parseDouble(string[1]));			// set promotion discount
				} else {
					promo.setPercentage(Double.parseDouble(string[1]));			// set promotion percentage discount
				}
				String id[] = string[2].split(";");
				int ids[] = new int[id.length];
				for (int index = 0; index < id.length; index++) {
					ids[index] = Integer.parseInt((id[index]));					
				}
				promo.setProductIDs(ids);										// set all codes on which discount is applicable
				promoProduct.add(promo);
			}
			br.close();
			System.out.println();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return promoProduct;
	}
	
	/**
	 * 
	 * @param filePath
	 * @return list of objects of order promos class having all details of promos on total order
	 */
	public List<OrderPromo> printOrderPromos(String filePath) {
		OrderPromo oPromo;
		List<OrderPromo> orderPromo = new ArrayList<OrderPromo>();
		try {
			fstream = new FileInputStream(filePath);
			br = new BufferedReader(new InputStreamReader(fstream));
			while ((str = br.readLine()) != null) {
				oPromo = new OrderPromo();
				String string[] = str.split(",");
				oPromo.setPromotionType(string[0]);								// set promotion type		
				if (string[0].equals("OrderFixedAmountPromotion")) {
					oPromo.setDiscount(Double.parseDouble(string[1]));			// set discount
				} else {
					oPromo.setPercentage(Double.parseDouble(string[1]));		//set percentage discount	
				}
				oPromo.setThreshold(Double.parseDouble(string[2]));				// set threshold values	
				orderPromo.add(oPromo);
			}
			br.close();
			System.out.println();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return orderPromo;
	}

	/**
	 * 
	 * @param numOfProducts
	 * @param scan
	 * @param products
	 * @return list of objects of order entry class having all details of order given by user
	 */
	public List<OrderEntry> getOrderEntry(int numOfProducts,Scanner scan,List<Products> products){
		OrderEntry order;
		List<OrderEntry> orders = new ArrayList<OrderEntry>();
		for (int index = 0; index < numOfProducts; index++) {
			order = new OrderEntry();
			boolean flag = true;
			System.out.println("Enter product code : ");
			int productCode = scan.nextInt();
			order.setProductID(productCode);
			do{
				try{
					System.out.println("Enter quantity : ");
					int quantity = Integer.parseInt(scan.next());
					if(quantity <= 0 ){
						throw new NumberFormatException();
					}
					flag = false;
					order.setQuantity(quantity);
				}
				catch(NumberFormatException n){
					System.out.println("Enter a valid quantity");
				}
			}while(flag);
			for (Products obj1 : products) {
				if (obj1.getProductID() == productCode) {
					order.setProductName(obj1.getProductName());
					order.setProductPrize(obj1.getProductPrize());
				}
			}
			orders.add(order);
		}
		return orders;
	}
}

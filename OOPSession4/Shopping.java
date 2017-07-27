/**
 * class having control of shopping and taking user input and print bill
 */
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Shopping implements Promotion,Action {
	

	public static void main(String args[]) {
		 
			}

	
	
	@Override
	public double calculateDiscount(double Price, int quantity, double discount) {
		// TODO Auto-generated method stub
		discount = quantity * discount;
		return discount;
	}

	@Override
	public double calculatePercentageDiscount(double Price, int quantity,
			double percent) {
		// TODO Auto-generated method stub
		percent = (percent / 100) * Price * quantity;
		return percent;
	}

	/**
	 * 
	 * @param list
	 * @param result
	 * @return order level discount based on type of promotion applicable
	 */
	public double getOrderDiscount(List<OrderPromo> list, double result) {
		Iterator<OrderPromo> itr = list.iterator();
		double orderDisc = 0, pre = 0, orderPer = 0,threshold=0,value = 0;
		String str = "";
		while (itr.hasNext()) {
			OrderPromo temp = itr.next();
			if (temp.getPromotionType().equals("OrderFixedAmountPromotion")) {
				if (result > temp.getTheshold() && temp.getTheshold() >= pre) {
					orderDisc = temp.getDiscount();
					threshold = temp.getTheshold();
					value = temp.getDiscount();
					str = " Rs.";
					pre = temp.getTheshold();
				}
			} else if (result > temp.getTheshold()) {
				orderPer = (temp.getPercentage() / 100) * result;
				if (orderPer > orderDisc) {
					orderDisc = orderPer;
					threshold = temp.getTheshold();
					value = temp.getPercentage();
					str = " %";
				}
			}
		}
		System.out.println( value +str+ " off on orders above "+threshold);
		return orderDisc;
	}

	/**
	 * print bill for customer 
	 * @param orders
	 * @param promoProduct
	 * @param orderPromo
	 */
	public void printBill(List<OrderEntry> orders,List<ProductPromo> promoProduct,List<OrderPromo> orderPromo){
		double result = 0, disc = 0;
		double discount[] = new double[100];
		double price[] = new double[100];
		int index = 0, flag = 0;
		
		System.out.println("\n#############################################################");
		System.out.println(" YOUR ORDER ");
		System.out.println("#############################################################\n");
		System.out.println("PURCHASED PRODUCTS : ");

		for (OrderEntry obj2 : orders) {							
			for (ProductPromo obj1 : promoProduct) {
				int arr[] = obj1.getProductIDs();
				Arrays.sort(arr);
				if (Arrays.binarySearch(arr, obj2.getProductID()) >= 0) {			// search if the product has any promotion
					
					System.out.println("Product : "+ obj2.getProductID() + " - "+ obj2.getProductName());
					price[index] = obj2.getQuantity()* obj2.getProductPrize();
					System.out.println("Cost : Rs. " + price[index] + " ( " + obj2.getQuantity() + " * "+ obj2.getProductPrize() + " ) ");
					
					if (obj1.getPromotionType().equals("ProductFixedAmountPromotion")) {
						discount[index] = calculateDiscount(obj2.getProductPrize(), obj2.getQuantity(),obj1.getDiscount());
						System.out.println("Applied Promotion : "+ obj1.getPromotionType() + " with Rs. "+ obj1.getDiscount() + " off");
						System.out.println("Discount : " + discount[index]+ "\n");
						index++;
					} else {
						discount[index] = calculatePercentageDiscount(obj2.getProductPrize(), obj2.getQuantity(),obj1.getPercentage());
						System.out.println("Applied Promotion : "+ obj1.getPromotionType() + " with "+ obj1.getPercentage() + " % off");
						System.out.println("Discount : " + discount[index]+ "\n");
						index++;
					}
					flag = 1;
					break;
				}
			}
			if (flag != 1) {
				System.out.println("Product : " + obj2.getProductID()
						+ " - " + obj2.getProductName());
				price[index] = obj2.getQuantity() * obj2.getProductPrize();
				System.out.println("Cost : Rs. " + price[index] + " ( "+ obj2.getQuantity() + " * "+ obj2.getProductPrize() + " ) ");
				discount[index] = 0;
				System.out.println("Discount : " + discount[index] + "\n");
				index++;
			}
			flag = 0;
		}
		result = getTotal(price,index);
		disc = getTotal(discount,index); 
		System.out.println("Subtotal : " + result);					
		System.out.println("Product Level Discount : " + disc);
		double orderDisc = getOrderDiscount(orderPromo, result - disc);
		System.out.println("Order Level Discount : " + orderDisc);
		System.out.println("Total : " + (result - orderDisc - disc)+"\n");
	}
	
	public double getTotal(double[] array , int index){
		double result=0;
		for (int jindex = 0; jindex < index; jindex++) {
			result += array[jindex];
		}
		return result;
	}



	@Override
	public void performAction() {
		// TODO Auto-generated method stub
		FileHandling obj = new FileHandling();
		List<Products> products = obj.printProducts("C:/Users/User21/Desktop/ProductsList.txt");
		List<ProductPromo> promoProduct = obj.printPromos("C:/Users/User21/Desktop/ProductPromo.txt");
		List<OrderPromo> orderPromo = obj.printOrderPromos("C:/Users/User21/Desktop/OrderPromo.txt");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of products you want to buy : ");
		int numOfProducts = scan.nextInt();
		List<OrderEntry> orders = obj.getOrderEntry(numOfProducts,scan,products);
		printBill(orders, promoProduct,orderPromo);
	}
}

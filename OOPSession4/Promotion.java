/**
 * 
 * @author Shubham
 * an interface having promotion calculation as its methods
 */
public interface Promotion {
	// calculate discount
 public double calculateDiscount(double Price, int quantity, double discount);
 	// calculate percentage discount
 public double calculatePercentageDiscount(double Price, int quantity, double percent);
}

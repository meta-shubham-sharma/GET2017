import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

/**
 * 
 */

/**
 * @author Shubham
 *
 */
public class TestMenu {

	/**
	 * test product level discount
	 */
	@Test
	public void testDiscount() {
		Shopping obj = new Shopping();
		Double actual = obj.calculateDiscount(1600 , 3 , 100);
		Double expected = 300.0;
		assertEquals(expected,actual);
	}

	/**
	 * test product level percentage discount
	 */
	@Test
	public void testPercentageDiscount() {
		Shopping obj = new Shopping();
		Double actual = obj.calculatePercentageDiscount(1600 , 3 , 10);
		Double expected = 480.0;
		assertEquals(expected,actual);
	}
	
	/**
	 * test order level discount
	 */
	@Test
	public void testOrderDiscount() {
		Shopping obj = new Shopping();
		FileHandling file = new FileHandling();
		List<OrderPromo> orderPromo = file.printOrderPromos("C:/Users/User21/Desktop/OrderPromo.txt");
		Double actual = obj.getOrderDiscount(orderPromo,1600);
		Double expected = 160.0;
		assertEquals(expected,actual);
	}
}

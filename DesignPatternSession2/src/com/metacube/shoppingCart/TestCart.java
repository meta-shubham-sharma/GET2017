import static org.junit.Assert.*;

import org.junit.Test;

import com.metacube.shoppingCart.Constants;
import com.metacube.shoppingCart.Dao.FileHandling;
import com.metacube.shoppingCart.Facade.ProductFacade;
import com.metacube.shoppingCart.Facade.ShoppingCartFacade;


/**
 * @author User21
 *
 */
public class TestCart {
	/**
	 * test whether this product is present in database
	 */
	@Test
	public void testFromDatabase() {
		FileHandling.readProducts(Constants.PRODUCTLOC);
		ProductFacade pf = new ProductFacade();
		boolean actual = pf.checkProductCode("123");
		boolean expected = true;
		assertEquals(actual,expected);
	}
	
	/**
	 * test whether user has selected this product
	 */
	@Test
	public void testFromCart() {
		FileHandling.readProducts(Constants.PRODUCTLOC);
		ShoppingCartFacade sf = new ShoppingCartFacade();
		boolean actual = sf.checkProductCodeFromCart("123");
		boolean expected = false;
		assertEquals(actual,expected);
	}
}

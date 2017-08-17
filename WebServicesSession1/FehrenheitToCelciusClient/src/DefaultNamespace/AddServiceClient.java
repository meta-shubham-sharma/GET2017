package DefaultNamespace;

import java.util.Scanner;

/**
 * @author shubham
 *
 */
public class AddServiceClient {
	/**
	 * 
	 * @param args
	 */
	public static double convertTemperature(double input) {
		ConvertFehrToCelciusServiceLocator csl = new ConvertFehrToCelciusServiceLocator();
		csl.setConvertFehrToCelciusEndpointAddress("http://localhost:8080/FehrenheitToCelcius/services/ConvertFehrToCelcius");
		try {
			ConvertFehrToCelcius object = csl.getConvertFehrToCelcius();
			double output = object.convertTemperature(input);
			return output;
		} catch (Exception e) {
			return 0;
		}
	}
}

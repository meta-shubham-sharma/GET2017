import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author shubham
 *
 */
@WebService
public class ConvertFehrToCelcius {
	@WebMethod
	public double convertTemperature(double fehrenheit) {
		double celcius = (fehrenheit - 32) / 1.8;
		return Math.round(celcius);
	}
}

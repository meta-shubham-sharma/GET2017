import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * get and set threshold values
 * @author User21
 *
 */
public class OrderPromo extends ProductPromo{
	double threshold;
	/**
	 * get threshold value
	 * @return
	 */
	public double getTheshold(){
		return this.threshold;
	}
	/**
	 * set threshold value
	 * @param value
	 */
	public void setThreshold(double value){
		this.threshold = value;
	}
	@Override
	public void performAction() {
		// TODO Auto-generated method stub
		try{
			String str ="";
			FileInputStream fstream= new FileInputStream("C:/Users/User21/Desktop/OrderPromo.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
			while ((str = br.readLine()) != null) {
				System.out.println(str);
			}
			System.out.println();
			}catch(Exception e){
				
			}
	}
}

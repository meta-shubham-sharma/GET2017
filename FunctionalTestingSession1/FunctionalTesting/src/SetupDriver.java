import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
/**
 * class to setup driver
 * @author shubham
 *
 */
public class SetupDriver {
	public static void main(String[] args) {
		WebDriver driver = new InternetExplorerDriver();
		driver.get("http://automationpractice.com/");
		try {
			Thread.sleep(1000);
			driver.findElement(By.id("search_query_top")).click();
			driver.findElement(By.id("search_query_top")).sendKeys("Test");
			driver.findElement(By.name("submit_search")).click();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}

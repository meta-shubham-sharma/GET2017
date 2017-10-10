import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * class to perform automation script
 * @author shubham
 *
 */
public class AutomationScript {
	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		driver.get("http://automationpractice.com/");
		try {
			Thread.sleep(1000);
			System.out.println("test over");
			driver.findElement(By.linkText("Sign in")).click();
			driver.findElement(By.id("email")).sendKeys("abc@xyz.com");
			driver.findElement(By.id("passwd")).sendKeys("testing123");
			driver.findElement(By.id("SubmitLogin")).click();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}

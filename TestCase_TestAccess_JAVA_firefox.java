//Used for UI testing purpose
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class TC1 {

	public static void main(String[] args) {
    	
    	System.setProperty(Util.Web_Driver_FX,Util.FX_Web_Driver_Path);
    	WebDriver driver = new FirefoxDriver();
    	
    	driver.get(Util.BASE_URL+"V4/");
    	
    	driver.findElement(By.name("uid")).sendKeys(Util.USER_NAME);
    	driver.findElement(By.name("password")).sendKeys(Util.PASSWD);
    	driver.findElement(By.name("btnLogin")).click();
    	
    	String ActualTitle = driver.getTitle();
    	
    	    	
    	if (ActualTitle.contentEquals(Util.EXPECT_TITLE))
    	{
    		System.out.println("Test OK");
    		
    	} else
    	{
    		System.out.println("Test KO");
    	}
    	
       
    	driver.quit();
    }

}
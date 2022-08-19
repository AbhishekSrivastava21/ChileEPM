package Test_Cases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {
	
   WebDriver driver;
    
    @BeforeMethod 
    public void launchBrowser()
    {
     System.setProperty("webdriver.chrome.driver", "C:\\BrowserDriver\\chromedriver.exe");
	 driver=new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	 driver.manage().window().maximize();
    }
    @Test
    public void login() throws InterruptedException
    {
      driver.get("http://10.60.160.20:8081");
	  driver.findElement(By.cssSelector("[placeholder='Username']")).sendKeys("SJERRIPO");
	  driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("xemanti6");
      driver.findElement(By.xpath("//button[@type='submit']")).click();
      Thread.sleep(2000);
    }
   
    @AfterMethod
    public void logout()
    {
      List<WebElement>suggestion=driver.findElements(By.xpath("//button[text()='Logout']"));
      for(WebElement i:suggestion)
      {
    	  String sug1=i.getText();
    	  if(sug1.contains("Logout"))
    	    {
    		  i.click();
    	    }
    }
    }
    @AfterClass
    public void closeBrowser()
    {
      driver.quit();
    }
}


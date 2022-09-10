package Test_Cases;

import java.awt.AWTException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Kilometers 
{
WebDriver driver;
    
    @BeforeMethod 
    public void launchBrowser()
    {
      WebDriverManager.chromedriver().setup();
     
	 driver=new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
    } 
    
      @Test
  	  public void mileage() throws InterruptedException, AWTException 
      {
  		driver.get("http://10.60.160.20:8081");
  		driver.findElement(By.cssSelector("[placeholder='Username']")).sendKeys("SJERRIPO");
  		driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("xemanti6");
  		driver.findElement(By.xpath("//button[@type='submit']")).click();
  		driver.findElement(By.xpath("//*[@id=\"page-wrap\"]/div/div[1]/div[2]/div/ul/li[4]/a")).click();
  		Thread.sleep(5000);
		WebElement dropdown = driver.findElement(By.xpath("//span[text()='Agregar nueva']"));
		dropdown.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ant-drawer-wrapper-body']")));
		 
	   //Transportista
		driver.findElement(By.xpath("//div[text()='Seleccione transportista']")).click();
		driver.findElement(By.xpath("//li[text()='BU-890012  - BU-890012']")).click();
		Thread.sleep(4000);
		 
		 
	   //Conducido por fecha
		WebElement s=driver.findElement(By.xpath("//input[@placeholder='Seleccione la fecha de conducción']"));
		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("arguments[0].click();", s);
		driver.findElement(By.xpath("//div[@aria-selected='true']")).click();
		
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(40));
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[text()='seleccione la ciudad']")));
		 
		
	   //Ciudad
		WebElement m = driver.findElement(By.xpath("//div[text()='seleccione la ciudad']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", m);
        driver.findElement(By.xpath("//li[text()='Santiago']")).click();
        
		
	   //Inicio Kilómetros
		driver.findElement(By.xpath("//input[@type='number'][1]")).clear();
		driver.findElement(By.xpath("//input[@type='number'][1]")).sendKeys("60");
		Thread.sleep(1000);
		
		
	   //Kilómetros finales
		driver.findElement(By.xpath("//input[@placeholder='Introducir kilómetros finales']")).sendKeys("600");
		
		
	   //Aceptar	
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		  
		  
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
	    
      }	
}

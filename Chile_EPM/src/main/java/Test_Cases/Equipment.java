package Test_Cases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
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

public class Equipment 
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
  	public void createEquipment() throws InterruptedException, AWTException {
  		driver.get("http://10.60.160.20:8081");
  		driver.findElement(By.cssSelector("[placeholder='Username']")).sendKeys("SJERRIPO");
  		driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("xemanti6");
  		driver.findElement(By.xpath("//button[@type='submit']")).click();
  		
  		//Equipment +ADD NEW
  		driver.findElement(By.xpath("//*[@id=\"page-wrap\"]/div/div[1]/div[2]/div/ul/li[3]/a")).click();
  		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.xpath("//span[text()='Agregar nueva']"));
		dropdown.click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
		 wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ant-drawer-wrapper-body']")));
		
		//Identificación Activo
		driver.findElement(By.xpath("//input[@placeholder='Ingrese el Identificación Activo']")).sendKeys("100012");
		
		
		
		
		//Grupo de mantenimiento
		driver.findElement(By.xpath("//div[@title='BODEGA PANOL SAN FERNANDO']")).click();
		driver.findElement(By.xpath("//li[text()='Administracion']")).click();
		
		//Description Line 1
		driver.findElement(By.xpath("//textarea[@placeholder='Introduce la descripción'][1]")).sendKeys("Automation test");
		
		//Description Line 2
		driver.findElement
	       (By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/div/div[1]/form/div[3]/div/div[4]/div/div/div/span/div/div/textarea")).sendKeys("Automation test2");
		
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_PAGE_DOWN);
		r.keyRelease(KeyEvent.VK_PAGE_DOWN);
		Thread.sleep(1000);
		
		
		//Modelo/clase de peso
		WebElement m=driver.findElement(By.xpath("//div[text()='Seleccionar modelo/clase de peso']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", m);
		driver.findElement(By.xpath("//li[text()='30001 - 35000']")).click();
		
		//Estado del equipo
		driver.findElement(By.xpath("//div[text()='Seleccione el estado del equipo']")).click();
		driver.findElement(By.xpath("//li[text()='En Venta']")).click();
		
		//tipo de equipo
		driver.findElement(By.xpath("//div[text()='Seleccionar tipo de equipo']")).click();
		driver.findElement(By.xpath("//li[text()='Flota']")).click();
		
		//Fabricante
		driver.findElement(By.xpath("//div[text()='Seleccionar fabricante']")).click();
		driver.findElement(By.xpath("//li[text()='Automoviles']")).click();
		
		//Ubicación de la tienda
		driver.findElement(By.xpath("//div[text()='Seleccione la ubicación de la tienda']")).click();
		driver.findElement(By.xpath("//li[text()='Activo Paga Impuesto Territor.']")).click();
		
	       //Aceptar
	  	driver.findElement(By.xpath("//span[text()='Aceptar']")).click();
		
		
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

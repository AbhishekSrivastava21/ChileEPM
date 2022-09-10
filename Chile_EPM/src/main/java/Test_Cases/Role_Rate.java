package Test_Cases;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Role_Rate 
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
  	  public void roleRate() throws InterruptedException, AWTException 
      {
  		driver.get("http://10.60.160.20:8081");
  		driver.findElement(By.cssSelector("[placeholder='Username']")).sendKeys("SJERRIPO");
  		driver.findElement(By.cssSelector("[placeholder='Password']")).sendKeys("xemanti6");
  		driver.findElement(By.xpath("//button[@type='submit']")).click();
  		
  		driver.findElement(By.xpath("//*[@id=\"page-wrap\"]/div/div/div[2]/div/ul/li[5]/a")).click();
  		Thread.sleep(5000);
		WebElement dropdown = driver.findElement(By.xpath("//span[text()='Agregar nueva']"));
		dropdown.click();
		
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ant-drawer-wrapper-body']")));
		
		//Nombre de usuario JDE
		driver.findElement(By.cssSelector("[placeholder='Introduzca su nombre de usuario']")).sendKeys("AbhiTest");
		
		//Grupo de mantenimiento
		driver.findElement(By.xpath("//div[text()='BODEGA PANOL SAN FERNANDO']")).click();
		driver.findElement(By.xpath("//li[text()='Mantencion Frigorifico']")).click();
		
		//Nombre de la libreta de direcciones
		WebElement search=driver.findElement(By.xpath("//div[text()='Escriba 3 caracteres para buscar']"));
		Actions act=new Actions(driver);
		act.click(search).sendKeys("ABARZA MESINA JENARO").build().perform();
		
		WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(40));
		 wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[text()='ABARZA MESINA JENARO']")));
		driver.findElement(By.xpath("//li[text()='ABARZA MESINA JENARO']")).click();
		
	    //Papel
		driver.findElement(By.xpath("//div[text()='Seleccionar rol']")).click();
		driver.findElement(By.xpath("//li[text()='SUPERVISOR']")).click();
		
		
		//Calificar
		driver.findElement(By.cssSelector("[placeholder='Entrada en $']")).sendKeys("65");
		
		/*//Aceptar	
		driver.findElement(By.xpath("//button[@type='submit']")).click();*/
		
	
      }
      
}
package pack3;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ej_3
	{private WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(ITestContext context){
		try 
		{driver = new FirefoxDriver();} 
		catch (Exception e) {}
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestContext context){
		try 
		{driver.close();
		driver.quit();} 
		catch (Exception e) {}
	}

	@Test(description = "Exercise")
	public void exercise03() {
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.google.com");
		
		WebElement busqueda = driver.findElement(By.xpath("//input[@id='lst-ib']"));
		busqueda.sendKeys("busqueda de prueba");
		
		WebElement boton = driver.findElement(By.xpath("//button[@class='lsb']"));
		boton.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement resultado = driver.findElement(By.xpath("//*[@class='r']"));
		resultado.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Boolean elemento = driver.findElement(By.xpath("//*")) != null;
		
		Assert.assertTrue(elemento, "Página sin elementos.");
		
	}
}

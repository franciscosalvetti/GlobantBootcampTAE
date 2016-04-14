package pack2;
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

public class ej_2
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
	public void exercise02() {
		
		driver.get("http://www.hotmail.com");
		
		WebElement campo_email = driver.findElement(By.xpath("//input[@class='form-control ltr_override']"));		
		campo_email.sendKeys("nestor_ortigoza@hotmail.com");
		
		WebElement password = driver.findElement(By.xpath("//input[@class='form-control']"));		
		password.sendKeys("nestor20");
		
		WebElement boton = driver.findElement(By.xpath("//input[@class='btn btn-block btn-primary btn-image btn-image-svg']"));		
		boton.submit();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement correo = driver.findElement(By.xpath("//*[@id='_ariaId_25']"));
		correo.click();
		
		WebElement boton1 = driver.findElement(By.xpath("//button[@class='ms-border-color-neutralTertiary ms-border-color-black-hover _rp_37 o365button']"));
		boton1.click();
		
		WebElement remitente = driver.findElement(By.xpath("//span[@class='_pe_l _pe_K']"));
		//System.out.println(remitente.getText());
		
		String CorreoClave = "support@hotmail.com";
		
		Boolean Resultado = remitente.getText().contains(CorreoClave);
		
		Assert.assertTrue(Resultado, "El remitente de este correo no pertenece al soporte.");
		
	}	
}

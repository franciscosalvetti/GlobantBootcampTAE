package pack1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ej_1
{
private WebDriver driver;

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
	public void exercise01() {
		driver.get("http://www.labrujula24.com");
		
		WebElement noticia = driver.findElement(By.xpath("//div[@class='news-title-box']"));
		
		noticia.click();	
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='fb_ltr']")));
		
		WebElement comentarios = driver.findElement(By.xpath("//span[@class=' _50f7']"));				
		
		char num_comentario = comentarios.getText().charAt(0);
		
		if ((int)num_comentario > 0)
		{ 
			WebElement text_comentario = driver.findElement(By.xpath("//span[@class='_5mdd']"));
			System.out.println(text_comentario.getText());	

			String PalabraClave = "Noticia";
			String PalabraClave2 = "noticia";			
			
			Boolean Resultado;
			
			if (text_comentario.getText().contains(PalabraClave) & text_comentario.getText().contains(PalabraClave2))
			{Resultado = true;}
			else
			{Resultado = false;}
			
			Assert.assertTrue(Resultado, "El primer comentario no contiene la palabra 'Noticia'.");
		}
		else
		{System.out.println("La noticia no tiene comentarios");}
		
		driver.switchTo().defaultContent();
	}
}
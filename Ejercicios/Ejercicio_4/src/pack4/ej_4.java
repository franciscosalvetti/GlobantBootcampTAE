package pack4;
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

public class ej_4
	{private WebDriver driver;

	@BeforeMethod(alwaysRun = true)
	public void beforeMethod(ITestContext context){
		try 
		{driver = new FirefoxDriver();} 
		catch (Exception e) {}
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestContext context)
		{
		try 
		{driver.close();
		driver.quit();} 
		catch (Exception e) {}
	}

	@Test(description = "Exercise")
	public void exercise04() {
		
		driver.get("http://www.tn.com.ar");	

		WebElement noticia = driver.findElement(By.xpath("//article[@id='big-header']"));
		noticia.click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement comentarios = driver.findElement(By.xpath("//a[@class='comments']"));
		System.out.println(comentarios.getText());
		
		
		Assert.assertTrue(comentarios.getText()!="0", "La noticia tiene mas de un comentario.");
	}
}
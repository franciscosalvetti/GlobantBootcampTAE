package pack_proy_final;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class esperas {
	
	public static boolean Esperar_Por(WebDriver driver, By locator, int seconds) {
		if (seconds > 0){
			//System.out.println("Esperando por el elemento "+ locator +" durante " + seconds + " segundos.");
		} 
		else {
			//System.out.println("Chequeando si el elemento "+ locator +" está presente.");
		}
		try {
			seconds = (seconds == 0 ? 1 : seconds);
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
			driver.findElement(locator);
			return true;
		} 
		catch (NoSuchElementException e) {
			return false ;
		}
	}

}

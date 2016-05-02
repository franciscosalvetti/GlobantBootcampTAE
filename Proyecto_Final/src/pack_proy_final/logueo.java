package pack_proy_final;

import org.openqa.selenium.By;
import pack_proy_final.esperas;

public class logueo {	
	
	public void Loguearse(final String usuario, String contraseña) {			
		if (esperas.Esperar_Por(Inicial.driver, By.id("Email"), 5)){
			Inicial.driver.findElement(By.id("Email")).sendKeys(usuario);
		};
		
		
		if (esperas.Esperar_Por(Inicial.driver, By.id("next"), 5)){
			Inicial.driver.findElement(By.id("next")).click();
		};
		
		
		if (esperas.Esperar_Por(Inicial.driver, By.id("Passwd"), 5)){
			Inicial.driver.findElement(By.id("Passwd")).sendKeys(contraseña);
		};
		
		if (esperas.Esperar_Por(Inicial.driver, By.id("signIn"), 5)){
			Inicial.driver.findElement(By.id("signIn")).click();
		};
		
		try {Thread.sleep(1000);} 
		catch (InterruptedException e) 
		{e.printStackTrace();}
	};
};



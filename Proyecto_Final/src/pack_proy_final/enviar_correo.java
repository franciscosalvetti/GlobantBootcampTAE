package pack_proy_final;


import org.openqa.selenium.By;

import pack_proy_final.esperas;

public class enviar_correo {
	
	public void enviar_mail(final String destinatario, String asunto, String mensaje) {				
		
		if (esperas.Esperar_Por(Inicial.driver, By.xpath("//div[@class='z0']//div[@role='button']"), 5)){
			Inicial.driver.findElement(By.xpath("//div[@class='z0']//div[@role='button']")).click();
		};
				
		if (esperas.Esperar_Por(Inicial.driver, By.className("vO"), 5)){
			Inicial.driver.findElement(By.className("vO")).sendKeys(destinatario);
		};		
		
		if (esperas.Esperar_Por(Inicial.driver, By.className("aoT"), 5)){
			Inicial.driver.findElement(By.className("aoT")).sendKeys(asunto);
		};
		
		if (esperas.Esperar_Por(Inicial.driver, By.xpath("//div[@class='Ar Au']//div[@role='textbox']"), 5)){
			Inicial.driver.findElement(By.xpath("//div[@class='Ar Au']//div[@role='textbox']")).sendKeys(mensaje);
		};
		
		if (esperas.Esperar_Por(Inicial.driver, By.xpath("//div[@class='J-J5-Ji']//div[@role='button']"), 5)){
			Inicial.driver.findElement(By.xpath("//div[@class='J-J5-Ji']//div[@role='button']")).click();
		};
		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}

}

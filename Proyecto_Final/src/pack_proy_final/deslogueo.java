package pack_proy_final;

import org.openqa.selenium.By;

import pack_proy_final.esperas;

public class deslogueo {
	
	public void Desloguear(){
		if (esperas.Esperar_Por(Inicial.driver, By.xpath("//a[@class='gb_b gb_7a gb_R']"), 5)){
			Inicial.driver.findElement(By.xpath("//a[@class='gb_b gb_7a gb_R']")).click();
		};
				
		if(esperas.Esperar_Por(Inicial.driver, By.id("gb_71"), 5)){
			Inicial.driver.findElement(By.id("gb_71")).click();
		};				
	};
}

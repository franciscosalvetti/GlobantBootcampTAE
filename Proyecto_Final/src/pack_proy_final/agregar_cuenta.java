package pack_proy_final;

import org.openqa.selenium.By;

import pack_proy_final.esperas;

public class agregar_cuenta {
	
	public void Agregar_Cuenta(){
		if (esperas.Esperar_Por(Inicial.driver, By.id("account-chooser-link"), 3)){
			Inicial.driver.findElement(By.id("account-chooser-link")).click();
		};
				
		if (esperas.Esperar_Por(Inicial.driver, By.id("account-chooser-add-account"), 3)){
			Inicial.driver.findElement(By.id("account-chooser-add-account")).click();
		};			
	};   
};

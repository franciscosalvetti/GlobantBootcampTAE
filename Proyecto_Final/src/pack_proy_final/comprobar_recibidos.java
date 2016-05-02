package pack_proy_final;

import org.openqa.selenium.By;

public class comprobar_recibidos {
	
	public boolean comprobar_mails_recibidos(final String remitente, String mensaje1, String mensaje2, String mensaje3){
		
		Boolean Correo1 = false;
		Boolean Correo2 = false;
		Boolean Correo3 = false;
		
//-------------------------------------------------------------------------------------------------------------------------	
		try {Thread.sleep(1000);} 
		catch (InterruptedException e) 
		{e.printStackTrace();}
		
		Inicial.driver.findElement(By.id("gbqfq")).sendKeys("in:inbox "+remitente);
		Inicial.driver.findElement(By.id("gbqfb")).click();
		
		try {Thread.sleep(1000);} 
		catch (InterruptedException e) 
		{e.printStackTrace();}
		
		if (ciclo_recibidos.ciclo_rec(remitente, mensaje1)){
			Correo1= true;	
		}			
		
		if (ciclo_recibidos.ciclo_rec(remitente, mensaje2)){
			Correo2= true;
		}
		
		if (ciclo_recibidos.ciclo_rec(remitente, mensaje3)){
			Correo3= true;
		}
//-------------------------------------------------------------------------------------------------------------------------				
		if(Correo1 == true && Correo2 == true && Correo3 == true){
			return true;
		}
		else{
			return false;
		}				
	}
}

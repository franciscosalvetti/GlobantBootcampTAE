package pack_proy_final;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class ciclo_enviados {
	
	static Boolean Correo = false;
	static String msj;
	static String desti;
	static String Control1 = "(";
	static String Control2 = ")";
	static String Numero_Correos;
	
	public static Boolean ciclo_env(final String destinatario, String mensaje){
		
		WebElement Tabla = Inicial.driver.findElement(By.xpath("//div[@class='ae4 UI']"));		
		List<WebElement> Filas = Tabla.findElements(By.tagName("tr"));		
		
		for(WebElement Fila:Filas){
			Fila.click();
			List<WebElement> Celdas = Fila.findElements(By.tagName("td"));
			Numero_Correos = Celdas.get(3).getText();
			if((Numero_Correos.contains(Control1)) && (Numero_Correos.contains(Control2))){
				//mas de un correo en la conversacion
				WebElement Lista = Inicial.driver.findElement(By.xpath("//div[@class='nH aHU']"));							//tomo la clase que contiene la conversacion
				List<WebElement> Correos = Lista.findElements(By.xpath("//div[@role='listitem']"));							//tomo la lista de correos en la conversacion							
				WebElement ultCorreo = Correos.get(Correos.size()-1);														//acceder al ultimo
				ultCorreo.findElement(By.xpath("//div[@class='ajV']")).click();												//clickear en el boton para extender el correo
				msj = ultCorreo.findElement(By.xpath("//div[@class='a3s aXjCH adM']")).getText();							//rescato el mensaje del correo
				ultCorreo.findElement(By.className("ajy")).click();															//abro la ventana desplegable
				desti = ultCorreo.findElement(By.xpath("//tr[@class='ajv']/td[@class='gL']/span[@class='gI']")).getText();	//rescatar el remitente del correo
			}
			else{
				//solo un correo en la conversacion
				WebElement ultCorreo = Inicial.driver.findElement(By.xpath("//div[@class='h7  ie nH oy8Mbf']"));			//tomo el primero
				msj = ultCorreo.findElement(By.xpath("//div[@class='a3s aXjCH']")).getText();								//tomo el mensaje del correo
				ultCorreo.findElement(By.className("ajy")).click();															//abro la ventana desplegable
				desti = ultCorreo.findElement(By.xpath("//tr[@class='ajv']/td[@class='gL']/span[@class='gI']")).getText();  //tomo el destinatario
			}	
			
			//System.out.println(desti+"  "+destinatario+"            "+msj+"  "+mensaje);
						
			if ((desti.contains(destinatario)) && (mensaje.equals(msj))){
				Correo = true;
			}								
			
			Inicial.driver.navigate().back();
			
			try {Thread.sleep(1000);} 
			catch (InterruptedException e) 
			{e.printStackTrace();}
		}
		
		if (Correo == true){
			return true;		
		}
		else{
			return false;
		}	
	}
}

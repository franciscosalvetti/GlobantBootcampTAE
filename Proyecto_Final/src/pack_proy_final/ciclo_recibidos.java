package pack_proy_final;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ciclo_recibidos {
	
	static Boolean Correo = false;
	static String msj;
	static String remi;
	static String Control1 = "(";
	static String Control2 = ")";
	static String Numero_Correos;
	
	public static Boolean ciclo_rec(final String remitente, String mensaje){	
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		WebElement Tabla = Inicial.driver.findElement(By.xpath("//div[@class='ae4 UI UJ']"));	
		List<WebElement> Filas = Tabla.findElements(By.tagName("tr"));
		
		for(WebElement Fila:Filas){						
			Fila.click();			
			List<WebElement> Celdas = Fila.findElements(By.tagName("td"));
			Numero_Correos = Celdas.get(3).getText();
			System.out.println(Celdas.get(3).getText());
			if((Numero_Correos.contains(Control1)) && (Numero_Correos.contains(Control2))){
				//mas de un correo enviado en la conversacion
				WebElement Lista = Inicial.driver.findElement(By.xpath("//div[@class='nH aHU']"));							//tomo la clase que contiene la conversacion
				List<WebElement> Correos = Lista.findElements(By.xpath("//div[@role='listitem']"));							//tomo la lista de correos en la conversacion							
				WebElement ultCorreo = Correos.get(Correos.size()-1);														//acceder al ultimo
				ultCorreo.findElement(By.xpath("//div[@class='ajV']")).click();												//clickeo en el boton para extender el correo
				msj = ultCorreo.findElement(By.xpath("//div[@class='a3s aXjCH adM']")).getText();							//tomo el mensaje del correo
				remi = ultCorreo.findElement(By.xpath("//tr/td/h3[@class='iw']/span[@class='go']")).getText();	//tomo el destinatario del correo
				System.out.println("mas de 1 correo");
			}
			else{
				//solo un correo enviado en la conversacion
				WebElement ultCorreo = Inicial.driver.findElement(By.xpath("//div[@class='h7  ie nH oy8Mbf']"));			//tomo el primer correo
				msj = ultCorreo.findElement(By.xpath("//div[@class='a3s aXjCH']")).getText();								//tomo el mensaje del correo	
				remi = ultCorreo.findElement(By.xpath("//tr/td/h3[@class='iw']/span[@class='go']")).getText();  //tomo el destinatario
				System.out.println("solo 1 correo");
			}
			
			//System.out.println(remi+"  "+remitente+"            "+msj+"  "+mensaje);
				
			if((remi.contains(remitente)) && (mensaje.equals(msj))){
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

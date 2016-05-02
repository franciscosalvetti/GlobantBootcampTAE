package pack_proy_final;

public class comprobar_correos {
	
	public Boolean comprobar_mails(final String destinatario, String mensaje1, String mensaje2, String mensaje3){
		
		Boolean Correo1 = false;
		Boolean Correo2 = false;
		Boolean Correo3 = false;
		
//-------------------------------------------------------------------------------------------------------------------------					
		if (ciclo_enviados.ciclo_env(destinatario, mensaje1)){
			Correo1= true;	
		}		
		
		if (ciclo_enviados.ciclo_env(destinatario, mensaje2)){
			Correo2= true;
		}
			
		
		if (ciclo_enviados.ciclo_env(destinatario, mensaje3)){
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
		
		
		
		/*String msj1;
		String msj2;
		String msj3;
		String desti;
		String Control1 = "(";
		String Control2 = ")";
		String Numero_Correos;
		
						
//-------------------------------------------------------------------------------------------------------------		
		for(WebElement Fila:Filas){						
			Fila.click();			
			List<WebElement> Celdas = Fila.findElements(By.tagName("td"));
			Numero_Correos = Celdas.get(3).getText();
			if((Numero_Correos.contains(Control1)) && (Numero_Correos.contains(Control2))){
				//mas de un correo enviado en la conversacion
				WebElement Lista = Inicial.driver.findElement(By.xpath("//div[@class='nH aHU']"));							//tomo la clase que contiene la conversacion
				List<WebElement> Correos = Lista.findElements(By.xpath("//div[@role='listitem']"));							//tomo la lista de correos en la conversacion							
				WebElement ultCorreo = Correos.get(Correos.size()-1);														//acceder al ultimo
				ultCorreo.findElement(By.xpath("//div[@class='ajV']")).click();												//clickeo en el boton para extender el correo
				msj2 = ultCorreo.findElement(By.xpath("//div[@class='a3s aXjCH adM']")).getText();							//tomo el mensaje del correo
				ultCorreo.findElement(By.className("ajy")).click();															//abro ventana desplegable
				desti = ultCorreo.findElement(By.xpath("//tr[@class='ajv']/td[@class='gL']/span[@class='gI']")).getText();	//tomo el destinatario del correo
			}
			else{
				//solo un correo enviado en la conversacion
				WebElement ultCorreo = Inicial.driver.findElement(By.xpath("//div[@class='h7  ie nH oy8Mbf']"));			//tomo el primer correo
				msj2 = ultCorreo.findElement(By.xpath("//div[@class='a3s aXjCH']")).getText();								//tomo el mensaje del correo
				ultCorreo.findElement(By.className("ajy")).click();															//abro la ventana deplegable	
				desti = ultCorreo.findElement(By.xpath("//tr[@class='ajv']/td[@class='gL']/span[@class='gI']")).getText();  //tomo el destinatario
			}
			
			//System.out.println(desti+"  "+destinatario+"            "+msj2+"  "+mensaje2);
				
			if((desti.contains(destinatario)) && (mensaje2.equals(msj2))){
				Correo2 = true;
			}			
			
			Inicial.driver.navigate().back();
			
			try {Thread.sleep(1000);} 
			catch (InterruptedException e) 
			{e.printStackTrace();}			
		}
//-------------------------------------------------------------------------------------------------------------		
		for(WebElement Fila:Filas){						
			Fila.click();			
			List<WebElement> Celdas = Fila.findElements(By.tagName("td"));
			Numero_Correos = Celdas.get(3).getText();
			if((Numero_Correos.contains(Control1)) && (Numero_Correos.contains(Control2))){
				//mas de un correo enviado en la conversacion
				WebElement Lista = Inicial.driver.findElement(By.xpath("//div[@class='nH aHU']"));							//tomo la clase que contiene la conversacion
				List<WebElement> Correos = Lista.findElements(By.xpath("//div[@role='listitem']"));							//tomo la lista de correos en la conversacion							
				WebElement ultCorreo = Correos.get(Correos.size()-1);														//acceder al ultimo
				ultCorreo.findElement(By.xpath("//div[@class='ajV']")).click();												//clickeo en el boton para extender el correo
				msj3 = ultCorreo.findElement(By.xpath("//div[@class='a3s aXjCH adM']")).getText();							//tomo el mensaje del correo
				ultCorreo.findElement(By.className("ajy")).click();															//abro ventana desplegable
				desti = ultCorreo.findElement(By.xpath("//tr[@class='ajv']/td[@class='gL']/span[@class='gI']")).getText();	//tomo el destinatario del correo
			}
			else{
				//solo un correo enviado en la conversacion
				WebElement ultCorreo = Inicial.driver.findElement(By.xpath("//div[@class='h7  ie nH oy8Mbf']"));			//tomo el primer correo
				msj3 = ultCorreo.findElement(By.xpath("//div[@class='a3s aXjCH']")).getText();								//tomo el mensaje del correo
				ultCorreo.findElement(By.className("ajy")).click();															//abro la ventana deplegable	
				desti = ultCorreo.findElement(By.xpath("//tr[@class='ajv']/td[@class='gL']/span[@class='gI']")).getText();  //tomo el destinatario
			}
			
			//System.out.println(desti+"  "+destinatario+"            "+msj3+"  "+mensaje3);
				
			if((desti.contains(destinatario)) && (mensaje3.equals(msj3))){
				Correo3 = true;
			}			
			
			Inicial.driver.navigate().back();
			
			try {Thread.sleep(1000);} 
			catch (InterruptedException e) 
			{e.printStackTrace();}			
		}
//-------------------------------------------------------------------------------------------------------------		
		if(Correo1 == true && Correo2 == true && Correo3 == true){
			return true; 
		}
		else{
			return false;
		}				
	}

}
*/
package pack_proy_final;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pack_proy_final.esperas;

public class Inicial {	
	static WebDriver driver = new FirefoxDriver();	
	static logueo logueo1;
	static deslogueo deslogueo1;
	static enviar_correo enviar_correo1;
	static comprobar_correos comprobar_correos1;
	static agregar_cuenta agregar_cuenta1;
	static comprobar_recibidos comprobar_recibidos1;	
//---------------Data Providers-------------------------------		
	@DataProvider(name = "Logueo")
	   public static Object[][] Logueo() {
		return new Object[][] {{"franciscosalvetti10@gmail.com", "esmeralda24"}};}
	@DataProvider(name = "Envio")
	   public static Object[][] Envio() {
		return new Object[][] {{"franciscosalvetti6@gmail.com" , "primer asunto" , "este es el primer mensaje"}, 
			  				     {"franciscosalvetti6@gmail.com" , "segundo asunto" , "este es el segundo mensaje"},
			  				     {"franciscosalvetti6@gmail.com" , "tercer asunto" , "este es el tercer mensaje"}};}
	@DataProvider(name = "Comprobar")
	   public static Object[][] Comprobar(){
		 return new Object [][] {{"franciscosalvetti6@gmail.com" , "este es el primer mensaje" , "este es el segundo mensaje" , "este es el tercer mensaje"}};}	
	@DataProvider(name = "Logueo2")
	   public static Object[][] Logueo2() {
	     return new Object[][] {{"franciscosalvetti6@gmail.com" , "esmeralda24"}};}
	@DataProvider(name = "ComprobarRecibidos")
	   public static Object[][] ComprobarRecibidos(){
		 return new Object[][] {{"franciscosalvetti10@gmail.com" , "este es el primer mensaje" , "este es el segundo mensaje" , "este es el tercer mensaje"}};}
//---------------Data Providers-------------------------------	
	 @BeforeMethod(alwaysRun = true)
	   public void beforeMethod() {
		 driver.manage().window().maximize();
	     logueo1 = new logueo();
	     deslogueo1 = new deslogueo();
	     enviar_correo1 = new enviar_correo();
	     comprobar_correos1 = new comprobar_correos();
	     agregar_cuenta1 = new agregar_cuenta();
	     comprobar_recibidos1 = new comprobar_recibidos();
	   }	 
//----------Logueo 1-------------------------------------------------		 	   	   
	   @Test(priority = 1, dataProvider = "Logueo")
	   public void logueo1(String usuario, String contraseña) {
		   //acceso a gmail.com
		   driver.get("http://www.gmail.com");
		   //logueo primera cuenta
		   logueo1.Loguearse(usuario, contraseña);			  
	   }	   
//-----------Envios-----------------------------------------------		   	   	   
	   @Test(dependsOnMethods= {"logueo1"},priority = 2, dataProvider = "Envio")
	   public void enviar_correo1(String destinatario, String asunto, String mensaje) {
		   //enviar mail 
		   enviar_correo1.enviar_mail(destinatario, asunto, mensaje);	
		   try {Thread.sleep(1000);} 
		   catch (InterruptedException e) 
		   {e.printStackTrace();
		}
	   }
//----------Comprobacion------------------------------------------------		   	   	   	   	  
	   @Test(dependsOnMethods={"enviar_correo1"}, priority = 3, dataProvider = "Comprobar")
	   public void comprobar_correos1(String destinatario, String mensaje1, String mensaje2, String mensaje3){
	   //---------------------Filtrar mails ------------------------------------------
		   if (esperas.Esperar_Por(driver, By.xpath("//div[@class='aim']"), 3)){
			   List<WebElement> BotonesLaterales = driver.findElements(By.xpath("//div[@class='aim']")); 
			   BotonesLaterales.get(1).click();
			   Assert.assertTrue(comprobar_correos1.comprobar_mails(destinatario, mensaje1, mensaje2, mensaje3), "Falló la comprobación de mensajes enviados.");
		   };		   		   	   				   		   		  		   		   
	   } 
//---------Deslogueo--------------------------------------------------	   	   	   	   
	   @Test(dependsOnMethods={"comprobar_correos1"}, priority = 4)
	   public void deslog() {
		   //deslog primera cuenta
		   deslogueo1.Desloguear();		   
	   }
//---------Logueo 2--------------------------------------------------	   
	   @Test(dependsOnMethods={"deslog"}, priority = 5, dataProvider = "Logueo2")
	   public void logueo2(String usuario2, String contraseña2){		   
		   //agregar la cuenta para loguear
		   agregar_cuenta1.Agregar_Cuenta(); 
		   //uso logueo1 para loguear la segunda cuenta
		   logueo1.Loguearse(usuario2, contraseña2);		  		   
	   }	   
//-------------Comprobar 2----------------------------------------------	   
	   @Test(dependsOnMethods={"logueo2"}, priority = 6, dataProvider = "ComprobarRecibidos")
	   public void ComprobarRecibidos(String remitente, String mensaje1, String mensaje2, String mensaje3) {		 		   		  
		   Assert.assertTrue(comprobar_recibidos1.comprobar_mails_recibidos(remitente, mensaje1, mensaje2, mensaje3), "Falló la comprobación de mensajes recibidos.");
	   } 		     		   	   
//----------------------------------------------------------------------

}
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;


import static org.testng.AssertJUnit.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;




public class DataprovideTest {
	WebDriver driver;
	By alojamienteolocator = By.xpath("//a[@href=\"//www.despegar.com.ar/hoteles/\"]");
	By destinolocator = By.cssSelector(".ac-container .item-text");
	By igresoCiudadlocator = By.cssSelector(".sbox5-box-places-ovr input");
	//calendario
	By calendarioEntraLocator = By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid'][@data-month='2022-02']//div[@class='sbox5-monthgrid-datenumber-number'][text()='28']");
	By entradaLocator  = By.xpath("//div[@class=\"sbox5-box-dates-checkbox-container\"]//div[@class=\"sbox5-dates-input1\"]");
	By SalidaLocator = By.xpath("//div[@class=\"sbox5-box-dates-checkbox-container\"]//div[@class=\"sbox5-dates-input2-container\"]");
	By calendarioSalidaLocator = By.xpath("//div[@class='sbox5-floating-tooltip sbox5-floating-tooltip-opened']//div[@class='sbox5-monthgrid'][@data-month='2022-03']//div[@class='sbox5-monthgrid-datenumber-number'][text()='9']");
	By aplicarLocator = By.cssSelector(".sbox5-floating-tooltip-opened .calendar-footer .btn-text");
	//Habitacion
	By adultoslocator = By.cssSelector(".stepper__room .stepper__room__row:nth-child(1) .steppers-icon-right");
	By habitacionlocator = By.cssSelector("div.sbox5-3-double-input");
	By menorlocator = By.cssSelector(".stepper__room .stepper__room__row:nth-child(2) .steppers-icon-right");
	
	By seleccionarEdad = By.cssSelector(".select-option[value='5']");
	By aplicarHabitacion = By.cssSelector("div.sbox5-floating-tooltip-opened div.stepper__room__footer>a:nth-child(1)");
	
	By buscarlocator = By.cssSelector("div.sbox5-box-container div.sbox5-box-content button.sbox5-box-button-ovr.sbox5-3-btn.-secondary.-icon.-lg > em.btn-text");
	By resultado = By.cssSelector(".results-cluster-container:nth-child(1) .btn-text");
	By precio = By.cssSelector("div.results-cluster-container:nth-child(1) div.price-info-wrapper.-eva-3-mt-xsm:nth-child(2) > span.main-value");
	
  
	
	
  @Test(dataProvider = "ciudades")
  public void alojamiento( String ciudades) throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\mat_4\\Desktop\\drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://www.despegar.com.ar/");
	    driver.manage().deleteAllCookies();
	      driver.findElement(alojamienteolocator).isDisplayed();
		  
		  
		  driver.findElement(alojamienteolocator).click();
		  Thread.sleep(2000);
		  driver.findElement(igresoCiudadlocator).click();		  
		  Thread.sleep(2000);
		  driver.findElement(igresoCiudadlocator).clear();
		  Thread.sleep(2000);
		 // WebDriverWait wait = new WebDriverWait(driver,10);
		  //wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(igresoCiudadlocator));
		  driver.findElement(igresoCiudadlocator).sendKeys(ciudades);
		  Thread.sleep(3000);
		  driver.findElement(igresoCiudadlocator).sendKeys(Keys.CONTROL);
		  Thread.sleep(2000);
		  driver.findElement(destinolocator).click();
		  Thread.sleep(2000);
		  driver.findElement(entradaLocator).click();
		  Thread.sleep(1000);
		  driver.findElement(calendarioEntraLocator).click();		  
		  driver.findElement(SalidaLocator).click();
		  Thread.sleep(2000);
		 driver.findElement(calendarioSalidaLocator).click();
		 driver.findElement(aplicarLocator).click();
		 Thread.sleep(1000);
		 driver.findElement(habitacionlocator).click();
		 
		 
		 Thread.sleep(2000);
		 driver.findElement(adultoslocator).click();
		 
		 
		 Thread.sleep(2000);
		 driver.findElement(menorlocator).click();
		 Thread.sleep(2000);
		 driver.findElement(seleccionarEdad).click();
		 Thread.sleep(2000);
		 driver.findElement(aplicarHabitacion).click();
		 Thread.sleep(3000);
		 driver.findElement(buscarlocator).click();
		 Thread.sleep(3000);		 				 		 		 
		 driver.findElement(seleccionarEdad).click();
		 Thread.sleep(2000);		 		 		 
		 assertTrue(driver.findElement(resultado).isDisplayed());
		 Thread.sleep(3000);				 
		 
		// System.out.println("EL PRECIO ES  $"+ driver.findElement(precio).getText());
		 
		 driver.close();
		 
	  }
  

  @DataProvider(name = "ciudades")
  public Object[][] getData() {
    return new Object[][] {{" San Rafael, Mendoza, Argentina"}, {" Rio de Janeiro, Rio de Janeiro, Brasil"}, {" Mar del Plata, Buenos Aires, Argentina"}};
    
  }
  


}

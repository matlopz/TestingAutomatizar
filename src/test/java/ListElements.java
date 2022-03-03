import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.Test;

public class ListElements {
	private WebDriver driver;
	
  @Test
  public void Lista() throws InterruptedException{
	  boolean verificar= false;
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\mat_4\\Desktop\\drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.get("https://www.despegar.com.ar/");
	    List<WebElement> listaDespegar = driver.findElements(By.cssSelector(".header-product-item"));
	    for (WebElement Element : listaDespegar) {
	    	verificar= Element.isSelected();
	    	if (!verificar) {
	    		
	    		Element.isDisplayed();
	    		
	    		Thread.sleep(3000);
	    		}
	    	
	    	
	    	
	    	System.out.println(Element.getText());
			
		}
	  
  }
}

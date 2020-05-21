package pruebas;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


public class Laboratorio3_E1 {
	WebDriver driver;
	@BeforeSuite
	public void setUp() {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "../EducacionIt/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	@BeforeTest
	public void irUrl () {
		driver.get("https://www.facebook.com/");	
	}
	@BeforeClass
	public void maxWindow() {
		driver.manage().window().maximize();
		
	}
  @Test (description="Registro invalido de usuario ")
	public void registroUsuario() {
	 
	        WebDriverWait myWaitVar = new WebDriverWait(driver, 15);
	        WebElement txtNombre = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("firstname")));
	        txtNombre.sendKeys("Nadia");
	        WebElement txtApellido = myWaitVar.until(
	                ExpectedConditions.elementToBeClickable(By.xpath("(//input[contains(@class,'inputtext _58mg')])[2]")));
	        txtApellido.sendKeys("Orihuela");
	        WebElement txtCel = myWaitVar
	                .until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[name='reg_email__']")));
	        txtCel.sendKeys("13123");
	        WebElement txtCont = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("reg_passwd__")));
	        txtCont.sendKeys("13123");
	

	        Select mes = new Select(myWaitVar.until(ExpectedConditions.elementToBeClickable(By.id("month"))));
	        mes.selectByVisibleText("mar");
	        Select dia = new Select(myWaitVar.until(ExpectedConditions.elementToBeClickable(By.id("day"))));
	        dia.selectByIndex(0);
	        WebElement btnClic = myWaitVar.until(ExpectedConditions.elementToBeClickable(By.name("websubmit")));
	        btnClic.click();
	        
	        Assert.assertEquals(driver.getCurrentUrl(), "https://www.facebook.com/");

	}

	@AfterClass
	public void finPrueba() {
		System.out.println("Fin de prueba");
	}

	@AfterTest
	public void cierre() {
		driver.quit();
	}

	@AfterSuite
	public void finSuite() {
		System.out.println("Fin Suite");
	}
//http://automationpractice.com/index.php
}

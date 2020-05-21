package pruebas;
import org.testng.annotations.Test;
import org.testng.Assert;
import paginas.paginaInicio;
import paginas.paginaLogin;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.AfterSuite;

public class Laboratorio3_E2 {
  WebDriver driver;
  String url = "http://automationpractice.com/index.php";
  String pathDriver = "../EducacionIt/Drivers/chromedriver.exe";
 
  @BeforeTest
  public void setUp () {
	  System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
	  System.setProperty("webdriver.chrome.driver", pathDriver);
		driver = new ChromeDriver();
		driver.get(url);
  }
	@Test (priority=0)
  public void f() {

	  
	  paginaInicio objInicio=new paginaInicio(driver); 
	  String titulo = objInicio.getLoginText();
	  System.out.println(titulo);  
	  objInicio.clicLogin();
	  
	  Assert.assertEquals(titulo, "Sign in");

	  
	  
  }
	@Test (priority=1)
	public void ingreso () throws IOException {
		
		paginaLogin login = new paginaLogin (driver);
		login.loginUsuario("dasda", "377468");
		
		File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen,new File("..\\EducacionIt\\Evidencias\\Test.png"));

	}
}

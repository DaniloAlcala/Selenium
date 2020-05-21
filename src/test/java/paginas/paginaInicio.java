package paginas;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class paginaInicio {
	WebDriver driver;

	@FindBy(xpath = "//a[@class='login']")
	WebElement btnLoggin;
	@FindBy(xpath = "/html/head/title")
	WebElement title;

	public paginaInicio(WebDriver driver) {
		this.driver = driver;
		// Inicializa los elementos con una espera implicita
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
	}

	public void clicLogin() {
		btnLoggin.click();

	}

	public String getLoginText() {
		
		return btnLoggin.getText();
	  }
	
	
	}


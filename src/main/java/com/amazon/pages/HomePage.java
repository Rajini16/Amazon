package com.amazon.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	 WebDriverWait wait;
	
	@FindBy(id = "twotabsearchtextbox")
	WebElement productNavSearchBox;
	
	@FindBy(css = "input#nav-search-submit-button")
	WebElement searchSubmit;
	
	public HomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(100));
        PageFactory.initElements(driver, this);
    }
   
    public void enterSearchText(String searchText) {
        productNavSearchBox.sendKeys(searchText);
    }
    
    public void clickSearchButton() {
    	searchSubmit.click();
    }
    
    public void waitForSearchBoxClickable() {
    	
        wait.until(ExpectedConditions.elementToBeClickable(productNavSearchBox));    	
    }
    	
}

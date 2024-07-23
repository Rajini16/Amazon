package com.amazon.utils;

import org.openqa.selenium.WebDriver;

import com.amazon.pages.HomePage;
import com.amazon.pages.SearchResultPage;

public class TestContext {
	private static TestContext instance;
	private WebDriver driver;
    private DriverFactory driverFactory;
    private HomePage homePage;
    private SearchResultPage searchResultPage;   
    private ConfigReader configReader;
    private Utility utility;
    
    public TestContext() throws InterruptedException {
    	System.out.println("At TestContext COnstructor:\n");
    	configReader = ConfigReader.getInstance();
    	driverFactory = DriverFactory.getInstance();
    }
    
//    public void initializePageObjectsAndUtilities() throws InterruptedException {
////    	 String url = configReader.getUrl();
////         if (configReader.isUrlReachable(url)) {
////        	 
////         } else {
////             throw new RuntimeException("Invalid URL or URL is not reachable: " + url);
////         }
//        homePage = new HomePage(driver);
//        searchResultPage = new SearchResultPage(driver);
//        utility = new Utility(driver);
//    }
    
  
    public static synchronized TestContext getInstance() throws InterruptedException {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }
    
    public WebDriver getDriver() throws InterruptedException {
        if (driver == null) {
            // Initialize WebDriver if not already initialized
            driver = driverFactory.initDriver(configReader.getBrowser());
            System.out.println("******TestContext.getDriver inside If loop Method****");
            System.out.println("**********TestContext Driver object:\n "+ driver+"\n*****************************" );
                    }
        System.out.println("******TestContext.getDriver outside If loop Method****");
        System.out.println("**********TestContext Driver object:\n "+ driver+"\n*****************************" );
        
        return driver;
    }
    
    public void quitDriver() {
          driverFactory.quitDriver(driver);
          driver = null;
    }
    
    public String getUrl() {
        return configReader.getUrl();
    }
    
    public DriverFactory getDriverFactory() {
        return driverFactory;
    }

    
    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public SearchResultPage getSearchResultPage() {
        if (searchResultPage == null) {
            searchResultPage = new SearchResultPage(driver);
        }
        return searchResultPage;
    }

    public Utility getUtility() throws InterruptedException {
        if (utility == null) {
            utility = new Utility(driver);
        }
        return utility;
    }


}

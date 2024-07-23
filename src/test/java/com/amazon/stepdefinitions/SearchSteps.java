package com.amazon.stepdefinitions;

import org.testng.Assert;

import com.amazon.utils.TestContext;
import io.cucumber.java.en.*;

public class SearchSteps {
    private TestContext testContext;

    public SearchSteps() throws InterruptedException {
    	testContext = TestContext.getInstance();
        System.out.println("AT Searchstep definition file constructor:");
    }

    @Given("I open the Amazon homepage")
    public void i_open_the_amazon_homepage() throws InterruptedException {
  
    	testContext.getDriver().get(testContext.getUrl());
    	System.out.println("At Given url from config file: " + testContext.getUrl());
    	 try {
             // Validate the URL
    		 testContext.getUtility().validateUrl();
         } catch (RuntimeException e) {
//        	 testContext.quitDriver();  // Quit the browser if URL validation fails
             throw e;  // Rethrow the exception to stop the test execution
         }        
    }

    @When("^I enter (.*) in the search box$")
    public void i_enter_in_the_search_box(String productName) {

    	   testContext.getHomePage().waitForSearchBoxClickable();
    	   testContext.getHomePage().enterSearchText(productName);
           
    }
    
    @When("I click on the search button")
    public void i_click_on_the_search_button() {

    	testContext.getHomePage().clickSearchButton();
    }

    @Then("^I should see search results for product (.*)$")
    public void i_should_see_search_results_for_product (String productName) throws InterruptedException {

       	boolean isTextPresent = testContext.getSearchResultPage().isProductTextPresentOnInfoBar(productName);
    	Assert.assertTrue(isTextPresent, "Product text is not present on info bar.");
    	Assert.assertTrue(testContext.getSearchResultPage().getSearchResults().size() > 0);
    }

    @Then("I apply the following filters:")
    public void i_apply_the_following_filters(io.cucumber.datatable.DataTable dataTable) {
        // Implementation for applying filters based on data table

    }
}

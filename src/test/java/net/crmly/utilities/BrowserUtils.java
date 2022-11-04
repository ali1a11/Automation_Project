package net.crmly.utilities;

/*
In this class only general utility methods that are not related to some specific page
 */

// check EU9-CucumberJunit
// BrowserUtils for more utility functions !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BrowserUtils {

    // This method will accept int (in seconds) and execute Thread sleep
    // for given duration
    public static void sleep(int second) {
        second *= 1000;
        try {
            Thread.sleep(second);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // This method accepts 3 arguments
    // Arg1: webdriver
    // Arg2: expectedInUrl: for verify if the url contains given String
    //        - If condition matches, will break loop
    // Arg3: expectedTitle to be compared against actualTitle
    public static void switchWindowAndVerify(String expectedInUrl, String expectedTitle) {
        Set<String> allWindowsHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowsHandles) {
            Driver.getDriver().switchTo().window(each);

            System.out.println("driver.getCurrentUrl() = " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }

        //5. Assert: Title contains expectedTitle
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    // This method accepts a String "expectedTitle" and Asserts if it is true
    public static void verifyTitle(String expectedTitle) {

        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }

    // Creating an utility method for ExplicitWait so we don't have to repeat the lines
    public static void waitForInvisibilityOf(WebElement webElement){
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); //to solve implicitlywait explicitlywait problem !!!
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.invisibilityOf(webElement));
    }

    /**
     * This method will verify if the current URL contains expected value
     * @param expectedInURL /** + Enter
     */
    public static void verifyURLContains(String expectedInURL){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));

    }

    /**
     * This method will accept a dropdown as a WebElement
     * and return all the options' text in a List of String
     * @param dropdownElement
     * @return List<String>
     */
    public static List<String> dropdownOptionsAsString(WebElement dropdownElement){

        Select select = new Select(dropdownElement);
        List<WebElement> actualOptionsAsWebElement = select.getOptions();

        List<String> actualOptionsAsString = new ArrayList<>();

        for (WebElement webElement : actualOptionsAsWebElement) {
            actualOptionsAsString.add(webElement.getText());
        }
        return actualOptionsAsString;
    }

    /**
     * This method accepts a group of radio buttons as a List of WebElement
     * It will loop through the list, and click to the radio button with provided attributeValue
     * @param radioButtons
     * @param attributeValue
     */
    public static void clickRadioButton (List<WebElement> radioButtons, String attributeValue){

        for (WebElement each : radioButtons) {
            if(each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }
        }
    }

    public static boolean assertWebElementNotPresent(WebElement webElement) throws Exception{

        try {
            Driver.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            //webElement.getText();
            webElement.isDisplayed();
            return false;
        } catch (Exception ignored) {
            return true;
        }
    }


}




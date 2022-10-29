package net.crmly.step_definitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.crmly.pages.ActivityStreamPage;
import net.crmly.pages.LoginPage;
import net.crmly.utilities.BrowserUtils;
import net.crmly.utilities.ConfigurationReader;
import net.crmly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StepDefinitions {

    LoginPage loginPage = new LoginPage();
    ActivityStreamPage activityStreamPage = new ActivityStreamPage();

//    @Given("the user is on the main page of Activity Stream.")
//    public void the_user_is_on_the_main_page_of_activity_stream() {
//        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
//        loginPage.login();
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
//        wait.until(ExpectedConditions.visibilityOf(activityStreamPage.userName));
//    }

    @Given("the user is on the main page of Activity Stream as a {string}")
    public void the_user_is_on_the_main_page_of_activity_stream_as_a(String loginType) {
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));

        loginPage.loginAs(loginType);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(activityStreamPage.userName));

    }

    String randomMessage = "";

    @When("the user types into MESSAGE text inputbox")
    public void the_user_types_into_message_text_inputbox() {
        activityStreamPage.messageButton.click();

        Driver.getDriver().switchTo().frame(activityStreamPage.messageInputFrame);

        Faker faker = new Faker();
        randomMessage = faker.chuckNorris().fact();

//        activityStreamPage.messageInbutbox.sendKeys(ConfigurationReader.getProperty("testText"));
        activityStreamPage.messageInbutbox.sendKeys(randomMessage);


        Driver.getDriver().switchTo().parentFrame();
    }

    @When("the user attach the link to the text")
    public void the_user_attach_the_link_to_the_text() {
        activityStreamPage.linkButton.click();
        activityStreamPage.linkTextinputbox.sendKeys(ConfigurationReader.getProperty("testText"));
        activityStreamPage.linkURLinputbox.sendKeys(ConfigurationReader.getProperty("testURL"));
        activityStreamPage.saveButton.click();
    }

    @When("the user clicks SEND button")
    public void the_user_clicks_send_button() {
        activityStreamPage.sendButton.click();
    }


    @Then("the user see the message with linked text on Activity Stream")
    public void the_user_see_the_message_with_linked_text_on_activity_stream() {

//        Driver.getDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
//        wait.until(ExpectedConditions.visibilityOf(activityStreamPage.sentMessageTextWithLink));


        String actualLink = "";
        for (int i = 0; i < 2; i++) {
            try{
                actualLink = activityStreamPage.sentMessageTextWithLink.getAttribute("href");
                break;
            }
            catch(StaleElementReferenceException exp){
                System.out.println(exp.getMessage());
            }
        }


//        String actualLink = activityStreamPage.sentMessageTextWithLink.getAttribute("href");

        String expectedLink = ConfigurationReader.getProperty("testURL");



        Assert.assertEquals(actualLink, expectedLink);

    }

    //video
    @When("the user inserts Vimeo video into the message")
    public void the_user_inserts_vimeo_video_into_the_message() {
        activityStreamPage.insertVideoButton.click();
        activityStreamPage.videoSourceInputbox.sendKeys(ConfigurationReader.getProperty("testVimeoVideoURL"));

//        activityStreamPage.table.click();

//        Thread.sleep(3000);

//        Select select = new Select(activityStreamPage.selectVideoSize);
//        select.selectByValue("560x315");

//        Thread.sleep(15000);

//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
//        wait.until(ExpectedConditions.visibilityOf(activityStreamPage.videoFound));

        //Driver.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        activityStreamPage.saveButton.click();

    }

    @Then("the user see the message with Vimeo video on Activity Stream")
    public void the_user_see_the_message_with_vimeo_video_on_activity_stream() {

        Driver.getDriver().switchTo().frame(activityStreamPage.sentMessageIframe);
        String actualResult = activityStreamPage.sentMessageIframe.getAttribute("src");
        System.out.println("actualResult = " + actualResult);
        Driver.getDriver().switchTo().parentFrame();
    }

    @When("the user adds Quote text into the message")
    public void the_user_adds_quote_text_into_the_message() {

        activityStreamPage.quoteTextButton.click();

        Driver.getDriver().switchTo().frame(activityStreamPage.messageInputFrame);
        Faker faker = new Faker();
        randomMessage = faker.chuckNorris().fact();
        activityStreamPage.quoteInput.sendKeys(randomMessage);
//        activityStreamPage.quoteInput.sendKeys(ConfigurationReader.getProperty("testQuote"));
        Driver.getDriver().switchTo().parentFrame();
    }

    @Then("the user see the message with Quote text on Activity Stream")
    public void the_user_see_the_message_with_quote_text_on_activity_stream() {

        String actualSentQuote = "";
        for (int i = 0; i < 2; i++) {
            try{
                actualSentQuote = activityStreamPage.sentMessageWithQuote.getText();
                break;
            }
            catch(StaleElementReferenceException exp){
                System.out.println(exp.getMessage());
            }
        }


//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
//        wait.until(ExpectedConditions.visibilityOf(activityStreamPage.sentMessageWithQuote));

//        String actualSentQuote = activityStreamPage.sentMessageWithQuote.getText();

        String expectedSentQuote = randomMessage;
//        String expectedSentQuote = ConfigurationReader.getProperty("testQuote");


        Assert.assertEquals(expectedSentQuote, actualSentQuote);

    }

    @When("the user adds tags into the message")
    public void the_user_adds_tags_into_the_message() {
        activityStreamPage.addTagButton.click();
        activityStreamPage.tagInputbox.sendKeys(ConfigurationReader.getProperty("tagTest1"));
        activityStreamPage.addButton.click();
        activityStreamPage.addTagButton.click();
        activityStreamPage.tagInputbox.sendKeys(ConfigurationReader.getProperty("tagTest2"));
        activityStreamPage.addButton.click();
    }

    @Then("the user see the message with tags on Activity Stream")
    public void the_user_see_the_message_with_tags_on_activity_stream() {

        String actualSentTag1 = "";
        for (int i = 0; i < 2; i++) {
            try{
                actualSentTag1 = activityStreamPage.senttag1.getText();
                break;
            }
            catch(StaleElementReferenceException exp){
                System.out.println(exp.getMessage());
            }
        }


//        String actualSentTag1 = activityStreamPage.senttag1.getText();
        String expectedSemtTag1 = ConfigurationReader.getProperty("tagTest1");

        String actualSentTag2 = activityStreamPage.senttag2.getText();
        String expectedSentTag2 = ConfigurationReader.getProperty("tagTest2");

        Assert.assertEquals(expectedSemtTag1, actualSentTag1);
        Assert.assertEquals(expectedSentTag2, actualSentTag2);

    }

    @When("the user cancels link before sending the message")
    public void the_user_cancels_link_before_sending_the_message(){

        Driver.getDriver().switchTo().frame(activityStreamPage.messageInputFrame);

        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(activityStreamPage.linkedTextinMessageInputbox).contextClick().build().perform();

        Driver.getDriver().switchTo().parentFrame();
        activityStreamPage.removeLinkButton.click();
    }

    @Then("the user see the message without linked text on Activity Stream")
    public void the_user_see_the_message_without_linked_text_on_activity_stream() throws Exception {

        boolean elementNotPresent = BrowserUtils.assertWebElementNotPresent(activityStreamPage.sentMessageTextWithLink);

        Assert.assertTrue(elementNotPresent);

    }


    String employee1 = "";
    String employee2 = "";

    @When("the user adds mentions into the message")
    public void the_user_adds_mentions_into_the_message() {
        activityStreamPage.addMentionButton.click();
        activityStreamPage.employeesAndDepartmentButton.click();
        employee1 = activityStreamPage.employee1.getText();
        activityStreamPage.employee1.click();

        activityStreamPage.addMentionButton.click();
        activityStreamPage.employeesAndDepartmentButton.click();
        employee2 = activityStreamPage.employee2.getText();
        activityStreamPage.employee2.click();
    }

    @Then("the user see the message with mentions on Activity Stream")
    public void the_user_see_the_message_with_mentions_on_activity_stream() {

//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
//        wait.until(ExpectedConditions.visibilityOf(activityStreamPage.getSentMessageText));

//        String expectedResultText = "Testing message" + employee1.trim() + " " + employee2;
        String expectedResultText = randomMessage + employee1.trim() + " " + employee2;
        expectedResultText = expectedResultText.trim();


//        String actualResultText = activityStreamPage.getSentMessageText.getText().trim();

        String actualResultText = "";

        for (int i = 0; i < 2; i++) {
            try{
                actualResultText = activityStreamPage.getSentMessageText.getText().trim();
                break;
            }
            catch(StaleElementReferenceException exp){
                System.out.println(exp.getMessage());
            }
        }

        Assert.assertEquals(expectedResultText, actualResultText);
    }


    @When("the user clicks Add mention button")
    public void the_user_clicks_add_mention_button() {
        activityStreamPage.addMentionButton.click();

    }

    @Then("the user can add mentions about only department employees")
    public void the_user_can_add_mentions_about_only_department_employees() {
        List<String> actuallist = new ArrayList<>();

        for (WebElement each : activityStreamPage.sections) {
            actuallist.add(each.getText());
        }
        List<String> expectedlist = new ArrayList<>(Arrays.asList("Recent", "Employees and departments"));

        Assert.assertEquals(expectedlist, actuallist);

    }
}

//deleting message after assertion
//        activityStreamPage.moreButton.click();
//        activityStreamPage.deleteButton.click();
//        Alert alert = Driver.getDriver().switchTo().alert();
//        alert.accept();
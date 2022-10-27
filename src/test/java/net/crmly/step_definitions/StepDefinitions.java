package net.crmly.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.crmly.pages.ActivityStreamPage;
import net.crmly.pages.LoginPage;
import net.crmly.utilities.ConfigurationReader;
import net.crmly.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class StepDefinitions {

    LoginPage loginPage = new LoginPage();
    ActivityStreamPage activityStreamPage = new ActivityStreamPage();

    @Given("the user is on the main page of Activity Stream.")
    public void the_user_is_on_the_main_page_of_activity_stream() {
        Driver.getDriver().get(ConfigurationReader.getProperty("URL"));
        loginPage.login();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 20);
        wait.until(ExpectedConditions.visibilityOf(activityStreamPage.userName));
    }

    @When("the user types into MESSAGE text inputbox")
    public void the_user_types_into_message_text_inputbox() {
        activityStreamPage.messageButton.click();

        Driver.getDriver().switchTo().frame(activityStreamPage.messageInputFrame);
        activityStreamPage.messageInbutbox.sendKeys(ConfigurationReader.getProperty("testText"));
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
        String actualLinkText = activityStreamPage.sentMessageTextWithLink.getText();

        String actualLink = activityStreamPage.sentMessageTextWithLink.getAttribute("href");
        String expectedLink = ConfigurationReader.getProperty("testURL");

        //activityStreamPage.sentMessageText.click();

        Assert.assertEquals(actualLink, expectedLink);

        //deleting message after assertion
        activityStreamPage.moreButton.click();
        activityStreamPage.deleteButton.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

    }

    //video
    @When("the user inserts Vimeo video into the message")
    public void the_user_inserts_vimeo_video_into_the_message() throws InterruptedException {
        activityStreamPage.insertVideoButton.click();
        activityStreamPage.videoSourceInputbox.sendKeys(ConfigurationReader.getProperty("testVimeoVideoURL"));

//        activityStreamPage.table.click();

        Thread.sleep(3000);

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
        activityStreamPage.quoteInput.sendKeys(ConfigurationReader.getProperty("testQuote"));
        Driver.getDriver().switchTo().parentFrame();
    }

    @Then("the user see the message with Quote text on Activity Stream")
    public void the_user_see_the_message_with_quote_text_on_activity_stream() {
        String actualSentQuote = activityStreamPage.sentMessageWithQuote.getText();
        String expectedSentQuote = ConfigurationReader.getProperty("testQuote");

        Assert.assertEquals(expectedSentQuote, actualSentQuote);

        //deleting message after assertion
        activityStreamPage.moreButton.click();
        activityStreamPage.deleteButton.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
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
        String actualSentTag1 = activityStreamPage.senttag1.getText();
        String expectedSemtTag1 = ConfigurationReader.getProperty("tagTest1");

        String actualSentTag2 = activityStreamPage.senttag2.getText();
        String expectedSentTag2 = ConfigurationReader.getProperty("tagTest2");

        Assert.assertEquals(expectedSemtTag1, actualSentTag1);
        Assert.assertEquals(expectedSentTag2, actualSentTag2);

        //deleting message after assertion
        activityStreamPage.moreButton.click();
        activityStreamPage.deleteButton.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();
    }

    @When("the user cancels link before sending the message")
    public void the_user_cancels_link_before_sending_the_message() throws InterruptedException {

        Driver.getDriver().switchTo().frame(activityStreamPage.messageInputFrame);

        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(activityStreamPage.linkedTextinMessageInputbox).contextClick().build().perform();
//        Thread.sleep(3000);

//        action.moveToElement(activityStreamPage.removeLinkButton).click().perform();

//        JavascriptExecutor executor = (JavascriptExecutor)Driver.getDriver();
//        executor.executeScript("arguments[0].click();", activityStreamPage.removeLinkButton);

        Driver.getDriver().switchTo().parentFrame();
        activityStreamPage.removeLinkButton.click();

    }

    @Then("the user see the message without linked text on Activity Stream")
    public void the_user_see_the_message_without_linked_text_on_activity_stream() throws Exception {

        boolean elementNotPresent = activityStreamPage.assertLinkNotPresent(activityStreamPage.sentMessageTextWithLink);

        Assert.assertTrue(elementNotPresent);

        //deleting message after assertion
        activityStreamPage.moreButton.click();
        activityStreamPage.deleteButton.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

    }


    @When("the user adds mentions into the message")
    public void the_user_adds_mentions_into_the_message() {
        activityStreamPage.addMentionButton.click();
        activityStreamPage.employeesAndDepartmentButton.click();
        activityStreamPage.employee1.click();

        activityStreamPage.addMentionButton.click();
        activityStreamPage.employeesAndDepartmentButton.click();
        activityStreamPage.employee2.click();


    }

    @Then("the user see the message with mentions on Activity Stream")
    public void the_user_see_the_message_with_mentions_on_activity_stream() {

        String expectedResultText = "Testing messagehelpdesk22@cybertekschool.com helpdesk23@cybertekschool.com  ";
        String actualResultText = activityStreamPage.getSentMessageText.getText();

        Assert.assertEquals(expectedResultText, actualResultText);

        //deleting message after assertion
        activityStreamPage.moreButton.click();
        activityStreamPage.deleteButton.click();
        Alert alert = Driver.getDriver().switchTo().alert();
        alert.accept();

    }


}

package net.crmly.pages;

import net.crmly.utilities.Driver;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ActivityStreamPage {
    public ActivityStreamPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//span[@class=\"user-name\"]")
    public WebElement userName;

    @FindBy(xpath = "//span[.='Message']")
    public WebElement messageButton;

    @FindBy(xpath = "//iframe[@class='bx-editor-iframe']")
    public WebElement messageInputFrame;

    @FindBy(xpath = "//body[@contenteditable='true']")
    public WebElement messageInbutbox;

    @FindBy(xpath = "//body[@contenteditable='true']/a")
    public WebElement linkedTextinMessageInputbox;

    @FindBy(xpath = "//*[@id=\"bx-admin-prefix\"]/span[3]/span[2]")
    public WebElement removeLinkButton;

    @FindBy(id = "blog-submit-button-save")
    public WebElement sendButton;

    // Link
    @FindBy(xpath = "//span[@title='Link']")
    public WebElement linkButton;

    @FindBy(id="linkidPostFormLHE_blogPostForm-text")
    public WebElement linkTextinputbox;

    @FindBy(id="linkidPostFormLHE_blogPostForm-href")
    public WebElement linkURLinputbox;

    @FindBy(className = "adm-btn-save")
    public WebElement saveButton;

    //Video
    @FindBy(xpath = "//span[@title='Insert video']")
    public WebElement insertVideoButton;

    @FindBy(id="video_idPostFormLHE_blogPostForm-source")
    public WebElement videoSourceInputbox;

    @FindBy(xpath = "//div[@class=\"bx-core-adm-dialog-content-wrap-inner\"]")
    public WebElement table;

    @FindBy(id="video_idPostFormLHE_blogPostForm-size")
    public WebElement selectVideoSize;

    @FindBy(xpath = "//div[@class='vp-player-ui-container']")
    public WebElement videoFound;

//    it is same with link save button
//    @FindBy(xpath = "//input[@class='adm-btn-save']")
//    public WebElement videoSaveButton;

    //Quote text
    @FindBy(xpath = "//span[@title='Quote text']")
    public WebElement quoteTextButton;

    @FindBy(xpath = "//blockquote[@class='bxhtmled-quote']")
    public WebElement quoteInput;

    //Add mention
    @FindBy(xpath = "//span[@id='bx-b-mention-blogPostForm']")
    public WebElement addMentionButton;

    @FindBy(xpath = "//div[@class= 'bx-finder-box-tabs']/a")
    public List<WebElement> sections;

    @FindBy(xpath = "//a[contains(@id, 'destDepartmentTab_mention')]")
    public WebElement employeesAndDepartmentButton;


    @FindBy(xpath = "(//div[@class=\"bx-finder-company-department-employee-info\"])[1]")
    public WebElement employee1;

    @FindBy(xpath = "(//div[@class=\"bx-finder-company-department-employee-info\"])[3]")
    public WebElement employee2;

    @FindBy(xpath = "(//div[@class='bx-finder-box-item-t7-name'])[1]")
    public WebElement employeeUserNameMention1;

    @FindBy(xpath = "(//div[@class='bx-finder-box-item-t7-name'])[2]")
    public WebElement employeeUserNameMention2;

    //Add tag
    @FindBy(xpath = "//span[@id='bx-b-tag-input-blogPostForm']")
    public WebElement addTagButton;

    @FindBy(id="TAGS_blogPostForm67abSn")
    public WebElement tagInputbox;

    @FindBy(xpath = "//span[@class='popup-window-button']")
    public WebElement addButton;

    //sent message
    @FindBy(xpath = "(//div[@class='feed-post-text-block-inner-inner'])[1]")
    public WebElement getSentMessageText;

    @FindBy(xpath = "(//div[@class='feed-post-text-block-inner-inner'])[1]/a")
    public WebElement sentMessageTextWithLink;

    @FindBy(xpath = "(//div[@class='feed-post-text-block-inner-inner'])[1]//td")
    public WebElement sentMessageWithQuote;

    @FindBy(xpath = "//div[@class='feed-com-files-cont']/a[1]")
    public WebElement senttag1;

    @FindBy(xpath = "//div[@class='feed-com-files-cont']/a[2]")
    public WebElement senttag2;

    @FindBy(xpath = "(//div[@class='feed-post-text-block-inner-inner'])[2]/iframe")
    public WebElement sentMessageIframe;

    //Log out
    @FindBy(xpath = "//span[.='Log out']")
    public WebElement logOutButton;


    //deleting message after assertion
    @FindBy(xpath = "(//span[@class=\"feed-post-more-text\"])[1]")
    public WebElement moreButton;

    @FindBy(xpath = "//span[.='Delete']") //(//span[@class="menu-popup-item-text"])[7]
    public WebElement deleteButton;




}

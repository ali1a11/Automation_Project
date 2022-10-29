package net.crmly.pages;

import net.crmly.utilities.ConfigurationReader;
import net.crmly.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@placeholder='Login']")
    public WebElement userName;

    @FindBy(xpath = "//input[@placeholder='Password']")
    public WebElement password;

    @FindBy(className = "login-btn")
    public WebElement loginButton;

    public void login(){
        this.userName.sendKeys(ConfigurationReader.getProperty("helpdeskUsername"));
        this.password.sendKeys(ConfigurationReader.getProperty("password"));
        this.loginButton.click();
    }

    public void login(String username, String password){
        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();
    }

    public void loginAs(String loginType){
        String username ="";
        String password ="";

        switch(loginType){
            case "Helpdesk":
                username = ConfigurationReader.getProperty("helpdesk_username");
                password = ConfigurationReader.getProperty("helpdesk_password");
                break;
            case "Human Resource":
                username = ConfigurationReader.getProperty("hr_username");
                password = ConfigurationReader.getProperty("hr_password");
                break;
            case "Marketing":
                username = ConfigurationReader.getProperty("marketing_username");
                password = ConfigurationReader.getProperty("marketing_password");
                break;
            default:
                System.out.println("invalid entry");

        }

        this.userName.sendKeys(username);
        this.password.sendKeys(password);
        this.loginButton.click();

    }


}

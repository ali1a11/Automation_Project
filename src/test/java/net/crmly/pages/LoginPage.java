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



}

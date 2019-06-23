package com.invoiceplane.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Dell on 23/04/2019.
 */
public class Login
{
   WebDriver driver;
    @FindBy (name="email")
   public WebElement txtEmail;

    @FindBy (name="password")
    public WebElement txtPassword;

    @FindBy (xpath="//button[@class='btn btn-primary']")
    public WebElement btnLogin;

    @FindBy (xpath="//a[contains(text(),'forgot')]")
    public WebElement btnForgotPassword;

    @FindBy(xpath = "//h1[contains(text(),'Login')]")
    public WebElement lblLogin;

    @FindBy(xpath="//label[contains(text(),'Email')]")
    public WebElement lblEmail;

    @FindBy(xpath = "//label[contains(text(),'Password')]")
    public WebElement lblPassword;


    public Login(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    public void setTxtEmail(String username)

    {
        txtEmail.sendKeys(username);
    }

    public void setTxtPassword(String password)


    {
        txtPassword.sendKeys(password);
    }
    public void clickLogin()


    {
        btnLogin.click();
    }

    public void clickForgotPassword()


    {
        btnForgotPassword.click();
    }


}

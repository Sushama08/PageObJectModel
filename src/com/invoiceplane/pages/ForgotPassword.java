package com.invoiceplane.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Dell on 23/04/2019.
 */
public class ForgotPassword
{
    WebDriver driver;

    @FindBy (xpath="//input[@id='email']")
    WebElement txtResetEmail;

    @FindBy (xpath="//button[@class='btn btn-danger']")
    WebElement btnResetPassword;

    public ForgotPassword(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }


    public void setTxtResetEmail(String ResetEmail)

    {
        txtResetEmail.sendKeys(ResetEmail);
    }

    public void clickReset()
    {
        // comment
        btnResetPassword.click();
    }






    /*public void ForgotPassword()
    {
        driver.cl
    } */

}

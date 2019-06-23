package UITesting;

import com.invoiceplane.pages.Login;
import com.invoiceplane.utilities.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class LoginTest
{
    WebDriver driver = Browser.getDriver(Browser.DriverTypes.CHROME);
    Login login;

    @BeforeClass

    public void logintest()
    {
        ResourceBundle rb=ResourceBundle.getBundle("invoicePlane");
        String url = rb.getString("url");
        driver.get(url);
        login = new Login(driver);
    }


    @Test
    public void checkTxtEmailVisibility()
    {
        boolean expected  =true;
        boolean actual;

        try
        {
            actual = login.txtEmail.isDisplayed();
        }
        catch (Exception e)
        {
            actual= false;
        }

        Assert.assertEquals(actual,expected);
    }

    @Test
    public void checkTxtPasswordEnable()
    {
        boolean expected =true;
        boolean actual;
        try {

            actual = login.txtPassword.isEnabled();
        }
        catch (Exception e)
        {
            actual=false;
        }

        Assert.assertEquals(actual,expected);

    }

    @Test

    public void lblLoginTestCheck()
    {
        String expected="Login";
        String actual="";

        try {
            actual = login.lblLogin.getText();
        }
        catch (Exception e)
        {
            actual="";
        }

        Assert.assertEquals(actual,expected);
    }

    @Test

    public void lblEmailTestCheck()
    {
        String expected="Email";
        String actual="";

        try
        {
            actual=login.lblEmail.getText();
        }
        catch (Exception e)
        {
            actual="";
        }
        Assert.assertEquals(actual,expected);
    }

    @Test

    public void lblPasswordTestCheck()
    {
        String expected="Password";
        String actual="";

        try
        {
            actual=login.lblPassword.getText();
        }
        catch (Exception e)
        {
            actual="";
        }
        Assert.assertEquals(actual,expected);
    }

    @Test

    public void lblLoginButtonCheck()
    {
        String expected="Login";
        String actual="";

        try
        {
            actual=login.btnLogin.getText();
        }
        catch (Exception e)
        {
            actual="";
        }
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void buttonLoginEnabledCheck()
    {
        boolean expected=true;
        boolean actual;

        try
        {
            actual=login.btnLogin.isEnabled();
        }
        catch (Exception e)
        {
            actual=false;
        }
        Assert.assertEquals(actual,expected);


    }

    @Test
    public void textEmailWatermarkCheck()
    {
        String expected="Email";
        String actual;

        try
        {
            actual=login.txtEmail.getAttribute("placeholder");
        }
        catch (Exception e)
        {
            actual="";
        }
        Assert.assertEquals(actual,expected);
    }

    @Test

    public void textPasswordWatermarkCheck()
    {
        String expected="Password";
        String actual;

        try
        {
            actual=login.txtPassword.getAttribute("placeholder");
        }
        catch (Exception e)
        {
            actual="";
        }
        Assert.assertEquals(actual,expected);
    }

}

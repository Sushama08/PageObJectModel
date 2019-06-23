package regression;

import com.invoiceplane.pages.ForgotPassword;
import com.invoiceplane.pages.Login;
import com.invoiceplane.utilities.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

/**
 * Created by Dell on 27/04/2019.
 */
public class ForgotPasswordTest
{
    WebDriver driver= Browser.getDriver(Browser.DriverTypes.CHROME);
    @Test

    public void forgotpassword()
    {
        ResourceBundle rb=ResourceBundle.getBundle("invoicePlane");
        String url = rb.getString("url");
        driver.get(url);

        Login login = new Login(driver);
        login.clickForgotPassword();

        ForgotPassword fp = new ForgotPassword(driver);
        fp.setTxtResetEmail("abc@p.lcl");
        fp.clickReset();


    }


}

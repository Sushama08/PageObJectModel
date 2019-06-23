package regression;

import com.invoiceplane.pages.Login;
import com.invoiceplane.utilities.Browser;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

/**
 * Created by Dell on 27/04/2019.
 */
public class LoginTest
{
    WebDriver driver = Browser.getDriver(Browser.DriverTypes.CHROME);
    @Test

    public void logintest()
    {
        ResourceBundle rb=ResourceBundle.getBundle("invoicePlane");
        String url = rb.getString("url");
        driver.get(url);

        Login login = new Login(driver);
        login.setTxtEmail("someusername");
        login.setTxtPassword("somepassword");
        login.clickLogin();
    }

}

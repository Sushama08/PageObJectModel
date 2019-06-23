package UITesting;

import com.invoiceplane.pages.Login;
import com.invoiceplane.utilities.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ResourceBundle;

public class UITestColor
{
    WebDriver driver = Browser.getDriver(Browser.DriverTypes.CHROME);
    Login login;
@Test
    public void logintest() {
        ResourceBundle rb = ResourceBundle.getBundle("invoicePlane");
        String url = rb.getString("url");
        driver.get(url);
        login = new Login(driver);


        WebElement btnLogin = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        String expected = "#2C8EDD";
        String btnValue = btnLogin.getCssValue("background-color");

        System.out.println(btnValue);

        String hexValue = Color.fromString(btnValue).asHex();
        System.out.println(hexValue);

        String actual= hexValue.toUpperCase();

        Assert.assertEquals(actual,expected);
    }



}

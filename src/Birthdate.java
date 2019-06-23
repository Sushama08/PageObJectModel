import com.invoiceplane.pages.Login;
import com.invoiceplane.pages.Menu;
import com.invoiceplane.pages.clients.AddClient;
import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * Created by Dell on 11/05/2019.
 */
public class Birthdate
{
    @Test

    public void testBirthdate() throws ParseException
    {
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver2.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        ResourceBundle rb=ResourceBundle.getBundle("invoicePlane");
        String url = rb.getString("url");
        driver.get(url);

        Login login = new Login(driver);
        login.setTxtEmail("kamble.sushama26@gmail.com");
        login.setTxtPassword("Invoice@123");
        login.clickLogin();

       // AddClient addClient = new AddClient(driver);
        Menu menu = new Menu(driver);
        menu.clickAddClient();
       // driver.switchTo().frame(driver.findElement(By.className("panel-body")));
        //driver.findElement(By.className("form-control datepicker")).click();

        driver.findElement(By.xpath("//input[@class='form-control datepicker']")).click();
        String setDate = "20/05/2018";
        String currentDate = driver.findElement(By.className("datepicker-switch")).getText();

        Date setBirthdate = new SimpleDateFormat("dd/MM/yyyy").parse(setDate);
        Date currBirthdate = new SimpleDateFormat("MMMM yyyy").parse(currentDate);

        int monthDifference = Months.monthsBetween(new DateTime(currBirthdate).withDayOfMonth(1),new DateTime(setBirthdate).withDayOfMonth(1)).getMonths();

        boolean isFuture = true;

        if(monthDifference<0)
        {
            isFuture = false;
            monthDifference = -1*monthDifference;
        }

        for(int i=0;i<monthDifference;i++)
        {
            if(isFuture)

                driver.findElement(By.className("next")).click();
            else

                driver.findElement(By.className("prev")).click();

        }

        String day1;
        day1= new SimpleDateFormat("dd").format(setBirthdate);
       // driver.findElement(By.xpath("//a[text()='"+Integer.parseInt(day1)+"']")).click();;
        driver.findElement(By.xpath("//td[@class='day' and  text()='"+Integer.parseInt(day1)+"']")).click();



    }
}

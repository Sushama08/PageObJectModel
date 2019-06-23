import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;

/**
 * Created by Dell on 05/05/2019.
 */
public class SelectDate
{
    @Test
    public void testDate() throws ParseException {
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver2.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://jqueryui.com/datepicker/");

        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        driver.findElement(By.id("datepicker")).click();

        String setDatestr = "25/08/2019";//dd/MM/yyyy
        String CurrDatestr = driver.findElement(By.className("ui-datepicker-title")).getText();  //MMMM yyyy

        Date setDate = new SimpleDateFormat("dd/MM/yyyy").parse(setDatestr);
        Date currDate = new SimpleDateFormat("MMMM yyyy").parse(CurrDatestr);

        int monthDiff = Months.monthsBetween(new DateTime(currDate).withDayOfMonth(1),new DateTime(setDate).withDayOfMonth(1)).getMonths();

        boolean isFuture = true;

        if(monthDiff<0)
        {
            isFuture = false;
            monthDiff = -1 * monthDiff;
        }

        for(int i=0;i<monthDiff;i++)
        {
            if(isFuture)

                driver.findElement(By.xpath("//span[text()='Next']")).click();

            else

                driver.findElement(By.xpath("//span[text()='Prev']")).click();
        }

        String day;
        day = new SimpleDateFormat("dd").format(setDate);
        driver.findElement(By.xpath("//a[text()='"+Integer.parseInt(day)+"']")).click();;
       // driver.findElement(By.xpath("//tbody//tr//td[text()='"+Integer.parseInt(day)+"']")).click();






    }
}

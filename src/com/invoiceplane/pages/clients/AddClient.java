package com.invoiceplane.pages.clients;

import org.joda.time.DateTime;
import org.joda.time.Months;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dell on 23/04/2019.
 */
public class AddClient
{
    WebDriver driver;

    //Personal Information

    @FindBy (xpath="//input[@name='client_name']")
    WebElement txtClientName;

    @FindBy (xpath="//input[@name='client_surname']")
    WebElement txtClientSurname;

    @FindBy (xpath="//span[@id=\"select2-client_language-container\"]")
    WebElement containerLanguage;

    @FindBy(xpath="//input[@type=\"search\"]")
    WebElement searchTextLanguage;

    //Address

    @FindBy (xpath="//input[@name='client_address_1']")
    WebElement txtStreetAddress;

    @FindBy (xpath="//input[@name='client_address_2']")
    WebElement txtStreetAddress2;

    @FindBy (xpath="//input[@name='client_city']")
    WebElement txtCity;

    @FindBy (xpath="//input[@name='client_state']")
    WebElement txtState;

    @FindBy (xpath="//input[@name='client_zip']")
    WebElement txtZipCode;

    @FindBy (xpath="//span[@id='select2-client_country-container']")
    WebElement containerCountry;

    @FindBy (xpath="//input[@type='search']")
    WebElement searchBox;

    //Personla Informatio
    @FindBy (xpath="//span[@id=\"select2-client_gender-container\"]")
    WebElement containerGender;

    @FindBy(xpath="//input[@type=\"search\"]")
    WebElement searchBoxGender;

    @FindBy (xpath="//input[@class='form-control datepicker']")
    WebElement txtBirthdate;

    //Contact Information

    @FindBy (xpath="//input[@name='client_phone']")
    WebElement txtPhoneNumber;

    @FindBy (xpath="//input[@name='client_fax']")
    WebElement txtFaxNumber;

    @FindBy (xpath="//input[@name='client_mobile']")
    WebElement txtMobileNumber;

    @FindBy (xpath="//input[@name='client_email']")
    WebElement txtEmailAddress;

    @FindBy (xpath="//input[@name='client_web']")
    WebElement txtWebAddress;

    //Taxes Information

    @FindBy (xpath="//input[@name='client_vat_id']")
    WebElement txtVATId;

    @FindBy (xpath="//input[@name='client_tax_code']")
    WebElement txtTaxesCode;

    @FindBy(xpath = "//button[@name='btn_submit']") WebElement buttonnSubmit;
    @FindBy(xpath = "//button[@name='btn_cancel']") WebElement buttonCancel;

    public AddClient(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);

    }

    //Personal Information
    public void setTxtClientName(String clientName)

    {
        txtClientName.sendKeys(clientName);
    }

    public void setTxtClientSurname(String clientSurname)
    {
        txtClientSurname.sendKeys(clientSurname);
    }

    //Address

    public void setTxtStreetAddress(String streetAddress)
    {
        txtStreetAddress.sendKeys(streetAddress);
    }

    public void setTxtStreetAddress2(String streetAddress2)
    {
        txtStreetAddress2.sendKeys(streetAddress2);
    }

    public void setTxtCity(String city)
    {
        txtCity.sendKeys(city);
    }

    public void setTxtState(String state)
    {
        txtState.sendKeys(state);
    }

    public void setTxtZipCode(String zipCode)


    {
        txtZipCode.sendKeys(zipCode);
    }

   /* public void setDropdownCountry
    {
        dropdownCountry.click();
    }

    public void setCountrySearchTxt(String country)
    {
        countrySearchTxt.sendKeys(country);
    } */


    public void setTxtPhoneNumber(String phoneNumber)
    {
        txtPhoneNumber.sendKeys(phoneNumber);
    }

    public void setTxtFaxNumber(String faxNumber)
    {
        txtFaxNumber.sendKeys(faxNumber);
    }

    public void setTxtMobileNumber(String mobileNumber)
    {
        txtMobileNumber.sendKeys(mobileNumber);
    }

    public void setTxtEmailAddress(String emailAddress)
    {
        txtEmailAddress.sendKeys(emailAddress);
    }

    public void setTxtWebAddress(String webAddress)
    {
        txtWebAddress.sendKeys(webAddress);
    }

    public void setTxtVATId(String vatId)
    {
        txtVATId.sendKeys(vatId);
    }

    public void setTxtTaxesCode(String taxesCode)
    {
        txtTaxesCode.sendKeys(taxesCode);
    }

    public void setButtonSubmit()

    {
        buttonnSubmit.click();
    }

    public void setButtonCancel()

    {
        buttonCancel.click();
    }

    public void setCountry(String country)
    {
        containerCountry.click();
        searchBox.sendKeys(country);
        driver.findElement(By.xpath("//li[text()='"+country+"']")).click();
    }

    public void setGender(String gender)
    {
        containerGender.click();;
        searchBoxGender.sendKeys(gender);
        driver.findElement(By.xpath("//li[contains(text(),'"+gender+"')]")).click();
    }

    public void setLanguage(String language)
    {
        containerLanguage.click();
        searchTextLanguage.sendKeys(language);
        driver.findElement(By.xpath("//li[contains(text(),'"+language+"')]")).click();
    }


    public void setDate(String setDate) throws ParseException
    {
        //driver.findElement(By.xpath("//input[@class='form-control datepicker']")).click();
       txtBirthdate.click();

        //String setDate = "20/05/2018";
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

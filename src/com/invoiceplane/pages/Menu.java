package com.invoiceplane.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Dell on 28/04/2019.
 */
public class Menu
{
    WebDriver driver;
    public Menu(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    //Clients

    @FindBy (xpath="//span[text()='Clients']")
    WebElement tbClients;

    @FindBy (xpath="//a[text()='Add Client']")
    WebElement subtbAddClient;

    @FindBy (xpath="//a[text()='View Clients']")
    WebElement subtbViewClients;

    public void clickAddClient()
    {
        tbClients.click();
        subtbAddClient.click();
    }

    public void clickViewClients()
    {
        tbClients.click();
        subtbViewClients.click();
    }


    //Quotes

    @FindBy (xpath="//span[text()='Quotes']")
    WebElement tbQuotes;

    @FindBy (xpath="//a[text()='Create Quote']")
    WebElement subtbCreateQuote;

    @FindBy (xpath="//a[text()='View Quotes']")
    WebElement subtbViewQuotes;

    public void clickCreateQuote()
    {
        tbQuotes.click();
        subtbCreateQuote.click();

    }

    public void clickViewQuotes()
    {
        tbQuotes.click();
        subtbViewQuotes.click();

    }

    //Invoice

    @FindBy (xpath="//span[text()='Invoices']")
    WebElement tbInvoice;

    @FindBy (xpath="//a[text()='Create Invoice']")
    WebElement subtbCreateInvoice;

    @FindBy (xpath="//a[text()='View Invoices']")
    WebElement subtbViewInvoices;

    @FindBy (xpath="//a[text()='View Recurring Invoices']")
    WebElement subtbViewRecurringInvoices;

    public void clickCreateInvoice()
    {
        tbInvoice.click();
        subtbCreateInvoice.click();

    }

    public void clickViewInvoices()
    {
        tbInvoice.click();
        subtbViewInvoices.click();
    }

    public void clickViewRecurringInvoices()
    {
        tbInvoice.click();
        subtbViewRecurringInvoices.click();
    }


    //Payments
    @FindBy (xpath="//span[text()='Payments']")
    WebElement tbPayments;

    @FindBy (xpath="//a[text()='Enter Payments']")
    WebElement subtbEnterPayment;

    @FindBy (xpath="//a[text()='View Payments']")
    WebElement subtbViewPayments;

    @FindBy (xpath="//a[text()='View Online Payment Logs']")
    WebElement subtbViewOnlinePaymentLogs;

    public void clickEnterPayments()
    {
        tbPayments.click();
        subtbEnterPayment.click();
    }

    public void clickViewPayments()
    {
        tbPayments.click();
        subtbViewPayments.click();
    }

    public void clickViewOnlinePaymentLogs()
    {
        tbPayments.click();
        subtbViewOnlinePaymentLogs.click();
    }



    //Products
    @FindBy (xpath="//span[text()='Products']")
    WebElement tbProduct;

    @FindBy (xpath="//a[text()='Create Products']")
    WebElement subtbCreateProduct;

    @FindBy (xpath="//a[text()='View Products']")
    WebElement subtbViewProducts;

    @FindBy (xpath="//a[text()='Product Families']")
    WebElement subtbProductFamilies;

    @FindBy (xpath="//a[text()='Product Units']")
    WebElement subtbProductUnits;

    public void clickCreateProduct()
    {
        tbProduct.click();
        subtbCreateProduct.click();
    }

    public void clickViewProducts()
    {
        tbProduct.click();
        subtbViewProducts.click();
    }

    public void clickProductFamilies()
    {
        tbProduct.click();
        subtbProductFamilies.click();
    }

    public void clickProductUnits()
    {
        tbProduct.click();
        subtbProductUnits.click();
    }

    //Tasks
    @FindBy (xpath="//span[text()='Tasks']")
    WebElement tbTasks;

    @FindBy (xpath="//a[text()='Create Task']")
    WebElement subtbCreateTask;

    @FindBy (xpath="//a[text()='Show Tasks']")
    WebElement subtbShowTasks;

    @FindBy (xpath="//a[text()='Projects']")
    WebElement subtbProjects;

    public void clickCreateTask()
    {
        tbProduct.click();
        subtbCreateTask.click();
    }

    public void clickShowTasks()
    {
        tbProduct.click();
        subtbShowTasks.click();
    }

    public void clickProjects()
    {
        tbProduct.click();
        subtbProjects.click();
    }

    //Reports

    @FindBy (xpath="//span[text()='Reports']")
    WebElement tbReports;

    @FindBy (xpath="//a[text()='Invoice Aging']")
    WebElement subtbInvoiceAging;

    @FindBy (xpath="//a[text()='Payment History']")
    WebElement subtbPaymentHistory;

    @FindBy (xpath="//a[text()='Sales by Client']")
    WebElement subtbSalesByClient;

    @FindBy (xpath="//a[text()='Sales by Date']")
    WebElement subtbSalesByDate;

    public void clickInvoiceAging()
    {
        tbReports.click();
        subtbInvoiceAging.click();
    }

    public void clickPaymentHistory()
    {
        tbReports.click();
        subtbPaymentHistory.click();
    }

    public void clickSalesbyClient()
    {
        tbReports.click();
        subtbSalesByClient.click();
    }

    public void clickSalesbyDate()
    {
        tbReports.click();
        subtbSalesByDate.click();
    }





}

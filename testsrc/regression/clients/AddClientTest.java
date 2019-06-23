package regression.clients;

import com.invoiceplane.pages.Login;
import com.invoiceplane.pages.Menu;
import com.invoiceplane.pages.clients.AddClient;
import com.invoiceplane.utilities.Browser;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ResourceBundle;

/**
 * Created by Dell on 27/04/2019.
 */
public class AddClientTest
{
    WebDriver driver = Browser.getDriver(Browser.DriverTypes.CHROME);

    @BeforeClass
    public void doLogin()
    {
        ResourceBundle rb=ResourceBundle.getBundle("invoicePlane");
        String url = rb.getString("url");
        driver.get(url);

        Login login = new Login(driver);
        login.setTxtEmail("kamble.sushama26@gmail.com");
        login.setTxtPassword("Invoice@123");
        login.clickLogin();

    }

    @Test (dataProvider = "getData")

    public void AddClientTest(String ClientName,String Clientsurname,String Language,String streetadd1,String streetadd2,String city,String state,String zipcode,
                               String country, String gender, String birthdate,String phonenumber,String Faxnumber,String mobilenumber,String emailid,
                               String webaddress,String vatid,String taxcode, String expected, String xPathOfActual) throws ParseException, IOException
    {
        Menu menu = new Menu(driver);
        menu.clickAddClient();

        AddClient addClient = new AddClient(driver);
        addClient.setTxtClientName(ClientName);
        addClient.setTxtClientSurname(Clientsurname);
        addClient.setLanguage(Language);
        addClient.setTxtStreetAddress(streetadd1);
        addClient.setTxtStreetAddress2(streetadd2);
        addClient.setTxtCity(city);
        addClient.setTxtState(state);
        addClient.setTxtZipCode(zipcode);
        addClient.setCountry(country);
        addClient.setGender(gender);
        addClient.setDate(birthdate);
        addClient.setTxtPhoneNumber(phonenumber);
        addClient.setTxtFaxNumber(Faxnumber);
        addClient.setTxtMobileNumber(mobilenumber);
        addClient.setTxtEmailAddress(emailid);
        addClient.setTxtWebAddress(webaddress);
        addClient.setTxtVATId(vatid);
        addClient.setTxtTaxesCode(taxcode);

        addClient.setButtonSubmit();




 /*        addClient.setTxtClientName("Rob");
        addClient.setTxtClientSurname("Dsouza");
        addClient.setLanguage("French");
        addClient.setTxtStreetAddress("'Spring' society,Flat no.109");
        addClient.setTxtStreetAddress2("Lane no.5");
        addClient.setTxtCity("Newyork");
        addClient.setTxtState("Texas");
        addClient.setTxtZipCode("896574125");
        addClient.setCountry("India");
        addClient.setGender("Female");
        addClient.setDate("10/08/2015");
        addClient.setTxtPhoneNumber("7452130658");
        addClient.setTxtFaxNumber("785412365");
        addClient.setTxtMobileNumber("8989745210");
        addClient.setTxtEmailAddress("abcde@p.com");
        addClient.setTxtWebAddress("www.test.com");
        addClient.setTxtVATId("89652");
        addClient.setTxtTaxesCode("856");



       addClient.setButtonSubmit();*/


       // String Expected="Client already exists!";
        String actual;

        try
        {
            actual = driver.findElement(By.xpath(xPathOfActual)).getText();
        }
        catch (Exception e)
        {
            actual="";
        }
        Assert.assertEquals(actual,expected);


    }
        @DataProvider
        public Object[][] getData() throws IOException
        {

            FileInputStream fileInputStream = new FileInputStream("Data/Book1.xlsx");
            XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
            XSSFSheet worksheet = workbook.getSheet("Sheet1");

            int rowCount = worksheet.getPhysicalNumberOfRows();

            Object[][] data=new Object[rowCount][20];

            for(int i=0;i<rowCount;i++)
            {
                XSSFRow row = worksheet.getRow(i);

                XSSFCell clientname = row.getCell(0);
                if(clientname==null)
                    data[i][0]="";
                else
                {
                    clientname.setCellType(CellType.STRING);
                    data[i][0] = clientname.getStringCellValue();
                }


                XSSFCell clientsurname = row.getCell(1);
                if(clientsurname==null)
                    data[i][1]="";
                else
                {
                    clientsurname.setCellType(CellType.STRING);
                    data[i][1] = clientsurname.getStringCellValue();
                }

                XSSFCell language = row.getCell(2);
                if(language==null)
                    data[i][2]="";
                else {
                    language.setCellType(CellType.STRING);
                    data[i][2] = language.getStringCellValue();
                }

                XSSFCell streetadd1 = row.getCell(3);
                if(streetadd1==null)
                    data[i][3]="";
                else {

                    streetadd1.setCellType(CellType.STRING);
                    data[i][3] = streetadd1.getStringCellValue();
                }

                XSSFCell streetadd2 = row.getCell(4);
                if(streetadd2==null)
                    data[i][4]="";
                else {

                    streetadd2.setCellType(CellType.STRING);
                    data[i][4] = streetadd2.getStringCellValue();
                }

                XSSFCell city = row.getCell(5);
                if(city==null)
                    data[i][5]="";
                else {

                    city.setCellType(CellType.STRING);
                    data[i][5] = city.getStringCellValue();
                }

                XSSFCell state = row.getCell(6);
                if(state==null)
                    data[i][6]="";
                else {

                    state.setCellType(CellType.STRING);
                    data[i][6] = state.getStringCellValue();
                }

                XSSFCell zipcode = row.getCell(7);
                if(zipcode==null)
                    data[i][7]="";
                else {

                    zipcode.setCellType(CellType.STRING);
                    data[i][7] = zipcode.getStringCellValue();
                }

                XSSFCell country = row.getCell(8);
                if(country==null)
                    data[i][8]="";
                else {

                    country.setCellType(CellType.STRING);
                    data[i][8] = country.getStringCellValue();
                }

                XSSFCell gender = row.getCell(9);
                if(gender==null)
                    data[i][9]="";
                else {

                    gender.setCellType(CellType.STRING);
                    data[i][9] = gender.getStringCellValue();
                }

                XSSFCell birthdate = row.getCell(10);
                if(birthdate==null)
                    data[i][10]="";
                else {

                    birthdate.setCellType(CellType.STRING);
                    data[i][10] = birthdate.getStringCellValue();
                }

                XSSFCell phonenumber = row.getCell(11);
                if(phonenumber==null)
                    data[i][11]="";
                else {

                    phonenumber.setCellType(CellType.STRING);
                    data[i][11] = phonenumber.getStringCellValue();
                }

                XSSFCell faxnumber = row.getCell(12);
                if(faxnumber==null)
                    data[i][12]="";
                else {

                    faxnumber.setCellType(CellType.STRING);
                    data[i][12] = faxnumber.getStringCellValue();
                }

                XSSFCell mobilenumber = row.getCell(13);
                if(mobilenumber==null)
                    data[i][13]="";
                else {

                    mobilenumber.setCellType(CellType.STRING);
                    data[i][13] = mobilenumber.getStringCellValue();
                }

                XSSFCell emailid = row.getCell(14);
                if(emailid==null)
                    data[i][14]="";
                else {

                    emailid.setCellType(CellType.STRING);
                    data[i][14] = emailid.getStringCellValue();
                }

                XSSFCell webaddress = row.getCell(15);
                if(webaddress==null)
                    data[i][15]="";
                else {

                    webaddress.setCellType(CellType.STRING);
                    data[i][15] = webaddress.getStringCellValue();
                }

                XSSFCell vatid = row.getCell(16);
                if(vatid==null)
                    data[i][16]="";
                else {

                    vatid.setCellType(CellType.STRING);
                    data[i][16] = vatid.getStringCellValue();
                }

                XSSFCell taxcode = row.getCell(17);
                if(taxcode==null)
                    data[i][17]="";
                else
                    {

                    taxcode.setCellType(CellType.STRING);
                    data[i][17] = taxcode.getStringCellValue();
                }

                XSSFCell expected = row.getCell(18);
                if(expected==null)
                    data[i][18]="";
                else
                {

                    expected.setCellType(CellType.STRING);
                    data[i][18] = expected.getStringCellValue();
                }

                XSSFCell xPathOfActual = row.getCell(19);
                if(xPathOfActual==null)
                    data[i][19]="";
                else
                {

                    xPathOfActual.setCellType(CellType.STRING);
                    data[i][19] = xPathOfActual.getStringCellValue();
                }


            }


            return data;

    }



}

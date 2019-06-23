package com.invoiceplane.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Conversion
{

    public static String convertCountry(String country)
    {
        String convertedCountry="";

        switch(country)
        {
            case "IN" : convertedCountry ="India"; break;
            case "AL" : convertedCountry="Albania"; break;
            case "DZ" : convertedCountry="Algeria"; break;
            case "AS" : convertedCountry="American Samoa"; break;
            case "AD" : convertedCountry="Andorra"; break;

        }

        return  convertedCountry;
    }

    public static String convertGender(String gn)
    {
        String convertGender="";

        switch (gn)
        {
            case "0" : convertGender="Male"; break;
            case "1" : convertGender="Female"; break;
        }
        return convertGender;
    }

    public static String convertDate(String bd) throws ParseException
    {

        String convertedDate="";
        SimpleDateFormat sd1= new SimpleDateFormat("yyyy-MM-dd");
        Date date= sd1.parse(bd);

        SimpleDateFormat sd2 = new SimpleDateFormat("dd/MM/yyyy");

        convertedDate = sd2.format(date);
        return convertedDate;

    }


}

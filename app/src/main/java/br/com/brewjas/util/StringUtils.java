package br.com.brewjas.util;


/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {

    public static String setLabel(String base, String label){

        return base.replace("{var}", label);
    }

    public static Date parseStringToDate(String date){

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date finalDate = new Date();

        try {
            finalDate = format.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return finalDate;
    }

    public static String parseDateToString(Date date){

        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = format.format(date);
        return dateString;
    }

}

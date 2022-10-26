/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PC
 */
public class DateValidatorUsingDateFormat implements DateValidator{
      private String dateFormat;

    public DateValidatorUsingDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public Date isValid02(String dateStr) {
        DateFormat sdf = new SimpleDateFormat(this.dateFormat);
        sdf.setLenient(false);
        Date date;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Check Format Again");
            return null;
        }
        return date;
    }

    @Override
    public Date isDateInPast(Date date) {
        Date curDate = new Date();
        if (date.compareTo(curDate) < 0) {
            System.out.println("Date is expired!");
            return null;
        }
        return date;
    }
}


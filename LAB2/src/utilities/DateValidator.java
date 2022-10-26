/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.Date;

/**
 *
 * @author PC
 */
public interface DateValidator {
    Date isValid02(String dateStr);
    Date isDateInPast(Date date);
}

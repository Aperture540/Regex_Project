/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package regex_project;

import java.util.Scanner;
import java.util.regex.*;

/**
 *
 * @author agendron
 */
public class Regex_Project {

    public static void main(String[] args) {
        String phoneNumber;
        Pattern numPat = Pattern.compile("([(]{0,})([0-9]{3})([)]{0,}[ ]{0,}[-]{0,}[.]{0,})([0-9]{3})([-]{0,}[.]{0,})([0-9]{4})");
        
        phoneNumber = getNumber();
        if (!phoneNumber.equals("")) {
            Matcher numMatch = numPat.matcher(phoneNumber);
            
            if(numMatch.matches()) {
                String punct1 = numMatch.group(1);
                String aCode = numMatch.group(2);
                String punct2 = numMatch.group(3);
                String cOCode = numMatch.group(4);
                String punct3 = numMatch.group(5);
                String sCode = numMatch.group(6);
                System.out.println("(" + aCode + ")" + " " + cOCode + "-" + sCode);
            }
            else {
                System.out.println("Error: Invalid format.");
            }
        }
        else {
            System.out.println("Error: No number.");
        }
    }

    private static String getNumber() {
        String phoneNumber;
        Scanner numberInput = new Scanner(System.in);
        System.out.println("Please enter a valid phone number with the area code.");
        phoneNumber = numberInput.nextLine();
        numberInput.close();
        return phoneNumber;
    }
}

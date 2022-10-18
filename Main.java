/**
This program calculate how mutch money solar cells generate per sun hour.
* 1. setting variables for month and day and taking in scanner.
* 2. Printing and taking input from user with delimiter
* 3. Input checking for the correct day and month with error handeling
* 4. Setting variables for sunrise and sunset
* 5. Printing and taking input from user with delimiter for sunrise.
* 6. Checks if time is valid
* 7. Printing and taking input from user with delimiter for sunset.
* 9. Checks if time is valid
* 10. Checks different senarios for calculating the sun hours
* 11. Calculating effect and prise
* 12. Printing out result and chois of starting over or quit program
* @author Andreas Svensson, sevane-2
*/

import java.util.*;

class Main {
    public static void main(String[] args) {
        int month;
        int day;
        Scanner input = new Scanner(System.in);
        
        // User input month and day
        System.out.print("Skriv in dagens datum [mm-dd]> ");
        input.useDelimiter("[-:\\s]+");
        month = input.nextInt();
        day = input.nextInt();
        
        // checks if the month is juni or july and the day is between 1 and 31 
        if (month == 6 || month == 7) {
            if (day >= 1 && day <= 31) {
                
            } else {
                System.out.println("Dagen måste vara mellan 1-31");
                main(args);
            }
        } else {
            System.out.println("Månaden är inte juni eller juli");
            main(args);
        
        }

        // Setting variables
        int sunriseHour;
        int sunriseMinute;
        int sunsetHour;
        int sunsetMinute;

        // Input for sunrise
        System.out.print("Skriv in tidpunkt soluppgång [hh:mm]> ");
        input.useDelimiter("[-:\\s]+");
        sunriseHour = input.nextInt();
        sunriseMinute = input.nextInt();

        // check if the time is valid 
        if (sunriseHour < 0 || sunriseHour > 23 || sunriseMinute < 0 || sunriseMinute > 59) {
            System.out.println("Ogilting inmatning av tid\n");
            main(args);
        
        }
        // Input for sunset
        System.out.print("Skriv in tidpunkt solnedgång [hh:mm]> ");
        input.useDelimiter("[-:\\s]+");
        sunsetHour = input.nextInt();
        sunsetMinute = input.nextInt();
        // check if the time is valid format and if it is a valid time
        if (sunsetHour < 0 || sunsetHour > 23 || sunsetMinute < 0 || sunsetMinute > 59) {
            System.out.println("Ogiltig inmatning av tid\n");
            // start over 
            main(args);

        } else {
            // Checks if sunrise is before sunset
            if (sunriseHour > sunsetHour) {
                System.out.println("Soluppgång måste vara före solnedgång\n");
                main(args);
            
            }

        }

        // calculate the total sunhours and minutes in 24 hours
        int sunHours = sunsetHour - sunriseHour;
        int sunMinutes = sunsetMinute - sunriseMinute;

        // checks if the sunhours is negative and if it is add 24 hours
        if (sunHours < 0) {
            sunHours = sunHours + 24;
        }
        // checks if the sunminutes is negative
        if (sunMinutes < 0) {
            sunMinutes = sunMinutes + 60;
            sunHours = sunHours - 1;
        }

        // sunhours and sunminutes with 2 decimals
        double sunHoursDecimal;
        sunHoursDecimal = sunHours + (sunMinutes / 60.0);

        // Setting variables

        double sunPanelAreaTotal = 1.7 * 26;
        double solarRadiationSquareHour = 166 * sunPanelAreaTotal;
        double solarEffect = solarRadiationSquareHour * 0.2;
        double price = 0.9 * solarEffect;
        
        // print the total sunhours and minutes
        System.out.println("==================================");
        System.out.printf("Soltimmar: %.2f timmar%n", sunHoursDecimal);
        
        // print the total production in kWh two decimals
        System.out.printf("Total produktion: %.2f kWh%n", sunHoursDecimal * solarEffect / 1000);
        // print the total price in SEK two decimals
        System.out.printf("Till ett värde av: %.2f kr%n", sunHoursDecimal * price / 1000);

        // user choise to start over or quit
        System.out.println("Vill du göra en ny beräkning? [j/n]");
        String answer = input.next();
        if (answer.equals("j")) {
            main(args);
        } else {
            System.out.println("Tack för att du använde mitt program!");
        }
        // close scanner
        input.close();
    }

}
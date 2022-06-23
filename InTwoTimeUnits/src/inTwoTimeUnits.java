// The program converts the given time period into text with only two largest time units
// in the format of digits followed by corresponding letters where 'y' - year,
// 'm' - month, etc.

import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println(inTwoTimeUnits(console.nextLong()));
    }

     public static String inTwoTimeUnits(long X) {

        String result = "";
        long seconds = X / 1000;
        long minutes = seconds / 60;
        long remainderSeconds = seconds % 60;
        long hours = minutes / 60;
        long remainderMinutes = minutes % 60;
        long days = hours / 24;
        long remainderHours = hours % 24;
        long weeks = days / 7;
        long remainderDays = days % 7;
        long months = days / 30;
        long remainderWeeks = months % 4;
        long years = months / 12;
        long remainderMonths = months % 12;

        int params = 0;

        // tracking of time units at the beginning

//        System.out.println("Years: " + years);
//        System.out.println("Months: " + remainderMonths);
//        System.out.println("Weeks " + remainderWeeks);
//        System.out.println("Days: " + remainderDays);
//        System.out.println("Hours: " + remainderHours);
//        System.out.println("Minutes: " + remainderMinutes);
//        System.out.println("Seconds: " + remainderSeconds);

        // checking non-zero parameters and selecting largest two
        if (years != 0) {
            params++;
        }

        if (remainderMonths != 0 && params == 1 && remainderWeeks != 0) {
            remainderMonths++;
            params++;
            remainderWeeks = 0;
        } else if (remainderMonths != 0 && params == 1 && remainderWeeks == 0) {
            params++;
        } else if (remainderMonths != 0 && params == 0) {
            params++;
        }

        if (remainderWeeks != 0 && params >= 2) {
            weeks = 0;
        } else if (remainderWeeks != 0 && params == 1 && remainderDays != 0) {
            remainderWeeks++;
            params++;
            days = 0;
        } else if (remainderWeeks != 0 && params == 1 && remainderDays == 0) {
            params++;
        } else if (remainderWeeks != 0 && params == 0) {
            params++;
        }

         if (remainderDays != 0 && params >= 2) {
             remainderDays = 0;
         } else if (remainderDays != 0 && params == 1 && remainderHours != 0) {
            remainderDays++;
            params++;
            remainderHours = 0;
        } else if (remainderDays != 0 && params == 1 && remainderHours == 0) {
             params++;
         } else if (remainderDays != 0 && params == 0) {
            params++;
        }

         if (remainderHours != 0 && params >= 2) {
             remainderHours = 0;
         } else if (remainderHours != 0 && params == 1 && remainderMinutes != 0) {
            remainderHours++;
            params++;
            remainderMinutes = 0;
        } else if (remainderHours != 0 && params == 1 && remainderMinutes == 0) {
            params++;
         } else if (remainderHours != 0 && params == 0) {
            params++;
         }

         if (remainderMinutes != 0 && params >= 2) {
             remainderMinutes = 0;
         } else if (remainderMinutes != 0 && params == 1 && remainderSeconds != 0) {
            remainderMinutes++;
            params++;
            remainderSeconds = 0;
        } else if (remainderMinutes != 0 && params == 1 && remainderSeconds == 0) {
             params++;
         } else if (remainderMinutes != 0 && params == 0) {
            params++;
        }

        if (remainderSeconds != 0 && params >= 2) {
            // minutes++;
            remainderSeconds = 0;
        }

        // checking if only two units are left
//        System.out.println("Years: " + years);
//        System.out.println("Months: " + remainderMonths);
//        System.out.println("Weeks " + remainderWeeks);
//        System.out.println("Days: " + remainderDays);
//        System.out.println("Hours: " + remainderHours);
//        System.out.println("Minutes: " + remainderMinutes);
//        System.out.println("Seconds: " + remainderSeconds);

    // selecting non-zeros and adding abbreviations to the result string
        if(years != 0) {
            result = result + years + "y";
        }
        if(remainderMonths != 0) {
            result = result + remainderMonths + "m";
        }
        if(remainderWeeks != 0) {
            result = result + remainderWeeks + "w";
        }
        if(remainderDays !=0) {
            result = result + remainderDays + "d";
        }
        if(remainderHours !=0) {
            result = result + remainderHours + "h";
        }
        if(remainderMinutes !=0) {
            result = result + remainderMinutes + "m";
        }
        if(remainderSeconds !=0) {
            result = result + remainderSeconds + "s";
        }

    return result;
    }
}
package UserManagerSystem.common;

import java.util.Calendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Validation {
     static Scanner in = new Scanner(System.in);

    public String getString() {
        while (true) {
            String res = in.nextLine().trim();

            if (!res.isEmpty()) {
                return res;
            } else {
                System.out.println("you cannot enter empty!");
            }
        }
    }

    public int getInt(String message, int min, int max) {
        boolean flag = true;
        int number = 0;

        while (flag) {
            System.out.println(message);
            try {
                number = Integer.parseInt(getString());
                if (number >= min && number <= max) {
                    flag = false;
                } else {
                    System.out.println("number out of range!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Number invalid!");
            }
        }

        return number;
    }

    public boolean chooseYN() {
        while (true) {
            String choose = getString().toLowerCase().substring(0, 1);

            switch (choose) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    System.out.println("enter Y/N only!");
            }
        }
    }


    public String getValidPhoneNumber() {
        String phoneNumber;
        boolean isValid = false;

        do {
            System.out.print("Enter phone number: ");
            phoneNumber = in.nextLine();

            isValid = isValidPhoneNumber(phoneNumber);

            if (!isValid) {
                System.out.println("Phone number is invalid.");
            }
        } while (!isValid);

        return phoneNumber;
    }



    public static boolean isValidPhoneNumber(String phoneNumber){
        String regex = "^(\\d{10}|\\d{3}-\\d{3}-\\d{4}|\\(\\d{3}\\)-\\d{3}-\\d{4}|\\d{3}\\.\\d{3}\\.\\d{4}|\\d{3} \\d{3} \\d{4}|\\d{3}-\\d{3}-\\d{4} x\\d{1,4}|\\d{3}-\\d{3}-\\d{4} ext\\d{1,4})$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
    }


    public int getYearOfExperience(int birthDate) {
        int yearCurrent = Calendar.getInstance().get(Calendar.YEAR);
        int age = yearCurrent - birthDate;

        while (true) {
            int yearExperience = getInt("enter year of experience", 0, 100);
            if (yearExperience > age) {
                System.out.println("year of experience must be smaller than age");
            } else {
                return yearExperience;
            }
        }
    }

    public String getRankOfGraduation() {
        while (true) {
            String rank = getString().toLowerCase();

            switch (rank) {
                case "excellence":
                case "good":
                case "fair":
                case "poor":
                    return rank;
                default:
                    System.out.println("excellence, good, fair or poor only!");
            }
        }

    }



    // public String getID(ArrayList<Contact> contacts) {
    //     return String.valueOf(contacts.size() + 1);
    // }


    public int getIntData(String msg) {
        int data = 0;

        while (true) {
            try {
                System.out.print(msg);
                data = in.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("The integer number format is invalid\n");
                in.nextLine();
            }
        }
        in.nextLine();
        return data;
    }
}


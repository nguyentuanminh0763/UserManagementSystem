package UserManagerSystem.DataAccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import UserManagerSystem.model.Account;

public class AccountDAO {
    private static AccountDAO instance = null;
    Scanner sc = new Scanner(System.in);
    ArrayList<Account> accounts = new ArrayList<>();

    public static AccountDAO getInstance() {
        if (instance == null) {
            synchronized (AccountDAO.class) {
                if (instance == null) {
                    instance = new AccountDAO();
                }
            }
        }
        return instance;
    }


    public void addAccount() {
        String userName;
        String passWord;
        do {
            System.out.println("Enter your user name: ");
            userName = sc.nextLine();
            if (CheckErrorAccount(userName, 5) == 0) {
                System.out.println("You must enter least at 5 character, and no space!");
            }
            if (checkExist(userName) == 0) {
                System.out.println("The user name is exits");
            }
        } while (CheckErrorAccount(userName, 5) == 0 || checkExist(userName) == 0);

        do {
            System.out.println("Enter your password: ");
            passWord = sc.nextLine();
            if (CheckErrorAccount(passWord, 6) == 0) {
                System.out.println("You must enter least at 6 character, and no space!");
            }
        } while (CheckErrorAccount(passWord, 6) == 0);
        Account account = new Account(userName, passWord);
        accounts.add(account);
        saveDataToFile();

    }

    public void login() {
        loadDataFromFile();
        String userName;
        String passWord;
        int mark = 1;
        do {
            System.out.println("Enter your user name: ");
            userName = sc.nextLine();
            if (CheckErrorAccount(userName, 5) == 0 || checkExist(userName) == 1) {
                System.out.println("Your account do not exits!");
            }
        } while (CheckErrorAccount(userName, 5) == 0 || checkExist(userName) == 1);

        do {
            System.out.println("Enter your pass word");
            passWord = sc.nextLine();

        } while (mark == 0);

        for (Account account : accounts) {
            if (account.getUserName().equals(userName)) {
                if (account.getPassWord().equals(passWord)) {
                    System.out.println("Login succes!");
                    mark = 1;
                } else {
                    mark = 0;
                }
            }
        }

    }

    public int CheckErrorAccount(String userName, int mark) {
        if (userName.length() < mark)
            return 0;
        for (int i = 0; i < userName.length(); i++) {
            if (userName.charAt(i) == ' ')
                return 0;
        }

        return 1;
    }

    public int checkExist(String userName) {
        for (Account account : accounts) {
            if (account.getUserName().equals(userName))
                return 0;
        }
        return 1;
    }

    public boolean loadDataFromFile(){
        accounts.clear();
        String filePath = "UserManagerSystem\\data\\user.txt";
        File file = new File(filePath);
        
        if(!file.exists()){
            System.out.println("The file does not exist");
            return false;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String data;
            do{
                data = br.readLine();

                if(data != null){
                    String input[] = data.split(",");
                    String userName = input[0];
                    String passWord = input[1];
                    accounts.add(new Account(userName, passWord));
                }
            }while(data != null);
            br.close();
        } catch (Exception e) {
            
            System.out.println("Error happens while reading file");
            return false;
        }   

        return true;
    }

    public boolean saveDataToFile(){
        File file = new File("UserManagerSystem\\data\\user.txt");
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(file);
            for (Account account : accounts) {
                String data = account.getUserName() + "," + account.getPassWord();
                pw.println(data);
            }
        } catch (Exception e) {
            
            System.out.println("Error happen while writing to file");
            return false;
        } finally{
            if(pw != null){
                pw.flush();
                pw.close();
            }
        }
        return true;
    }

}

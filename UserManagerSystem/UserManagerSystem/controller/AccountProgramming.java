package UserManagerSystem.controller;

import UserManagerSystem.reponsitory.AccountRepository;
import UserManagerSystem.view.Menu;

public class AccountProgramming extends Menu<String>{

    private AccountRepository accountRepository = new AccountRepository();

    public AccountProgramming() {
        super("Account Programming", new String[]{"Create a new account", "Login", "Exit"});
    }

    @Override
    public void excute(int n) {
        switch (n) {
            case 1:
                try {
                    accountRepository.addAccount(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 2:

                try {
                    accountRepository.find(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case 3:

                System.exit(0);
        
           
        }
        
    }
    
}

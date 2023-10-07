package UserManagerSystem.reponsitory;


import UserManagerSystem.DataAccess.AccountDAO;
import UserManagerSystem.model.Account;

public class AccountRepository implements IAccountRepository{

    @Override
    public void addAccount(Account acc) throws Exception {
        try {
            AccountDAO.getInstance().addAccount();
            System.out.println("Success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account find(Account acc) throws Exception {
        try {
            AccountDAO.getInstance().login();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acc;   
    }
    
}

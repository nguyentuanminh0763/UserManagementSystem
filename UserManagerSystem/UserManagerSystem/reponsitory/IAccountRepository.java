package UserManagerSystem.reponsitory;

import UserManagerSystem.model.Account;

public interface IAccountRepository {
    void addAccount(Account acc) throws Exception;
    Account find(Account acc) throws Exception;
      
}

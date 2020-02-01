package repositories.impl;

import domains.Account;
import repositories.AccountRepository;

public class AccountRepositoryDummyImpl implements AccountRepository {
    @Override
    public Account findByAccount(Long a) {
        return new Account(a);
    }
}

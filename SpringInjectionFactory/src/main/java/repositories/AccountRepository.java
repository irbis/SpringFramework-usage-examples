package repositories;

import domains.Account;

public interface AccountRepository {
    Account findByAccount(Long a);
}

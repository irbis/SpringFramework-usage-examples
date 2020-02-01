package repositories;

import domains.Account;

import java.math.BigDecimal;

public interface TransferRepository {
    void transfer(Account accountA, Account accountB, BigDecimal amount);
}

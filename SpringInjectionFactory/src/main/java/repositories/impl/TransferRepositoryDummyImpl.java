package repositories.impl;

import domains.Account;
import repositories.TransferRepository;

import java.math.BigDecimal;

public class TransferRepositoryDummyImpl implements TransferRepository {
    @Override
    public void transfer(Account accountA, Account accountB, BigDecimal amount) {
    }
}

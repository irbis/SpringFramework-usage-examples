package repositories.impl;

import domains.Account;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountRepositoryDummyImplTest {

    private final AccountRepositoryDummyImpl accountRepository = new AccountRepositoryDummyImpl();

    @Test
    public void findByAccount() {
        Long testId = 5L;
        Account account = accountRepository.findByAccount(testId);

        assertEquals(testId, account.getId());
    }
}
package services.impl;

import domains.Account;
import repositories.AccountRepository;
import repositories.TransferRepository;
import services.TransferService;

import java.math.BigDecimal;

public class TransferServiceImpl implements TransferService {
    private final AccountRepository accountRepository;
    private final TransferRepository transferRepository;

    public TransferServiceImpl(AccountRepository accountRepository,
                               TransferRepository transferRepository) {
        this.accountRepository = accountRepository;
        this.transferRepository = transferRepository;
    }

    @Override
    public void transferMoney(Long a, Long b, BigDecimal amount) {
        Account accountA = accountRepository.findByAccount(a);
        Account accountB = accountRepository.findByAccount(b);

        transferRepository.transfer(accountA, accountB, amount);
    }
}

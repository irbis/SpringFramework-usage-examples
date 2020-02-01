package services;

import java.math.BigDecimal;

public interface TransferService {
    void transferMoney(Long a, Long b, BigDecimal amount);
}

package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import repositories.AccountRepository;
import repositories.TransferRepository;
import repositories.impl.AccountRepositoryDummyImpl;
import repositories.impl.TransferRepositoryDummyImpl;
import services.TransferService;
import services.impl.TransferServiceImpl;

@Configuration
public class AppConfig {
    @Bean
    public TransferService transferService() {
        return new TransferServiceImpl(accountRepository(), transferRepository());
    }

    @Bean
    public AccountRepository accountRepository() {
        return new AccountRepositoryDummyImpl();
    }

    @Bean
    public TransferRepository transferRepository() {
        return new TransferRepositoryDummyImpl();
    }
}

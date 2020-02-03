package app;

import configuration.AppConfig;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import repositories.AccountRepository;
import repositories.TransferRepository;
import repositories.impl.AccountRepositoryDummyImpl;
import repositories.impl.TransferRepositoryDummyImpl;
import services.TransferService;
import services.impl.TransferServiceImpl;

import static org.junit.Assert.*;

public class SpringInjectionFactoryTest {

    ConfigurableApplicationContext applicationContext;

    @Before
    public void setupApplicationContext() {
        applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
    }

    @After
    public void closeApplicationContext() {
        applicationContext.close();
    }

    @Test
    public void testTransferServiceBean() {
        TransferService transferService = applicationContext.getBean(TransferService.class);

        assertNotNull(transferService);
        assertTrue(transferService instanceof TransferServiceImpl);
    }

    @Test
    public void testAccountRepositoryBean() {
        AccountRepository accountRepository = applicationContext.getBean(AccountRepository.class);

        assertNotNull(accountRepository);
        assertTrue(accountRepository instanceof AccountRepositoryDummyImpl);
    }

    @Test
    public void testTransferRepositoy() {
        TransferRepository transferRepository = applicationContext.getBean(TransferRepository.class);

        assertNotNull(transferRepository);
        assertTrue(transferRepository instanceof TransferRepositoryDummyImpl);
    }
}
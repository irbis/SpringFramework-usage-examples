package app;

import configuration.AppConfig;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import services.TransferService;

import java.math.BigDecimal;

public final class SpringInjectionFactory {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        TransferService transferService = applicationContext.getBean(TransferService.class);
        transferService.transferMoney(100L, 200L, BigDecimal.valueOf(34.5));

        applicationContext.close();
    }
}

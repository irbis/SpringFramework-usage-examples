package git.irbis.spring3.controllerusageexample.customers.web;

import git.irbis.spring3.controllerusageexample.customers.repository.CustomersRepository;
import org.springframework.util.StringUtils;

/**
 *
 * @author irbis4lan@yandex.ua
 */
class ListCustomersCommandFactory {
    private final String firstName;
    private final String lastName;

    private ListCustomersCommandFactory(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    static ListCustomersCommandFactory parseLastName(String lastName) {
        return new ListCustomersCommandFactory(null, lastName);
    }
    
    static ListCustomersCommandFactory parseFirstLastName(String firstName, 
            String lastName) {
        return new ListCustomersCommandFactory(
                StringUtils.hasLength(firstName) ? firstName : null,
                StringUtils.hasLength(lastName) ? lastName : null);
    }
    
    static ListCustomersCommandFactory instanceOf() {
        return new ListCustomersCommandFactory(null, null);
    }
    
    ListCustomersCommand createCommand(CustomersRepository customersRepository) {
        
        if (firstName == null && lastName != null)
            return new ListByLastNameCustomersCommand(customersRepository, 
                    lastName);

        if (firstName != null && lastName == null)
            return new ListByFirstNameCustomersCommand(
                    customersRepository, firstName);
        
        if (firstName != null && lastName != null)
            return new ListByFirstLastNameCustomersCommand(
                    customersRepository, firstName, lastName);
        
        return new ListAllCustomersCommand(customersRepository);
    }
}

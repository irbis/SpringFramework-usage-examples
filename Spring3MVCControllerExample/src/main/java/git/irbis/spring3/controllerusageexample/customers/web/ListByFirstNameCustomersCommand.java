package git.irbis.spring3.controllerusageexample.customers.web;

import git.irbis.spring3.controllerusageexample.customers.repository.Customer;
import git.irbis.spring3.controllerusageexample.customers.repository.CustomersRepository;
import java.util.List;

/**
 *
 * @author irbis4lan@yandex.ua
 */
class ListByFirstNameCustomersCommand extends ListCustomersCommand {

    private final String firstName;

    public ListByFirstNameCustomersCommand(CustomersRepository customersRepository,
            String firstName) {
        super(customersRepository);
        this.firstName = firstName;
    }
    
    @Override
    protected List<Customer> find() {
        return customersRepository.findCustomerByFirstName(firstName);
    }
    
}

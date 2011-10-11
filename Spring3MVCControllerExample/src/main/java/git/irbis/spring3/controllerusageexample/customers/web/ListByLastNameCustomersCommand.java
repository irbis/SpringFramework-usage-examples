package git.irbis.spring3.controllerusageexample.customers.web;

import git.irbis.spring3.controllerusageexample.customers.repository.Customer;
import git.irbis.spring3.controllerusageexample.customers.repository.CustomersRepository;
import java.util.List;

/**
 *
 * @author irbis4lan@yandex.ua
 */
class ListByLastNameCustomersCommand extends ListAllCustomersCommand {

    private final String lastName;
    
    public ListByLastNameCustomersCommand(CustomersRepository customersRepository,
            String lastName) {
        super(customersRepository);
        this.lastName = lastName;
    }

    @Override
    protected List<Customer> find() {
        return customersRepository.findCustomersByLastName(lastName);
    }
    
}

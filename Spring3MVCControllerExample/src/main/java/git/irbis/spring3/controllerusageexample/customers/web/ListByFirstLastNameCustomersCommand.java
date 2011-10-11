package git.irbis.spring3.controllerusageexample.customers.web;

import git.irbis.spring3.controllerusageexample.customers.repository.Customer;
import git.irbis.spring3.controllerusageexample.customers.repository.CustomersRepository;
import java.util.List;

/**
 *
 * @author irbis4lan@yandex.ua
 */
class ListByFirstLastNameCustomersCommand extends ListCustomersCommand {
    private final String firstName;
    private final String lastName;

    public ListByFirstLastNameCustomersCommand(
            CustomersRepository customersRepository, String firstName, 
            String lastName) {
        super(customersRepository);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    protected List<Customer> find() {
        return customersRepository.findCustomerByFirstLastName(
                firstName, lastName);
    }
    
}

package git.irbis.spring3.controllerusageexample.customers.web;

import git.irbis.spring3.controllerusageexample.customers.repository.Customer;
import git.irbis.spring3.controllerusageexample.customers.repository.CustomersRepository;
import java.util.List;

/**
 *
 * @author irbis4lan@yandex.ua
 */
class ListAllCustomersCommand extends ListCustomersCommand {

    public ListAllCustomersCommand(CustomersRepository customersRepository) {
        super(customersRepository);
    }

    @Override
    protected List<Customer> find() {
        return customersRepository.findAllCustomers();
    }
}

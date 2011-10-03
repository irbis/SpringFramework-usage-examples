package git.irbis.spring3.controllerusageexample.customers.repository;

import java.util.List;

/**
 *
 * @author irbis4lan@yahoo.ua
 */
public interface CustomersRepository {
    public List<Customer> findAllCustomers();
}

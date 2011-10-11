package git.irbis.spring3.controllerusageexample.customers.repository;

import java.util.List;

/**
 *
 * @author irbis4lan@yahoo.ua
 */
public interface CustomersRepository {
    public List<Customer> findAllCustomers();
    public Customer find(int customerId);

    public List<Customer> findCustomersByLastName(String lastName);
    public List<Customer> findCustomerByFirstName(String firstName);
    public List<Customer> findCustomerByFirstLastName(
            String firstName, String lastName);
}

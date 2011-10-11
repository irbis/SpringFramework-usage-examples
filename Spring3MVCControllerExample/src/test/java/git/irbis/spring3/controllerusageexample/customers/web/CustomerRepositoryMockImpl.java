package git.irbis.spring3.controllerusageexample.customers.web;

import git.irbis.spring3.controllerusageexample.customers.repository.Customer;
import git.irbis.spring3.controllerusageexample.customers.repository.CustomersRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author irbis4lan@yandex.ua
 */
class CustomerRepositoryMockImpl implements CustomersRepository {

    final List<Customer> customers = new ArrayList<Customer>();

    private Customer createTestCustomer(int customerId) {
        return new Customer(customerId, "firstName"+customerId,
                "lastName" + customerId, "address" + customerId);
    }
    
    public CustomerRepositoryMockImpl() {
        customers.add(createTestCustomer(1));
        customers.add(createTestCustomer(2));
        customers.add(createTestCustomer(3));
        customers.add(createTestCustomer(4));
        customers.add(createTestCustomer(5));
    }
    
    @Override
    public List<Customer> findAllCustomers() {
        List<Customer> result = new ArrayList<Customer>(customers.size());
        
        for (Customer c : customers)
            result.add(new Customer(c));
        
        return result;
    }

    @Override
    public Customer find(int customerId) {
        for (Customer c : customers)
            if (customerId == c.getCustomerId())
                return c;
        
        return null;
    }

    @Override
    public List<Customer> findCustomersByLastName(String lastName) {
        List<Customer> foundCustomers = new ArrayList<Customer>();
        String lastNameLowerCase = lastName.toLowerCase();
        
        for (Customer c : customers)
            if (c.getLastName().toLowerCase().startsWith(lastNameLowerCase))
                foundCustomers.add(new Customer(c));
        
        return foundCustomers;
    }

    @Override
    public List<Customer> findCustomerByFirstName(String firstName) {
        List<Customer> foundCustomers = new ArrayList<Customer>();
        String firstNameLowerCase = firstName.toLowerCase();
        
        for (Customer c : customers)
            if (c.getFirstName().toLowerCase().startsWith(firstNameLowerCase))
                foundCustomers.add(new Customer(c));
        
        return foundCustomers;
    }
    
    @Override
    public List<Customer> findCustomerByFirstLastName(
            String firstName, String lastName) {
        List<Customer> foundCustomers = new ArrayList<Customer>();
        String firstNameLowerCase = firstName.toLowerCase();
        String lastNameLowerCase = lastName.toLowerCase();

        for (Customer c : customers)
            if (c.getFirstName().toLowerCase().startsWith(firstNameLowerCase) &&
                    c.getLastName().toLowerCase().startsWith(lastNameLowerCase))
                foundCustomers.add(new Customer(c));
        
        return foundCustomers;
    }
}

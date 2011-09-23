package git.irbis.springmvccommandclassusage.customer;

import git.irbis.springmvccommandclassusage.customer.dao.CustomerDAO;
import git.irbis.springmvccommandclassusage.customer.impl.CustomerBO;
import org.irbis.springmvccommandclassusage.domainmodel.Customer;

/**
 *
 * @author Alexsey Nadtochey<irbis4lan@yandex.ua>
 */
public class CustomerBOImpl implements CustomerBO {
    private final CustomerDAO customerDAO;

    public CustomerBOImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public void update(Customer customer) {
        customerDAO.update(customer);
    }

    @Override
    public Customer find(int customerId) {
        return customerDAO.find(customerId);
    }

    @Override
    public Customer create(Customer customer) {
        return customerDAO.create(customer);
    }
}

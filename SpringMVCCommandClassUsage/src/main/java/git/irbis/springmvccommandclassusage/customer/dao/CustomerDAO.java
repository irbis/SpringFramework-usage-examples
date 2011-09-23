package git.irbis.springmvccommandclassusage.customer.dao;

import org.irbis.springmvccommandclassusage.domainmodel.Customer;

/**
 *
 * @author Alexsey Nadtochey<irbis4lan@yandex.ua>
 */
public interface CustomerDAO {

    Customer create(Customer customer);

    Customer find(int customerId);

    void update(Customer customer);
    
}

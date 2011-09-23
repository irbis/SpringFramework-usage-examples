package git.irbis.springmvccommandclassusage.customer.impl;

import org.irbis.springmvccommandclassusage.domainmodel.Customer;

/**
 *
 * @author Alexsey Nadtochey<irbis4lan@yandex.ua>
 */
public interface CustomerBO {

    Customer create(Customer customer);

    Customer find(int customerId);

    void update(Customer customer);
    
}

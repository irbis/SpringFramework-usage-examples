package git.irbis.springmvccommandclassusage.customer.web;

import git.irbis.springmvccommandclassusage.customer.impl.CustomerBO;
import org.irbis.springmvccommandclassusage.domainmodel.Customer;

/**
 *
 * @author Alexsey Nadtochey<irbis4lan@yandex.ua>
 */
class CustomerCommandFactory {
    private CustomerBO customerBO;

    CustomerCommandFactory(CustomerBO customerBO) {
        this.customerBO = customerBO;
    }
    
    CustomerCommand createCustomerCommandCancel(int customerId) {
        Customer customer = customerBO.find(customerId);
        if (customer != null)
            return new CustomerCommandCancel(customer);
        else
            return new CustomerCommandCancel(new Customer());
    }
    
    CustomerCommand createCustomerCommandCancel() {
        return new CustomerCommandCancel(new Customer());
    }
    
    CustomerCommand createCustomerCommandSaveCustomer(int customerId) {
        Customer customer = customerBO.find(customerId);
        
        if (customer != null)
            return new CustomerCommandSaveCustomer(customer, customerBO);
        else
            return new CustomerCommandSaveCustomer(new Customer(), customerBO);
    }
    
    CustomerCommand createCustomerCommandSaveCustomer() {
        return new CustomerCommandSaveCustomer(new Customer(), customerBO);
    }
}

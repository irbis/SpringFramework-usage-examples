package git.irbis.springmvccommandclassusage.customer.web;

import git.irbis.springmvccommandclassusage.customer.impl.CustomerBO;
import org.irbis.springmvccommandclassusage.domainmodel.Customer;

/**
 *
 * @author Alexsey Nadtochey<irbis4lan@yandex.ua>
 */
public class CustomerCommandSaveCustomer extends CustomerCommand {

    private final CustomerBO customerBO;

    public CustomerCommandSaveCustomer(Customer customer, 
            CustomerBO customerBO) {
        super(customer);
        this.customerBO = customerBO;
    }
    
    @Override
    public void execute() {
        if (this.customer.getCustomerId() == 0)
            customerBO.create(customer);
        else
            customerBO.update(customer);
    }
}

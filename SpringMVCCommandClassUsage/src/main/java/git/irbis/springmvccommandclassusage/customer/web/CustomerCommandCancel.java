package git.irbis.springmvccommandclassusage.customer.web;

import org.irbis.springmvccommandclassusage.domainmodel.Customer;

/**
 *
 * @author Alexsey Nadtochey<irbis4lan@yandex.ua>
 */
public class CustomerCommandCancel extends CustomerCommand {

    public CustomerCommandCancel(Customer customer) {
        super(customer);
    }
    
    @Override
    public void execute() {
    }
}

package git.irbis.springmvccommandclassusage.customer.web;

import org.irbis.springmvccommandclassusage.domainmodel.Customer;

/**
 *
 * @author Alexsey Nadtochey<irbis4lan@yandex.ua>
 */
abstract class CustomerCommand {
    protected final Customer customer;
    
    public CustomerCommand(Customer customer) {
        this.customer = customer;
    }

    public void setLastName(String lastName) {
        customer.setLastName(lastName);
    }

    public void setFirstName(String firstName) {
        customer.setFirstName(firstName);
    }

    public void setCustomerId(int customerId) {
        customer.setCustomerId(customerId);
    }

    public void setAddress(String address) {
        customer.setAddress(address);
    }

    public String getLastName() {
        return customer.getLastName();
    }

    public String getFirstName() {
        return customer.getFirstName();
    }

    public int getCustomerId() {
        return customer.getCustomerId();
    }

    public String getAddress() {
        return customer.getAddress();
    }

    public abstract void execute();
}

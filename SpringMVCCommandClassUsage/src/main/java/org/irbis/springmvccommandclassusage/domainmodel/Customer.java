package org.irbis.springmvccommandclassusage.domainmodel;

/**
 *
 * @author Alexsey Nadtochey<irbis4lan@yandex.ua>
 */
public class Customer {
    private int customerId = 0;

    private String firstName = "";
    private String lastName = "";
    private String address = "";

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}

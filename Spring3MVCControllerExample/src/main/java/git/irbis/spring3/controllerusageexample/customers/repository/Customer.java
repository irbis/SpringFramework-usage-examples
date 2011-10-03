package git.irbis.spring3.controllerusageexample.customers.repository;

/**
 *
 * @author irbis4lan@yandex.ua
 */
public class Customer {

    private final int customerId;
    private final String firstName;
    private final String lastName;
    private final String address;

    public Customer(int customerId, String firstName, String lastName,
            String address) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Customer(Customer c) {
        this.customerId = c.customerId;
        this.firstName = c.firstName;
        this.lastName = c.lastName;
        this.address = c.address;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (this.customerId != other.customerId) {
            return false;
        }
        if ((this.firstName == null) ? (other.firstName != null) : !this.firstName.equals(other.firstName)) {
            return false;
        }
        if ((this.lastName == null) ? (other.lastName != null) : !this.lastName.equals(other.lastName)) {
            return false;
        }
        if ((this.address == null) ? (other.address != null) : !this.address.equals(other.address)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.customerId;
        hash = 79 * hash + (this.firstName != null ? this.firstName.hashCode() : 0);
        hash = 79 * hash + (this.lastName != null ? this.lastName.hashCode() : 0);
        hash = 79 * hash + (this.address != null ? this.address.hashCode() : 0);
        return hash;
    }
    
    /**
     * Get the value of address
     *
     * @return the value of address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Get the value of lastName
     *
     * @return the value of lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get the value of firstName
     *
     * @return the value of firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get the value of customerId
     *
     * @return the value of customerId
     */
    public int getCustomerId() {
        return customerId;
    }
}

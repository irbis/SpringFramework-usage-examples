/*
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package git.irbis.spring3.controllerusageexample.customers.web;

import git.irbis.spring3.controllerusageexample.customers.repository.Customer;
import git.irbis.spring3.controllerusageexample.customers.repository.CustomersRepository;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexsey Nadtochey <A.Nadtochey@gmail.com>
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

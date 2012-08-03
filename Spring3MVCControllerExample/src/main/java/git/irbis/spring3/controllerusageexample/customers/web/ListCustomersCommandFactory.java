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

import git.irbis.spring3.controllerusageexample.customers.repository.CustomersRepository;
import org.springframework.util.StringUtils;

/**
 * <p>
 * A factory to create command class to process request from the list customers
 * controller. Request can specify lastname or lastname and firstname or can't 
 * have any additional parameters to show all customers. The factory parses
 * parameters and prepare a factory object to call method createCommand() to
 * create command class.
 * </p>
 * @see ListCustomersController
 * @author Alexsey Nadtochey <A.Nadtochey@gmail.com>
 */
class ListCustomersCommandFactory {
    private final String firstName;
    private final String lastName;

    private ListCustomersCommandFactory(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    static ListCustomersCommandFactory parseLastName(String lastName) {
        return new ListCustomersCommandFactory(null, lastName);
    }
    
    static ListCustomersCommandFactory parseFirstLastName(String firstName, 
            String lastName) {
        return new ListCustomersCommandFactory(
                StringUtils.hasLength(firstName) ? firstName : null,
                StringUtils.hasLength(lastName) ? lastName : null);
    }
    
    static ListCustomersCommandFactory instanceOf() {
        return new ListCustomersCommandFactory(null, null);
    }
    
    ListCustomersCommand createCommand(CustomersRepository customersRepository) {
        
        if (firstName == null && lastName != null)
            return new ListByLastNameCustomersCommand(customersRepository, 
                    lastName);

        if (firstName != null && lastName == null)
            return new ListByFirstNameCustomersCommand(
                    customersRepository, firstName);
        
        if (firstName != null && lastName != null)
            return new ListByFirstLastNameCustomersCommand(
                    customersRepository, firstName, lastName);
        
        return new ListAllCustomersCommand(customersRepository);
    }
}

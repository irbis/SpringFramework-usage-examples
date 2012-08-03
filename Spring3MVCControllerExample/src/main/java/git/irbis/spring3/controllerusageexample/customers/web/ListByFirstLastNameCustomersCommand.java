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
import java.util.List;

/**
 * <p>
 * A command to show list of customers whom firstname and lastname started from
 * values specified in the list customer controllers request.
 * </p>
 * @see ListCustomersController
 * @see ListCustomersCommandFactory
 * @author Alexsey Nadtochey <A.Nadtochey@gmail.com>
 */
class ListByFirstLastNameCustomersCommand extends ListCustomersCommand {
    private final String firstName;
    private final String lastName;

    public ListByFirstLastNameCustomersCommand(
            CustomersRepository customersRepository, String firstName, 
            String lastName) {
        super(customersRepository);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    protected List<Customer> find() {
        return customersRepository.findCustomerByFirstLastName(
                firstName, lastName);
    }
    
}

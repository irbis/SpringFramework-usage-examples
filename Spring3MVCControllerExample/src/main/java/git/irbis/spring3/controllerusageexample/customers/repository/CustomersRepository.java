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
package git.irbis.spring3.controllerusageexample.customers.repository;

import java.util.List;

/**
 *
 * @author Alexsey Nadtochey <A.Nadtochey@gmail.com>
 */
public interface CustomersRepository {
    public List<Customer> findAllCustomers();
    public Customer find(int customerId);

    public List<Customer> findCustomersByLastName(String lastName);
    public List<Customer> findCustomerByFirstName(String firstName);
    public List<Customer> findCustomerByFirstLastName(
            String firstName, String lastName);
}

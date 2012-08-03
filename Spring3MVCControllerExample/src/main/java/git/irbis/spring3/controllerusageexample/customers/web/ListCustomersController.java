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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * A controller to show list of customers. There are following URI's can
 * be used to show customers:
 * <ul>
 * <li>/listcustomers - to show full list of customers</li>
 * <li>/listcustomers/{lastName} - to show list of customers lastname started
 * entered</li>
 * <li>listcustomers?firstName={firstName}&lastName={lastName} - to show list
 * of customers started from entered firstname and lastname.
 * </ul>
 * </p>
 * @see ListCustomersCommandFactory
 * @see ListCustomersCommand
 * @author Alexsey Nadtochey <A.Nadtochey@gmail.com>
 */
@Controller
public class ListCustomersController {

    private final CustomersRepository customersRepository;

    public ListCustomersController(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @RequestMapping("/listcustomers")
    public ModelAndView listAllCustomers() {
        return ListCustomersCommandFactory.instanceOf().createCommand(
                customersRepository).execute();
    }

    @RequestMapping("/listcustomers/{lastName}")
    public ModelAndView listCustomersByLastnameInPath(
            @PathVariable String lastName) {
        return ListCustomersCommandFactory.parseLastName(
                lastName).createCommand(customersRepository).execute();
    }

    @RequestMapping(value="/listcustomers", params = {"firstName", "lastName"})
    public ModelAndView listCustomersByLastnameInParam(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName) {
        return ListCustomersCommandFactory.parseFirstLastName(firstName,
                lastName).createCommand(customersRepository).execute();
    }
}

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
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 * An abstract command class to process request from list customers controller.
 * </p>
 * @see ListCustomersController
 * @see ListCustomersCommandFactory
 * @author Alexsey Nadtochey <A.Nadtochey@gmail.com>
 */
abstract class ListCustomersCommand {
    
    private final String listCustomersViewName = "listcustomers";
    private final String listCustomersModelName = "customers";
    
    protected final CustomersRepository customersRepository;

    ListCustomersCommand(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }
    
    ModelAndView execute() {
        ModelAndView mv = new ModelAndView(listCustomersViewName);
        
        mv.addObject(listCustomersModelName, find());
        
        return mv;
    }
    
    protected abstract List<Customer> find();
}

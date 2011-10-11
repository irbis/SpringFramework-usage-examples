package git.irbis.spring3.controllerusageexample.customers.web;

import git.irbis.spring3.controllerusageexample.customers.repository.CustomersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author A.Nadtochey<irbis4lan@yahoo.ua>
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

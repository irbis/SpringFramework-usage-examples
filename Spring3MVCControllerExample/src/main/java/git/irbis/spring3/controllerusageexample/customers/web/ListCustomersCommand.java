package git.irbis.spring3.controllerusageexample.customers.web;

import git.irbis.spring3.controllerusageexample.customers.repository.Customer;
import git.irbis.spring3.controllerusageexample.customers.repository.CustomersRepository;
import java.util.List;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author irbis4lan@yandex.ua
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

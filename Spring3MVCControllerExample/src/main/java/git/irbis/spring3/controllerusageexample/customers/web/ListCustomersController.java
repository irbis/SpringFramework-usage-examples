package git.irbis.spring3.controllerusageexample.customers.web;

import git.irbis.spring3.controllerusageexample.customers.repository.CustomersRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ModelAndView listCustomers() {
        ModelAndView mv = new ModelAndView("listcustomers");
        
        mv.getModel().put("customers", customersRepository.findAllCustomers());
        
        return mv;
    }
}

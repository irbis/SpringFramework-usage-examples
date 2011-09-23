package git.irbis.springmvccommandclassusage.customer.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import git.irbis.springmvccommandclassusage.customer.impl.CustomerBO;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractFormController;
import org.springframework.web.servlet.view.RedirectView;

/**
 *
 * @author Alexsey Nadtochey<irbis4lan@yandex.ua>
 */
public class EditCustomerController extends AbstractFormController {
    
    private final CustomerCommandFactory customerCommandFactory;

    public EditCustomerController(CustomerBO customerBO) {
        this.customerCommandFactory = new CustomerCommandFactory(customerBO);
    }

    private int parseCustomerId(HttpServletRequest request) {
        int customerId = -1;
        
        try {
            customerId = Integer.parseInt(request.getParameter("customerid"));
        } catch (Exception e) {
        }
        
        return customerId;
    }
    
    @Override
    protected Object formBackingObject(HttpServletRequest request) 
            throws Exception {
        int customerId = parseCustomerId(request);
        
        switch (Action.instanceOf(request)) {
            case OK:
            case APPLY:
                return customerId == -1 ? 
                        customerCommandFactory.createCustomerCommandSaveCustomer() :
                        customerCommandFactory.createCustomerCommandSaveCustomer(customerId);
            default: // cancel button
                return customerId == -1 ?
                        customerCommandFactory.createCustomerCommandCancel() :
                        customerCommandFactory.createCustomerCommandCancel(customerId);
        }
    }

    @Override
    protected ModelAndView showForm(HttpServletRequest request, 
    HttpServletResponse response, BindException errors) throws Exception {
        return showForm(request, errors, "editcustomer");
    }

    @Override
    protected ModelAndView processFormSubmission(HttpServletRequest request, 
    HttpServletResponse response, Object command, BindException errors) 
            throws Exception {
        Action action = Action.instanceOf(request);
        switch (Action.instanceOf(request)) {
            case OK:
            case APPLY:
                if (errors.hasErrors())
                    return this.showForm(request, response, errors);
                else
                    return onSubmit(action, command);
            default: // cancel button
                return onSubmit(action, command);
        }
    }

    private ModelAndView onSubmit(Action action, Object command) {
        CustomerCommand customerCommand = (CustomerCommand) command;
        
        customerCommand.execute();
        switch (action) {
            case OK:
            case CANCEL:
                return new ModelAndView(new RedirectView("customerslist"));
            default: // apply button
                return new ModelAndView(new RedirectView("editcustomer"));
        }
    }
    
}

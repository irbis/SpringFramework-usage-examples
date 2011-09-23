package git.irbis.springmvccommandclassusage.customer.web;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.util.StringUtils;

/**
 *
 * @author Alexsey Nadtochey<irbis4lan@yandex.ua>
 */
public class CustomerValidator implements Validator {

    @Override
    public boolean supports(Class clazz) {
        return CustomerCommand.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerCommand customerCommand = (CustomerCommand) target;
        
        if (!StringUtils.hasLength(customerCommand.getFirstName()))
            errors.rejectValue("firstName", "customer.firstNameRequired",
                    "First name required");
        
        if (!StringUtils.hasLength(customerCommand.getLastName()))
            errors.rejectValue("lastName", "customer.lastNameRequired", 
                    "Last name required");
    }
    
}

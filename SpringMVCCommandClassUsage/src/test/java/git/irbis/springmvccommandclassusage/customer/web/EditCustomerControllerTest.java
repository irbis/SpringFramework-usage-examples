package git.irbis.springmvccommandclassusage.customer.web;

import java.util.ArrayList;
import java.util.List;
import git.irbis.springmvccommandclassusage.customer.impl.CustomerBO;
import org.irbis.springmvccommandclassusage.domainmodel.Customer;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import static org.junit.Assert.*;

/**
 *
 * @author Alexsey Nadtochey<irbis4lan@yandex.ua>
 */
public class EditCustomerControllerTest {
    
    private static class CustomerBOMockImpl implements CustomerBO {
        private final List<Customer> customers;
                
        public CustomerBOMockImpl() {
            customers = new ArrayList<Customer>();
        }

        public CustomerBOMockImpl(List<Customer> customers) {
            this.customers = customers;
        }

        @Override
        public Customer create(Customer customer) {
            this.customers.add(customer);
            return customer;
        }

        @Override
        public Customer find(int customerId) {
            Customer customer = new Customer();
            customer.setCustomerId(1);
            customer.setFirstName("firstName");
            customer.setLastName("lastName");
            customer.setAddress("address1");
            
            return customer;
        }

        @Override
        public void update(Customer customer) {
        }
    }
    
    private CustomerBO mockCustomerBO = new CustomerBOMockImpl();
    
    @Test
    public void createNewCustomerGetRequest() throws Exception {
        EditCustomerController editCustomerController = 
                new EditCustomerController(mockCustomerBO);
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        
        editCustomerController.setValidator(new CustomerValidator());
        
        request.setMethod("GET");
        
        ModelAndView mv = editCustomerController.handleRequest(request, response);
        
        assertNotNull(mv);
        Object command = mv.getModel().get("command");
        assertNotNull(command);
        assertTrue(command instanceof CustomerCommandCancel);
        
        CustomerCommandCancel commandCancel = (CustomerCommandCancel) command;
        assertNotNull(commandCancel.getFirstName());
        assertNotNull(commandCancel.getLastName());
        assertNotNull(commandCancel. getAddress());
    }
    
    @Test
    public void createNewCustomerPostRequest() throws Exception {
        List<Customer> customers = new ArrayList<Customer>();
        EditCustomerController editCustomerController = 
                new EditCustomerController(new CustomerBOMockImpl(customers));
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        editCustomerController.setValidator(new CustomerValidator());
        
        request.setMethod("POST");
        request.setParameter("firstName", "firstName1");
        request.setParameter("lastName", "lastName1");
        request.setParameter("address", "address1");
        request.setParameter("ok", "ok");
        
        ModelAndView mv = editCustomerController.handleRequest(request, response);
        assertNotNull(mv);
        assertTrue(mv.getView() instanceof RedirectView);
        
        assertEquals(1, customers.size());
        Customer customer = customers.get(0);
        assertEquals("firstName1", customer.getFirstName());
        assertEquals("lastName1", customer.getLastName());
        assertEquals("address1", customer.getAddress());
    }

    @Test
    public void showCustomerGetRequest() throws Exception {
        EditCustomerController editCustomerController = 
                new EditCustomerController(mockCustomerBO);
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        editCustomerController.setValidator(new CustomerValidator());
        
        request.setMethod("GET");
        request.setParameter("customerid", Integer.toString(1));
        
        ModelAndView mv = editCustomerController.handleRequest(request, response);
        
        assertNotNull(mv);
        Object command = mv.getModel().get("command");
        assertNotNull(command);
        assertTrue(command instanceof CustomerCommandCancel);
        
        CustomerCommandCancel commandCancel = (CustomerCommandCancel) command;
        assertEquals("firstName", commandCancel.getFirstName());
        assertEquals("lastName", commandCancel.getLastName());
        assertEquals("address1", commandCancel. getAddress());
    }

    @Test
    public void createNewCustomerFirstNameValidatorCheck() throws Exception {
        EditCustomerController editCustomerController = 
                new EditCustomerController(mockCustomerBO);
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        editCustomerController.setValidator(new CustomerValidator());
        
        request.setMethod("POST");
        request.setParameter("firstName", "");
        request.setParameter("lastName", "lastName1");
        request.setParameter("address", "address1");
        request.setParameter("ok", "ok");
        
        ModelAndView mv = editCustomerController.handleRequest(request, response);
        assertNotNull(mv);
        
        assertNotNull(mv.getModel().get("command"));
        assertTrue(mv.getModel().get("command") instanceof CustomerCommandSaveCustomer);

        assertNotNull(mv.getModel().get(BindingResult.class.getName() + ".command"));
        BeanPropertyBindingResult bindingResult = (BeanPropertyBindingResult)
                mv.getModel().get(BindingResult.class.getName() + ".command");
        assertNotNull(bindingResult.getFieldError("firstName"));
        assertNull(bindingResult.getFieldError("lastName"));
        assertNull(bindingResult.getFieldError("address"));
        
        FieldError firstNameFieldError = bindingResult.getFieldError("firstName");
        assertEquals("customer.firstNameRequired", firstNameFieldError.getCode());
    }
    
    @Test
    public void createNewCustomerLastNameValidatorCheck() throws Exception {
        EditCustomerController editCustomerController = 
                new EditCustomerController(mockCustomerBO);
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        editCustomerController.setValidator(new CustomerValidator());
        
        request.setMethod("POST");
        request.setParameter("firstName", "firstName1");
        request.setParameter("lastName", "");
        request.setParameter("address", "address1");
        request.setParameter("ok", "ok");
        
        ModelAndView mv = editCustomerController.handleRequest(request, response);
        assertNotNull(mv);
        
        assertNotNull(mv.getModel().get("command"));
        assertTrue(mv.getModel().get("command") instanceof CustomerCommandSaveCustomer);

        assertNotNull(mv.getModel().get(BindingResult.class.getName() + ".command"));
        BeanPropertyBindingResult bindingResult = (BeanPropertyBindingResult)
                mv.getModel().get(BindingResult.class.getName() + ".command");
        assertNull(bindingResult.getFieldError("firstName"));
        assertNotNull(bindingResult.getFieldError("lastName"));
        assertNull(bindingResult.getFieldError("address"));
        
        FieldError lastNameFieldError = bindingResult.getFieldError("lastName");
        assertEquals("customer.lastNameRequired", lastNameFieldError.getCode());
    }

    @Test
    public void createNewCustomerFirstLastNameValidatorCheck() throws Exception {
        EditCustomerController editCustomerController = 
                new EditCustomerController(mockCustomerBO);
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        editCustomerController.setValidator(new CustomerValidator());
        
        request.setMethod("POST");
        request.setParameter("firstName", "");
        request.setParameter("lastName", "");
        request.setParameter("address", "address1");
        request.setParameter("ok", "ok");
        
        ModelAndView mv = editCustomerController.handleRequest(request, response);
        assertNotNull(mv);
        
        assertNotNull(mv.getModel().get("command"));
        assertTrue(mv.getModel().get("command") instanceof CustomerCommandSaveCustomer);

        assertNotNull(mv.getModel().get(BindingResult.class.getName() + ".command"));
        BeanPropertyBindingResult bindingResult = (BeanPropertyBindingResult)
                mv.getModel().get(BindingResult.class.getName() + ".command");
        assertNotNull(bindingResult.getFieldError("firstName"));
        assertNotNull(bindingResult.getFieldError("lastName"));
        assertNull(bindingResult.getFieldError("address"));
        
        FieldError firstNameFieldError = bindingResult.getFieldError("firstName");
        assertEquals("customer.firstNameRequired", firstNameFieldError.getCode());
        FieldError lastNameFieldError = bindingResult.getFieldError("lastName");
        assertEquals("customer.lastNameRequired", lastNameFieldError.getCode());
    }

    @Test
    public void createNewCustomerFirstLastNameValidatorCancelAction() throws Exception {
        EditCustomerController editCustomerController = 
                new EditCustomerController(mockCustomerBO);
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();

        editCustomerController.setValidator(new CustomerValidator());
        
        request.setMethod("POST");
        request.setParameter("firstName", "");
        request.setParameter("lastName", "");
        request.setParameter("address", "address1");
        request.setParameter("cancel", "cancel");
        
        ModelAndView mv = editCustomerController.handleRequest(request, response);
        assertNotNull(mv);
        assertTrue(mv.getView() instanceof RedirectView);
    }
    
}

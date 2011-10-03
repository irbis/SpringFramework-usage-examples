package git.irbis.spring3.controllerusageexample.customers.web;

import git.irbis.spring3.controllerusageexample.customers.repository.Customer;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.ModelAndViewAssert;
import static org.junit.Assert.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

/**
 *
 * @author A.Nadtochey <irbis4lan@yandex.ua>
 */
public class ListCustomersControllerTest {
    
    public ListCustomersControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of listCustomers method, of class ListCustomersController.
     */
    @Test
    public void testListCustomers() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        ListCustomersController listCustomersController = 
                new ListCustomersController(new CustomerRepositoryMockImpl());
        request.setMethod("GET");
        request.setRequestURI("/listcustomers");
        
        try {
            ModelAndView mv = new AnnotationMethodHandlerAdapter().handle(
                    request, response, listCustomersController);
            
            ModelAndViewAssert.assertViewName(mv, "listcustomers");
            List<Customer> customers = (List<Customer>) mv.getModel().get(
                    "customers");
            
            assertNotNull(customers);
            assertEquals(5, customers.size());
        } catch (Exception ex) {
            fail();
        }
    }
}

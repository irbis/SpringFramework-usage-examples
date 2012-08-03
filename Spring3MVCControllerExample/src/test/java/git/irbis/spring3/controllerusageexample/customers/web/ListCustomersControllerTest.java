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
 * <p>
 * JUnit tests to validate ListCustomerController functionality.
 * </p>
 * @see ListCustomersController
 * @author Alexsey Nadtochey <A.Nadtochey@gmail.com>
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
     * Test of request: show all customers.
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
    
    /**
     * Test of request: show customers started from lastname, result success.
     */
    @Test
    public void testListCustomersByLastNameSuccess() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        ListCustomersController listCustomersController = 
                new ListCustomersController(new CustomerRepositoryMockImpl());
        request.setMethod("GET");
        request.setRequestURI("/listcustomers/last");
        
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
    
    /**
     * Test of request: show customers by lastname, result failure.
     */
    @Test
    public void testListCustomersByLastNameFailure() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        ListCustomersController listCustomersController = 
                new ListCustomersController(new CustomerRepositoryMockImpl());
        request.setMethod("GET");
        request.setRequestURI("/listcustomers/first");
        
        try {
            ModelAndView mv = new AnnotationMethodHandlerAdapter().handle(
                    request, response, listCustomersController);
            
            ModelAndViewAssert.assertViewName(mv, "listcustomers");
            List<Customer> customers = (List<Customer>) mv.getModel().get(
                    "customers");
            
            assertNotNull(customers);
            assertTrue(customers.isEmpty());
        } catch (Exception ex) {
            fail();
        }
    }

    /**
     * Test of request: show customers by lastname, result success.
     */
    @Test
    public void testFindCustomerByLastNameSuccess() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        ListCustomersController listCustomersController = 
                new ListCustomersController(new CustomerRepositoryMockImpl());
        request.setMethod("GET");
        request.setRequestURI("/listcustomers/lastname2");
        
        try {
            ModelAndView mv = new AnnotationMethodHandlerAdapter().handle(
                    request, response, listCustomersController);
            
            ModelAndViewAssert.assertViewName(mv, "listcustomers");
            List<Customer> customers = (List<Customer>) mv.getModel().get(
                    "customers");
            
            assertNotNull(customers);
            assertEquals(1, customers.size());
        } catch (Exception ex) {
            fail();
        }
    }
    
    /**
     * Test of request: show customers started from firstname, result success.
     */
    @Test
    public void testListCustomersByFirstNameSuccess() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        ListCustomersController listCustomersController = 
                new ListCustomersController(new CustomerRepositoryMockImpl());
        request.setMethod("GET");
        request.setRequestURI("/listcustomers");
        request.setParameter("firstName", "first");
        request.setParameter("lastName", "");
        
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

    /**
     * Test of request: show customer by fistname, result success.
     */
    @Test
    public void testFindCustomerByFirstNameSuccess() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        ListCustomersController listCustomersController = 
                new ListCustomersController(new CustomerRepositoryMockImpl());
        request.setMethod("GET");
        request.setRequestURI("/listcustomers");
        request.setParameter("firstName", "firstname1");
        request.setParameter("lastName", "");
        
        try {
            ModelAndView mv = new AnnotationMethodHandlerAdapter().handle(
                    request, response, listCustomersController);
            
            ModelAndViewAssert.assertViewName(mv, "listcustomers");
            List<Customer> customers = (List<Customer>) mv.getModel().get(
                    "customers");
            
            assertNotNull(customers);
            assertEquals(1, customers.size());
        } catch (Exception ex) {
            fail();
        }
    }
    
    /**
     * Test of request: show customers by firstname, result failure.
     */
    @Test
    public void testListCustomersByFirstNameFailure() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        ListCustomersController listCustomersController = 
                new ListCustomersController(new CustomerRepositoryMockImpl());
        request.setMethod("GET");
        request.setRequestURI("/listcustomers");
        request.setParameter("firstName", "last");
        request.setParameter("lastName", "");
        
        try {
            ModelAndView mv = new AnnotationMethodHandlerAdapter().handle(
                    request, response, listCustomersController);
            
            ModelAndViewAssert.assertViewName(mv, "listcustomers");
            List<Customer> customers = (List<Customer>) mv.getModel().get(
                    "customers");
            
            assertNotNull(customers);
            assertTrue(customers.isEmpty());
        } catch (Exception ex) {
            fail();
        }
    }

    /**
     * Test of request: show customers started from firstname and lastname, 
     * result success.
     */
    @Test
    public void testListCustomersByFirstLastNameSuccess() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        ListCustomersController listCustomersController = 
                new ListCustomersController(new CustomerRepositoryMockImpl());
        request.setMethod("GET");
        request.setRequestURI("/listcustomers");
        request.setParameter("firstName", "first");
        request.setParameter("lastName", "last");
        
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

    /**
     * Test of request: show customers by firstname lastname, result failure.
     */
    @Test
    public void testListCustomersByFirstLastNameFailure() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        MockHttpServletResponse response = new MockHttpServletResponse();
        ListCustomersController listCustomersController = 
                new ListCustomersController(new CustomerRepositoryMockImpl());
        request.setMethod("GET");
        request.setRequestURI("/listcustomers");
        request.setParameter("firstName", "fr");
        request.setParameter("lastName", "last");
        
        try {
            ModelAndView mv = new AnnotationMethodHandlerAdapter().handle(
                    request, response, listCustomersController);
            
            ModelAndViewAssert.assertViewName(mv, "listcustomers");
            List<Customer> customers = (List<Customer>) mv.getModel().get(
                    "customers");
            
            assertNotNull(customers);
            assertTrue(customers.isEmpty());
        } catch (Exception ex) {
            fail();
        }
    }
    
}

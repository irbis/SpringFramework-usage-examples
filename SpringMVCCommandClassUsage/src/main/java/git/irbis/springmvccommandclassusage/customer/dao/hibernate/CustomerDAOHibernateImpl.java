package git.irbis.springmvccommandclassusage.customer.dao.hibernate;

import git.irbis.springmvccommandclassusage.customer.dao.CustomerDAO;
import org.irbis.springmvccommandclassusage.domainmodel.Customer;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 *
 * @author Alexsey Nadtochey<irbis4lan@yandex.ua>
 */
public class CustomerDAOHibernateImpl extends HibernateDaoSupport 
implements CustomerDAO {
    @Override
    public Customer find(int customerId) {
        return (Customer) getHibernateTemplate().get(Customer.class, customerId);
    }
    
    @Override
    public void update(Customer customer) {
        getHibernateTemplate().update(customer);
    }
    
    @Override
    public Customer create(Customer customer) {
        getHibernateTemplate().save(customer);
        return customer;
    }
}

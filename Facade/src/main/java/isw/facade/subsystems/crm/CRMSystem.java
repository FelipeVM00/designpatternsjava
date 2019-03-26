package isw.facade.subsystems.crm;

import isw.facade.util.Customer;
import isw.facade.util.OnMemoryDataBase;

public class CRMSystem {
    
    public Customer findCustomer(Long customerId){
        return OnMemoryDataBase.findCustomerById(customerId);
    }
}
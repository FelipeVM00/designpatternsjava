package isw.facade.subsystems.biller;

import isw.facade.util.Customer;
import isw.facade.util.OnMemoryDataBase;

public class BillingSystem {

    public double queryCustomerBalance(Long customerId) {
        Customer customer = OnMemoryDataBase.findCustomerById(customerId);
        return customer.getBalance();
    }

    public double pay(BillingPayRequest billingPay) {
        Customer customer = OnMemoryDataBase.findCustomerById(billingPay.getCustomerId());
        customer.setBalance(customer.getBalance() - billingPay.getAmount());
        System.out.println("Pago aplicado al cliente '"+customer.getName()+"', "
                + "el nuevo saldo es '"+customer.getBalance()+"'");
        return customer.getBalance();//new Balance.
    }
}
package isw.adapter;

import isw.adapter.impl.BankCreditRequest;
import isw.adapter.impl.BankCreditResponse;
import isw.adapter.impl.IBankAdapter;
import isw.adapter.impl.XBankCreditAdapter;
import isw.adapter.impl.YBankCreditAdapter;
import isw.adapter.impl.ZBankCreditAdapter;

public class AdapterMain {

    public static void main(String[] args) {
        //Request generico para las dos API's
        BankCreditRequest request = new BankCreditRequest();
        request.setCustomer("Pedro Perez");
        request.setAmount(1600);

        IBankAdapter xBank = new XBankCreditAdapter();
        BankCreditResponse xresponse = xBank.sendCreditRequest(request);
        System.out.println("xBank approved > " + xresponse.isApproved() + "\n");

        IBankAdapter yBank = new YBankCreditAdapter();
        BankCreditResponse yresponse = yBank.sendCreditRequest(request);
        System.out.println("yBank approved > " + yresponse.isApproved() + "\n");
        
        IBankAdapter zBank = new ZBankCreditAdapter();
        BankCreditResponse zresponse = zBank.sendCreditRequest(request);
        System.out.println("zBank approved > " + zresponse.isApproved() + "\n");

        if (xresponse.isApproved()) {
            System.out.println("xBank aprobo su credito, felicidades!");
        } else if (yresponse.isApproved()) {
            System.out.println("yBank aprobo su credito, felicidades!");
        } else if (zresponse.isApproved()) {
        	System.out.println("zBank aprobo su credito, felicidades!");
        } else {
            System.out.println("Lo sentimos su credito no ha sido aprobado.");
        }
    }
}
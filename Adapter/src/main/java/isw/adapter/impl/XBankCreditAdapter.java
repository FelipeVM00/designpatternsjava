package isw.adapter.impl;

import isw.adapter.creditapi.bankx.XBankCreditAPI;
import isw.adapter.creditapi.bankx.XBankCreditRequest;
import isw.adapter.creditapi.bankx.XBankCreditResponse;

public class XBankCreditAdapter implements IBankAdapter{

    @Override
    public BankCreditResponse sendCreditRequest(BankCreditRequest request) {
        
        XBankCreditRequest xrequest = new XBankCreditRequest();
        xrequest.setCustomerName(request.getCustomer());
        xrequest.setRequestAmount(request.getAmount());
        
        XBankCreditAPI api = new XBankCreditAPI();
        XBankCreditResponse xresponse = api.sendCreditRequest(xrequest);
        
        BankCreditResponse response = new BankCreditResponse();
        response.setApproved(xresponse.isAproval());
        return response;
    }
}
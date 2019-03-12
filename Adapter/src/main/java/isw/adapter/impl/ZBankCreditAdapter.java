package isw.adapter.impl;

import isw.adapter.creditapi.bankz.ZBankCreditAPI;
import isw.adapter.creditapi.bankz.ZBankCreditRequest;
import isw.adapter.creditapi.bankz.ZBankCreditResponse;

public class ZBankCreditAdapter implements IBankAdapter{
	 @Override
	    public BankCreditResponse sendCreditRequest(BankCreditRequest request) {
	        
	        ZBankCreditRequest zrequest = new ZBankCreditRequest();
	        zrequest.setCustomerName(request.getCustomer());
	        zrequest.setRequestAmount(request.getAmount());
	        
	        ZBankCreditAPI api = new ZBankCreditAPI();
	        ZBankCreditResponse zresponse = api.sendCreditRequest(zrequest);
	        
	        BankCreditResponse response = new BankCreditResponse();
	        response.setApproved(zresponse.isAproval());
	        return response;
	    }

}

package isw.adapter.creditapi.bankz;

public class ZBankCreditAPI {
    
    public ZBankCreditResponse sendCreditRequest(ZBankCreditRequest request){
        ZBankCreditResponse response =new ZBankCreditResponse();
        if(request.getRequestAmount()<= 1000){
            response.setAproval(true);
        }else{
            try {
				throw new ZBankCreditException("El credito no fue aprobado.");
			} catch (ZBankCreditException e) {
				e.printStackTrace();
			}
        }
        return response;
    }
}
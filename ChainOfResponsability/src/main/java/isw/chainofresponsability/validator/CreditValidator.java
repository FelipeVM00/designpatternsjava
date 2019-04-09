package isw.chainofresponsability.validator;

import isw.chainofresponsability.domain.CreditData;
import isw.chainofresponsability.domain.order.AbstractOrder;

public class CreditValidator extends AbstractOrderValidator{

    @Override
    public void validate(AbstractOrder order)throws ValidationException {
        double total = order.getTotal();
        CreditData creditData = order.getContributor().getCreditData();
        double newBalance = creditData.getBalance() + total;
        if(newBalance > creditData.getCreditLimit()){
            throw new ValidationException("El monto de la orden excede el "
                    + "límite de crédito disponible");
        }
    }
}
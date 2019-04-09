package isw.chainofresponsability.validator;

import isw.chainofresponsability.domain.order.AbstractOrder;
import isw.chainofresponsability.domain.order.SalesOrder;

public class SalesOrderValidator extends AbstractOrderValidator {

    @Override
    public void validate(AbstractOrder order) throws ValidationException {
        if (!(order instanceof SalesOrder)) {
            throw new ValidationException("Se esperaba una orden de Venta");
        }

        for(AbstractOrderValidator validator : validators){
            validator.validate(order);
        }
    }
}

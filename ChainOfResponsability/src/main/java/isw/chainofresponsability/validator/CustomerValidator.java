package isw.chainofresponsability.validator;

import isw.chainofresponsability.domain.Customer;
import isw.chainofresponsability.domain.order.AbstractOrder;

public class CustomerValidator extends AbstractOrderValidator{
    
    @Override
    public void validate(AbstractOrder order) throws ValidationException{
        for(AbstractOrderValidator validator : validators){
            validator.validate(order);
        }
        
        if(!(order.getContributor() instanceof Customer)){
            throw new ValidationException("El contribuyente no es un cliente");
        }
    }
}
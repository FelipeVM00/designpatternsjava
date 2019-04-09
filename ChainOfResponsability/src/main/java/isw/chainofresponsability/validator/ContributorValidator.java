package isw.chainofresponsability.validator;

import isw.chainofresponsability.domain.Contributor;
import isw.chainofresponsability.domain.Status;
import isw.chainofresponsability.domain.order.AbstractOrder;

public class ContributorValidator extends AbstractOrderValidator{
    
    @Override
    public void validate(AbstractOrder order) throws ValidationException {
        for(AbstractOrderValidator validator : validators){
            validator.validate(order);
        }
        Contributor contributor = order.getContributor();
        if(Status.ACTIVO != contributor.getStatus()){
            throw new ValidationException("El contribuyente no está activo");
        }
    }
}

package isw.chainofresponsability.validator;

import java.util.ArrayList;
import java.util.List;

import isw.chainofresponsability.domain.order.AbstractOrder;

public abstract class AbstractOrderValidator {
    
    protected List<AbstractOrderValidator> validators = new ArrayList<>();
    
    public abstract void validate(AbstractOrder order) throws ValidationException;
    
    public void addValidator(AbstractOrderValidator validator){
        validators.add(validator);
    }
}

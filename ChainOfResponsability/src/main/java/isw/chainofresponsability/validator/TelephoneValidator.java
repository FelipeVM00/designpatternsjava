package isw.chainofresponsability.validator;

import isw.chainofresponsability.domain.Telephone;
import isw.chainofresponsability.domain.order.AbstractOrder;

public class TelephoneValidator extends AbstractOrderValidator{

    @Override
    public void validate(AbstractOrder order) throws ValidationException{
        Telephone tel = order.getContributor().getTelephone();
        if(null == tel){
            throw new ValidationException(
                    "El teléfono del contribuyente es obligatorio");
        }else if(tel.getNumber().length()!= 7){
            throw new ValidationException("Número de teléfono inválido");
        }else if(tel.getLada().length()!=3){
            throw new ValidationException("Lada inválida");
        }
    }
}

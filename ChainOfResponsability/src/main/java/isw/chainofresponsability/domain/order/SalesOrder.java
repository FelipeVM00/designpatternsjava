package isw.chainofresponsability.domain.order;

import java.util.Calendar;

public class SalesOrder extends AbstractOrder{
    protected Calendar deliveryDate;

    public Calendar getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Calendar deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    
}

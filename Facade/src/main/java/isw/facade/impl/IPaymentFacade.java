package isw.facade.impl;

public interface IPaymentFacade {
    public PaymentResponse pay(PaymentRequest paymentRequest)throws GeneralPaymentError;
}
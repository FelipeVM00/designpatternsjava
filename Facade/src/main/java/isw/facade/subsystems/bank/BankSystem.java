package isw.facade.subsystems.bank;

import java.util.UUID;

import isw.facade.impl.GeneralPaymentError;
import isw.facade.util.OnMemoryDataBase;

public class BankSystem {

    public String transfer(TransferRequest request) throws GeneralPaymentError {
        String cardNumerPrefix = request.getCardNumber().substring(0, 3);
        if (!OnMemoryDataBase.validateCardBins(cardNumerPrefix)) {
            throw new GeneralPaymentError("Tarjeta invalida.");
        }
        String cardCompany = OnMemoryDataBase.getCardCompany(cardNumerPrefix);
        if ("AMEX".equals(cardCompany) && request.getCardNumber().length() != 15) {
            throw new GeneralPaymentError("El numero de la tarjeta es invalido");
        } else if (("VISA".equals(cardCompany) || "MASTERCARD".equals(cardCompany))
                && request.getCardNumber().length() != 16) {
            throw new GeneralPaymentError("El numero de la tarjeta es invalido");
        }
        String number = request.getCardNumber();
        String cardNumerSubfix = number.substring(number.length()-4, number.length());
        System.out.println("Se ha realizado un cargo al cliente '"
                + request.getCardName() + "' \n"
                + "\tpor el monto de '" + request.getAmmount() + "' a la tarjeta "
                + "terminacion '"+cardNumerSubfix+"'.\n");
        
        return UUID.randomUUID().toString();
    }
}
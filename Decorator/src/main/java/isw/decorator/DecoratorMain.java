package isw.decorator;

import isw.decorator.impl.decorators.EncryptMessage;
import isw.decorator.impl.decorators.SOAPEnvelopMessage;
import isw.decorator.impl.decorators.XMLFormatterDecorate;
import isw.decorator.impl.message.CustomerMessage;
import isw.decorator.impl.message.IMessage;

public class DecoratorMain {

    public static void main(String[] args) {
        
        CustomerMessage customerMessage = new CustomerMessage(
                "Pedro Perez", "pedroperez123@gmail.com", "0375342756");
        System.out.println("Original Message ==> " + customerMessage);
        
        IMessage message1 = new EncryptMessage("usuario", "HG58YZ3CR9123456", 
                new SOAPEnvelopMessage(
                    new XMLFormatterDecorate(customerMessage))).processMessage();
        System.out.println("message1 =====================================>\n" 
                + message1.getContent() + "\n\n");
        
        IMessage message2 = new SOAPEnvelopMessage(
                new EncryptMessage("usuario", "HG58YZ3CR9123456",
                    new XMLFormatterDecorate(customerMessage))).processMessage();
        System.out.println("message2 =====================================>\n" 
                + message2.getContent());
    }
    
}
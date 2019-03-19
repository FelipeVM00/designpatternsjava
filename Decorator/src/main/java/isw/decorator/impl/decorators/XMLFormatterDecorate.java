package isw.decorator.impl.decorators;

import java.io.ByteArrayOutputStream;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;

import isw.decorator.impl.message.IMessage;
import isw.decorator.impl.message.TextMessage;

public class XMLFormatterDecorate extends MessageDecorator {

    public XMLFormatterDecorate(IMessage message) {
        super(message);
    }

    @Override
    public IMessage processMessage() {
        message = message.processMessage();
        message = xmlMessage();
        return message;
    }

    private IMessage xmlMessage() {
        try {
            JAXBContext jc = JAXBContext.newInstance(message.getClass());
            JAXBElement<IMessage> je2 = new JAXBElement<IMessage>(new QName(message.getClass().getName()), (Class<IMessage>) message.getClass(), message);
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            marshaller.marshal(je2, output);
            return new TextMessage(new String(output.toByteArray()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error al convertir el XML");
        }
    }
}
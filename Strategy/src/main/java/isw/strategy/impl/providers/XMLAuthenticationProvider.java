package isw.strategy.impl.providers;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;

import isw.strategy.impl.IAuthenticationStrategy;
import isw.strategy.impl.Principal;

public class XMLAuthenticationProvider implements IAuthenticationStrategy {

    private static final String rolXPath = "Users/User[@userName='%s' and @password='%s']/@rol";
    
    @Override
    public Principal authenticate(String userName, String passwrd) {
        InputStream file = null;
        try {
            file = getClass().getResourceAsStream("/META-INF/UserFile.xml");
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document xmlDocument = builder.parse(file);
            XPath xPath = XPathFactory.newInstance().newXPath();
            
            String xpath = String.format(rolXPath, userName,passwrd);
            String rol = xPath.compile(xpath).evaluate(xmlDocument);
            if(rol!=null && !rol.isEmpty()){
                return new Principal(userName, rol);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try { file.close(); } catch (IOException ex) {}
        }
    }
}
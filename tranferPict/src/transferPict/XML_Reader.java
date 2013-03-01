/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transferPict;

import java.io.BufferedReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author d.fedorov
 */
public class XML_Reader {

    public  XML_Reader() throws IOException {

        try {
            URL url = new URL("http://posuda-moll.ru/shop/xml_products_without_photo");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            //File file = new File("http://posuda-moll.ru/shop/xml_products_without_photo");
            JAXBContext jaxbContext = JAXBContext.newInstance(rss.class);
            
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            rss item = (rss) jaxbUnmarshaller.unmarshal(reader);

            System.out.println("Customer: " + item.getName()
                    + "(id='" + item.getId()
                    + "',name='" + item.getName()
                    + "',name='" + item.getSiteLarge()
                    + "',name='" + item.getSiteSmall()
                    + "',name='" + item.getSupplierLarge()
                    + "',name='" + item.getSupplierSmall()
                    + "',name='" + item.getUrl()
                    + "')");
        } catch (JAXBException jaxbe) {
            System.out.println(jaxbe.getLocalizedMessage());
            jaxbe.printStackTrace();
        } catch (MalformedURLException ex) {
            Logger.getLogger(XML_Reader.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

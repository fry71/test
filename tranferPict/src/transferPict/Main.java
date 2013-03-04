/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transferPict;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.File;
import java.io.InputStreamReader;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import org.w3c.dom.Element;

import org.w3c.dom.Node;

import org.w3c.dom.NodeList;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception{
        try {
 URL url = new URL("http://posuda-moll.ru/shop/xml_products_without_photo");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            File file = new File("c:\\MyXMLFile.xml");

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc;
            doc = db.parse(url.openStream());

            doc.getDocumentElement().normalize();

            System.out.println("Root element " + doc.getDocumentElement().getNodeName());

            NodeList nodeLst = doc.getElementsByTagName("product");

            System.out.println(nodeLst.getLength());



            for (int s = 0; s < nodeLst.getLength(); s++) {



                Node fstNode = nodeLst.item(s);


                
                if (fstNode.getNodeType() == Node.ELEMENT_NODE) {

                    

                    Element fstElmnt = (Element) fstNode;
                    NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("photo_supplier_large");
                    Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
                    NodeList fstNm = fstNmElmnt.getChildNodes();
                    System.out.println("First Name : " + ((Node) fstNm.item(0)).getNodeValue());

                    NodeList lstNmElmntLst = fstElmnt.getElementsByTagName("url");

                    Element lstNmElmnt = (Element) lstNmElmntLst.item(0);

                    NodeList lstNm = lstNmElmnt.getChildNodes();

                    System.out.println("Last Name : " + ((Node) lstNm.item(0)).getNodeValue());
                    
                    

                }



            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}

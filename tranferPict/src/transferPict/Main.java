/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transferPict;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import javax.imageio.ImageIO;

import javax.xml.parsers.DocumentBuilder;

import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import org.w3c.dom.Element;

import org.w3c.dom.Node;

import org.w3c.dom.NodeList;

public class Main {

    public static String ConfUrl;
    public static int BigW;
    public static int BigH;
    public static int SmallW;
    public static int SmallH;
    public static String path;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        String tmp = null;
        String[] params = null;
        try (Scanner in = new Scanner(new File("config.txt"))) {
            while (in.hasNext()) {
                tmp += in.nextLine();
            }

            params = tmp.split(";");
        } catch (IOException e) {
            System.out.println(e);
        }
        ConfUrl = params[0];
        BigW = Integer.getInteger(params[1]);
        SmallW = Integer.getInteger(params[2]);
        path = params[3];

        try {

            URL url = new URL(ConfUrl);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            //File file = new File("c:\\MyXMLFile.xml");

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
                    // System.out.println("First Name : " + ((Node) fstNm.item(0)).getNodeValue());

                    NodeList lstNmElmntLst = fstElmnt.getElementsByTagName("url");

                    Element lstNmElmnt = (Element) lstNmElmntLst.item(0);

                    NodeList lstNm = lstNmElmnt.getChildNodes();

                    // System.out.println("Last Name : " + ((Node) lstNm.item(0)).getNodeValue());

                    getImageById(((fstNm.item(0)).getNodeValue()).toString(), (((Node) lstNm.item(0)).getNodeValue()).toString());

                }



            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public static boolean getImageById(String path, String name) {



        try {
//           
            BufferedImage buffimg = null;
            URL url = new URL(path);
            buffimg = ImageIO.read(url);
            //BufferedImage buffimg = BufferedImage.getGraphics().drawImage(image3, 0 , 0, null);
            boolean mkdirs;
            File large = new File(path + "/large/");
            large.mkdirs();
            File small = new File(path + "/small/");
            small.mkdirs();
            Image image;
            image = buffimg.getScaledInstance(BigW, -1, Image.SCALE_REPLICATE);
            BufferedImage buffered = new BufferedImage(image.getWidth(null),
                    image.getHeight(null),
                    BufferedImage.TYPE_INT_RGB);
            buffered.getGraphics().drawImage(image, 0, 0, null);
            FileOutputStream fos = new FileOutputStream(large + name + ".jpg");
            ImageIO.write(buffimg, "jpg", fos);

            Image image2;
            image2 = buffimg.getScaledInstance(SmallW, -1, Image.SCALE_AREA_AVERAGING);
            BufferedImage buffered2 = new BufferedImage(image2.getWidth(null),
                    image2.getHeight(null),
                    BufferedImage.TYPE_INT_RGB);
            buffered2.getGraphics().drawImage(image2, 0, 0, null);
            FileOutputStream fos2 = new FileOutputStream(small + name + ".jpg");
            ImageIO.write(buffered2, "jpg", fos2);


        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return true;
    }
}

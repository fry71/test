/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transferPict;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author d.fedorov
 */
public class XML {
     
    
    private int id;
    private String url;
    private String name;
    private String supplierLarge;
    private String supplierSmall;
    private String siteLarge;
    private String siteSmall;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSupplierLarge() {
        return supplierLarge;
    }

    public void setSupplierLarge(String supplierLarge) {
        this.supplierLarge = supplierLarge;
    }

    public String getSupplierSmall() {
        return supplierSmall;
    }

    public void setSupplierSmall(String supplierSmall) {
        this.supplierSmall = supplierSmall;
    }

    public String getSiteLarge() {
        return siteLarge;
    }

    public void setSiteLarge(String siteLarge) {
        this.siteLarge = siteLarge;
    }

    public String getSiteSmall() {
        return siteSmall;
    }

    public void setSiteSmall(String siteSmall) {
        this.siteSmall = siteSmall;
    }
    
}

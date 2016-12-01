/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.tecmilenio.taller.prod.bean;

import java.util.ArrayList;
import java.util.List;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Osvaldo Ignacio Rios Zambrano
 */
public class ElementDataBean {
    private Long productID;
    private String shortModNum;
    private String nameElementSMN;
    private List<String> listAttrSMN;
    private String unifiedModNum;
    private String nameElementUMN;
    private List<String> listAttrUMN;
    private String catalogName;
    private String nameElementCN;
    private List<String> listAttrCN;
    private String language;
    private String created;
    private String featuresXml;
    private List<String> listFeatures;
    private String shortFeatureTitle;
    private String shortFeatureDescription;
    private List<String> listShortFeaturesDesc;
    
    public ElementDataBean(){
        
    }

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public String getShortModNum() {
        return shortModNum;
    }

    public void setShortModNum(String shortModNum) {
        this.shortModNum = shortModNum;
    }

    public String getNameElementSMN() {
        return nameElementSMN;
    }

    public void setNameElementSMN(String nameElementSMN) {
        this.nameElementSMN = nameElementSMN;
    }

    public List<String> getListAttrSMN() {
        return listAttrSMN;
    }

    public void setListAttrSMN(List<String> listAttrSMN) {
        this.listAttrSMN = listAttrSMN;
    }

    public String getUnifiedModNum() {
        return unifiedModNum;
    }

    public void setUnifiedModNum(String unifiedModNum) {
        this.unifiedModNum = unifiedModNum;
    }

    public String getNameElementUMN() {
        return nameElementUMN;
    }

    public void setNameElementUMN(String nameElementUMN) {
        this.nameElementUMN = nameElementUMN;
    }

    public List<String> getListAttrUMN() {
        return listAttrUMN;
    }

    public void setListAttrUMN(List<String> listAttrUMN) {
        this.listAttrUMN = listAttrUMN;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getNameElementCN() {
        return nameElementCN;
    }

    public void setNameElementCN(String nameElementCN) {
        this.nameElementCN = nameElementCN;
    }

    public List<String> getListAttrCN() {
        return listAttrCN;
    }

    public void setListAttrCN(List<String> listAttrCN) {
        this.listAttrCN = listAttrCN;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getFeaturesXml() {
        return featuresXml;
    }

    public void setFeaturesXml(String featuresXml) {
        SAXBuilder builder = new SAXBuilder();
        List<String> feat = new ArrayList();
        /*try{
            Document document = (Document) builder.
            Element rootNode = document.getRootElement();
            List list = rootNode.getChildren( "ft" );
            for ( int i = 0; i < list.size(); i++ ){
                Element tabla = (Element) list.get(i);
                String title_ = tabla.getChildren("title").get(0).toString();
 
                System.out.println( "title : " + title_ );
                feat.add(title_);
            
            }
        }catch ( IOException io ) {
            System.out.println( io.getMessage() );
        }catch ( JDOMException jdomex ) {
            System.out.println( jdomex.getMessage() );
        }
        this.setListFeatures(feat);*/
        this.featuresXml = featuresXml;
    }

    public String getShortFeatureTitle() {
        return shortFeatureTitle;
    }

    public void setShortFeatureTitle(String shortFeatureTitle) {
        this.shortFeatureTitle = shortFeatureTitle;
    }

    public String getShortFeatureDescription() {
        return shortFeatureDescription;
    }

    public void setShortFeatureDescription(String shortFeatureDescription) {
        this.shortFeatureDescription = shortFeatureDescription;
    }

    public List<String> getListFeatures() {
        return listFeatures;
    }

    public void setListFeatures(List<String> listFeatures) {
        this.listFeatures = listFeatures;
    }

    public List<String> getListShortFeaturesDesc() {
        return listShortFeaturesDesc;
    }

    public void setListShortFeaturesDesc(List<String> listShortFeaturesDesc) {
        this.listShortFeaturesDesc = listShortFeaturesDesc;
    }
    
    
}

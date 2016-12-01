/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.tecmilenio.taller.prod.service.impl;

import java.util.List;
import mx.tecmilenio.taller.prod.bean.ElementDataBean;
import mx.tecmilenio.taller.prod.bean.TechnicalFeaturesBean;
import mx.tecmilenio.taller.prod.dao.XMLDao;
import mx.tecmilenio.taller.prod.dao.impl.XMLDaoImpl;
import mx.tecmilenio.taller.prod.service.XMLService;

/**
 *
 * @author Osvaldo Ignacio Rios Zambrano
 */
public class XMLServiceImpl implements XMLService{
    private final XMLDao dao = new XMLDaoImpl();
    private final String[] chars = new String[]{"\\","\'","|","*", "`", 
                          "^",">","<",")","(","}",
                          "{","]","[","&","/",":"," " };
    
    /**
     *
     * @param word
     * @return
     */
    @Override
    public String contiene(String word){
        for(String c: chars){
            if(word.contains(c)){
                word = word.replace(c, "");
            }
        }
        return word;
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<ElementDataBean> getModels(){
        return dao.getAllProducts();
    }
    
    /**
     *
     * @param productID
     * @return
     */
    @Override
    public List<String> getGroupsOfProduct(Long productID){
        return dao.getGroupsOfProduct(productID);
    }
    
    @Override
    public String createNameFile(String umn, String countryCode, String language){
        String namefile = umn;
        if(namefile.contains("/")){
            namefile = namefile.replace("/", "-");
        } else if(namefile.contains("|")){
            namefile = namefile.replace("|", "-");
        }
        namefile = contiene(namefile);
        namefile = namefile + "_" + countryCode + "_" + language + ".xml";
        return namefile;
    }
    
    @Override
    public List<TechnicalFeaturesBean> getTechnicalFeatures(Long productID, String group){
        return dao.getTechnicalFeatures(productID, group);
    }
    
    /**
     *
     * @param productID
     * @return
     */
    @Override
    public List<TechnicalFeaturesBean> getTechnicalFeatures(Long productID){
        return dao.getTechnicalFeatures(productID);
    }
}

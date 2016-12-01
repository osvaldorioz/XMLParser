/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.tecmilenio.taller.prod.service;

import java.util.List;
import mx.tecmilenio.taller.prod.bean.ElementDataBean;
import mx.tecmilenio.taller.prod.bean.TechnicalFeaturesBean;

/**
 *
 * @author Osvaldo Ignacio Rios Zambrano
 */
public interface XMLService {
    public List<ElementDataBean> getModels();
    public String createNameFile(String umn, String countryCode, String language);
    public List<String> getGroupsOfProduct(Long productID);
    public List<TechnicalFeaturesBean> getTechnicalFeatures(Long productID, String group);
    public List<TechnicalFeaturesBean> getTechnicalFeatures(Long productID);
    public String contiene(String word);
}

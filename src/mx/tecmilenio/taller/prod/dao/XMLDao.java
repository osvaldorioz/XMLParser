/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.tecmilenio.taller.prod.dao;

import java.util.List;
import mx.tecmilenio.taller.prod.bean.ElementDataBean;
import mx.tecmilenio.taller.prod.bean.TechnicalFeaturesBean;

/**
 *
 * @author Osvaldo Ignacio Rios Zambrano
 */
public interface XMLDao {
    public List<ElementDataBean> getAllProducts();
    public List<String> getGroupsOfProduct(Long productID);
    public List<TechnicalFeaturesBean> getTechnicalFeatures(Long productID, String group);
    public List<TechnicalFeaturesBean> getTechnicalFeatures(Long productID);
}

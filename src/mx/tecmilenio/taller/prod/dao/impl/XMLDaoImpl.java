/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.tecmilenio.taller.prod.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import mx.tecmilenio.taller.prod.bean.ElementDataBean;
import mx.tecmilenio.taller.prod.bean.TechnicalFeaturesBean;
import mx.tecmilenio.taller.prod.connector.Connector;
import mx.tecmilenio.taller.prod.dao.XMLDao;
import mx.tecmilenio.taller.prod.variables.XMLVars;

/**
 *
 * @author Osvaldo Ignacio Rios Zambrano
 */
public class XMLDaoImpl implements XMLDao {
    private final XMLVars vars = XMLVars.getInstance();
    private final Connection conn = Connector.getInstance().getConn();
    
    private List<String> getListAttrSMN(){
        List<String> attr = new ArrayList<String>();
        attr.add("ShortModelNumber");
        attr.add("Short Model Number");
        attr.add("Short Model Number");
        attr.add("string");
        return attr;
    }
   
    
    private List<String> getListAttrUMN(){
        List<String> attr = new ArrayList<String>(); 
        attr.add("UnifiedModelNumber");
        attr.add("Unified Model Number");
        attr.add("Unified Model Number");
        attr.add("string");
        return attr;
    }
    
    private List<String> getListAttrCN(){
        List<String> attr = new ArrayList<String>(); 
        attr.add("catalogName");
        attr.add("catalogName");
        attr.add("catalogName");
        attr.add("string");
        return attr;
    }
    
    /**
     *
     * @param productID
     * @return
     */
    @Override
    public List<TechnicalFeaturesBean> getTechnicalFeatures(Long productID){
        List<TechnicalFeaturesBean> lst = new ArrayList();
        StringBuilder sb = new StringBuilder();
        sb.
        append("select Value, Name ").
        append("  from [").append(vars.getNameDB()).append("].[dbo].[ProductFields]").
        append(" where ProductId = ?");
        try{
            PreparedStatement ps = conn.prepareStatement(sb.toString());
            ps.setLong(1, productID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TechnicalFeaturesBean tfb = new TechnicalFeaturesBean();
                tfb.setName(rs.getString("Name"));
                tfb.setValue(rs.getString("Value"));
                lst.add(tfb);
            }
        }catch(SQLException err){
            System.err.println(err.getMessage());
        }
        return lst;
    }
    
    /**
     *
     * @param productID
     * @param group
     * @return
     */
    @Override
    public List<TechnicalFeaturesBean> getTechnicalFeatures(Long productID, String group){
        List<TechnicalFeaturesBean> lst = new ArrayList();
        /*StringBuilder sb = new StringBuilder();
        sb.
        append("select Value, Name ").
        append("  from [").append(vars.getNameDB()).append("].[dbo].[ProductFields]").
        append(" where ProductId = ?").
        append("   and [GROUP] = ?");
        
        try{
            PreparedStatement ps = conn.prepareStatement(sb.toString());
            ps.setLong(1, productID);
            ps.setString(2, group);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TechnicalFeaturesBean tfb = new TechnicalFeaturesBean();
                tfb.setName(rs.getString("Name"));
                tfb.setValue(rs.getString("Value"));
                lst.add(tfb);
            }
        }catch(SQLException err){
            System.err.println(err.getMessage());
        }*/
        TechnicalFeaturesBean tfb = new TechnicalFeaturesBean();
        tfb.setName("key");
        tfb.setValue("value");
        lst.add(tfb);
        return lst;
    }
    
    /**
     *
     * @param productID
     * @return
     */
    @Override
    public List<String> getGroupsOfProduct(Long productID){
        List<String> lst = new ArrayList();
        /*StringBuilder sb = new StringBuilder();
        sb.
        append("select distinct([GROUP])as grupos ").
        append("  from [").append(vars.getNameDB()).append("].[dbo].[ProductFields]").
        append(" where ProductId = ?").
        append(" order by 1");
        
        try{
            PreparedStatement ps = conn.prepareStatement(sb.toString());
            ps.setLong(1, productID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                lst.add(rs.getString("grupos"));
            }
        }catch(SQLException err){
            System.err.println(err.getMessage());
        }*/
        
        lst.add("GRP1");
        
        return lst;
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<ElementDataBean> getAllProducts(){
        List<ElementDataBean> list = new ArrayList();
        
        /*
        StringBuilder sb = new StringBuilder();
        sb.
        append("SELECT A.PRODUCTID, A.NAME, A.CODE, B.NAME AS CATALOGNAME,").
        append("       A.[DESCRIPTION] AS DESC1, B.[DESCRIPTION] AS DESC2,").
        append("       A.CATEGORYID, B.[LEVEL], A.LENGUAJE, A.PRODUCTID,").
        append("       A.FeaturesXml, A.ShortFeatureTitle, A.ShortFeatureDescription,").
        append("       C.CREATED").
        append("  from [").append(vars.getNameDB()).append("].[dbo].[Product] A,").
        append("       [").append(vars.getNameDB()).append("].[dbo].[ProductCategory] B,").
        append("       [").append(vars.getNameDB()).append("].[dbo].[ProductType] C").
        append(" where A.CATEGORYID = B.CATEGORYID").
        append("   and A.CATEGORYID = C.CATEGORYID");
             
        try{
            PreparedStatement ps = conn.prepareStatement(sb.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ElementDataBean edb = new ElementDataBean();
                edb.setProductID(rs.getLong("PRODUCTID"));
                edb.setShortModNum(rs.getString("NAME"));
                edb.setNameElementSMN("data");
                edb.setListAttrSMN(getListAttrSMN());
                edb.setUnifiedModNum(rs.getString("CODE"));
                edb.setNameElementUMN("data");
                edb.setListAttrUMN(getListAttrUMN());
                edb.setCatalogName(rs.getString("CATALOGNAME"));
                edb.setNameElementCN("data");
                edb.setListAttrCN(getListAttrCN());
                edb.setLanguage(rs.getString("LENGUAJE"));
                edb.setCreated(rs.getString("CREATED"));
                edb.setFeaturesXml(rs.getString("FeaturesXml"));
                edb.setShortFeatureTitle(rs.getString("ShortFeatureTitle"));
                edb.setShortFeatureDescription(rs.getString("ShortFeatureDescription"));
                list.add(edb);
            }
        }catch(SQLException err){
            System.err.println(err.getMessage());
        }
        System.err.println("List size getAllProducts " + list.size());
        */
        
        Random r = new Random();
        for(int x=0; x < 5; x++){
            ElementDataBean edb = new ElementDataBean();
            edb.setProductID(r.nextLong());
            edb.setShortModNum("NOMBRE_" + Math.abs(r.nextLong()));
            edb.setNameElementSMN("data");
            edb.setListAttrSMN(getListAttrSMN());
            edb.setUnifiedModNum("CODE_" + Math.abs(r.nextLong()));
            edb.setNameElementUMN("data");
            edb.setListAttrUMN(getListAttrUMN());
            edb.setCatalogName("CATALOGNAME_" + Math.abs(r.nextLong()));
            edb.setNameElementCN("data");
            edb.setListAttrCN(getListAttrCN());
            edb.setLanguage("en");
            edb.setCreated("11-22-2016");
            edb.setFeaturesXml("FeaturesXml_" + r.nextBoolean() + "_" + Math.abs(r.nextLong())); 
            edb.setShortFeatureTitle("ShortFeatureTitle_" + r.nextBoolean() + "_" + Math.abs(r.nextLong()));
            edb.setShortFeatureDescription("ShortFeatureDescription_" + r.nextBoolean() + "_" + Math.abs(r.nextLong()));
            list.add(edb);
        }
        return list;
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.tecmilenio.taller.prod.dom.generator.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import mx.tecmilenio.taller.prod.dom.generator.XMLGen;
import org.jdom2.Attribute;
import org.jdom2.CDATA;
import org.jdom2.Element;

/**
 *
 * @author Osvaldo Ignacio Rios Zambrano
 */
public class XMLGenImpl implements XMLGen{
    @Override
    public HashMap<String,String> setMap(List<String> args){
        String[] keys = {"nodeName","attributeName","transAttributeName","dataType"};
        HashMap<String,String> map = new HashMap();
        int x = 0;
        for(String arg: args){
            map.put(keys[x++], arg );
        }
        return map;
    }
    
    @Override
    public Element addElement(String name, HashMap<String,String> attr){
        Element e = new Element(name);
        Set<String>set = attr.keySet();
        for(String at: set){
            Attribute a = new Attribute(at, attr.get(at)==null?"UNDEFINED":attr.get(at));
            e.setAttribute(a);
        }
        return e; 
    }
   
    @Override
    public Element setElementData(String product, String name, List<String> attr){
        
        HashMap<String,String> map = setMap(attr);
        Element data = addElement(name, map);
        CDATA cdata=new CDATA(product);
        data.setContent(cdata);
        return data;
    }
}

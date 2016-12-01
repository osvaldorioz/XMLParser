/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.tecmilenio.taller.prod.dom.generator;

import java.util.HashMap;
import java.util.List;
import org.jdom2.Element;

/**
 *
 * @author Osvaldo Ignacio Rios Zambrano
 */
public interface XMLGen {
    public HashMap<String,String> setMap(List<String> args);
    public Element addElement(String name, HashMap<String,String> attr);
    public Element setElementData(String product, String name, List<String> attr);
}

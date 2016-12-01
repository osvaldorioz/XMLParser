/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.tecmilenio.taller.prod.variables;

/**
 *
 * @author Osvaldo Ignacio Rios Zambrano
 */
public class XMLVars {
    private static XMLVars vars = new XMLVars();
    private String nameDB;
    
    private XMLVars(){
        
    }
    
    public static XMLVars getInstance(){
        return vars;
    }

    public static XMLVars getVars() {
        return vars;
    }

    public static void setVars(XMLVars vars) {
        XMLVars.vars = vars;
    }

    public String getNameDB() {
        return nameDB;
    }

    public void setNameDB(String nameDB) {
        this.nameDB = nameDB;
    }
    
    
}

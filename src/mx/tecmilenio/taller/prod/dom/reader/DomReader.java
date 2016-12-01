/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.tecmilenio.taller.prod.dom.reader;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;

import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/**
 *
 * @author Osvaldo Ignacio Rios Zambrano
 */
public class DomReader {
    public void reader(String xml){
        //Se crea un SAXBuilder para poder parsear el archivo
        System.err.println("DomReader " + xml);
        SAXBuilder builder = new SAXBuilder();
        File xmlFile = new File( xml );
        try
        {
            //Se crea el documento a traves del archivo
            Document document = (Document) builder.build( xmlFile );
            
            //Se obtiene la raiz 'tables'
            Element rootNode = document.getRootElement();
            //List<Attribute> attrib = rootNode.getAttributes();
            //System.err.println(attrib.get(0).getName() + attrib.get(0).getValue());
            List<Element> list = rootNode.getChildren();

            //Se recorre la lista de hijos de 'tables'
            for ( int i = 0; i < list.size(); i++ )
            {
                //Se obtiene el elemento 'tabla'
                Element tabla = (Element) list.get(i);
                System.out.println( "Element: " + tabla.getName() );
                //Se obtiene el atributo 'nombre' que esta en el tag 'tabla'
                List<Attribute> att = tabla.getAttributes();
                
                for(Attribute a: att){
                    String nombreTabla = a.getName();
                    System.out.println( "Tabla: " + nombreTabla );

                    /*//Se obtiene la lista de hijos del tag 'tabla'
                    List lista_campos = tabla.getChildren();

                    System.out.println( "\tNombre\t\tTipo\t\tValor" );

                    //Se recorre la lista de campos
                    for ( int j = 0; j < lista_campos.size(); j++ )
                    {
                        //Se obtiene el elemento 'campo'
                        Element campo = (Element)lista_campos.get( j );

                        //Se obtienen los valores que estan entre los tags '<campo></campo>'
                        //Se obtiene el valor que esta entre los tags '<nombre></nombre>'
                        String nombre = campo.getChildTextTrim("nombre");

                        //Se obtiene el valor que esta entre los tags '<tipo></tipo>'
                        String tipo = campo.getChildTextTrim("tipo");

                        //Se obtiene el valor que esta entre los tags '<valor></valor>'
                        String valor = campo.getChildTextTrim("valor");

                        System.out.println( "\t"+nombre+"\t\t"+tipo+"\t\t"+valor);
                    }*/
                }
            }
        }catch ( IOException io ) {
            System.out.println( io.getMessage() );
        }catch ( JDOMException jdomex ) {
            System.out.println( jdomex.getMessage() );
        }
    }
}

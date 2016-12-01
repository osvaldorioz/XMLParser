/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.tecmilenio.taller.prod.connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Osvaldo Ignacio Rios Zambrano
 */
public class Connector {
	
	/**
	 * connection
	 */
	private static final Connector con = new Connector();
	private Connection connectionLP;
	
	private Connector(){
            
	}
	
	public static Connector getInstance(){
            return con;
        }
        
        public boolean stablishConnection(String server, String db, String login, String pwd){
            try{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                connectionLP = DriverManager.getConnection("jdbc:sqlserver://" + server + ":1433;" +
                        "databaseName="+ db + ";user="+ login +";password=" + pwd + ";");
		 
		   
            } catch(ClassNotFoundException e){
                System.err.println(e.getMessage());
		return false;
            }catch(SQLException e){
                System.err.println(e.getMessage());
		return false;	
	    } 
            return true;
        }
	

	public Connection getConn(){
		return connectionLP;
	}
}
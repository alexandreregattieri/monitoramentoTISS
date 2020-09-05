package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {

	private String serverName = "xxxx:1433";
	private String mydatabase = "yyyy;instance=corporativo"; // ;namedpipe=trueinstance=corporativo
	private String username = "zzzz";
	private String password = "wwww";
	
		
	private String url = "jdbc:jtds:sqlserver://" + serverName + "/" + mydatabase;
	private Connection con = null;
	
	public Connection getConexao() {
		//System.out.println(url);
        try {
        	if(con == null){
        		Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
        		con = DriverManager.getConnection(url, username, password);
        	}
        } catch (Exception e) {
            System.out.println(e.toString());
        } 
        return con;
	}
	
}

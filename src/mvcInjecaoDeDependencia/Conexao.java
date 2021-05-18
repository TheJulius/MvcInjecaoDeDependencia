package mvcInjecaoDeDependencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	private Connection con = null;

	  private String hostName = null;
	  private String userName = null;
	  private String password = null;
	  private String url = null;
	  private String jdbcDriver = null;
	  private String dataBaseName = null;
	  private String dataBasePrefix = null;
	  private String dabaBasePort = null;
	  
	  public Conexao() {

		"jdbc: mysql:/localhost:3306/meu_bd";
		  hostName = "localhost";
		  userName = "juliocesar";
		  password = "whyjava";
		  jdbcDriver = "org.gjt.mm.mysql.Driver";
		  dataBaseName = "bdteste";
		  dataBasePrefix = "jdbc: mysql:/";
		  dabaBasePort = "3306";

		  url = dataBasePrefix + hostName + ":"+dabaBasePort+"/" + dataBaseName + "/";

		}

		public Connection getConnection() {
		  try {
		    if (con == null) {
		      Class.forName(jdbcDriver);
		      con = DriverManager.getConnection(url, userName, password);
		    } else if (con.isClosed()) {
		      con = null;
		      return getConnection();
		    }
		  } catch (ClassNotFoundException e) {

		    //TODO: use um sistema de log apropriado.

		    e.printStackTrace();
		  } catch (SQLException e) {

		    //TODO: use um sistema de log apropriado.

		    e.printStackTrace();
		  }
		  return con;
		}
}

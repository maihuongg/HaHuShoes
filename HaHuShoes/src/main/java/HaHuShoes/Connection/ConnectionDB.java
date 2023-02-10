package HaHuShoes.Connection;

import java.sql.Connection;
import java.sql.DriverManager;



public class ConnectionDB {
//	private final String serverName = "LAPTOP-930OP88C\\SQLEXPRESS";
	private final String serverName = "DESKTOP-3S3BS06\\SQLEXPRESS";
	private final String dbName = "HaHuShoes";
	private final String portNumber = "1433";
	private final String instance = "";// MSSQLSERVER LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
//	private final String userID = "";
//	private final String password = "";

	public Connection getConnectionW() throws Exception {
		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance
				+ ";integratedSecurity=true;databaseName=" + dbName;
		if (instance == null || instance.trim().isEmpty())
			url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";integratedSecurity=true;databaseName="
					+ dbName;
		// DriverManager.registerDriver(new
		// com.microsoft.sqlserver.jdbc.SQLServerDriver());
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		return DriverManager.getConnection(url);
	}

	public static void main(String[] args) {
		try {
			System.out.println(new ConnectionDB().getConnectionW());
		} catch (Exception e) {
			e.printStackTrace();
		}
}
}

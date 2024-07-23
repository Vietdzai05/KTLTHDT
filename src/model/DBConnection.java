package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;



@SuppressWarnings("hiding")
public class DBConnection<Connection> {
	@SuppressWarnings("rawtypes")
	private static DBConnection instance;
	private java.sql.Connection conn;
	private String ipadd ;
	private String port;
	private String database;
	private String username;
	private String password;
	
	
	private DBConnection() {
		try (Scanner sc = new Scanner(System.in)) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				if(this.ipadd == null) {
					System.out.print("IP address: ");
					this.ipadd = sc.nextLine();
				}
				
				if(this.port == null) {
					System.out.print("Port: ");
					this.port = sc.nextLine();
				}
				if(this.database == null) {
					System.out.print("Database: ");
					this.database = sc.nextLine();
				}
				if(this.username == null) {
					System.out.print("Username: ");
					this.username = sc.nextLine();
				}
				if(this.password == null) {
					System.out.print("Password: ");
					this.password = sc.nextLine();
				}
				this.conn = DriverManager.getConnection("jdbc:mysql://" + ipadd + ":" +
						port + "/" + database, username, password);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Loi phan mem");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Loi ket noi den may chu CSDL");
			}
		}
	}
	
	@SuppressWarnings("unchecked")
	public Connection getConnection() {
		return (Connection) this.conn;
	}
	
	@SuppressWarnings("rawtypes")
	public static DBConnection getInstance() throws SQLException {
		if(instance == null) {
			instance = new DBConnection();
		}else if(((java.sql.Connection) instance.getConnection()).isClosed()) {
				instance = new DBConnection();
		}
			
		return instance;
	}

	
	
}

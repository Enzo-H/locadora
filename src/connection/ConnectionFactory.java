package connection;

public class ConnectionFactory {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/locadora";
	private static final String USER = "root";
	private static final String PASS = "";
	
	public static Connection getConnection() {
		try {  
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e) {
			throw new RuntimeException("erro na conexão: ", e );
		}
		
	}
	
	public static void closeConnection(Connection con) {
		  if(con != null) {
			  try {
				con.close();
			} catch (SQLException e) {
			throw new RuntimeException("erro ao encerrar a conexão: ", e ); 
			}
		 }
   	  }
	
	public static void closeConnection(Connection con, PreparedStatement stmt) {
		closeConnection(con);  
		if(stmt != null) {
			  try {
				stmt.close();
			} catch (SQLException e) { 
			throw new RuntimeException("erro ao encerrar a conexão: ", e ); 
			}
		 }
 	  }
	
	public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs) {
		closeConnection(con, stmt);  
		if(rs != null) {
			  try {
				rs.close();
			} catch (SQLException e) {
			throw new RuntimeException("erro ao encerrar a conexão: ", e ); 
			}
		 }
 	  }
}
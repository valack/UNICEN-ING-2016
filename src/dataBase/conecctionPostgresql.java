package dataBase;


	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.ResultSetMetaData;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.sql.PreparedStatement;

	public class conecctionPostgresql {
		
		public static void conecction()
		{
			String clave = "guille123";
			
			try {
				//CLASE USADA PARA EL DIVER
				Class.forName("org.postgresql.Driver");
				
				//RUTA DE LA BASE DE DATOS
				String url = "jdbc:postgresql://localhost:5432/postgres";
				
				//CONEXION A LA BASE DE DATOS			
				Connection cn = DriverManager.getConnection(url, "postgres", clave);
				
				cn.setAutoCommit(false);
				
				//TRAE LOS DATOS
				Statement st = cn.createStatement();
				
				//SELECCTIONA LA TABLA
				
				//EJEMPLO SELECT
				
				String sql_SELECT = "SELECT * FROM public.persona";
				
				ResultSet rs = st.executeQuery(sql_SELECT);
				
				while (rs.next())
					System.out.println("id: "  + rs.getString("id") + ", Nombre: " + rs.getString("nombre"));
				
							
				//EJEMPLO UPDATE
							
				int val = 3;
				String nombre = "Ana";
				
				String sql_UPDATE = "UPDATE persona SET nombre = '" + nombre + "'  WHERE id = " + val + ";";
				
				st.executeUpdate(sql_UPDATE);
				
				System.out.println(sql_UPDATE);
				
				//EJEMPLO INSERT
				
				 String sql_INSERT = "INSERT INTO persona(id, nombre) VALUES(?,?)";
				 
				 PreparedStatement pst = cn.prepareStatement(sql_INSERT);
		            
		         pst.setInt(1, 21);
		         pst.setString(2, "pepe");
		         
		         pst.executeUpdate();
				
				cn.commit();
							
				rs = st.executeQuery(sql_SELECT);
				
				//LLAMA AL METODO
				while (rs.next())
					System.out.println("id: "  + rs.getString(1) + ", Nombre: " + rs.getString(2));

				st.close();
				cn.close();

				} catch (ClassNotFoundException ex) {
					System.out.println("Error en el driver");
				} catch (SQLException e ){
					System.out.println(e.getMessage());					
				}
			
		}
		
		public static void main(String[] args){
			conecction();		
		}
		
		
	}



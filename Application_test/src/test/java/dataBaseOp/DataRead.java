package dataBaseOp;
import java.sql.*;
public class DataRead {
	public static void main(String[] args) {
		final String DB_URL="jdbc:mysql://localhost:3306/users";
		final String username="root";
		final String password="*********";
		Connection conn=null;
		Statement stmt=null;
		int expectedId=2;
		
		try{
			//register driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("connecting to selcted database");
			
			//open a connection
			conn=DriverManager.getConnection(DB_URL, username, password);
			System.out.println("connected successfully..");
			
			//execute query
			System.out.println("create statement");
			stmt=conn.createStatement();
			
			String sql="select ud.id, ud.name,ud.Address from UserDetails as ud INNER JOIN cityDetails as cd where ud.id=cd.id";

			ResultSet rs=stmt.executeQuery(sql);
			
			while(rs.next())
			{
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String address=rs.getString("Address");
				System.out.println("id ="+id);
				System.out.println("name ="+name);
				System.out.println("address ="+address);
				if(expectedId==id)
				{
				System.out.println("id ="+id);
				System.out.println("name ="+name);
				System.out.println("address ="+address);
				
				}
				
				
			}
			double val=19;
			String fname="zeta";
			
			String sql2="insert into UserDetails "
					+ "values("+val+",'"+fname+"','york ,45 US',89136633,52)";
			System.out.println("sql2 ="+sql2);

			stmt.executeUpdate(sql2);
			System.out.println("data inserted");
			
			String sql3="select * from UserDetails where id=014";

			ResultSet rs3=stmt.executeQuery(sql3);
			
			while(rs3.next())
			{
				int id=rs3.getInt("id");
				String name=rs3.getString("name");
				String address=rs3.getString("Address");
				System.out.println("id ="+id);
				System.out.println("name ="+name);
				System.out.println("address ="+address);
				if(expectedId==id)
				{
				System.out.println("id ="+id);
				System.out.println("name ="+name);
				System.out.println("address ="+address);
				
				}
				
				
			}
			
			rs3.close();
		}
		catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }finally{
		      //finally block used to close resources
		      try{
		         if(stmt!=null)
		            conn.close();
		      }catch(SQLException se){
		      }// do nothing
		      try{
		         if(conn!=null)
		            conn.close();
		      }catch(SQLException se){
		         se.printStackTrace();
		      }//end finally try
		   }//end try
		   System.out.println("Goodbye!");

	}

}

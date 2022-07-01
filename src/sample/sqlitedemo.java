package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sqlitedemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String jdbcUrl="jdbc:sqlite:/C:\\Users\\randomuser\\Desktop\\db\\classicmovies.db";
		
		try {
			Connection con=DriverManager.getConnection(jdbcUrl);
			String sql = "SELECT * FROM movietable150";
			Statement st = con.createStatement();
			ResultSet res = st.executeQuery(sql);
			int i=1;
			while(res.next()) {
				String filmname=res.getString("filmname");
				String actor=res.getString("actor");
				String actress=res.getString("actress");
				String director=res.getString("director");
				String year=res.getString("year");
				
				System.out.println(i+" | "+filmname+" | "+actor+" | "+actress+" | "+director+" | "+year);
				i++;
			}
			
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			
			
			String sql2 = "SELECT filmname FROM movietable150 WHERE actor='Vijay';";
			Statement st2 = con.createStatement();
			ResultSet res2 = st2.executeQuery(sql2);
			int j=1;
			while(res2.next()) {
				String filmname=res2.getString("filmname");
		
				System.out.println(j+" | "+filmname);
				j++;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error connecting to SQLite Database");
			e.printStackTrace();
		}

	}

}

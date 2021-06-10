package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Category;
import entity.Document;
import entity.Entity;
import entity.Event;
import entity.Payment;
import entity.Person;
import entity.Society;

public class Utilities {

	private static Connection conn;
	private static Statement stmt;
	
	static {

	}

	public static void insertEntity(Entity entity) throws SQLException, FileNotFoundException {
		if (entity.getClass().equals(Society.class)) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/team_management","root","Tommasocalcio10");
				stmt = conn.createStatement();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			String query="";
			
			switch(entity.getTableName()) {
				case Society.TABLENAME : 
					Society society = (Society) entity;
					query="INSERT INTO " +Society.TABLENAME + " (PartitaIVA, Nome, CodSport, CodImmagine) VALUES ('" + society.getPrimaryKey() +"', '" + society.getNome() + "', '1','1')"; 
					break;
				case Category.TABLENAME : 
					Category category = (Category) entity;
					query="INSERT INTO " +entity.getTableName() + " (PartitaIVA, Nome, CodSport, CodImmagine) VALUES ('" + society.getPrimaryKey() +"', '" + society.getNome() + "', '1','1')" ;
					break;
				case Document.TABLENAME : 
					Document document = (Document) entity;
					break;
				case Event.TABLENAME : 
					Event event = (Event) entity;
					break;
				case Payment.TABLENAME : 
					Payment payment = (Payment) entity;
					break;
				case Person.TABLENAME : 
					Person person = (Person) entity;
					break;
			}
			
			InputStream is = new FileInputStream("C:\\Users\\tbrin\\Desktop\\b1SB.png");
			//PreparedStatement ps = conn.prepareStatement("INSERT INTO immagine (IdImmagine, Nome, TipoFile, DatiFimmagineimmagineile) VALUES ('1', 'bomber', '.png', ?)");
			//ps.setBlob(1, is);
			//ps.execute();
			//stmt.executeUpdate("INSERT INTO IMMAGINE(IdImmagine,Nome,TipoFile)");
//			stmt.executeUpdate("INSERT INTO " +entity.getTableName() + " (PartitaIVA, Nome, CodSport, CodImmagine) VALUES ('" + society.getPrimaryKey() +"', '" + society.getNome() + "', '1','1')" );
			stmt.executeUpdate(query);
			conn.close();
			stmt.close();
		}
		
	};

	public static void deleteEntity(Entity entity) throws SQLException {
		if (entity.getClass().equals(Society.class)) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/team_management","root","Tommasocalcio10");
				stmt = conn.createStatement();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			Society society = (Society) entity;
			//InputStream is = new FileInputStream("C:\\Users\\tbrin\\Desktop\\b1SB.png");
			//PreparedStatement ps = conn.prepareStatement("INSERT INTO immagine (IdImmagine, Nome, TipoFile, DatiFimmagineimmagineile) VALUES ('1', 'bomber', '.png', ?)");
			//ps.setBlob(1, is);
			//ps.execute();
			//stmt.executeUpdate("INSERT INTO IMMAGINE(IdImmagine,Nome,TipoFile)");
			stmt.executeUpdate("DELETE FROM societa AS s WHERE s.PartitaIVA="+society.getPrimaryKey());
			conn.close();
			stmt.close();
		}
		
	};

}

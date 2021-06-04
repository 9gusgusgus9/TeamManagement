package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Entity;
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
			Society society = (Society) entity;
			InputStream is = new FileInputStream("C:\\Users\\tbrin\\Desktop\\b1SB.png");
			//PreparedStatement ps = conn.prepareStatement("INSERT INTO immagine (IdImmagine, Nome, TipoFile, DatiFimmagineimmagineile) VALUES ('1', 'bomber', '.png', ?)");
			//ps.setBlob(1, is);
			//ps.execute();
			//stmt.executeUpdate("INSERT INTO IMMAGINE(IdImmagine,Nome,TipoFile)");
			stmt.executeUpdate("INSERT INTO societa (PartitaIVA, Nome, CodSport, CodImmagine) VALUES ('" + society.getPrimaryKey() +"', '" + society.getNome() + "', '1','1')" );
		}
	};

	static void deleteEntity(Entity entity) {

	};

}

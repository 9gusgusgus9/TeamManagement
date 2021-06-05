import java.io.FileNotFoundException;
import java.sql.SQLException;

import entity.Society;
import entity.Sport;
import utilities.Utilities;

public class Prova {

	public static void main(String[] args) throws SQLException {
		
		Society tommi = new Society("12345678901","TOMMI",Sport.CALCIO);
		try {
			Utilities.insertEntity(tommi);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

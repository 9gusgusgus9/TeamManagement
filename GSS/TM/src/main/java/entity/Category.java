package entity;

public class Category extends Entity {
	public final static String TABLENAME="categoria";

	public String getNome() {
		return "";
	}
	
	public int getPrimaryKey() {
		return 0;
	}
	
	@Override
	public String getTableName() {
		return null;
	}
}

package entity;

import java.awt.image.BufferedImage;

public class Society implements Entity {
	
	String partitaIVA;
	String nome;
	Sport sport;
	BufferedImage image;
	
	public Society(String partitaIVA, String nome, Sport sport){
		this.partitaIVA=partitaIVA;
		this.nome=nome;
		this.sport=sport;
	}
	
	public Society(String partitaIVA, String nome, Sport sport, BufferedImage image){
		this.partitaIVA=partitaIVA;
		this.nome=nome;
		this.sport=sport;
		this.image=image;
	}
	
	@Override
	public String getPrimaryKey() {
		return this.partitaIVA;
	}

	@Override
	public void insert() {
		
	}

	@Override
	public void delete() {
		
	}

	public String getNome() {
		return nome;
	}

	public Sport getSport() {
		return sport;
	}

	public BufferedImage getImage() {
		return image;
	}
	
	

	
}

package pojo;

import about.classcastexception.ICar;

public class BMWCar implements ICar{
	
	private String nome;
	private String modello;

	public void setNome(String nome) {
		this.nome=nome;
	}
	public String getNome(){
		return this.nome;
	}
	
	public void setModello(String modello){
		this.modello=modello;
	}
	
	public String getModello(){
		return this.modello;
	}

}

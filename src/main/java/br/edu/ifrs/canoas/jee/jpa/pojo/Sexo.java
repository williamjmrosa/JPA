package br.edu.ifrs.canoas.jee.jpa.pojo;

public enum Sexo {
	M("Masculino"),F("Feminino");
	
	private String descricao;
	
	private Sexo(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}

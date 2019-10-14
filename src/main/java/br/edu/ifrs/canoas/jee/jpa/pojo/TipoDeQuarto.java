package br.edu.ifrs.canoas.jee.jpa.pojo;

public enum TipoDeQuarto {
	STANDARD("Standard"), DUPLO("Duplo"),TRIPLO("Triplo"),
	MASTER("Master"),PRESIDENCIAL("Presidencial"),MEGA_ULTRA("Mega Ultra");
	
	private String descricao;
	
	private TipoDeQuarto(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
}

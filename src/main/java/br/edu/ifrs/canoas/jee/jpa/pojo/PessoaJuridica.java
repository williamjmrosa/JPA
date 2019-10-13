package br.edu.ifrs.canoas.jee.jpa.pojo;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: PessoaJuridica
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PessoaJuridica extends Pessoa implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private String razaoSocial;
	private String cnpj;
	private String inscricaoEstadual;
	private String inscricaoMunicipal;

   
}

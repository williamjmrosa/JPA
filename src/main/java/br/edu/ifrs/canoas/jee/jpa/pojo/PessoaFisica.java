package br.edu.ifrs.canoas.jee.jpa.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: PessoaFisica
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PessoaFisica extends Pessoa implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private String cpf;
	private String rg;
	private Date dataNascimento;
	private Sexo sexo;
	
}

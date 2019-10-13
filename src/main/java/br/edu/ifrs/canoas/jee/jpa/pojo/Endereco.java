package br.edu.ifrs.canoas.jee.jpa.pojo;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: Endereco
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Endereco implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String logradouro;
	private int numero;
	private String complemento;
	private String cep;
	private String bairro;
	private String uf;
   
}

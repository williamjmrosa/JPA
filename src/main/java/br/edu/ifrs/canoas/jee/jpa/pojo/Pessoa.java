package br.edu.ifrs.canoas.jee.jpa.pojo;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: Pessoa
 *
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public class Pessoa implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private String nome;
	private String email;
	@OneToOne (cascade = CascadeType.ALL)
	@JoinColumn (name = "id_endereco")
	private Endereco endereco;
   
}

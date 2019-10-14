package br.edu.ifrs.canoas.jee.jpa.pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: Diaria
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance (strategy = InheritanceType.TABLE_PER_CLASS)
public class Diaria implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private Date data;
	@ManyToOne
	@JoinColumn (name = "NUMERO_QUARTO")
	private Quarto quarto;
	@ManyToMany (mappedBy = "diarias")
	private Collection<PessoaFisica> hospedes;
	
	public void hospedesAdd(PessoaFisica pessoaFisica) {
		hospedes.add(pessoaFisica);
	}
	
   
}

package br.edu.ifrs.canoas.jee.jpa.pojo;

import java.io.Serializable;
import java.util.Collection;

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
	@OneToMany (mappedBy = "cliente")
	private Collection<Reserva> reservas;
	@OneToMany (mappedBy = "cliente")
	private Collection<DiariaAvulsa> diariasAvulsas;
	
	public void addReserva(Reserva reserva) {
		reservas.add(reserva);
	}
	
	public void addDiariasAvulsal(DiariaAvulsa diariaAvulsa) {
		diariasAvulsas.add(diariaAvulsa);
	}
   
}

package br.edu.ifrs.canoas.jee.jpa.pojo;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: DiariaAvulsa
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiariaAvulsa extends Diaria implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn (name = "id_Pessoa")
	private Pessoa cliente;
	
	
   
}

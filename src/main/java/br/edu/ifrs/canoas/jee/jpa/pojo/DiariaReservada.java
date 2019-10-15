package br.edu.ifrs.canoas.jee.jpa.pojo;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: DiariaReservada
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiariaReservada extends Diaria implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@OneToOne (mappedBy = "diarias")
	private Reserva reserva;
	
   
}

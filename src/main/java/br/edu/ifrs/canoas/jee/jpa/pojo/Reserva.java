package br.edu.ifrs.canoas.jee.jpa.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: Reserva
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reserva implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Id
	private Long id;
	private Date data;
	private double valor;
	
	
   
}

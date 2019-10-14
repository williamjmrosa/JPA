package br.edu.ifrs.canoas.jee.jpa.pojo;

import java.io.Serializable;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity implementation class for Entity: Quarto
 *
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Quarto implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private String numero;
	private TipoDeQuarto tipoDeQuarto;
   
}

package br.edu.ifrs.canoas.jee.jpa.DAO;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifrs.canoas.jee.jpa.pojo.Quarto;
import br.edu.ifrs.canoas.jee.jpa.pojo.TipoDeQuarto;

public class QuartoDAOTest {

	QuartoDAO qDAO;

	@Before
	public void setup() {
		qDAO = new QuartoDAO();
	}

	@Test
	public void testSalva() {
		// Cria Quarto
		Quarto q = Quarto.builder().numero("1").tipoDeQuarto(TipoDeQuarto.MEGA_ULTRA).build();
		// Salva Quarto
		qDAO.salva(q);
		// Verifica se salvo
		assertThat(qDAO.busca(q.getNumero()).getNumero()).isNotNull();

	}

	@Test
	public void testAtualiza() {
		// Cria Quarto
		Quarto q = Quarto.builder().numero("2").tipoDeQuarto(TipoDeQuarto.MEGA_ULTRA).build();
		// Salva Quarto
		qDAO.salva(q);
		// Verifica se salvo
		assertThat(qDAO.busca(q.getNumero()).getNumero()).isNotNull();
		// Altera
		q.setTipoDeQuarto(TipoDeQuarto.DUPLO);
		// Atualiza
		qDAO.atualiza(q);
		// Verifica se Atualizo
		Quarto busca = qDAO.busca(q.getNumero());
		assertThat(busca.getNumero()).isNotNull();
		assertThat(busca.getTipoDeQuarto()).isEqualTo(TipoDeQuarto.DUPLO);
	}

	@Test
	public void testRemove() {
		// Cria Quarto
		Quarto q = Quarto.builder().numero("3").tipoDeQuarto(TipoDeQuarto.MEGA_ULTRA).build();
		// Salva Quarto
		qDAO.salva(q);
		// Verifica se salvo
		assertThat(qDAO.busca(q.getNumero()).getNumero()).isNotNull();
		// Remove
		qDAO.remove(q.getNumero());
		// Verifica se removeu
		assertThat(qDAO.busca(q.getNumero())).isNull();
	}

	@Test
	public void testBusca() {
		// Cria Quarto
		Quarto q1 = Quarto.builder().numero("4").tipoDeQuarto(TipoDeQuarto.MEGA_ULTRA).build();
		Quarto q2 = Quarto.builder().numero("5").tipoDeQuarto(TipoDeQuarto.MASTER).build();
		Quarto q3 = Quarto.builder().numero("6").tipoDeQuarto(TipoDeQuarto.STANDARD).build();
		// Salva Quarto
		qDAO.salva(q1);
		qDAO.salva(q2);
		qDAO.salva(q3);
		// Verifica se salvo
		assertThat(qDAO.busca(q1.getNumero()).getNumero()).isNotNull();
		assertThat(qDAO.busca(q2.getNumero()).getNumero()).isNotNull();
		assertThat(qDAO.busca(q3.getNumero()).getNumero()).isNotNull();
		//Busca Quarto
		List<Quarto> quartos = qDAO.busca();
		//Deve ter no minimo 3
		assertThat(quartos).size().isGreaterThan(2);
	}

}

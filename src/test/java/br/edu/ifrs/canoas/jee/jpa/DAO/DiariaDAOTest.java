package br.edu.ifrs.canoas.jee.jpa.DAO;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifrs.canoas.jee.jpa.pojo.Diaria;
import br.edu.ifrs.canoas.jee.jpa.pojo.Endereco;
import br.edu.ifrs.canoas.jee.jpa.pojo.PessoaFisica;
import br.edu.ifrs.canoas.jee.jpa.pojo.Quarto;
import br.edu.ifrs.canoas.jee.jpa.pojo.TipoDeQuarto;

public class DiariaDAOTest {

	DiariaDAO dDAO;
	QuartoDAO qDAO;
	PessoaFisicaDAO pfDAO;

	@Before
	public void setup() {
		dDAO = new DiariaDAO();
		qDAO = new QuartoDAO();
		pfDAO = new PessoaFisicaDAO();
	}

	@Test
	public void testSalva() {
		// Cria Quarto
		Quarto quarto = Quarto.builder().numero("1").tipoDeQuarto(TipoDeQuarto.MASTER).build();
		// Salva Quarto
		qDAO.salva(quarto);
		// Verifica se salvo
		assertThat(qDAO.busca(quarto.getNumero()).getNumero()).isEqualTo(quarto.getNumero());
		// Cria Diario
		LocalDate ld = LocalDate.of(2019, 10, 14);
		Diaria diaria = Diaria.builder().data(Date.valueOf(ld)).build();
		diaria.setQuarto(quarto);
		// Salva Diario
		dDAO.salva(diaria);
		// verifica se salvo
		assertThat(diaria.getId()).isNotNull();

	}

	@Test
	public void testAtualiza() {
		// Cria Quarto
		Quarto quarto = Quarto.builder().numero("2").tipoDeQuarto(TipoDeQuarto.MASTER).build();
		// Salva Quarto
		qDAO.salva(quarto);
		// Verifica se salvo
		assertThat(qDAO.busca(quarto.getNumero()).getNumero()).isEqualTo(quarto.getNumero());
		// Cria Diario
		LocalDate ld = LocalDate.of(2019, 10, 14);
		Diaria diaria = Diaria.builder().data(Date.valueOf(ld)).build();
		diaria.setQuarto(quarto);
		// Salva Diario
		dDAO.salva(diaria);
		// verifica se salvo
		assertThat(diaria.getId()).isNotNull();
		// Altera
		ld = LocalDate.of(2019, 11, 15);
		diaria.setData(Date.valueOf(ld));
		// Atualiza
		dDAO.atualiza(diaria);
		// Verifica se Atualizo
		Diaria busca = dDAO.busca(diaria.getId());
		assertThat(busca.getId()).isNotNull();
		assertThat(busca.getData().getDate()).isEqualTo(diaria.getData().getDate());
	}

	@Test
	public void testRemove() {
		// Cria Quarto
		Quarto quarto = Quarto.builder().numero("3").tipoDeQuarto(TipoDeQuarto.MASTER).build();
		// Salva Quarto
		qDAO.salva(quarto);
		// Verifica se salvo
		assertThat(qDAO.busca(quarto.getNumero()).getNumero()).isEqualTo(quarto.getNumero());
		// Cria Diario
		LocalDate ld = LocalDate.of(2019, 10, 14);
		Diaria diaria = Diaria.builder().data(Date.valueOf(ld)).build();
		diaria.setQuarto(quarto);
		// Salva Diario
		dDAO.salva(diaria);
		// verifica se salvo
		assertThat(diaria.getId()).isNotNull();
		// Remove
		dDAO.remove(diaria.getId());
		// Verifica se removeu
		assertThat(dDAO.busca(diaria.getId())).isNull();
	}

	@Test
	public void testBusca() {
		// Cria Diario
		LocalDate ld = LocalDate.of(2019, 10, 14);
		Diaria d1 = Diaria.builder().data(Date.valueOf(ld)).build();
		Diaria d2 = Diaria.builder().data(Date.valueOf(ld)).build();
		Diaria d3 = Diaria.builder().data(Date.valueOf(ld)).build();
		// Salva Diario
		dDAO.salva(d1);
		dDAO.salva(d2);
		dDAO.salva(d3);
		// Busca
		List<Diaria> diarias = dDAO.busca();
		// Deve ter 2
		assertThat(diarias).size().isGreaterThan(2);
	}

	@Test
	public void buscaCompleta() {
		// Cria PessoFisica
		LocalDate ld = LocalDate.of(2019, 10, 13);
		PessoaFisica pf = new PessoaFisica();
		pf.setNome("William José");
		pf.setEmail("williamjmrosa@gmail.com");
		pf.setCpf("43212343212");
		pf.setRg("432");
		pf.setDataNascimento(Date.valueOf(ld));
		// Cria Endereco
		Endereco endereco = Endereco.builder().logradouro("RUA").bairro("Bairro").cep("92440320").numero(12)
				.complemento("completa").uf("RS").build();
		// Adiciona Endereco a Pessoa Fisica
		pf.setEndereco(endereco);
		// Salva Pessoa Fisica e Endereco
		pfDAO.salva(pf);
		// Verifica se Salvo
		assertThat(pf.getId()).isNotNull();
		assertThat(endereco.getId()).isNotNull();
		// Cria Quarto
		Quarto quarto = Quarto.builder().numero("4").tipoDeQuarto(TipoDeQuarto.MASTER).build();
		// Salva Quarto
		qDAO.salva(quarto);
		// Verifica se salvo
		assertThat(qDAO.busca(quarto.getNumero()).getNumero()).isEqualTo(quarto.getNumero());
		// Cria Diario
		ld = LocalDate.of(2019, 10, 14);
		Diaria diaria = Diaria.builder().data(Date.valueOf(ld)).build();
		diaria.setQuarto(quarto);
		diaria.setHospedes(new ArrayList<PessoaFisica>());
		diaria.hospedesAdd(pf);
		// Salva Diario
		dDAO.salva(diaria);
		// verifica se salvo
		assertThat(diaria.getId()).isNotNull();
		Diaria busca = dDAO.buscaCompleta(diaria.getId());

		assertThat(busca.getHospedes().get(0).getNome()).isEqualTo(pf.getNome());
		
		PessoaFisica buscaPf = pfDAO.buscaCompleta(busca.getHospedes().get(0).getId());
		
		assertThat(buscaPf.getDiarias().get(0).getId()).isEqualTo(diaria.getId());
	}

}

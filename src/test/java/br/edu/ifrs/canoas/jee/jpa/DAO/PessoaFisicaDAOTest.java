package br.edu.ifrs.canoas.jee.jpa.DAO;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifrs.canoas.jee.jpa.pojo.Endereco;
import br.edu.ifrs.canoas.jee.jpa.pojo.PessoaFisica;

public class PessoaFisicaDAOTest {

	PessoaFisicaDAO pfDAO;

	@Before
	public void setup() {
		pfDAO = new PessoaFisicaDAO();
	}

	@Test
	public void testSalva() {
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
	}

	@Test
	public void testAtualiza() {
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
		// Altera
		pf.setNome("William José de Moura da Rosa");
		pf.getEndereco().setBairro("Novo Bairro");
		// Atualiza
		pfDAO.atualiza(pf);
		// Verifica se Atualizo
		PessoaFisica busca = pfDAO.buscaId(pf.getId());
		assertThat(busca.getId()).isNotNull();
		assertThat(busca.getNome()).isEqualTo(pf.getNome());
		assertThat(busca.getEndereco().getId()).isNotNull();
		assertThat(busca.getEndereco().getBairro()).isEqualTo(pf.getEndereco().getBairro());

	}

	@Test
	public void testRemove() {
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
		// Removeu
		pfDAO.remove(pf.getId());
		// Verifica se removeu
		assertThat(pfDAO.buscaId(pf.getId())).isNull();

	}

	@Test
	public void testBuscaNome() {
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
		//Busca pelo nome PessoaFisica
		List<PessoaFisica> pessoaFisicas = pfDAO.buscaNome(pf.getNome());
		
	}
	
	@Test
	public void testBusca() {
		// Cria PessoaFisica
		PessoaFisica pf1 = new PessoaFisica();
		PessoaFisica pf2 = new PessoaFisica();
		PessoaFisica pf3 = new PessoaFisica();
		// Salva PessoaFisica
		pfDAO.salva(pf1);
		pfDAO.salva(pf2);
		pfDAO.salva(pf3);
		// Busca
		List<PessoaFisica> pessoaFisicas = pfDAO.busca();
		// Deve ter 2 PessoaFisicas No banco
		assertThat(pessoaFisicas).size().isGreaterThan(2);
	}

}

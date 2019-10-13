package br.edu.ifrs.canoas.jee.jpa.DAO;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifrs.canoas.jee.jpa.pojo.Endereco;

public class EnderecoDAOTest {

	EnderecoDAO enderecoDAO;

	@Before
	public void setup() {
		enderecoDAO = new EnderecoDAO();
	}

	@Test
	public void testSalva() {
		// Cria Endereco
		Endereco endereco = Endereco.builder().logradouro("RUA").bairro("Bairro").cep("92440320").numero(12)
				.complemento("completa").uf("RS").build();
		// Salva Endereco
		enderecoDAO.salva(endereco);
		// Verifica se salvo
		assertThat(endereco.getId()).isNotNull();
	}

	@Test
	public void testAtualiza() {
		// Cria Endereco
		Endereco endereco = Endereco.builder().logradouro("RUA").bairro("Bairro").cep("92440320").numero(12)
				.complemento("completa").uf("RS").build();
		// Salva Endereco
		enderecoDAO.salva(endereco);
		// Verifica se salvo
		assertThat(endereco.getId()).isNotNull();
		// Altera
		endereco.setBairro("Novo Bairro");
		endereco.setCep("92000320");
		endereco.setComplemento("Novo Complemento");
		endereco.setLogradouro("Nova Rua");
		endereco.setNumero(32);
		endereco.setUf("Novo RS");
		// Atualiza
		enderecoDAO.atualiza(endereco);
		// Verifica se atualizo
		Endereco busca = enderecoDAO.buscaId(endereco.getId());
		assertThat(busca.getId()).isNotNull();
		assertThat(busca.getBairro()).isEqualTo(endereco.getBairro());
		assertThat(busca.getCep()).isEqualTo(endereco.getCep());
		assertThat(busca.getComplemento()).isEqualTo(endereco.getComplemento());
		assertThat(busca.getLogradouro()).isEqualTo(endereco.getLogradouro());
		assertThat(busca.getNumero()).isEqualTo(endereco.getNumero());
		assertThat(busca.getUf()).isEqualTo(endereco.getUf());
	}

	@Test
	public void testRemove() {
		// Cria Endereco
		Endereco endereco = Endereco.builder().logradouro("RUA").bairro("Bairro").cep("92440320").numero(12)
				.complemento("completa").uf("RS").build();
		// Salva Endereco
		enderecoDAO.salva(endereco);
		// Verifica se salvo
		assertThat(endereco.getId()).isNotNull();
		// Remove endereco
		enderecoDAO.remove(endereco.getId());
		// Verifica se removeu
		assertThat(enderecoDAO.buscaId(endereco.getId())).isNull();
	}

	@Test
	public void testBusca() {
		// Cria Endereco
		Endereco e1 = new Endereco();
		Endereco e2 = new Endereco();
		Endereco e3 = new Endereco();
		// Salva Endereco
		enderecoDAO.salva(e1);
		enderecoDAO.salva(e2);
		enderecoDAO.salva(e3);
		// Verifica se salvo
		assertThat(e1.getId()).isNotNull();
		assertThat(e2.getId()).isNotNull();
		assertThat(e3.getId()).isNotNull();
		// Busca Enderecos
		List<Endereco> enderecos = enderecoDAO.busca();
		// Deve ter no minino 3 enderecos no banco
		assertThat(enderecos).size().isGreaterThanOrEqualTo(3);

	}

	@Test
	public void testBuscaCEP() {
		// Cria Endereco
		Endereco endereco = Endereco.builder().logradouro("RUA").bairro("Bairro").cep("92440320").numero(12)
				.complemento("completa").uf("RS").build();
		// Salva Endereco
		enderecoDAO.salva(endereco);
		// Verifica se salvo
		assertThat(endereco.getId()).isNotNull();
		//Busca pelo CEP
		Endereco busca = enderecoDAO.buscaCEP(endereco.getCep()).get(0);
		//Verifica se busco
		assertThat(busca.getId()).isNotNull();
		assertThat(busca.getCep()).isEqualTo(endereco.getCep());
	}

}

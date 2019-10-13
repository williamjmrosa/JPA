package br.edu.ifrs.canoas.jee.jpa.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifrs.canoas.jee.jpa.pojo.Endereco;
import br.edu.ifrs.canoas.jee.jpa.pojo.PessoaFisica;
import br.edu.ifrs.canoas.jee.jpa.util.EntityManagerUtil;

public class PessoaFisicaDAO {
	
	private EntityManager em;
	
	public PessoaFisicaDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void salva(PessoaFisica pessoaFisica) {
		em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		em.persist(pessoaFisica);
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualiza(PessoaFisica pessoaFisica) {
		em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		em.merge(pessoaFisica);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Long id) {
		em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		PessoaFisica pessoaFisica = em.find(PessoaFisica.class, id);
		em.remove(pessoaFisica);
		em.getTransaction().commit();
		em.close();
	}
	
	public PessoaFisica buscaId(Long id) {
		em = EntityManagerUtil.getEM();
		PessoaFisica pessoaFisica = em.find(PessoaFisica.class, id);
		em.close();
		return pessoaFisica;
	}
	
	public List<PessoaFisica> busca(){
		em = EntityManagerUtil.getEM();
		TypedQuery<PessoaFisica> query = em.createQuery("SELECT p FROM PessoaFisica p",PessoaFisica.class);
		List<PessoaFisica> pessoaFisicas = query.getResultList();
		em.close();
		return pessoaFisicas;
	}
	
	public List<PessoaFisica> buscaNome(String nome){
		em = EntityManagerUtil.getEM();
		TypedQuery<PessoaFisica> query = em.createQuery("SELECT p FROM PessoaFisica p WHERE lower(p.nome) = lower(:nome)",PessoaFisica.class);
		if(nome != null) {
			query.setParameter("nome",nome);
		}
		List<PessoaFisica> pessoaFisicas = query.getResultList();
		em.close();
		return pessoaFisicas;
	}
}

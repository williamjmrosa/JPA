package br.edu.ifrs.canoas.jee.jpa.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifrs.canoas.jee.jpa.pojo.PessoaJuridica;
import br.edu.ifrs.canoas.jee.jpa.util.EntityManagerUtil;

public class PessoaJuridicaDAO {
	
private EntityManager em;
	
	public PessoaJuridicaDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void salva(PessoaJuridica pessoaJuridica) {
		em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		em.persist(pessoaJuridica);
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualiza(PessoaJuridica pessoaJuridica) {
		em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		em.merge(pessoaJuridica);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Long id) {
		em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		PessoaJuridica pessoaJuridica = em.find(PessoaJuridica.class, id);
		em.remove(pessoaJuridica);
		em.getTransaction().commit();
		em.close();
	}
	
	public PessoaJuridica buscaId(Long id) {
		em = EntityManagerUtil.getEM();
		PessoaJuridica pessoaJuridica = em.find(PessoaJuridica.class, id);
		em.close();
		return pessoaJuridica;
	}
	
	public List<PessoaJuridica> busca(){
		em = EntityManagerUtil.getEM();
		TypedQuery<PessoaJuridica> query = em.createQuery("SELECT p FROM PessoaJuridica p",PessoaJuridica.class);
		List<PessoaJuridica> pessoaJuridicas = query.getResultList();
		em.close();
		return pessoaJuridicas;
	}
	
	public List<PessoaJuridica> buscaNome(String nome){
		em = EntityManagerUtil.getEM();
		TypedQuery<PessoaJuridica> query = em.createQuery("SELECT p FROM PessoaJuridica p WHERE lower(p.nome) = lower(:nome)",PessoaJuridica.class);
		if(nome != null) {
			query.setParameter("nome",nome);
		}
		List<PessoaJuridica> pessoaJuridicas = query.getResultList();
		em.close();
		return pessoaJuridicas;
	}
}

package br.edu.ifrs.canoas.jee.jpa.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifrs.canoas.jee.jpa.pojo.Endereco;
import br.edu.ifrs.canoas.jee.jpa.util.EntityManagerUtil;

public class EnderecoDAO {

	EntityManager em;
	
	public EnderecoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void salva(Endereco endereco) {
		em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		em.persist(endereco);
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualiza(Endereco endereco) {
		em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		em.merge(endereco);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Long id) {
		em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		Endereco endereco = em.find(Endereco.class, id);
		em.remove(endereco);
		em.getTransaction().commit();
		em.close();
	}
	
	public Endereco buscaId(Long id) {
		em = EntityManagerUtil.getEM();
		Endereco endereco = em.find(Endereco.class, id);
		em.close();
		return endereco;
	}
	
	public List<Endereco> busca(){
		em = EntityManagerUtil.getEM();
		TypedQuery<Endereco> query = em.createQuery("SELECT ende FROM Endereco ende",Endereco.class);
		List<Endereco> enderecos = query.getResultList();
		em.close();
		return enderecos;
	}
	
	public List<Endereco> buscaCEP(String cep){
		em = EntityManagerUtil.getEM();
		TypedQuery<Endereco> query = em.createQuery("SELECT ende FROM Endereco ende WHERE ende.cep = :cep",Endereco.class);
		if(cep != null) {
			query.setParameter("cep",cep);
		}
		List<Endereco> enderecos = query.getResultList();
		em.close();
		return enderecos;
	}
	
	
}

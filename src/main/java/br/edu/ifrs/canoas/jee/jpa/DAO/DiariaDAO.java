package br.edu.ifrs.canoas.jee.jpa.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifrs.canoas.jee.jpa.pojo.Diaria;
import br.edu.ifrs.canoas.jee.jpa.util.EntityManagerUtil;

public class DiariaDAO {

	EntityManager em;
	
	public DiariaDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void salva(Diaria diaria) {
		em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		em.persist(diaria);
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualiza(Diaria diaria) {
		em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		em.merge(diaria);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Long id) {
		em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		Diaria diaria = em.find(Diaria.class, id);
		em.remove(diaria);
		em.getTransaction().commit();
		em.close();
	}
	
	public Diaria busca(Long id) {
		em = EntityManagerUtil.getEM();
		Diaria diaria = em.find(Diaria.class, id);
		em.close();
		return diaria;
	}
	
	public Diaria buscaCompleta(Long id) {
		em = EntityManagerUtil.getEM();
		Diaria diaria = em.find(Diaria.class, id);
		diaria.getHospedes().size();
		em.close();
		return diaria;
	}
	
	public List<Diaria> busca(){
		em = EntityManagerUtil.getEM();
		TypedQuery<Diaria> query = em.createQuery("SELECT d FROM Diaria d",Diaria.class);
		List<Diaria> diarias = query.getResultList();
		return diarias;
	}
	
}

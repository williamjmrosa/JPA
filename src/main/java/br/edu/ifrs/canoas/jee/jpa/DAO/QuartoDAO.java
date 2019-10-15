package br.edu.ifrs.canoas.jee.jpa.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifrs.canoas.jee.jpa.pojo.Quarto;
import br.edu.ifrs.canoas.jee.jpa.pojo.Reserva;
import br.edu.ifrs.canoas.jee.jpa.util.EntityManagerUtil;

public class QuartoDAO {
	
	EntityManager em;
	
	public QuartoDAO() {
		// TODO Auto-generated constructor stub
	}

	public void salva(Quarto quarto) {
		em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		em.persist(quarto);
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualiza(Quarto quarto) {
		em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		em.persist(quarto);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Long id) {
		em = EntityManagerUtil.getEM();
		Quarto quarto = em.find(Quarto.class, id);
		em.remove(quarto);
		em.close();
	}
	
	public Quarto busca(Long id) {
		em = EntityManagerUtil.getEM();
		Quarto quarto = em.find(Quarto.class, id);
		em.close();
		return quarto;
	}
	
	public List<Quarto> busca(){
		em = EntityManagerUtil.getEM();
		TypedQuery<Quarto> query = em.createQuery("SELECT q FROM Quarto q",Quarto.class);
		List<Quarto> quartos = query.getResultList();
		return quartos;
	}
	
}

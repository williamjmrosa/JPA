package br.edu.ifrs.canoas.jee.jpa.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifrs.canoas.jee.jpa.pojo.Reserva;
import br.edu.ifrs.canoas.jee.jpa.util.EntityManagerUtil;

public class ReservaDAO {
	
	EntityManager em;
	
	public ReservaDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void salva(Reserva reserva) {
		em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		em.persist(reserva);
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualiza(Reserva reserva) {
		em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		em.merge(reserva);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Long id) {
		em = EntityManagerUtil.getEM();
		Reserva reserva = em.find(Reserva.class, id);
		em.remove(reserva);
		em.close();
	}
	
	public Reserva busca(Long id) {
		em = EntityManagerUtil.getEM();
		Reserva reserva = em.find(Reserva.class, id);
		em.close();
		return reserva;
	}
	
	public List<Reserva> busca(){
		em = EntityManagerUtil.getEM();
		TypedQuery<Reserva> query = em.createQuery("SELECT r FROM Reserva r",Reserva.class);
		List<Reserva> reservas = query.getResultList();
		return reservas;
	}
	
}

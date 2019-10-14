package br.edu.ifrs.canoas.jee.jpa.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifrs.canoas.jee.jpa.util.EntityManagerUtil;

public class DiariaReservadaDAO {

	EntityManager em;
	
	public DiariaReservadaDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void salva(DiariaReservadaDAO diariaReservada) {
		em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		em.persist(diariaReservada);
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualiza(DiariaReservadaDAO diariaReservada) {
		em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		em.persist(diariaReservada);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Long id) {
		em = EntityManagerUtil.getEM();
		DiariaReservadaDAO diariaReservada = em.find(DiariaReservadaDAO.class, id);
		em.remove(diariaReservada);
		em.close();
	}
	
	public DiariaReservadaDAO busca(Long id) {
		em = EntityManagerUtil.getEM();
		DiariaReservadaDAO diariaReservada = em.find(DiariaReservadaDAO.class, id);
		em.close();
		return diariaReservada;
	}
	
	public List<DiariaReservadaDAO> busca(){
		em = EntityManagerUtil.getEM();
		TypedQuery<DiariaReservadaDAO> query = em.createQuery("SELECT da FROM DiariaReservada da",DiariaReservadaDAO.class);
		List<DiariaReservadaDAO> diariaReservadas = query.getResultList();
		return diariaReservadas;
	}
	
}

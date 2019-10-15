package br.edu.ifrs.canoas.jee.jpa.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.edu.ifrs.canoas.jee.jpa.pojo.DiariaReservada;
import br.edu.ifrs.canoas.jee.jpa.util.EntityManagerUtil;

public class DiariaReservadaDAO {

	EntityManager em;
	
	public DiariaReservadaDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public void salva(DiariaReservada diariaReservada) {
		em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		em.persist(diariaReservada);
		em.getTransaction().commit();
		em.close();
	}
	
	public void atualiza(DiariaReservada diariaReservada) {
		em = EntityManagerUtil.getEM();
		em.getTransaction().begin();
		em.merge(diariaReservada);
		em.getTransaction().commit();
		em.close();
	}
	
	public void remove(Long id) {
		em = EntityManagerUtil.getEM();
		DiariaReservada diariaReservada = em.find(DiariaReservada.class, id);
		em.remove(diariaReservada);
		em.close();
	}
	
	public DiariaReservada busca(Long id) {
		em = EntityManagerUtil.getEM();
		DiariaReservada diariaReservada = em.find(DiariaReservada.class, id);
		em.close();
		return diariaReservada;
	}
	
	public List<DiariaReservada> busca(){
		em = EntityManagerUtil.getEM();
		TypedQuery<DiariaReservada> query = em.createQuery("SELECT da FROM DiariaReservada da",DiariaReservada.class);
		List<DiariaReservada> diariaReservadas = query.getResultList();
		return diariaReservadas;
	}
	
}

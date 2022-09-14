/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segta.controladores;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import segta.clases.Homo;
import segta.clases.Tamboreshomo;
import segta.exceptions.NonexistentEntityException;

/**
 *
 * @author MODERNIZACION
 */
public class TamboreshomoJpaController implements Serializable {

    public TamboreshomoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Tamboreshomo tamboreshomo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Homo idHomo = tamboreshomo.getIdHomo();
            if (idHomo != null) {
                idHomo = em.getReference(idHomo.getClass(), idHomo.getIdHomo());
                tamboreshomo.setIdHomo(idHomo);
            }
            em.persist(tamboreshomo);
            if (idHomo != null) {
                idHomo.getTamboreshomoCollection().add(tamboreshomo);
                idHomo = em.merge(idHomo);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Tamboreshomo tamboreshomo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tamboreshomo persistentTamboreshomo = em.find(Tamboreshomo.class, tamboreshomo.getIdTamboresHomo());
            Homo idHomoOld = persistentTamboreshomo.getIdHomo();
            Homo idHomoNew = tamboreshomo.getIdHomo();
            if (idHomoNew != null) {
                idHomoNew = em.getReference(idHomoNew.getClass(), idHomoNew.getIdHomo());
                tamboreshomo.setIdHomo(idHomoNew);
            }
            tamboreshomo = em.merge(tamboreshomo);
            if (idHomoOld != null && !idHomoOld.equals(idHomoNew)) {
                idHomoOld.getTamboreshomoCollection().remove(tamboreshomo);
                idHomoOld = em.merge(idHomoOld);
            }
            if (idHomoNew != null && !idHomoNew.equals(idHomoOld)) {
                idHomoNew.getTamboreshomoCollection().add(tamboreshomo);
                idHomoNew = em.merge(idHomoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = tamboreshomo.getIdTamboresHomo();
                if (findTamboreshomo(id) == null) {
                    throw new NonexistentEntityException("The tamboreshomo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Tamboreshomo tamboreshomo;
            try {
                tamboreshomo = em.getReference(Tamboreshomo.class, id);
                tamboreshomo.getIdTamboresHomo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tamboreshomo with id " + id + " no longer exists.", enfe);
            }
            Homo idHomo = tamboreshomo.getIdHomo();
            if (idHomo != null) {
                idHomo.getTamboreshomoCollection().remove(tamboreshomo);
                idHomo = em.merge(idHomo);
            }
            em.remove(tamboreshomo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Tamboreshomo> findTamboreshomoEntities() {
        return findTamboreshomoEntities(true, -1, -1);
    }

    public List<Tamboreshomo> findTamboreshomoEntities(int maxResults, int firstResult) {
        return findTamboreshomoEntities(false, maxResults, firstResult);
    }

    private List<Tamboreshomo> findTamboreshomoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Tamboreshomo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Tamboreshomo findTamboreshomo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Tamboreshomo.class, id);
        } finally {
            em.close();
        }
    }

    public int getTamboreshomoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Tamboreshomo> rt = cq.from(Tamboreshomo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

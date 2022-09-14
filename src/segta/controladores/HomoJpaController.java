/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package segta.controladores;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import segta.clases.Tamboreshomo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import segta.clases.Homo;
import segta.exceptions.IllegalOrphanException;
import segta.exceptions.NonexistentEntityException;

/**
 *
 * @author MODERNIZACION
 */
public class HomoJpaController implements Serializable {

    public HomoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Homo homo) {
        if (homo.getTamboreshomoCollection() == null) {
            homo.setTamboreshomoCollection(new ArrayList<Tamboreshomo>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Tamboreshomo> attachedTamboreshomoCollection = new ArrayList<Tamboreshomo>();
            for (Tamboreshomo tamboreshomoCollectionTamboreshomoToAttach : homo.getTamboreshomoCollection()) {
                tamboreshomoCollectionTamboreshomoToAttach = em.getReference(tamboreshomoCollectionTamboreshomoToAttach.getClass(), tamboreshomoCollectionTamboreshomoToAttach.getIdTamboresHomo());
                attachedTamboreshomoCollection.add(tamboreshomoCollectionTamboreshomoToAttach);
            }
            homo.setTamboreshomoCollection(attachedTamboreshomoCollection);
            em.persist(homo);
            for (Tamboreshomo tamboreshomoCollectionTamboreshomo : homo.getTamboreshomoCollection()) {
                Homo oldIdHomoOfTamboreshomoCollectionTamboreshomo = tamboreshomoCollectionTamboreshomo.getIdHomo();
                tamboreshomoCollectionTamboreshomo.setIdHomo(homo);
                tamboreshomoCollectionTamboreshomo = em.merge(tamboreshomoCollectionTamboreshomo);
                if (oldIdHomoOfTamboreshomoCollectionTamboreshomo != null) {
                    oldIdHomoOfTamboreshomoCollectionTamboreshomo.getTamboreshomoCollection().remove(tamboreshomoCollectionTamboreshomo);
                    oldIdHomoOfTamboreshomoCollectionTamboreshomo = em.merge(oldIdHomoOfTamboreshomoCollectionTamboreshomo);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Homo homo) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Homo persistentHomo = em.find(Homo.class, homo.getIdHomo());
            Collection<Tamboreshomo> tamboreshomoCollectionOld = persistentHomo.getTamboreshomoCollection();
            Collection<Tamboreshomo> tamboreshomoCollectionNew = homo.getTamboreshomoCollection();
            List<String> illegalOrphanMessages = null;
            for (Tamboreshomo tamboreshomoCollectionOldTamboreshomo : tamboreshomoCollectionOld) {
                if (!tamboreshomoCollectionNew.contains(tamboreshomoCollectionOldTamboreshomo)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Tamboreshomo " + tamboreshomoCollectionOldTamboreshomo + " since its idHomo field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Tamboreshomo> attachedTamboreshomoCollectionNew = new ArrayList<Tamboreshomo>();
            for (Tamboreshomo tamboreshomoCollectionNewTamboreshomoToAttach : tamboreshomoCollectionNew) {
                tamboreshomoCollectionNewTamboreshomoToAttach = em.getReference(tamboreshomoCollectionNewTamboreshomoToAttach.getClass(), tamboreshomoCollectionNewTamboreshomoToAttach.getIdTamboresHomo());
                attachedTamboreshomoCollectionNew.add(tamboreshomoCollectionNewTamboreshomoToAttach);
            }
            tamboreshomoCollectionNew = attachedTamboreshomoCollectionNew;
            homo.setTamboreshomoCollection(tamboreshomoCollectionNew);
            homo = em.merge(homo);
            for (Tamboreshomo tamboreshomoCollectionNewTamboreshomo : tamboreshomoCollectionNew) {
                if (!tamboreshomoCollectionOld.contains(tamboreshomoCollectionNewTamboreshomo)) {
                    Homo oldIdHomoOfTamboreshomoCollectionNewTamboreshomo = tamboreshomoCollectionNewTamboreshomo.getIdHomo();
                    tamboreshomoCollectionNewTamboreshomo.setIdHomo(homo);
                    tamboreshomoCollectionNewTamboreshomo = em.merge(tamboreshomoCollectionNewTamboreshomo);
                    if (oldIdHomoOfTamboreshomoCollectionNewTamboreshomo != null && !oldIdHomoOfTamboreshomoCollectionNewTamboreshomo.equals(homo)) {
                        oldIdHomoOfTamboreshomoCollectionNewTamboreshomo.getTamboreshomoCollection().remove(tamboreshomoCollectionNewTamboreshomo);
                        oldIdHomoOfTamboreshomoCollectionNewTamboreshomo = em.merge(oldIdHomoOfTamboreshomoCollectionNewTamboreshomo);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = homo.getIdHomo();
                if (findHomo(id) == null) {
                    throw new NonexistentEntityException("The homo with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Homo homo;
            try {
                homo = em.getReference(Homo.class, id);
                homo.getIdHomo();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The homo with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Tamboreshomo> tamboreshomoCollectionOrphanCheck = homo.getTamboreshomoCollection();
            for (Tamboreshomo tamboreshomoCollectionOrphanCheckTamboreshomo : tamboreshomoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Homo (" + homo + ") cannot be destroyed since the Tamboreshomo " + tamboreshomoCollectionOrphanCheckTamboreshomo + " in its tamboreshomoCollection field has a non-nullable idHomo field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(homo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Homo> findHomoEntities() {
        return findHomoEntities(true, -1, -1);
    }

    public List<Homo> findHomoEntities(int maxResults, int firstResult) {
        return findHomoEntities(false, maxResults, firstResult);
    }

    private List<Homo> findHomoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Homo.class));
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

    public Homo findHomo(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Homo.class, id);
        } finally {
            em.close();
        }
    }

    public int getHomoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Homo> rt = cq.from(Homo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}

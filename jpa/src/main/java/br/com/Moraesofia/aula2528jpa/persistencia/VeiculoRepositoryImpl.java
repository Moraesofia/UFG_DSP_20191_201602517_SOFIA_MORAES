package br.com.Moraesofia.aula2528jpa.persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.Moraesofia.aula2528jpa.model.Veiculo;

public class VeiculoRepositoryImpl implements VeiculoRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("br.com.Moraesofia.aula2528jpa");
    private EntityManager em;

    public VeiculoRepositoryImpl() {
        em = emf.createEntityManager();
    }

    @Override
    public Veiculo create(Veiculo vel) {
        em.getTransaction().begin();
        em.persist(vel);
        em.getTransaction().commit();
        return vel;
    }

    @Override
    public Veiculo read(Long id) {
        // em.getTransaction().begin();
        Veiculo vel = em.find(Veiculo.class, id);
        // em.getTransaction().commit();
        return vel;
    }

    // @Override
    // public List<Veiculo> findByName(String name) {
    // Query query = em.createQuery("Select v from Veiculo v where v.nome like
    // :name");
    // query.setParameter("name", name);
    // return query.getResultList();
    // }

    @Override
    public Veiculo update(Veiculo veiculo) {
        em.getTransaction().begin();
        veiculo = em.merge(veiculo);
        em.getTransaction().commit();
        return veiculo;
    }

    @Override
    public void delete(Veiculo veiculo) {
        em.getTransaction().begin();
        em.remove(veiculo);
        em.getTransaction().commit();
    }

    @Override
    public void close() {
        emf.close();
    }
}

package net.gtidev.sandbox.dbaccess;

import net.gtidev.sandbox.model.Address;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Repository
@Transactional
public class AddressServiceImpl implements AddressService {

  @PersistenceContext
  private EntityManager em;

  @Override
  public Address loadAddress(Long id) {

    TypedQuery query = em.createQuery("select a from Address a where a.id = ?1", Address.class);
    query.setParameter(1, id);

    return (Address) query.getSingleResult();
  }
}

package net.gtidev.sandbox.dbaccess;

import net.gtidev.sandbox.model.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookServiceImpl implements BookService {

  @PersistenceContext
  private EntityManager em;

  @Override
  public Book loadBook(Long id) {

    TypedQuery query = em.createQuery("select r from Book r where r.id = ?1", Book.class);

    query.setParameter(1, id);

    return (Book) query.getSingleResult();
  }
}

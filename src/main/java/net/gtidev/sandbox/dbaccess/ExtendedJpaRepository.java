package net.gtidev.sandbox.dbaccess;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.util.Optional;

@NoRepositoryBean
public interface ExtendedJpaRepository<T, ID extends Serializable> extends JpaRepository<T, ID> {
    Optional<T> findById(ID id);
}

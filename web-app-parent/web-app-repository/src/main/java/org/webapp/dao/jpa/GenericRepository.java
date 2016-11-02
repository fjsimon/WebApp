package org.webapp.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.webapp.model.Identity;

import java.io.Serializable;

@Component
@Transactional
public interface GenericRepository<T extends Identity, PK extends Serializable> extends JpaRepository<T, PK> {}

package org.webapp.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.webapp.model.Identity;

import java.io.Serializable;

public interface GenericRepository<T extends Identity, PK extends Serializable> extends JpaRepository<T, PK> {}

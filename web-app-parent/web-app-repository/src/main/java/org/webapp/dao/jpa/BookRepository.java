package org.webapp.dao.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;

// TODO Create a generic dao to extends JpaRepository
public interface BookRepository<T, PK extends Serializable> extends JpaRepository<T, PK> {}

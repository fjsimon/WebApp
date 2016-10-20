package org.webapp.model;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
public class Books implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -7792412266615174424L;
    private List<Book> books = new ArrayList<Book>();

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(books)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() == obj.getClass()) {
            Books other = (Books) obj;
            return new EqualsBuilder()
                    .append(books, other.books)
                    .isEquals();

        } else {
            return false;
        }
    }

    @Override
    public String toString() {

        return "Books [books=" + books + "]";
    }

}


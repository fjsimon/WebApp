package org.webapp.model;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public class Identity implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -3476936475623063326L;

    @Id
//    @DocumentId
    private long id;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

}

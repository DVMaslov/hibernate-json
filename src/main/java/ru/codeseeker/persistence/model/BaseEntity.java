package ru.codeseeker.persistence.model;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import ru.codeseeker.persistence.json.JsonType;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
@TypeDefs(@TypeDef(name = "jsonb", typeClass = JsonType.class))
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    public Long getId() {
        return id;
    }
}

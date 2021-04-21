package io.zgate.useradmin.server.persistence.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "identity_credential_types")
@Entity
public class IdentityCredentialTypesPO {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "IdentityCredentialTypesPO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

package io.zgate.admin.user.persistence.po;

import com.fasterxml.jackson.annotation.JsonRawValue;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "identity_credentials")
@Entity
public class IdentityCredentialsPO {
    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @Column(name = "config", columnDefinition = "json")
    @JsonRawValue
    private String config;

    @Column(name = "identity_credential_type_id")
    private String identityCredentialTypeId;

    @Column(name = "identity_id")
    private String identityId;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConfig() {
        return config;
    }

    public void setConfig(String config) {
        this.config = config;
    }

    public String getIdentityCredentialTypeId() {
        return identityCredentialTypeId;
    }

    public void setIdentityCredentialTypeId(String identityCredentialTypeId) {
        this.identityCredentialTypeId = identityCredentialTypeId;
    }

    public String getIdentityId() {
        return identityId;
    }

    public void setIdentityId(String identityId) {
        this.identityId = identityId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}

package org.keycloak.models.jpa.entities;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
@NamedQueries({
        @NamedQuery(name="hasScope", query="select m from ScopeMappingEntity m where m.client = :client and m.role = :role"),
        @NamedQuery(name="clientScopeMappings", query="select m from ScopeMappingEntity m where m.client = :client")
})
@Entity
public class ScopeMappingEntity {
    @Id
    @GenericGenerator(name="keycloak_generator", strategy="org.keycloak.models.jpa.utils.JpaIdGenerator")
    @GeneratedValue(generator = "keycloak_generator")
    protected String id;
    @ManyToOne
    protected ClientEntity client;
    @ManyToOne
    protected RoleEntity role;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ClientEntity getClient() {
        return client;
    }

    public void setClient(ClientEntity client) {
        this.client = client;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

}

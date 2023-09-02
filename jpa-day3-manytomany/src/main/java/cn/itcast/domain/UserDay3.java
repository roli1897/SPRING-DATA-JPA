package cn.itcast.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sys_user")
public class UserDay3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;
    @Column(name="user_name")
    private String userName;
    @Column(name="age")
    private Integer age;

    /**
     * Pour configurer une relation many-to-many entre les entités "Utilisateur" et "Rôle"
     * en utilisant l'annotation @ManyToMany dans une application Java avec JPA
     *
     *          1.Déclarer la configuration de la relation dans l'entité "Utilisateur" et "RoleDay3":
     *              @ManyToMany(targetEntity = RoleDay3.class)
     *
     *          2.créer la table intermédiaire pour gérer la relation many-to-many
     *                @JoinTable
     *                  name : le nom de la table intermédiaire
     *                  joinColumns： Configurer les colonnes étrangères pour l'objet actuel dans la table intermédiaire.
     *                      @JoinColumn
     *                          name： Nom de la colonne étrangère.
     *                          referencedColumnName：Nom de la clé primaire de la table de référence (entité propriétaire de la relation).
     *                  inverseJoinColumns：Configurer les colonnes étrangères pour l'autre objet dans la table intermédiaire.
     */
    @ManyToMany(targetEntity = RoleDay3.class,cascade = CascadeType.ALL)
    @JoinTable(name = "sys_user_role",

            joinColumns = {@JoinColumn(name = "sys_user_id",referencedColumnName = "user_id")},

            inverseJoinColumns = {@JoinColumn(name = "sys_role_id",referencedColumnName = "role_id")}
    )
    private Set<RoleDay3> roles = new HashSet<>();

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Set<RoleDay3> getRoles() {
        return roles;
    }

    public void setRoleDay3s(Set<RoleDay3> roles) {
        this.roles = roles;
    }
}

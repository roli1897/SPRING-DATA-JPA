package cn.itcast.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sys_role")
public class RoleDay3 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private long roleId;
    @Column(name = "role_name")
    private String roleName;

    //les configuration du manytomany
    @ManyToMany(mappedBy = "roles")
    private Set<UserDay3> users = new HashSet<>();

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<UserDay3> getUsers() {
        return users;
    }

    public void setUsers(Set<UserDay3> users) {
        this.users = users;
    }
}

package cn.itcast.dao;

import cn.itcast.domain.Role;
import cn.itcast.domain.RoleDay3;
import cn.itcast.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RoleDaoDay3 extends JpaRepository<RoleDay3,Long> ,JpaSpecificationExecutor<RoleDay3> {
}

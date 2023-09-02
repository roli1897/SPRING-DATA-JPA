package cn.itcast.dao;

import cn.itcast.domain.User;
import cn.itcast.domain.UserDay3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserDaoDay3 extends JpaRepository<UserDay3,Long> ,JpaSpecificationExecutor<UserDay3> {
}

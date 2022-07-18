package com.sostraik1903.distroprofes_v3.repository;

import com.sostraik1903.distroprofes_v3.entity.UserVO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface UserRepository extends JpaRepository<UserVO, Integer> {
    public abstract UserVO findByUsername(String username);

    @Query(value = "select ur.user_id, u.username, ur.role_id, r.role from users_roles ur inner join users u on ur.user_id = u.user_id inner join roles r on ur.role_id = r.role_id;", nativeQuery = true)
    public abstract Collection<Object[]> findAllWhitRole();
}

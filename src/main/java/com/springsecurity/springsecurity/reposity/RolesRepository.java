package com.springsecurity.springsecurity.reposity;

import com.springsecurity.springsecurity.model.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaRepositories
public interface RolesRepository extends JpaRepository<RoleModel, Long> {
}

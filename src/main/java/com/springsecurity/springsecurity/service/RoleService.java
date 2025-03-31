package com.springsecurity.springsecurity.service;

import com.springsecurity.springsecurity.model.RoleModel;
import com.springsecurity.springsecurity.reposity.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RolesRepository rolesRepository;

    public List<RoleModel> getAllRoles() {
        return rolesRepository.findAll();
    }

    public void registerRoleInfo (List<RoleModel> roles) {
        rolesRepository.saveAll(roles);
    }
}

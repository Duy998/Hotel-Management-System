package com.nokia.hotel.service.dto;

import org.apache.catalina.Role;

public class RoleDTO extends AbstractDTO<RoleDTO>{
    private static final long serialVersionUID = 1L;

    private String name;
    public RoleDTO(){};
    public RoleDTO(Role role) {
        this.name = role.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

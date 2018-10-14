package com.cryptoeagle.entity;

import org.junit.Test;

import static org.junit.Assert.*;

public class RoleTest {

    private static  Role ROLE = new Role("USER");

    @Test
    public void getAuthority() {
        String authority = ROLE.getAuthority();
        assertTrue(authority.equals("USER"));
    }

    @Test
    public void setRole() {
        ROLE.setRole("ADMIN");
        String authority = ROLE.getAuthority();
        assertTrue(authority.equals("ADMIN"));
    }

    @Test
    public void getRole() {
        String role = ROLE.getRole();
        assertTrue(role.equals("USER"));
    }
}
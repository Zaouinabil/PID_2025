package com.example.pid_2025.entities;

    public enum UserRole {
        ADMIN("admin"),
        MEMBER("member"),
        AFFILIATE("affiliatee"),
        PRESS("press"),
        PRODUCER("producer");

        private String role;

        UserRole(String role) {
            this.role = role;
        }

        public String getValue() {
            return role;
        }
    }


package com.example.pid_2025.entities;

    public enum UserRole {
        ADMIN("admin"),
        MEMBER("member"),
        AFFILIATE("affiliate"),
        PRESS("press"),
        PRODUCER("producer");

        private String role;

        UserRole(String role) {
            this.role = role;
        }

        public String getRole() {
            return role;
        }


        public String getValue() {
            return role;
        }
    }
//test git

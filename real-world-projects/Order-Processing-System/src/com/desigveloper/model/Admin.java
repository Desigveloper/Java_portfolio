package com.desigveloper.model;

public class Admin {
    private String adminID;
    private String department;
    private String permissions;

    public Admin(String adminID, String department, String permissions) {
        this.adminID = adminID;
        this.department = department;
        this.permissions = permissions;
    }

    // Getter
    public String getAdminID() {
        return this.adminID;
    }

    public String getDepartment() {
        return this.department;
    }

    public String permissions() {
        return this.permissions;
    }

    public void manageInventory() {

    }

    public void approveOrder() {

    }

    public void generateReports() {

    }
}

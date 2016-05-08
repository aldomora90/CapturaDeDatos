package com.aldomora.capturadedatos;

/**
 * Created by root on 8/05/16.
 */
public class Contact {
    private String name;
    private String date;
    private String telephone;
    private String email;
    private String description;

    public Contact(String name, String date, String telephone, String email, String description) {
        this.name = name;
        this.date = date;
        this.telephone = telephone;
        this.email = email;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

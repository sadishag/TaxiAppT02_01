package com.taxiapp.taxiappt02_01;

public class CustomerInformation {
    
    private String firstname;
    private String lastname;
    private String gender;
    private String username;
    private String password;
    private String email;
    
    public void CustomerInformation(String fn, String ln, String em, String g, String user, String pw) {
        firstname = fn;
        lastname = ln;
        gender = g;
        email = em;
        username = user;
        password = pw;
    }
    
    public String getFirstname() { return firstname; }
    public String getLastname() { return lastname; }
    public String getGender() { return gender; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
    
}

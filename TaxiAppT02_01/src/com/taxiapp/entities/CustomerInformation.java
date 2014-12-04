package com.taxiapp.entities;

public class CustomerInformation {
    
    private static String firstname;
    private static String lastname;
    private static String gender;
    private static String username;
    private static String password;
    private static String email;
    
    public static void setInformation(String[] str) {
        firstname = str[2];
        lastname = str[3];
        gender = str[5];
        email = str[4];
        username = str[6];
        password = str[7];
    }
    
    
    
    public static String getFirstname() { return firstname; }
    public static String getLastname() { return lastname; }
    public static String getGender() { return gender; }
    public static String getUsername() { return username; }
    public static String getPassword() { return password; }
    public static String getEmail() { return email; }
    
    public static void setFirstname(String str) { firstname = str; }
    public static void setLastname(String str) { lastname = str; }
    public static void setGender(String str) { gender = str; }
    public static void setUsername(String str) { username = str; }
    public static void setPassword(String str) { password = str; }
    public static void setEmail(String str) { email = str; }
    
}

package com.taxiapp.entities;

public class TaxiRideInformation {
    private static String username;
    private static String datebookedfor = "";
    private static String timebookedfor;
    private static String startaddress;
    private static String endaddress;
    private static String estimatedcost;
    private static String taxisharers;
    
    public static void setInformation(String[] str) {
        username = str[2];
        datebookedfor = str[3];
        timebookedfor = str[5];
        startaddress = str[4];
        endaddress = str[6];
        estimatedcost = str[7];
        taxisharers = str[8];
    }
    
    public String getUsername() { return username; }
    public static String getDate() { return datebookedfor; }
    public String getTime() { return timebookedfor; }
    public String getStartAddress() { return startaddress; }
    public String getEndAddress() { return endaddress; }
    public String getEstimatedCost() { return estimatedcost; }
    public String getTaxisharers() { return taxisharers; }
    
    public static void setUsername(String str) { username = str; }
    public static void setDate(String str) { datebookedfor = str; }
    public static void setTime(String str) { timebookedfor = str; }
    public static void setStartAddress(String str) { startaddress = str; }
    public static void setEndAddress(String str) { endaddress = str; }
    public static void setEstimatedCost(String str) { estimatedcost = str; }
    public static void setTaxisharers(String str) { taxisharers = str; }
}

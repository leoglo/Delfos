package com.example.delfos;

public class User {


    static private int id;
    static private String altorizado;
    static private String user;
    static private String password;
    static private String xp;
    static private String mago;
    static private String level;

    public static String getAltorizado() {
        return altorizado;
    }

    public static void setAltorizado(String altorizado) {
        User.altorizado = altorizado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getXp() {
        return xp;
    }

    public void setXp(String xp) {
        this.xp = xp;
    }

    public String getMago() {
        return mago;
    }

    public void setMago(String mago) {
        this.mago = mago;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}

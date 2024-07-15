package org.flashtool.system;

public class Driver {
    private String description;
    private int major;
    private int minor;
    private int mili;
    private int micro;

    public Driver(String description, int major, int minor, int mili, int micro) {
        this.description = description;
        this.major = major;
        this.minor = minor;
        this.mili = mili;
        this.micro = micro;
    }

    public String getDescription() {
        return description;
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public int getMili() {
        return mili;
    }

    public int getMicro() {
        return micro;
    }
    
}

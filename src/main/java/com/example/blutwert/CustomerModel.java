package com.example.blutwert;

public class CustomerModel {

    private int id;
    private String datum;
    private int eisengehalt;
    private int cholesteringehalt;
    private int blutzucker;
    private int triglyceride;
    private int blutdruck;
    private int vitaminD;
    private int vitaminB12;

    public CustomerModel(int id, String datum, int eisengehalt, int cholesteringehalt, int blutzucker, int triglyceride, int blutdruck, int vitaminD, int vitaminB12) {
        this.id = id;
        this.datum = datum;
        this.eisengehalt = eisengehalt;
        this.cholesteringehalt = cholesteringehalt;
        this.blutzucker = blutzucker;
        this.triglyceride = triglyceride;
        this.blutdruck = blutdruck;
        this.vitaminD = vitaminD;
        this.vitaminB12 = vitaminB12;
    }

    public CustomerModel(int customerID, int eisengehalt, int cholesteringehalt, int blutzucker, int triglyceride, int blutdruck, int vitaminD, int vitaminB12) {
    }

    // toString is necessary for printing the contents of a class
    @Override
    public String toString() {
        return "CustomerModel{" +
                "id=" + id +
                ", datum='" + datum + '\'' +
                ", eisengehalt=" + eisengehalt +
                ", cholesteringehalt=" + cholesteringehalt +
                ", blutzucker=" + blutzucker +
                ", triglyceride=" + triglyceride +
                ", blutdruck=" + blutdruck +
                ", vitaminD=" + vitaminD +
                ", vitaminB12=" + vitaminB12 +
                '}';
    }

    //getter and setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }

    public int getEisengehalt() {
        return eisengehalt;
    }

    public void setEisengehalt(int eisengehalt) {
        this.eisengehalt = eisengehalt;
    }

    public int getCholesteringehalt() {
        return cholesteringehalt;
    }

    public void setCholesteringehalt(int cholesteringehalt) {
        this.cholesteringehalt = cholesteringehalt;
    }

    public int getBlutzucker() {
        return blutzucker;
    }

    public void setBlutzucker(int blutzucker) {
        this.blutzucker = blutzucker;
    }

    public int getTriglyceride() {
        return triglyceride;
    }

    public void setTriglyceride(int triglyceride) {
        this.triglyceride = triglyceride;
    }

    public int getBlutdruck() {
        return blutdruck;
    }

    public void setBlutdruck(int blutdruck) {
        this.blutdruck = blutdruck;
    }

    public int getVitaminD() {
        return vitaminD;
    }

    public void setVitaminD(int vitaminD) {
        this.vitaminD = vitaminD;
    }

    public int getVitaminB12() {
        return vitaminB12;
    }

    public void setVitaminB12(int vitaminB12) {
        this.vitaminB12 = vitaminB12;
    }
}

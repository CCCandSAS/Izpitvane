package com.company;

public class Apartment implements Comparable<Apartment> {
    private String city;
    private int roomsNum;
    private int plost;
    private int cena;
    private String number;
    public Apartment(String city, int roomsNum, int plost, int cena, String Number){
        this.city=city;
        this.roomsNum=roomsNum;
        this.plost=plost;
        this.cena=cena;
        this.number=number;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getRoomsNum() {
        return roomsNum;
    }

    public void setRoomsNum(int roomsNum) {
        this.roomsNum = roomsNum;
    }

    public int getPlost() {
        return plost;
    }

    public void setPlost(int plost) {
        this.plost = plost;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
    @Override
    public int compareTo(Apartment a){
        if(getCena()>a.getCena())
        {
            return 1;
        }else if(getCena()==a.getCena()){
            return 0;
        }else(return -1;)
    }
}

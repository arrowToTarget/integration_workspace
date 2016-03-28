package com.lewis.vo;

/**
 * Created by zhangminghua on 2016/3/28.
 */
public class TravelRecord {

    private int id;

    private int userId;

    private String travelDate;

    private double fee;

    private int days;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "TravelRecord{" +
                "id=" + id +
                ", userId=" + userId +
                ", travelDate='" + travelDate + '\'' +
                ", fee=" + fee +
                ", days=" + days +
                '}';
    }
}

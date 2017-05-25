
package com.januzza.archweather.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity
public class WeatherData {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("cod")
    @Expose
    private @PrimaryKey String cod;
    @SerializedName("count")
    @Expose
    private Integer count;
    @SerializedName("list")
    @Expose
    private List<City> list = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<City> getList() {
        return list;
    }

    public void setList(List<City> list) {
        this.list = list;
    }

}

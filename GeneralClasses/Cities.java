package BigProject.GeneralClasses;

import java.io.Serializable;

public class Cities implements Serializable {
    private int id;
    private String name;
    private String country;
    private String short_name;

    public Cities(int id, String name, String country, String short_name) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.short_name = short_name;
    }

    public Cities() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getShort_name() {
        return short_name;
    }

    public void setShort_name(String short_name) {
        this.short_name = short_name;
    }
}

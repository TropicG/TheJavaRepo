package gson;

import com.google.gson.annotations.SerializedName;

public class Developer {

    private String name;
    private int age;
    @SerializedName("emplyer")
    private String company;
    // if you want a data member to not appear in the json use transient as a keyword when declareing a variable
    // example: private transient String company

    public Developer(String name, int age, String company) {
        this.name = name;
        this.age = age;
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCompany() {
        return company;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

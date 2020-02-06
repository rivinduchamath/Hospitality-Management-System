package lk.ijse.deppo.hotelManagement.entity;

import lk.ijse.deppo.hotelManagement.util.UserTM;

import java.sql.Date;

public class User extends UserTM implements SuperEntity {
    private String id;
    private String name;
    private String post;
    private String password;
    private int age;
    private Date date;

    public User(String id, String name, String post, String password, int age, Date date) {
        this.id = id;
        this.name = name;
        this.post = post;
        this.password = password;
        this.age = age;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", post='" + post + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", date=" + date +
                '}';
    }
}

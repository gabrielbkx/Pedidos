package entities;

import java.util.Date;

public class Client {
    private String name;
    private String email;
    private Date birthDate;

    public Client() {
    }

    public Client(String namne, String email, Date birthDate) {
        this.name = namne;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + " " + birthDate + "-" + " " + email);
        return sb.toString();
    }

}

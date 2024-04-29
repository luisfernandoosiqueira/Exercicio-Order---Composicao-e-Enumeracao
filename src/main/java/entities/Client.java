package entities;

import exceptions.OrderException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Client {

    private String name;
    private String email;
    private Date birthDate;

    public Client() {
    }

    // Objeto criado para formatar a data
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Client(String name, String email, Date birthDate) throws OrderException {

        Date now = new Date();
        if (birthDate.after(now)) {
            throw new OrderException("Data de nascimento deve ser anterior a data atual");
        } else {
            this.birthDate = birthDate;
        }

        this.name = name;
        this.email = email;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) throws OrderException {
        Date now = new Date();
        if (birthDate.before(now)) {
            throw new OrderException("Data de nascimento deve ser anterior à data atual.");
        } else {
            this.birthDate = birthDate;
        }
    }

    @Override
    public String toString() {

        return name + " (" + sdf.format(birthDate) + ") - " + email;
    }

}

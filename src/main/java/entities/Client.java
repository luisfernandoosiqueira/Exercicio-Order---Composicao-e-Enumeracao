/*
 * Copyright (C) 2024 Luís Fernando Siqueira <luisfernandosqueiraadv@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package entities;

/**
 *
 * @author Luís Fernando Siqueira <luisfernandosqueiraadv@gmail.com>
 * @date 28/04/2024
 * @brief Class Exception
 */

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
            throw new OrderException("Data de nascimento deve ser anterior à data atual.");
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
        if (birthDate.after(now)) {
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

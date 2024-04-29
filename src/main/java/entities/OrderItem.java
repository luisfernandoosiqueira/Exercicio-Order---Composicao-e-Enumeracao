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

import exceptions.OrderException.InvalidQuantityException;

/**
 *
 * @author Luís Fernando Siqueira <luisfernandosqueiraadv@gmail.com>
 * @date 28/04/2024
 * @brief Class Exception
 */
public class OrderItem {

    private Integer quantity;
    private Double price;

    //Composição
    private Product product;

    public OrderItem() {
    }

    public OrderItem(Integer quantity, Double price, Product product) throws InvalidQuantityException {

        if (quantity < 1) {
            throw new InvalidQuantityException("A quantidade deve ser pelo menos 1.");
        }
        this.quantity = quantity;
        this.price = price;

    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double subTotal() {

        return quantity * price;

    }

    @Override
    public String toString() {

        return getProduct().getName()
                + ", $"
                + String.format("%.2f", price)
                + ", Quantity: "
                + quantity
                + ", Subtotal: $"
                + String.format("%.2f", subTotal());

    }

}

package entities;

import entities.enums.OrderStatus;
import exceptions.OrderException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Date moment;
    private OrderStatus status;

    //Associações
    private Client client;
    private List<OrderItem> items = new ArrayList<OrderItem>();

    // Objeto criado para formatar a data
    private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Order() {
    }

    public Order(Date moment, OrderStatus status, Client client) {

        if (status != OrderStatus.PENDING_PAYMENT && status != OrderStatus.PROCESSING && status != OrderStatus.SHIPPED && status != OrderStatus.DELIVERED) {
            throw new IllegalArgumentException("Estado do pedido inválido");

        } else {

            this.moment = moment;
            this.status = status;
            this.client = client;
        }
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void addItem(OrderItem item) {

        items.add(item);

    }

    public void removeItem(OrderItem item) {

        items.remove(item);

    }

    public Double total() {

        double soma = 0.0;

        for (OrderItem it : items) {

            soma = soma + it.subTotal(); // Ou +=
        }

        return soma;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ORDER SUMMARY:" + "\n");
        sb.append("Order moment: ");
        sb.append(sdf.format(moment) + "\n");
        sb.append("Order status: ");
        sb.append(status + "\n");
        sb.append("Client: ");
        sb.append(client + "\n");
        sb.append("Order items: \n");

        for (OrderItem item : items) {
            sb.append(item + "\n");

        }

        sb.append("Total price: $");
        sb.append(String.format("%.2f", total()));

        return sb.toString();
    }
}

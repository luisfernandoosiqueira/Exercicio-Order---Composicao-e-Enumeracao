package application;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;
import exceptions.OrderException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

// Objeto criado para formatar a data
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {

            System.out.println("Digite os dados do cliente: ");
            System.out.print("Nome: ");
            String name = sc.nextLine();
            System.out.print("Email: ");
            String email = sc.nextLine();
            System.out.print("Data de nascimento (DD/MM/YYYY): ");
            Date birthDate = sdf.parse(sc.next());

            Client client = new Client(name, email, birthDate);

            System.out.println();
            System.out.println("Digite os dados do pedido: ");
            System.out.print("Status: ");
            OrderStatus status = OrderStatus.valueOf(sc.next());

            //Instanciação do pedido com hora atual do sistema (new Date())
            Order order = new Order(new Date(), status, client);

            System.out.print("Quantos items o pedido vai ter? ");
            int num = sc.nextInt();
            System.out.println();

            for (int i = 1; i <= num; i++) {

                System.out.println("Digite os dados do " + (i) + "º pedido:");
                System.out.print("Nome do produto: ");
                sc.nextLine();
                String productName = sc.nextLine();
                System.out.print("Preço do produto: ");
                Double productPrice = sc.nextDouble();
                System.out.print("Quantidade: ");
                int quantity = sc.nextInt();

                //Instanciação do produto
                Product product = new Product(productName, productPrice);

                //Instanciação do item
                OrderItem it = new OrderItem(quantity, productPrice, product);

                //Adicionar item ao pedido(Order)
                order.addItem(it);

            }

            //Imprimir 
            System.out.println();
            System.out.println(order);

        } catch (ParseException e) {

            System.out.println("Formato de data inválido");

        } catch (OrderException e) {

            System.out.println("Erro: " + e.getMessage());

        } catch (InputMismatchException e) {

            System.out.println("Erro: Digite somente números.");

        } catch (IllegalArgumentException es) {
            System.out.println("Erro: " + es.getMessage());
        } finally {
            sc.close();
        }
    }

}

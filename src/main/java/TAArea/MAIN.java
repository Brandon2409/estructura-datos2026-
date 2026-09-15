package TAArea;

import java.util.Scanner;

public class MAIN {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ColaPedidos cola = new ColaPedidos();
        int opcion = 0;

        do {
            System.out.println("\n===== PEDIDOS DE COCINA =====");
            System.out.println("1. Registrar pedido");
            System.out.println("2. Preparar siguiente pedido");
            System.out.println("3. Consultar siguiente pedido");
            System.out.println("4. Mostrar pedidos pendientes");
            System.out.println("5. Buscar pedido por número");
            System.out.println("6. Mostrar tiempo total pendiente");
            System.out.println("7. Salir");
            System.out.println("8. Mostrar pedido con mayor tiempo de preparación (Reto)");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Número de pedido: ");
                    int num = Integer.parseInt(scanner.nextLine());
                    System.out.print("Nombre del cliente: ");
                    String cliente = scanner.nextLine();
                    System.out.print("Platillo: ");
                    String platillo = scanner.nextLine();
                    System.out.print("Cantidad: ");
                    int cantidad = Integer.parseInt(scanner.nextLine());
                    System.out.print("Tiempo estimado (minutos): ");
                    int tiempo = Integer.parseInt(scanner.nextLine());

                    Pedido nuevo = new Pedido(num, cliente, platillo, cantidad, tiempo);
                    cola.enqueue(nuevo);
                    System.out.println("¡Pedido registrado con éxito!");
                    break;

                case 2:
                    Pedido atendido = cola.dequeue();
                    if (atendido != null) {
                        System.out.println("Preparando pedido " + atendido.getNumeroPedido());
                        System.out.println("Cliente: " + atendido.getCliente());
                        System.out.println("Platillo: " + atendido.getPlatillo());
                    } else {
                        System.out.println("No hay pedidos por preparar.");
                    }
                    break;

                case 3:
                    Pedido siguiente = cola.peek();
                    if (siguiente != null) {
                        System.out.println("Siguiente pedido a atender:");
                        System.out.println(siguiente);
                    } else {
                        System.out.println("No hay pedidos en la cola.");
                    }
                    break;

                case 4:
                    System.out.println("\n--- Lista de Pedidos Pendientes ---");
                    cola.mostrar();
                    break;

                case 5:
                    System.out.print("Ingrese el número de pedido a buscar: ");
                    int numBuscar = Integer.parseInt(scanner.nextLine());
                    Pedido buscado = cola.buscarPedido(numBuscar);
                    if (buscado != null) {
                        System.out.println("Pedido encontrado:");
                        System.out.println(buscado);
                    } else {
                        System.out.println("El pedido número " + numBuscar + " no existe en la cola.");
                    }
                    break;

                case 6:
                    System.out.println("Tiempo total pendiente: " + cola.tiempoTotalPendiente() + " minutos");
                    break;

                case 7:
                    System.out.println("Saliendo del sistema de cocina...");
                    break;

                case 8:
                    Pedido mayorTiempo = cola.pedidoMayorTiempo();
                    if (mayorTiempo != null) {
                        System.out.println("Pedido con mayor tiempo de preparación:");
                        System.out.println(mayorTiempo);
                    } else {
                        System.out.println("No hay pedidos en la cola.");
                    }
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 7);

        scanner.close();
    }
}

    package edu.udelp;
    import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {

            Scanner entrada = new Scanner(System.in);

            PilaPaquetes pila = new PilaPaquetes();

            int opcion;

            do {

                System.out.println("\n========= ALMACÉN =========");
                System.out.println("1. Registrar paquete");
                System.out.println("2. Retirar paquete");
                System.out.println("3. Consultar siguiente paquete");
                System.out.println("4. Mostrar paquetes");
                System.out.println("5. Buscar paquete");
                System.out.println("6. Salir");

                System.out.print("\nSelecciona una opción: ");

                opcion = entrada.nextInt();
                entrada.nextLine();

                switch (opcion) {

                    case 1:

                        System.out.println("\n===== REGISTRAR PAQUETE =====");

                        System.out.print("ID: ");
                        int id = entrada.nextInt();
                        entrada.nextLine();

                        System.out.print("Descripción: ");
                        String descripcion = entrada.nextLine();

                        System.out.print("Peso en kg: ");
                        double peso = entrada.nextDouble();

                        Paquete paquete = new Paquete(id, descripcion, peso);

                        pila.push(paquete);

                        System.out.println("\nPaquete registrado correctamente.");

                        break;

                    case 2:

                        System.out.println("\n===== RETIRAR PAQUETE =====");

                        Paquete retirado = pila.pop();

                        if (retirado == null) {

                            System.out.println("No hay paquetes para retirar.");

                        } else {

                            System.out.println("Paquete retirado:");
                            retirado.mostrar();
                        }

                        break;

                    case 3:

                        System.out.println("\n===== SIGUIENTE PAQUETE =====");

                        Paquete siguiente = pila.peek();

                        if (siguiente == null) {

                            System.out.println("No hay paquetes almacenados.");

                        } else {

                            System.out.println("El siguiente paquete en salir es:");
                            siguiente.mostrar();
                        }

                        break;

                    case 4:

                        pila.mostrar();

                        break;

                    case 5:

                        System.out.println("\n===== BUSCAR PAQUETE =====");

                        System.out.print("ID a buscar: ");
                        int idBuscar = entrada.nextInt();

                        Paquete encontrado = pila.buscar(idBuscar);

                        if (encontrado == null) {

                            System.out.println(
                                    "No existe un paquete con el ID " + idBuscar + "."
                            );

                        } else {

                            System.out.println("\nPaquete encontrado:");
                            encontrado.mostrar();
                        }

                        break;

                    case 6:

                        System.out.println("\nPrograma finalizado.");

                        break;

                    default:

                        System.out.println("\nOpción no válida.");

                        break;
                }

            } while (opcion != 6);

            entrada.close();
        }
    }




    /*import edu.udelp.Stack.Stack;
    import edu.udelp.exception.UdelpException;

    public class Main {

        public static void main(String[] args) {
            Stack stack = new Stack();
            imprime(stack);

            stack.push(5);
            imprime(stack);

            stack.push(6);
            imprime(stack);

            stack.push(7);
            imprime(stack);

            stack.push(8);
            imprime(stack);

            stack.pop();
            imprime(stack);

            stack.pop();
            imprime(stack);
        }

        public static void imprime(Stack stack) {
            System.out.println("Stack contents");
            System.out.println(stack);
            try {
                System.out.println("peek:" + stack.peek());
            } catch (UdelpException e) {
                System.out.println("size:" + stack.size());
            }
        }
    }















/*
import edu.udelp.ejercicios.Parentesis;

public class Main {
    public static void main (String[] args){
        String ecuacion = "";
        Parentesis par = new Parentesis();
        boolean resultado = par.evaluar(ecuacion);

        if(resultado){
            System.out.println("Ecuacion correcta");
        }else{
            System.out.println("Ecuacion incorrecta");
        }
    }
}






import edu.udelp.Stack.ArrayStack;
import edu.udelp.nodo.nodo;

public class Main {
    public static void main(String[] args) {
        nodo Nodo = new nodo(10);
        nodo Nodo2= new nodo(20);
        nodo Nodo3= new nodo(30);

        Nodo.setEnlace(Nodo2);
        Nodo2.setEnlace(Nodo3);

        nodo actual = Nodo;
        while(actual !=null){
            System.out.println(actual.getDato());
            actual=actual.getEnlace();
        }
        ArrayStack arrayStack= new ArrayStack(10);
        arrayStack.push(10);
        System.out.println(arrayStack.toString());

        arrayStack.push(20);
        System.out.println(arrayStack.toString());

        arrayStack.push(30);
        System.out.println(arrayStack.toString());

        System.out.println("cime" + arrayStack.peek());

        System.out.println("pop"+ arrayStack.pop());
        System.out.println("cima"+ arrayStack.peek());
        System.out.println(arrayStack.toString());

    }

}

 */
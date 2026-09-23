    package edu.udelp;

    import edu.udelp.exception.UdelpException;
    import edu.udelp.queue.Queue;

    public class Main{
        public static void main(String[] args){
            Queue q = new Queue();
            imprimir(q);

            q.enqueue(5);
            imprimir(q);

            q.enqueue(6);
            imprimir(q);

            q.enqueue(7);
            imprimir(q);

            int valor = q.dequeue();
            System.out.println("Salir: "+ valor);
            imprimir(q);

            q.enqueue(8);
            imprimir(q);
        }
        public static void imprimir(Queue queue){

            try {
                System.out.println(" ------..");
                System.out.println(queue.toString());
                System.out.println(queue.peek());
                System.out.println();
            }catch(UdelpException e){
                System.out.println(e.getMessage());
            }

        }
    }



















    /*import edu.udelp.Stack.PaginaStack;
    import edu.udelp.model.Pagina;

    /*import javax.swing.*;
    import java.util.Scanner;

    import static javax.swing.JOptionPane.showInputDialog;

    public class Main {
        public static void main(String[] args) {
            PaginaStack stack = new PaginaStack();
            PaginaStack stack2 = new PaginaStack();
            String [] opciones={"Nueva pagina","Atras","actual","adelante","salir"};
            boolean salir=false;

            while(!salir){
                int option = JOptionPane.showOptionDialog(
                        null, "Selecciona una opcion", "URL",
                        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, null
                );

            switch (option){
                case 0:

                    Pagina nueva= new Pagina();
                    String dato= JOptionPane.showInputDialog(null,
                            "selecciona el nombre de la pagina");
                    nueva.setUrl(dato);
                    stack.push(nueva);
                    break;
                case 1:
                    if(!stack.isEmpty()){
                        Pagina p= stack.pop();
                        stack2.push(p);
                    }

                    break;
                case 2:
                    if(!stack.isEmpty()){
                        JOptionPane.showMessageDialog(null,"Pagina actual: " + stack.peek());
                    }
                    break;

                case 3:
                    if(!stack2.isEmpty()){

                        Pagina p=stack2.pop();
                        stack2.push(p);
                    }
                    break;

                case 4:
                    salir=true;
                    break;
            }
        }
    }
    }

        /*public static void main(String[] args) {

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
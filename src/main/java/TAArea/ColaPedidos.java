package TAArea;

public class ColaPedidos {
    private NODO frente;
    private NODO fin;

    public ColaPedidos() {
        this.frente = null;
        this.fin = null;
    }

    public boolean isEmpty() {
        return frente == null;
    }
    public void enqueue(Pedido pedido) {
        NODO nuevoNodo = new NODO(pedido);
        if (isEmpty()) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
            fin = nuevoNodo;
        }
    }

    public Pedido dequeue() {
        if (isEmpty()) {
            return null;
        }
        Pedido pedidoAtendido = frente.getPedido();
        frente = frente.getSiguiente();

        if (frente == null) {
            fin = null;
        }
        return pedidoAtendido;
    }
    public Pedido peek() {
        if (isEmpty()) {
            return null;
        }
        return frente.getPedido();
    }

    public void mostrar() {
        if (isEmpty()) {
            System.out.println("La cola de pedidos está vacía.");
            return;
        }
        NODO actual = frente;
        while (actual != null) {
            System.out.println(actual.getPedido().getNumeroPedido() + " - " + actual.getPedido().getPlatillo());
            actual = actual.getSiguiente();
        }
    }

    public Pedido buscarPedido(int numero) {
        NODO actual = frente;
        while (actual != null) {
            if (actual.getPedido().getNumeroPedido() == numero) {
                return actual.getPedido();
            }
            actual = actual.getSiguiente();
        }
        return null;
    }
    public int tiempoTotalPendiente() {
        int total = 0;
        NODO actual = frente;
        while (actual != null) {
            total += actual.getPedido().getTiempoEstimado();
            actual = actual.getSiguiente();
        }
        return total;
    }
    public Pedido pedidoMayorTiempo() {
        if (isEmpty()) {
            return null;
        }
        NODO actual = frente;
        Pedido mayor = actual.getPedido();

        while (actual != null) {
            if (actual.getPedido().getTiempoEstimado() > mayor.getTiempoEstimado()) {
                mayor = actual.getPedido();
            }
            actual = actual.getSiguiente();
        }
        return mayor;
    }
}

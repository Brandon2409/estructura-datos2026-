package TAArea;

public class NODO {
    private Pedido pedido;
    private NODO siguiente;

    public NODO(Pedido pedido) {
        this.pedido = pedido;
        this.siguiente = null;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public NODO getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NODO siguiente) {
        this.siguiente = siguiente;
    }
}

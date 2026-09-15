package TAArea;

public class Pedido {
    private int numeroPedido;
    private String cliente;
    private String platillo;
    private int cantidad;
    private int tiempoEstimado;

    public Pedido(int numeroPedido, String cliente, String platillo, int cantidad, int tiempoEstimado) {
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.platillo = platillo;
        this.cantidad = cantidad;
        this.tiempoEstimado = tiempoEstimado;
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public String getPlatillo() {
        return platillo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getTiempoEstimado() {
        return tiempoEstimado;
    }

    @Override
    public String toString() {
        return "Pedido " + numeroPedido + " | Cliente: " + cliente + " | Platillo: " + platillo +
                " | Cantidad: " + cantidad + " | Tiempo: " + tiempoEstimado + " min";
    }
}

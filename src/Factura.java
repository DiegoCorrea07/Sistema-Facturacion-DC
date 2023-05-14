import java.util.ArrayList;
import java.util.List;

class Factura {
    private List<Producto> productos;           // Lista de productos en la factura
    private String nombreComprador;             // Nombre del comprador
    private String numeroCedula;                // Número de cédula del comprador

    public Factura() {
        productos = new ArrayList<>();          // Inicializar la lista de productos como una nueva ArrayList
    }

    public void agregarProducto(Producto producto, int cantidad) {
        producto.setCantidad(cantidad);         // Establecer la cantidad de unidades del producto
        productos.add(producto);                // Agregar el producto a la lista de productos
    }


    public void imprimirFactura() {
        double subtotal = calcularSubtotal();               // Calcular el subtotal de la factura
        double descuento = calcularDescuento(subtotal);     // Calcular el descuento aplicado
        double total = subtotal - descuento;                // Calcular el total a pagar


        System.out.println("Factura:");
        System.out.println("Productos:");
        for (Producto producto : productos) {
            int cantidad = producto.getCantidad();
            System.out.println("- " + producto.getNombre() + ": $" + calcularPrecio(producto, cantidad));
        }
        System.out.println("Subtotal: $" + subtotal);
        System.out.println("Descuento: $" + descuento);
        System.out.println("Total: $" + total);
        System.out.println("Nombre del comprador: " + nombreComprador);
        System.out.println("Número de cédula: " + numeroCedula);
    }


    private double calcularSubtotal() {
        double subtotal = 0;
        for (Producto producto : productos) {
            int cantidad = producto.getCantidad();
            subtotal += calcularPrecio(producto, cantidad);    // Calcular el precio total de cada producto y sumarlo al subtotal

        }
        return subtotal;
    }


    private double calcularPrecio(Producto producto, int cantidad) {
        if (cantidad >= producto.getCantidadPorMayor()) {
            return producto.getPrecioPorMayor() * cantidad;   // Calcular el precio total si se alcanza la cantidad mínima para precio al por mayor
        } else {
            return producto.getPrecioNormal() * cantidad;    // Calcular el precio total utilizando el precio normal
        }
    }


    private double calcularDescuento(double subtotal) {
        if (subtotal <= 100) {
            return 0;                       // No se aplica descuento si el subtotal es menor o igual a 100
        } else if (subtotal <= 500) {
            return subtotal * 0.05;         // Aplicar un descuento del 5% si el subtotal está entre 100 y 500
        } else if (subtotal <= 1000) {
            return subtotal * 0.07;         // Aplicar un descuento del 7% si el subtotal está entre 500 y 1000
        } else {
            return subtotal * 0.1;          // Aplicar un descuento del 10% si el subtotal es mayor a 1000
        }
    }

    public void setNombreComprador(String nombreComprador) {
        this.nombreComprador = nombreComprador;        // Establecer el nombre del comprador
    }

    public void setNumeroCedula(String numeroCedula) {
        this.numeroCedula = numeroCedula;             // Establecer el número de cédula del comprador
    }
}


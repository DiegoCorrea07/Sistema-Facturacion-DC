import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    private static List<Producto> productos;

    public static void main(String[] args) {
        // Inicialización de la lista de productos
        productos = inicializarProductos();

        // Creación del objeto Scanner para leer la entrada del usuario
        Scanner scanner = new Scanner(System.in);
        String opcion;
        Factura factura = new Factura();

        do {
            // Mostrar el menú al usuario
            mostrarMenu();
            opcion = scanner.nextLine();

            switch (opcion) {
                case "a":
                    // Mostrar los productos disponibles
                    mostrarProductos();
                    // Solicitar el código del producto y la cantidad al usuario
                    System.out.print("Ingrese el código del producto: ");
                    String codigoProducto = scanner.nextLine();
                    System.out.print("Ingrese la cantidad de unidades: ");
                    int cantidad = Integer.parseInt(scanner.nextLine());
                    // Buscar el producto seleccionado
                    Producto productoSeleccionado = buscarProducto(codigoProducto);

                    if (productoSeleccionado != null) {
                        // Agregar el producto a la factura si es válido
                        factura.agregarProducto(productoSeleccionado, cantidad);
                        System.out.println("Producto agregado correctamente.");
                    } else {
                        System.out.println("El código del producto no es válido.");
                    }
                    break;

                case "b":
                    // Solicitar el nombre del comprador y el número de cédula al usuario
                    System.out.print("Ingrese el nombre del comprador: ");
                    String nombreComprador = scanner.nextLine();
                    System.out.print("Ingrese el número de cédula: ");
                    String numeroCedula = scanner.nextLine();

                    // Establecer el nombre del comprador y el número de cédula en la factura
                    factura.setNombreComprador(nombreComprador);
                    factura.setNumeroCedula(numeroCedula);

                    // Imprimir la factura
                    factura.imprimirFactura();
                    break;

                case "c":
                    System.out.println("¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opción inválida. Por favor, intente nuevamente.");
            }
        } while (!opcion.equals("c"));
    }

    // Mostrar el menú de opciones
    private static void mostrarMenu() {
        System.out.println("Menú:");
        System.out.println("a. Facturar producto");
        System.out.println("b. Imprimir factura");
        System.out.println("c. Salir");
        System.out.print("Ingrese una opción: ");
    }

    // Mostrar los productos disponibles
    private static void mostrarProductos() {
        System.out.println("Productos disponibles:");
        for (Producto producto : productos) {
            System.out.println(producto.getNombre() + " - Precio: $" + producto.getPrecioNormal());
        }
    }

    // Inicializar la lista de productos
    private static List<Producto> inicializarProductos() {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Llantas", 150, 130, 6));
        productos.add(new Producto("Kit Pastillas de freno", 55, 45, 12));
        productos.add(new Producto("Kit de embrague", 180, 165, 8));
        productos.add(new Producto("Faro", 70, 60, 10));
        productos.add(new Producto("Radiador", 120, 105, 6));
        return productos;
    }

    // Buscar un producto por su código
    private static Producto buscarProducto(String codigo) {
        for (Producto producto : productos) {
            if (producto.getNombre().equalsIgnoreCase(codigo)) {
                return producto;
            }
        }
        return null;
    }
}

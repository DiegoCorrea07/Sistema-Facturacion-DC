class Producto {
    private String nombre;              // Nombre del producto
    private double precioNormal;        // Precio normal del producto
    private double precioPorMayor;      // Precio al por mayor del producto
    private int cantidadPorMayor;       // Cantidad mínima para aplicar precio al por mayor
    private int cantidad;               // Cantidad de unidades disponibles


    public Producto(String nombre, double precioNormal, double precioPorMayor, int cantidadPorMayor) {
        this.nombre = nombre;
        this.precioNormal = precioNormal;
        this.precioPorMayor = precioPorMayor;
        this.cantidadPorMayor = cantidadPorMayor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecioNormal() {
        return precioNormal;
    }

    public void setPrecioNormal(double precioNormal) {
        this.precioNormal = precioNormal;
    }

    public double getPrecioPorMayor() {
        return precioPorMayor;
    }

    public void setPrecioPorMayor(double precioPorMayor) {
        this.precioPorMayor = precioPorMayor;
    }

    public int getCantidadPorMayor() {
        return cantidadPorMayor;
    }

    public void setCantidadPorMayor(int cantidadPorMayor) {
        this.cantidadPorMayor = cantidadPorMayor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}


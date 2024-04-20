public class Telefono extends ArticuloElectronico implements Metodos {

    public Telefono() {
    }

    public Telefono(String nombre, String modelo, String descripcion, float precio) {
        super(nombre, modelo, descripcion, precio);
    }

    @Override
    public float obtenerPrecio() {
        int a =+ 40;
        return a;
    }

    @Override
    public String obtenerDescripcion(String descrip) {
        return descrip;

    }
}

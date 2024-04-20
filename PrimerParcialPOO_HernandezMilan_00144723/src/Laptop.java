public class Laptop extends ArticuloElectronico implements Metodos {
    private String rgb;

    public Laptop() {
    }

    public Laptop(String rgb) {
        this.rgb = rgb;
    }

    public Laptop(String nombre, String modelo, String descripcion, float precio, String rgb) {
        super(nombre, modelo, descripcion, precio);
        this.rgb = rgb;
    }

    public Laptop(ArticuloElectronico art, String rgb) {
        super(art);
        setRgb(rgb);
    }

    @Override
    public float obtenerPrecio() {
        int a = +40;
        return a;
    }

    @Override
    public String obtenerDescripcion(String descrip) {
        return descrip;

    }

    public String getRgb() {
        return rgb;
    }

    public void setRgb(String rgb) {
        this.rgb = rgb;
    }
}

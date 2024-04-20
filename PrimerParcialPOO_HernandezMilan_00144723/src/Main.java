import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<ArticuloElectronico> listaArticulos = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        menuPrincipal();
    }

    private static void menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        int opc;
        while (true) {
            try {
                imprimirMenu();
                opc = sc.nextInt();
                sc.nextLine();
                if (opc == 0) {
                    return;
                }
                switch (opc) {
                    case 1:
                        agregar();
                        break;
                    case 2:
                        modificarArticulo();
                        break;
                    case 3:
                        consultarListado();
                        break;
                }
            } catch (Exception e) {
                System.out.println("Por favoir ingrese un dato valido");
            }

        }
    }

    private static void modificarArticulo() {
        Scanner sc = new Scanner(System.in);
        String nombre;
        System.out.println("Ingrese el nombre del producto: ");
        nombre= sc.nextLine();

        for (int i = 0; i < listaArticulos.size(); i++) {
            ArticuloElectronico art = listaArticulos.get(i);
            if(art.getNombre().equals(nombre)){
                System.out.println("Ingrese el nuevo nombre del articulo: ");
                art.setNombre(sc.nextLine());
                System.out.println("Nuevo nombre del articulo " + art.getNombre() + " cambiado correctamente...");
                return;
            }
        }
    }

    private static void consultarListado() {
        System.out.println("------------------------------------------------------------");

       try {
            for (int i = 0; i <= listaArticulos.size(); i++) {
                ArticuloElectronico art = listaArticulos.get(i);

                System.out.println("------------------------------------------------------------");
                System.out.println("Articulo " + i);
                System.out.println("Nombre: " + art.getNombre());
                System.out.println("Modelo: " + art.getModelo());
                System.out.println("Descripcion: " + art.obtenerDescripcion(art.getDescripcion()));
                System.out.println("Precio: " + art.obtenerPrecio());
                System.out.println("------------------------------------------------------------");
            }
        }catch (Exception e)
       {
           System.out.println("\tTodos los elementos han sido mostrados. ");
       }
    }

    private static void agregar() {
        Scanner sc = new Scanner(System.in);

        String nombre;
        String modelo;
        String descripcion;
        String rgb;
        float precio = 0;

        System.out.println("Nombre: ");
        nombre = sc.nextLine();
        System.out.println("Modelo: ");
        modelo = sc.nextLine();
        System.out.println("Descripcion: ");
        descripcion = sc.nextLine();
        System.out.println("Posee rgb (SI - NO): ");
        rgb = sc.nextLine();

        int tipoArt = tipoArt();
        
        switch (tipoArt) {
            case 1:
                ArticuloElectronico telefono = new Telefono(nombre, modelo, descripcion, precio);
                listaArticulos.add(telefono);
                System.out.println("Articulo agregado correctamente...");
                break;
            case 2:
                ArticuloElectronico laptop = new Laptop(nombre, modelo, descripcion, precio, rgb);
                listaArticulos.add(laptop);
                System.out.println("Articulo agregado correctamente...");
                break;
        }
    }

    private static int tipoArt() {
        Scanner sc = new Scanner(System.in);
        int opc;
        while (true) {
            try {
                System.out.println("Seleccione que tipo de articulo es: ");
                System.out.println("1.Telefono ");
                System.out.println("2.Laptop ");
                opc = sc.nextInt();
                if (opc >= 1 && opc <= 2) return opc;
                System.out.println("Ingrese una opcion valida por favor.");
            } catch (Exception e) {
                System.out.println("Por favor ingrese un dato valido");
            }
        }
    }


    private static void imprimirMenu() {
        System.out.println("\tBIENVENIDO AL SISTEMA DE INVENTARIO DE LA TIENDA\n");
        System.out.println("\t1.Agregar\n"
                + "\t2.Modificar\n"
                + "\t3.Mostrar listado de los articulos\n"
                + "\t0.Salir");
        System.out.print("\tOpcion > ");
    }
}
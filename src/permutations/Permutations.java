package permutations;

/**
 *
 * @author Ricardo Almazán
 */
public class Permutations {

    public static void main(String[] args) {
        permutations.algoritmo permutacion = new permutations.algoritmo();
        /*Para el cifrado, se utiliza la información del archivo.*/
        permutacion.cargarDatos("permutacion1.txt");
        String cadena = permutacion.permutar();
        System.out.println("Mensaje cifrado: " + cadena);
        /*Para el descifrado, se usa la información previa.*/
        permutacion.setMessage(cadena.replace(" ", ""));
        permutacion.setKey(permutacion.calcularPermutacionInversa());

        System.out.println("Mensaje claro: " + permutacion.permutar());
    }
}

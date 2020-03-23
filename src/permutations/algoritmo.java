package permutations;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Ricardo Almazán
 */
public class algoritmo {

    private ArrayList<Integer> key;
    private String message;

    public algoritmo() {
        this.key = new ArrayList<>();
        this.message = "";
    }

    public String permutar() {
        String aux = "";
        /*Estas líneas de código es para garantizar que todos los caracteres
        del mensaje sean cifrados, se añaden caracteres extra*/
        Random r = new Random();
        while (this.message.length() % key.size() != 0) {
            this.message += (char)(r.nextInt(26) + 'a');
        }
        for (int i = 0; i < message.length(); i += key.size()) {
            for (Integer posicion : key) {
                aux += message.charAt(posicion + i);
            }
            aux += " ";
        }
        return aux;
    }

    public void cargarDatos(String nomArchivo) {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;
        String orden, linea;
        try {
            archivo = new File("files\\" + nomArchivo);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);
            orden = br.readLine();
            /*La primera línea del archivo, debe de ser la permutación*/
            for (int i = 0; i < orden.length(); i++) {
                if (Character.isDigit(orden.charAt(i))) {
                    int aux = 0;
                    if (Character.isDigit(orden.charAt(i + 1))) {
                        aux = Integer.parseInt(String.valueOf(orden.charAt(i) + "" + orden.charAt(++i)));
                    } else {
                        aux = Integer.parseInt(String.valueOf(orden.charAt(i)));
                    }

                    if (!this.key.contains(aux)) {
                        this.key.add(aux);
                    }
                }
            }
            /*El resto del archivo es el mensaje*/
            while ((linea = br.readLine()) != null) {
                this.message += linea;
            }
            this.message = this.message.replace(" ", "");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public ArrayList<Integer> calcularPermutacionInversa() {
        ArrayList<Integer> keyInv = new ArrayList<>();
        for (int i = 0; i < this.key.size(); i++) {
            for (int j = 0; j < this.key.size(); j++) {
                if (this.key.get(j) == i) {
                    keyInv.add(j);
                }
            }
        }
        return keyInv;
    }

    public void setKey(ArrayList<Integer> key) {
        this.key = key;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}

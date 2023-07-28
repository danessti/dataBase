package practica;

import java.util.*;

public class StreamExercise {

    public static void main(String[] args) {

//      Letras por palabras                                       7             4        3          6               6             4
        List<String> palabras = Arrays.asList("manzana", "pera", "uva", "sandía", "papaya", "kiwi");

//        ordena la lista en orden alfabético
        Collections.sort(palabras);

        System.out.println("Palabras filtradas con 4 caracteres");

        for (String string: palabras) {

            if (string.length() == 4) {
//                convierte las palabras filtradas en mayúscula
                System.out.println(string.toUpperCase());
            }

        }

        System.out.println("Palabras ordenadas alfabéticamente: \n" + palabras);

    }

}
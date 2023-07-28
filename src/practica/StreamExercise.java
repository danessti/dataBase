package practica;

import java.util.*;

public class StreamExercise {

    public static void main(String[] args) {
//                                                                                7             4        3          6               6             4
        List<String> palabras = Arrays.asList("manzana", "pera", "uva", "sandía", "papaya", "kiwi");

        Collections.sort(palabras);

        System.out.println("Palabras filtradas con 4 caracteres");

        for (String string: palabras) {

            if (string.length() == 4) {
                System.out.println(string.toUpperCase());
            }

        }

        System.out.println("Palabras ordenadas alfabéticamente: \n" + palabras);

    }

}
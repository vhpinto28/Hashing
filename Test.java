import java.util.List;
import java.util.LinkedList;
public class Test {
    public static void main(String[] args) {
        // Crear tabla hash con HashA
        HashA<String> hashTableA = new HashA<>(7);

        // Insertar elementos en la tabla hash
        hashTableA.insert(34, "Registro 1");
        hashTableA.insert(3, "Registro 2");
        hashTableA.insert(7, "Registro 3");
        hashTableA.insert(30, "Registro 4");
        hashTableA.insert(11, "Registro 5");
        hashTableA.insert(8, "Registro 6");
        hashTableA.insert(7, "Registro 7"); // Colisión con el Registro 3
        hashTableA.insert(23, "Registro 8");
        hashTableA.insert(41, "Registro 9");
        hashTableA.insert(16, "Registro 10");
        hashTableA.insert(34, "Registro 11"); // Colisión con el Registro 1

        // Imprimir la tabla hash completa
        System.out.println("Tabla Hash A:");
        System.out.println(hashTableA);

        // Mostrar contenido de las listas enlazadas
        System.out.println("Contenido de las listas enlazadas:");
        for (int i = 0; i < hashTableA.table.size(); i++) {
            List<HashA<String>.Element> chain = new LinkedList<>();
            chain.add(hashTableA.table.get(i));
            System.out.println("Lista " + i + ":");
            for (HashA<String>.Element element : chain) {
                System.out.println(element.reg);
            }
            System.out.println();
        }

        // Crear tabla hash con HashC
        HashC<String> hashTableC = new HashC<>(7);

        // Insertar elementos en la tabla hash
        hashTableC.insert(34, "Registro 1");
        hashTableC.insert(3, "Registro 2");
        hashTableC.insert(7, "Registro 3");
        hashTableC.insert(30, "Registro 4");
        hashTableC.insert(11, "Registro 5");
        hashTableC.insert(8, "Registro 6");
        hashTableC.insert(7, "Registro 7"); // Colisión con el Registro 3
        hashTableC.insert(23, "Registro 8");
        hashTableC.insert(41, "Registro 9");
        hashTableC.insert(16, "Registro 10");
        hashTableC.insert(34, "Registro 11"); // Colisión con el Registro 1

        // Imprimir la tabla hash completa
        System.out.println("Tabla Hash C:");
        System.out.println(hashTableC);

        // Mostrar contenido de las listas enlazadas
        System.out.println("Contenido de las listas enlazadas:");
        for (int i = 0; i < hashTableC.table.size(); i++) {
            HashC<String>.Element element = hashTableC.table.get(i);
            System.out.println("Elemento " + i + ":");
            if (element.mark == 1) {
                System.out.println(element.reg);
            } else {
                System.out.println("empty");
            }
            System.out.println();
        }
    }
}
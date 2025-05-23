//Nombre: Vernel Josue Hernández Cáceres.
//Carne: 24584.
//Algoritmos y Estructura de datos.
//Sección 30.

public class Estaciones {
    
        public static void main(String[] args) {
        String[] nombres = {"A", "B", "C", "D", "E"};
          System.out.println("--------------------------------------- Lógica de las Matrices  ------------------------------------------------");
    
        // Crear el grafo de 5 nodos (A, B, C, D, E)
        Grafo grafo = new Grafo(5);

        // Aristas según la matriz del ejercicio
        grafo.NewArista(0, 1, 3);  // A → B
        grafo.NewArista(0, 3, 7);  // A → D
        grafo.NewArista(1, 2, 1);  // B → C
        grafo.NewArista(1, 4, 8);  // B → E
        grafo.NewArista(2, 3, 2);  // C → D
        grafo.NewArista(3, 4, 3);  // D → E
        grafo.NewArista(4, 0, 4);  // E → A

        System.out.println(" Matriz original:");
       System.out.println(grafo.NewMatriz(nombres));

        FloydWarshall.floyd(grafo);

        System.out.println(" Matriz después de Floyd:");
        System.out.println(grafo.NewMatriz(nombres));

        System.out.println("Donde: ");
        System.out.println("A = Ciudad de Guatemala");
        System.out.println("B = Zacapa");
        System.out.println("C = Chiquimula");
        System.out.println("D = Quetzaltenango");
        System.out.println("E = Cobán");

        System.out.println("--------------------------------------------- Estaciones ---------------------------------------------------------");
        System.out.println(grafo.CentroGrafo(nombres));


        // Mostrar rutas más cortas desde Ciudad de Guatemala, este será el índice 0
        System.out.println("Rutas más cortas desde Ciudad de Guatemala a las otras estaciones:");
        for (int destino = 1; destino < grafo.n; destino++) {
            int distancia = grafo.matriz[0][destino];
            if (distancia == Integer.MAX_VALUE) {
                System.out.println("No hay ruta hacia " + nombres[destino]);
            } else {
                System.out.println("Hacia " + nombres[destino] + ": " + distancia + " km");
            
            }
        }
    }
}
    


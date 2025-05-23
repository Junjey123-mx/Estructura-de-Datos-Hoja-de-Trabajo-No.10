//Nombre: Vernel Josue Hernández Cáceres.
//Carne: 24584.
//Algoritmos y Estructura de datos.
//Sección 30.

public class Grafo {
    public int[][] matriz;
    public int n;

    // Constructor
    public Grafo(int n) {
        this.n = n;
        matriz = new int[n][n];

        // Inicialzar la matriz con infinito a excepción de diagonal
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    matriz[i][j] = 0; // distancia a sí mismo = 0
                } else {
                    matriz[i][j] = Integer.MAX_VALUE; // 0 para caminos no definidos
                }
            }
        }
    }

    // Método para agregar una arista
    public void NewArista(int origen, int destino, int peso) {
        matriz[origen][destino] = peso;
    }

    // Devuelve la matriz formateada
    public String NewMatriz(String[] nombres) {
        StringBuilder sb = new StringBuilder();

        sb.append("\t");
        for (int i = 0; i < n; i++) {
            sb.append(nombres[i]).append("\t");
        }
        sb.append("\n");

        for (int i = 0; i < n; i++) {
            sb.append(nombres[i]).append("\t");
            for (int j = 0; j < n; j++) {
                if (matriz[i][j] == Integer.MAX_VALUE) {
                    sb.append("0\t");
                } else {
                    sb.append(matriz[i][j]).append("\t");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    // Calcular el centro del grafo
public String CentroGrafo(String[] nombres) {
    int centro = -1;
    int minExcentricidad = Integer.MAX_VALUE;

    for (int i = 0; i < n; i++) {
        int max = 0;
        for (int j = 0; j < n; j++) {
            if (matriz[i][j] != Integer.MAX_VALUE && matriz[i][j] > max) {
                max = matriz[i][j];
            }
        }

        if (max < minExcentricidad) {
            minExcentricidad = max;
            centro = i;
        }
    }

    return "El centro del grafo/estaciones es el Nodo " + centro  + " es decir " + nombres[centro];
}
}

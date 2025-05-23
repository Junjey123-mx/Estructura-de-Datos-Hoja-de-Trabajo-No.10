public class FloydWarshall{
    public static void floyd(Grafo grafo) {
        int[][] dist = grafo.matriz; //Matriz de adyacencia del grafo -> dist[i][j] es la distancia de i a j.
        int n = grafo.n; // Número de nodos que tendrá el grafo.

        // Recorrer todos los nodos posibles como nodos intermedios.
        for (int k = 0; k < n; k++) {

            // Para cada nodo de origen i -->
            for (int i = 0; i < n; i++) {

                // <--  y cada nodo destino j -->
                for (int j = 0; j < n; j++) {

                    // <-- se verifica que existan caminos válidos desde i→k a k→j.
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE && //Se utiliza  Integer.MAX_VALUE && para disimular el inifinito.

                        //Verificar si pasar por k mejora la distancia de i a j.
                        dist[i][k] + dist[k][j] < dist[i][j]) {

                        //Actualizar la distancia mínima encontrada.
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }

}
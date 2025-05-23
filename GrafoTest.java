//Nombre: Vernel Josue Hernández Cáceres.
//Carne: 24584.
//Algoritmos y Estructura de datos.
//Sección 30.

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GrafoTest {
    Grafo grafo;
    String[] nombres = {"A", "B", "C", "D", "E"};

    @Before
    public void setUp() {
        grafo = new Grafo(5);
    }

    // Verifica que al agregar una arista, la matriz la almacene correctamente.
    @Test
    public void testNewArista() {
        grafo.NewArista(0, 1, 5);
        assertEquals(5, grafo.matriz[0][1]);
    }

    //Comprueba que se puede sobrescribir el peso de una arista existente.
    @Test
    public void testRewriteArista() {
        grafo.NewArista(0, 1, 5);
        grafo.NewArista(0, 1, 2);
        assertEquals(2, grafo.matriz[0][1]);
    }

    //// Simula la eliminación de una arista.
    @Test
    public void testEliminateArista() {
        grafo.NewArista(0, 1, 5);
        grafo.NewArista(0, 1, Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, grafo.matriz[0][1]);
    }

    // // Verifica que el algoritmo de FloydWarshall encuentre la ruta más corta pasando por un nodo intermedio.
    @Test
    public void testFloydWarshallRute() {
        grafo.NewArista(0, 1, 2);
        grafo.NewArista(1, 2, 2);
        grafo.NewArista(0, 2, 10);
        FloydWarshall.floyd(grafo);
        assertEquals(4, grafo.matriz[0][2]);
    }

    // Comprueba que el método para encontrar el centro del grafo funciona y devuelve un texto con el nombre del nodo.
    @Test
    public void testCentroGrafo() {
        grafo.NewArista(0, 1, 1);
        grafo.NewArista(1, 2, 1);
        grafo.NewArista(2, 0, 1);
        FloydWarshall.floyd(grafo);
        String resultado = grafo.CentroGrafo(nombres);
        assertTrue(resultado.contains("es decir"));
    }

    // Verifica que el método NewMatriz genere una salida textual que incluya los pesos de las aristas de forma.
    @Test
    public void testNewMatrizNoVacia() {
        grafo.NewArista(0, 1, 1);
        String salida = grafo.NewMatriz(nombres);
        assertTrue(salida.contains("1"));
    }
}


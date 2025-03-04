import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TablaHashTest {

    private TablaHash<Persona, String> tabla;

    @BeforeEach
    void setUp() {
        tabla = new TablaHash<>();
    }

    /**
     * Test para el metodo insertar(E dato, K clave)
     */
    @Test
    void testInsertar() {
        Persona persona1 = new Persona("Juan", "Pérez", "12345678A");
        boolean resultado = tabla.insertar(persona1, "12345678A");

        assertTrue(resultado, "El resultado de la inserción debería ser true");
        assertNotNull(tabla.buscar("12345678A"), "La persona debería estar en la tabla después de la inserción");
    }

    /**
     * Test para el metodo buscar(K clave)
     */
    @Test
    void testBuscar() {
        Persona persona1 = new Persona("Juan", "Pérez", "12345678A");
        tabla.insertar(persona1, "12345678A");

        Persona resultado = tabla.buscar("12345678A");

        assertNotNull(resultado, "El resultado de la búsqueda no debería ser null");
        assertEquals("Juan", resultado.nombre);
        assertEquals("Pérez", resultado.apellidos);
        assertEquals("12345678A", resultado.DNI);
    }

    /**
     * Test para el metodo borrar(K clave)
     */
    @Test
    void testBorrar() {
        Persona persona1 = new Persona("Juan", "Pérez", "12345678A");
        tabla.insertar(persona1, "12345678A");

        boolean resultadoBorrado = tabla.borrar("12345678A");
        Persona resultadoBusqueda = tabla.buscar("12345678A");

        assertTrue(resultadoBorrado, "El resultado de la eliminación debería ser true");
        assertNull(resultadoBusqueda, "La persona debería haber sido eliminada de la tabla");
    }
}
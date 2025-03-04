import java.util.ArrayList; // import the ArrayList class

/**
 * Tabla Hash abierta basada en el tipo ArrayList
 * https://www.w3schools.com/java/java_arraylist.asp
 */

public class TablaHash<E,K> {



    @SuppressWarnings("rawtypes")
    private ArrayList<CeldaHash>[] tabla;

    public TablaHash() {
        int numElem = 23;
        tabla = new ArrayList[numElem];
        System.out.println("Construyendo una tabla hash de " + numElem + " elementos");
    }

    public TablaHash(int numElem) {
        tabla = new ArrayList[numElem];
        System.out.println("Construyendo una tabla hash de " + numElem + " elementos");
    }



    /**
     * Insertar un elemento con su clave en la tabla hash. Si ya existe un elemento
     * con dicha clave no se inserta y devuelve false. Si la tabla supera el
     * factor de carga límite, se amplía la tabla y se hace un rehash.
    * @param dato El dato que se quiere guardar
    * @param clave La clave del dato a guardar.
    * @return true si se ha insertado correctamente y false en caso contrario.
    */ public boolean insertar(E dato, K clave){

        if (dato==null || clave==null)
            return false;
        
        int hash = fHash(clave);
        int pos= hash;
        
        if (tabla[pos] == null)         // Ya está ocupado
            tabla[pos] = new ArrayList<>();

        tabla[pos].add( new CeldaHash<>(dato, clave));

        return true;
    }

    /**
     * Busca el dato que corresponde con la clave dada
     * @param clave La clave del dato que se quiere.
    * @return El elemento de la tabla que tiene la clave buscada. Si no existe * devuelve null.
    */ public E buscar(K clave){

        if (clave==null)
            return null;
    
        int hash = fHash(clave);
        int pos = hash;

        if (tabla[pos] == null)
            return null;

        for (CeldaHash<E,K> celda: tabla[pos])
            if (celda.getClave().equals(clave))
                return celda.getDato();

        return null;
    }


    /**
     * Elimina de la tabla el dato que corresponde con la clave.
     * @param clave La clave del dato que se desea eliminar.
    * @return true si el elemento se encontró y borró y false en caso contrario.
    */
    public boolean borrar(K clave){ 

        if (clave==null)
            return false;
    
        int hash = fHash(clave);
        int pos = hash;

        if (tabla[pos] == null)
            return false;

        CeldaHash<E,K> celdaBorrar= null;

        for (CeldaHash<E,K> celda: tabla[pos])
            if (celda.getClave().equals(clave))
                celdaBorrar = celda;

        if (celdaBorrar != null) {
            tabla[pos].remove(celdaBorrar);
            return true;
        }

        return false;
    }


    @SuppressWarnings("unused")
    private int fHash(int clave) {
        return clave%tabla.length;
    }

    private int fHash(K clave) {
        String s = clave.toString();
        return fHash(s);
    }

    private int fHash(String clave) {
        
        int suma = 0;
        for (char c: clave.toCharArray()) {
            suma += c;
        }

        return suma%tabla.length;
    }



}








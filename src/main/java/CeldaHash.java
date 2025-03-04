
public class CeldaHash<E,K> {
    private E dato;
    private K clave;
    public CeldaHash(E dato, K clave) {
        this.dato = dato;
        this.clave = clave;
    }

    /**
     * Dato de la CeldaHash
     * @return El dato que contiene
    */ 
    public E getDato() { 
        return dato;
    }

    /**
     * Clave de la CeldaHash
     * @return La clave que contiene
    */
    public K getClave() { 
        return clave;
    }
}
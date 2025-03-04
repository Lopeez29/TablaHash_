public class EjemplosTablasHash {
     
    public static void main(String[] args) {

       System.out.println("Comenzando");

       TablaHash<Persona, String> miTablaHash = new TablaHash<Persona,String>();

 
        Persona angel = new Persona("Angel", "de Antonio", "00000000T");

        if (!miTablaHash.insertar(angel, angel.DNI) )
          System.out.println("Error insertando angel");
        else {
          Persona encontrado = miTablaHash.buscar(angel.DNI);

          if (encontrado==null)
              System.out.println("Dato no encontrado");
          else
              System.out.println("Se ha encontrado a " + encontrado.nombre + " " + encontrado.apellidos);
        }

        Persona angel2 = new Persona("Angel 2", "de Antonio 2", "00000001S");

        if (!miTablaHash.insertar(angel2, angel2.DNI) )
          System.out.println("Error insertando angel 2");
        else
          System.out.println("OK insertando angel 2");

        System.out.println("Finalizando");
    

    }
}



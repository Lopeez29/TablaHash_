# Test TablaHash

Este documento explica en detalle la implementación de las pruebas para la clase `TablaHash`. Se utilizan pruebas enfocadas en validar el funcionamiento correcto de los métodos fundamentales: `insertar`, `buscar` y `borrar`.

## Dependencias y Configuración

- **Framework de pruebas:** Se utiliza **JUnit 5** para definir y ejecutar las pruebas.
- **Aserciones:** Se emplean métodos como `assertTrue`, `assertNotNull`, `assertNull` y `assertEquals` para verificar que el comportamiento de la tabla hash sea el esperado.
- **Inicialización:** Se define un método `setUp()` anotado con `@BeforeEach` que crea una nueva instancia de `TablaHash` antes de cada prueba, garantizando un entorno limpio para cada test.

## Detalle de las Pruebas

### 1. Test de Inserción (`testInsertar`)

#### Objetivo
Verificar que al insertar un elemento en la tabla hash, éste se almacena correctamente y se puede recuperar posteriormente.

#### Pasos Realizados
- **Creación del Objeto:** Se instancia un objeto `Persona` con los datos:  
  - **Nombre:** "Juan"  
  - **Apellidos:** "Pérez"  
  - **DNI:** "12345678A"
- **Inserción en la Tabla:** Se llama al método `insertar` de `TablaHash`, pasando la instancia de `Persona` y usando el DNI como clave.
- **Verificación de Inserción:**  
  - Se comprueba que el método `insertar` retorne `true`, lo que indica que la operación fue exitosa.  
  - Se utiliza el método `buscar` para localizar el elemento insertado y se verifica que el resultado no sea `null`.

---

### 2. Test de Búsqueda (`testBuscar`)

#### Objetivo
Comprobar que el método `buscar` localiza correctamente un elemento almacenado en la tabla hash usando su clave.

#### Pasos Realizados
- **Preparación:**  
  - Se crea y se inserta una instancia de `Persona` en la tabla con el DNI "12345678A".
- **Ejecución de la Búsqueda:**  
  - Se llama al método `buscar` con la clave "12345678A".
- **Verificaciones:**  
  - Se verifica que el resultado no sea `null`, confirmando que se encontró el elemento.
  - Se realizan aserciones para comprobar que los atributos del objeto encontrado (nombre, apellidos y DNI) coinciden con los esperados.

---

### 3. Test de Borrado (`testBorrar`)

#### Objetivo
Validar que el método `borrar` elimina correctamente un elemento de la tabla hash y que, tras su eliminación, ya no puede ser encontrado.

#### Pasos Realizados
- **Preparación:**  
  - Se crea e inserta una instancia de `Persona` con el DNI "12345678A".
- **Ejecución del Borrado:**  
  - Se invoca el método `borrar` usando el DNI como clave.
- **Verificaciones:**  
  - Se comprueba que `borrar` retorne `true`, indicando que se encontró y eliminó el elemento.
  - Se utiliza el método `buscar` para confirmar que el elemento ya no está presente (el resultado debe ser `null`).

---

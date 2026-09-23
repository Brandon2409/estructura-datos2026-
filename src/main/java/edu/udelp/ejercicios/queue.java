/*
EJERCICIO 1: Cola Circular en Arreglo — Buffer de Cola de ImpresiónConcepto de examen: Uso del operador módulo ($\%$) en un arreglo estático de capacidad fija para reutilizar índices liberados.Archivo 1: Documento.javaJavapublic class Documento {
    private String nombre;
    private int paginas;

    public Documento(String nombre, int paginas) {
        this.nombre = nombre;
        this.paginas = paginas;
    }

    public String getNombre() { return nombre; }
    public int getPaginas() { return paginas; }

    @Override
    public String toString() {
        return "📄 [" + nombre + " - " + paginas + " pág.]";
    }
}
Archivo 2: ColaCircularImpresora.javaJavapublic class ColaCircularImpresora {
    private Documento[] buffer;
    private int frente;
    private int fin;
    private int tamanoActual;
    private int capacidad;

    public ColaCircularImpresora(int capacidad) {
        this.capacidad = capacidad;
        this.buffer = new Documento[capacidad];
        this.frente = 0;
        this.fin = -1;
        this.tamanoActual = 0;
    }

    // ENQUEUE: Encolar documento
    public boolean encolar(Documento doc) {
        if (tamanoActual == capacidad) {
            System.out.println("❌ OVERFLOW: Buffer lleno. No cabe: " + doc.getNombre());
            return false;
        }
        // Clave de examen: avance circular de fin
        fin = (fin + 1) % capacidad;
        buffer[fin] = doc;
        tamanoActual++;
        System.out.println("✅ Encolado en pos [" + fin + "]: " + doc);
        return true;
    }

    // DEQUEUE: Imprimir/Extraer documento
    public Documento desencolar() {
        if (tamanoActual == 0) {
            System.out.println("⚠️ UNDERFLOW: No hay documentos pendientes.");
            return null;
        }
        Documento impreso = buffer[frente];
        buffer[frente] = null; // Limpiamos la referencia en memoria
        // Clave de examen: avance circular de frente
        frente = (frente + 1) % capacidad;
        tamanoActual--;
        System.out.println("🖨️ Imprimiendo: " + impreso.getNombre());
        return impreso;
    }

    public void mostrarEstado() {
        if (tamanoActual == 0) {
            System.out.println("\n[ Cola vacía ]\n");
            return;
        }
        System.out.println("\n--- ESTADO DE LA COLA CIRCULAR ---");
        for (int i = 0; i < tamanoActual; i++) {
            int idx = (frente + i) % capacidad;
            System.out.println("  Índice [" + idx + "]: " + buffer[idx]);
        }
        System.out.println("  Frente=" + frente + " | Fin=" + fin + " | Tamaño=" + tamanoActual + "\n");
    }
}
Archivo 3: MainImpresora.javaJavapublic class MainImpresora {
    public static void main(String[] args) {
        // Buffer para 3 documentos
        ColaCircularImpresora impresora = new ColaCircularImpresora(3);

        // 1. Llenar el buffer
        impresora.encolar(new Documento("Examen_Estructuras.pdf", 5));
        impresora.encolar(new Documento("Proyecto_Java.docx", 12));
        impresora.encolar(new Documento("Foto_Credencial.png", 1));

        // Intento de desbordamiento (Overflow)
        impresora.encolar(new Documento("Tarea_Historia.pdf", 3));

        impresora.mostrarEstado();

        // 2. Liberar espacio (imprimir 2 documentos)
        impresora.desencolar();
        impresora.desencolar();

        // 3. Reutilización circular de posiciones
        System.out.println("Reintentando agregar nuevo documento:");
        impresora.encolar(new Documento("Tarea_Historia.pdf", 3));

        impresora.mostrarEstado();
    }
}
EJERCICIO 2: Cola Enlazada Dinámica con Nodos — Ventanilla de BancoConcepto de examen: Implementación de Cola FIFO sin límite de tamaño usando punteros frente y fin con Nodos.Archivo 1: Cliente.javaJavapublic class Cliente {
    private String nombre;
    private int numeroTurno;

    public Cliente(String nombre, int numeroTurno) {
        this.nombre = nombre;
        this.numeroTurno = numeroTurno;
    }

    public String getNombre() { return nombre; }
    public int getNumeroTurno() { return numeroTurno; }

    @Override
    public String toString() {
        return "👤 Turno #" + numeroTurno + " - " + nombre;
    }
}
Archivo 2: NodoCliente.javaJavapublic class NodoCliente {
    private Cliente dato;
    private NodoCliente siguiente;

    public NodoCliente(Cliente dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Cliente getDato() { return dato; }
    public NodoCliente getSiguiente() { return siguiente; }
    public void setSiguiente(NodoCliente siguiente) { this.siguiente = siguiente; }
}
Archivo 3: ColaBanco.javaJavapublic class ColaBanco {
    private NodoCliente frente;
    private NodoCliente fin;
    private int tamano;

    public ColaBanco() {
        this.frente = null;
        this.fin = null;
        this.tamano = 0;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    // ENQUEUE: Inserción por el FIN
    public void encolar(Cliente cliente) {
        NodoCliente nuevo = new NodoCliente(cliente);
        if (estaVacia()) {
            frente = nuevo; // Si está vacía, el nuevo nodo es frente y fin a la vez
        } else {
            fin.setSiguiente(nuevo); // El antiguo fin apunta al nuevo
        }
        fin = nuevo; // El fin se mueve al nuevo nodo
        tamano++;
        System.out.println("Llegó a la fila: " + cliente.getNombre());
    }

    // DEQUEUE: Extracción por el FRENTE
    public Cliente desencolar() {
        if (estaVacia()) {
            System.out.println("⚠️ No hay clientes esperando.");
            return null;
        }
        Cliente atendido = frente.getDato();
        frente = frente.getSiguiente(); // El frente avanza al siguiente nodo

        // Clave de examen: Si la cola queda vacía, se debe resetear el puntero 'fin'
        if (frente == null) {
            fin = null;
        }
        tamano--;
        System.out.println("🔔 Atendiendo a: " + atendido.getNombre());
        return atendido;
    }

    public void mostrarFila() {
        if (estaVacia()) {
            System.out.println("Fila vacía.");
            return;
        }
        System.out.println("\n--- FILA DEL BANCO (FRENTE ➔ FIN) ---");
        NodoCliente aux = frente;
        while (aux != null) {
            System.out.println(aux.getDato());
            aux = aux.getSiguiente();
        }
        System.out.println("-------------------------------------\n");
    }
}
Archivo 4: MainBanco.javaJavapublic class MainBanco {
    public static void main(String[] args) {
        ColaBanco banco = new ColaBanco();

        banco.encolar(new Cliente("Roberto", 101));
        banco.encolar(new Cliente("Lucía", 102));
        banco.encolar(new Cliente("Sofía", 103));

        banco.mostrarFila();

        banco.desencolar(); // Sale Roberto
        banco.mostrarFila();

        banco.desencolar(); // Sale Lucía
        banco.desencolar(); // Sale Sofía (la cola queda vacía)

        banco.desencolar(); // Intento extra sobre cola vacía
    }
}
EJERCICIO 3: Verificación de Palíndromos combinando Pila (LIFO) y Cola (FIFO)Concepto de examen: Demuestra cómo la Pila invierte los datos al desapilar (pop), mientras que la Cola mantiene el orden original al desencolar.Archivo 1: NodoChar.javaJavapublic class NodoChar {
    private char dato;
    private NodoChar siguiente;

    public NodoChar(char dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public char getDato() { return dato; }
    public NodoChar getSiguiente() { return siguiente; }
    public void setSiguiente(NodoChar siguiente) { this.siguiente = siguiente; }
}
Archivo 2: PilaChar.java (LIFO)Javapublic class PilaChar {
    private NodoChar tope;

    public void push(char c) {
        NodoChar nuevo = new NodoChar(c);
        nuevo.setSiguiente(tope);
        tope = nuevo;
    }

    public char pop() {
        if (tope == null) return '\0';
        char val = tope.getDato();
        tope = tope.getSiguiente();
        return val;
    }

    public boolean estaVacia() { return tope == null; }
}
Archivo 3: ColaChar.java (FIFO)Javapublic class ColaChar {
    private NodoChar frente;
    private NodoChar fin;

    public void encolar(char c) {
        NodoChar nuevo = new NodoChar(c);
        if (frente == null) {
            frente = nuevo;
        } else {
            fin.setSiguiente(nuevo);
        }
        fin = nuevo;
    }

    public char desencolar() {
        if (frente == null) return '\0';
        char val = frente.getDato();
        frente = frente.getSiguiente();
        if (frente == null) fin = null;
        return val;
    }

    public boolean estaVacia() { return frente == null; }
}
Archivo 4: VerificadorPalindromoMain.javaJavapublic class VerificadorPalindromoMain {

    public static boolean esPalindromo(String palabra) {
        PilaChar pila = new PilaChar();
        ColaChar cola = new ColaChar();

        // Limpieza de cadena: ignorar espacios y pasar a minúsculas
        String limpia = palabra.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // 1. Insertamos el mismo carácter en la Pila y en la Cola
        for (int i = 0; i < limpia.length(); i++) {
            char c = limpia.charAt(i);
            pila.push(c);     // LIFO: Guardará el orden inverso
            cola.encolar(c);  // FIFO: Guardará el orden original
        }

        // 2. Comparamos extraído a extraído
        while (!pila.estaVacia() && !cola.estaVacia()) {
            char dePila = pila.pop();         // Sale en orden inverso
            char deCola = cola.desencolar();  // Sale en orden original

            if (dePila != deCola) {
                return false; // Si un carácter no coincide, no es palíndromo
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String p1 = "Anita lava la tina";
        String p2 = "Estructuras de Datos";

        System.out.println("'" + p1 + "' ¿Es palíndromo?: " + (esPalindromo(p1) ? "✅ SÍ" : "❌ NO"));
        System.out.println("'" + p2 + "' ¿Es palíndromo?: " + (esPalindromo(p2) ? "✅ SÍ" : "❌ NO"));
    }
}
EJERCICIO 1: Cola de Prioridad con Nodos (Triage en Urgencias)
¿Por qué es nivel examen?

A diferencia de una cola normal que siempre inserta al final (fin), una Cola de Prioridad requiere recorrer la lista con un apuntador auxiliar (actual) e insertar el nodo en el lugar correcto según su nivel de urgencia (1 = Crítico/Máxima prioridad, 3 = Menor prioridad). Para pacientes con el mismo nivel de urgencia, respeta el orden de llegada (FIFO).

Archivo 1: Paciente.java
Java
public class Paciente {
    private String nombre;
    private int nivelUrgencia; // 1: Rojo (Grave), 2: Amarillo (Medio), 3: Verde (Leve)

    public Paciente(String nombre, int nivelUrgencia) {
        this.nombre = nombre;
        this.nivelUrgencia = nivelUrgencia;
    }

    public String getNombre() { return nombre; }
    public int getNivelUrgencia() { return nivelUrgencia; }

    @Override
    public String toString() {
        String color = (nivelUrgencia == 1) ? "🔴 ROJO" : (nivelUrgencia == 2) ? "🟡 AMARILLO" : "🟢 VERDE";
        return "[" + color + "] " + nombre + " (Prioridad " + nivelUrgencia + ")";
    }
}
Archivo 2: NodoPaciente.java
Java
public class NodoPaciente {
    private Paciente dato;
    private NodoPaciente siguiente;

    public NodoPaciente(Paciente dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Paciente getDato() { return dato; }
    public NodoPaciente getSiguiente() { return siguiente; }
    public void setSiguiente(NodoPaciente siguiente) { this.siguiente = siguiente; }
}
Archivo 3: ColaPrioridadUrgencias.java
Java
public class ColaPrioridadUrgencias {
    private NodoPaciente frente;
    private int tamano;

    public ColaPrioridadUrgencias() {
        this.frente = null;
        this.tamano = 0;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    // ENCOLA CON PRIORIDAD: Algoritmo clave de examen (Inserción Ordenada)
    public void encolarPrioridad(Paciente paciente) {
        NodoPaciente nuevo = new NodoPaciente(paciente);

        // CASO A: La cola está vacía O el nuevo paciente tiene mayor prioridad que el frente
        if (estaVacia() || paciente.getNivelUrgencia() < frente.getDato().getNivelUrgencia()) {
            nuevo.setSiguiente(frente);
            frente = nuevo; // El nuevo pasa a ser el frente de la cola
        }
        // CASO B: Hay que buscar la posición intermedia o final correcta
        else {
            NodoPaciente actual = frente;
            // Avanzamos mientras el siguiente exista y tenga igual o mayor prioridad
            while (actual.getSiguiente() != null &&
                   actual.getSiguiente().getDato().getNivelUrgencia() <= paciente.getNivelUrgencia()) {
                actual = actual.getSiguiente();
            }
            // Reconexión de punteros en medio de la lista
            nuevo.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(nuevo);
        }

        tamano++;
        System.out.println("➡️ Registrado en Triage: " + paciente);
    }

    // DESENCOLA: Atiende siempre al que quedó en el frente
    public Paciente desencolar() {
        if (estaVacia()) {
            System.out.println("⚠️ No hay pacientes en sala de espera.");
            return null;
        }
        Paciente atendido = frente.getDato();
        frente = frente.getSiguiente(); // Desplazamos el frente
        tamano--;
        System.out.println("🚨 ATENDIENDO EN DOCTOR: " + atendido);
        return atendido;
    }

    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("Sala de espera vacía.");
            return;
        }
        System.out.println("\n================ SALA DE ESPERA (POR PRIORIDAD) ================");
        NodoPaciente aux = frente;
        int turno = 1;
        while (aux != null) {
            System.out.println(" " + turno + ". " + aux.getDato());
            aux = aux.getSiguiente();
            turno++;
        }
        System.out.println("=================================================================\n");
    }
}
Archivo 4: MainUrgencias.java
Java
public class MainUrgencias {
    public static void main(String[] args) {
        ColaPrioridadUrgencias hospital = new ColaPrioridadUrgencias();

        // Llegan en este orden de tiempo: Leve -> Medio -> Crítico
        hospital.encolarPrioridad(new Paciente("Pedro", 3)); // Leve
        hospital.encolarPrioridad(new Paciente("Ana", 2));   // Medio
        hospital.encolarPrioridad(new Paciente("Carlos", 1));// Crítico (Debe saltar al frente)
        hospital.encolarPrioridad(new Paciente("Sofia", 1)); // Crítico (Llega después de Carlos, va tras él)

        hospital.mostrarCola();

        // Atender al primero (debe ser Carlos)
        hospital.desencolar();

        hospital.mostrarCola();
    }
}
EJERCICIO 2: Simulación de Planificador de CPU (Round Robin)
¿Por qué es nivel examen?

Simula la planificación de procesos en Sistemas Operativos. Un proceso toma la CPU por un intervalo de tiempo fijo (Quantum, ej. 3 milisegundos). Si el proceso no termina en ese tiempo, se le resta el Quantum consumido, se desencola del frente y se re-encola al final de la cola para esperar su siguiente turno.

Archivo 1: Proceso.java
Java
public class Proceso {
    private String idProceso;
    private int tiempoTotalRequerido; // ms totales de CPU que necesita

    public Proceso(String idProceso, int tiempoTotalRequerido) {
        this.idProceso = idProceso;
        this.tiempoTotalRequerido = tiempoTotalRequerido;
    }

    public String getIdProceso() { return idProceso; }
    public int getTiempoTotalRequerido() { return tiempoTotalRequerido; }

    public void ejecutar(int quantum) {
        this.tiempoTotalRequerido -= quantum;
        if (this.tiempoTotalRequerido < 0) {
            this.tiempoTotalRequerido = 0;
        }
    }

    @Override
    public String toString() {
        return "⚙️ [" + idProceso + " | Restante: " + tiempoTotalRequerido + "ms]";
    }
}
Archivo 2: NodoProceso.java
Java
public class NodoProceso {
    private Proceso dato;
    private NodoProceso siguiente;

    public NodoProceso(Proceso dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Proceso getDato() { return dato; }
    public NodoProceso getSiguiente() { return siguiente; }
    public void setSiguiente(NodoProceso siguiente) { this.siguiente = siguiente; }
}
Archivo 3: ColaProcesos.java
Java
public class ColaProcesos {
    private NodoProceso frente;
    private NodoProceso fin;

    public boolean estaVacia() {
        return frente == null;
    }

    public void encolar(Proceso proceso) {
        NodoProceso nuevo = new NodoProceso(proceso);
        if (estaVacia()) {
            frente = nuevo;
        } else {
            fin.setSiguiente(nuevo);
        }
        fin = nuevo;
    }

    public Proceso desencolar() {
        if (estaVacia()) return null;
        Proceso p = frente.getDato();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null; // Si se vacía, reseteamos fin
        }
        return p;
    }

    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("Cola de procesos vacía.");
            return;
        }
        System.out.print("Estado de la Cola CPU: [ ");
        NodoProceso aux = frente;
        while (aux != null) {
            System.out.print(aux.getDato().getIdProceso() + "(" + aux.getDato().getTiempoTotalRequerido() + "ms) ");
            aux = aux.getSiguiente();
        }
        System.out.println("]");
    }
}
Archivo 4: MainCPU.java
Java
public class MainCPU {
    public static void main(String[] args) {
        ColaProcesos colaCPU = new ColaProcesos();
        int QUANTUM = 3; // Ráfaga máxima de ejecucion por turno

        // Carga de 3 procesos en la cola
        colaCPU.encolar(new Proceso("P1_Navegador", 8));
        colaCPU.encolar(new Proceso("P2_Spotify", 4));
        colaCPU.encolar(new Proceso("P3_VSCode", 2));

        System.out.println("=== INICIO DE EJECUCIÓN CPU (ROUND ROBIN - QUANTUM = " + QUANTUM + "ms) ===");
        colaCPU.mostrarCola();
        System.out.println();

        int ciclo = 1;
        // El bucle corre mientras existan procesos incompletos en la cola
        while (!colaCPU.estaVacia()) {
            System.out.println("--- Ciclo de Reloj #" + ciclo + " ---");
            Proceso actual = colaCPU.desencolar();

            System.out.println("💻 Ejecutando " + actual.getIdProceso() + " por máximo " + QUANTUM + "ms...");
            actual.ejecutar(QUANTUM);

            // Evaluación de Examen: ¿El proceso terminó o debe re-encolarse?
            if (actual.getTiempoTotalRequerido() > 0) {
                System.out.println("⏳ " + actual.getIdProceso() + " aún requiere " + actual.getTiempoTotalRequerido() + "ms. Re-encolando al final...");
                colaCPU.encolar(actual);
            } else {
                System.out.println("✅ " + actual.getIdProceso() + " FINALIZADO Y REMOVIDO DE MEMORIA.");
            }

            colaCPU.mostrarCola();
            System.out.println();
            ciclo++;
        }

        System.out.println("🎉 Todos los procesos fueron ejecutados exitosamente.");
    }
}
PROBLEMA: Reorganización de Lotes (Revertir los primeros $K$ elementos de una Cola)¿Por qué es de nivel examen?Te piden invertir el orden únicamente de los primeros $K$ paquetes de una cola, dejando el resto de la cola exactamente en su orden original. Para resolverlo sin usar arreglos ni listas auxiliares, debes usar una Pila auxiliar en 3 pasos clave:Desencolar $K$ elementos de la Cola y hacer push a la Pila.Hacer pop de la Pila y volver a hacer encolar a la Cola (los primeros $K$ quedan invertidos, pero al final de la cola).Rotar los $N - K$ elementos restantes sacándolos del frente y re-encolándolos al final para restaurar la secuencia original.Archivo 1: Paquete.javaJavapublic class Paquete {
    private String codigo;
    private String destino;

    public Paquete(String codigo, String destino) {
        this.codigo = codigo;
        this.destino = destino;
    }

    public String getCodigo() { return codigo; }
    public String getDestino() { return destino; }

    @Override
    public String toString() {
        return "📦 [" + codigo + " ➔ " + destino + "]";
    }
}
Archivo 2: NodoPaquete.javaJavapublic class NodoPaquete {
    private Paquete dato;
    private NodoPaquete siguiente;

    public NodoPaquete(Paquete dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public Paquete getDato() { return dato; }
    public NodoPaquete getSiguiente() { return siguiente; }
    public void setSiguiente(NodoPaquete siguiente) { this.siguiente = siguiente; }
}
Archivo 3: PilaPaquetes.java (LIFO Auxiliar)Javapublic class PilaPaquetes {
    private NodoPaquete tope;

    public void push(Paquete paquete) {
        NodoPaquete nuevo = new NodoPaquete(paquete);
        nuevo.setSiguiente(tope);
        tope = nuevo;
    }

    public Paquete pop() {
        if (estaVacia()) return null;
        Paquete p = tope.getDato();
        tope = tope.getSiguiente();
        return p;
    }

    public boolean estaVacia() {
        return tope == null;
    }
}
Archivo 4: ColaPaquetes.java (FIFO)Javapublic class ColaPaquetes {
    private NodoPaquete frente;
    private NodoPaquete fin;
    private int tamano;

    public ColaPaquetes() {
        this.frente = null;
        this.fin = null;
        this.tamano = 0;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public int getTamano() {
        return tamano;
    }

    public void encolar(Paquete paquete) {
        NodoPaquete nuevo = new NodoPaquete(paquete);
        if (estaVacia()) {
            frente = nuevo;
        } else {
            fin.setSiguiente(nuevo);
        }
        fin = nuevo;
        tamano++;
    }

    public Paquete desencolar() {
        if (estaVacia()) return null;
        Paquete p = frente.getDato();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        tamano--;
        return p;
    }

    public void mostrarCola() {
        if (estaVacia()) {
            System.out.println("Cola vacía.");
            return;
        }
        System.out.print("FRENTE ➔ ");
        NodoPaquete aux = frente;
        while (aux != null) {
            System.out.print(aux.getDato() + " ");
            aux = aux.getSiguiente();
        }
        System.out.println("➔ FIN");
    }
}
Archivo 5: MainReorganizacion.java (Algoritmo de Examen)Javapublic class MainReorganizacion {


     * ALGORITMO CLAVE DE EXAMEN:
     * Invierte únicamente los primeros K elementos de la cola usando una Pila aux.

public static void revertirPrimerosK(ColaPaquetes cola, int k) {
    // Validación de casos borde
    if (k <= 0 || k > cola.getTamano()) {
        System.out.println("❌ Valor de K no válido.");
        return;
    }

    PilaPaquetes pilaAux = new PilaPaquetes();

    // PASO 1: Desencolar los primeros K elementos de la Cola y hacer PUSH a la Pila
    for (int i = 0; i < k; i++) {
        pilaAux.push(cola.desencolar());
    }

    // PASO 2: Desapilar (POP) de la Pila y encolar de nuevo en la Cola
    // Nota: Los elementos invertidos quedan temporalmente al FINAL de la cola.
    while (!pilaAux.estaVacia()) {
        cola.encolar(pilaAux.pop());
    }

    // PASO 3: Mover los (N - K) elementos restantes del frente al final
    // para que los elementos invertidos vuelvan a estar al FRENTE.
    int elementosRestantes = cola.getTamano() - k;
    for (int i = 0; i < elementosRestantes; i++) {
        cola.encolar(cola.desencolar());
    }
}

public static void main(String[] args) {
    ColaPaquetes envio = new ColaPaquetes();

    // Carga de 5 paquetes
    envio.encolar(new Paquete("P1", "CDMX"));
    envio.encolar(new Paquete("P2", "Guadalajara"));
    envio.encolar(new Paquete("P3", "Monterrey"));
    envio.encolar(new Paquete("P4", "Puebla"));
    envio.encolar(new Paquete("P5", "Querétaro"));

    System.out.println("=== ESTADO INICIAL DE LA COLA ===");
    envio.mostrarCola();

    int k = 3; // Queremos invertir solo P1, P2 y P3
    System.out.println("\n🔄 Invirtiendo los primeros K = " + k + " paquetes con Pila Auxiliar...");
    revertirPrimerosK(envio, k);

    System.out.println("\n=== ESTADO FINAL TRAS REORGANIZAR ===");
    envio.mostrarCola();
    // Resultado esperado: P3 -> P2 -> P1 -> P4 -> P5
}
}
*/


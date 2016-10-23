import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class VectorHeapTest {

	@Before
	public void setUp() throws Exception {
	}
	
	VectorHeap prueba = new VectorHeap();
	@Test
	public void addTest() {
		String cadena ="Ramon Samayoa, papiloma humano, B";
		String [] arreglo= cadena.split(",");
        Nodo paciente= new Nodo(arreglo[0],arreglo[1],arreglo[2]);
        prueba.add(paciente);
	}
	@Test
	public void sizeTest() {
		//Se probar� cuantos elementos tiene ahora el vector (1 paciente, un elemento)
		String cadena ="Ramon Samayoa, papiloma humano, B";
		String [] arreglo= cadena.split(",");
        Nodo paciente= new Nodo(arreglo[0],arreglo[1],arreglo[2]);
        prueba.add(paciente);
		int x = prueba.size();
		 assertTrue(x==1);
	}
	@Test
	public void removeTest() {
		String cadena ="Ramon Samayoa, papiloma humano, B";
		String [] arreglo= cadena.split(",");
        Nodo paciente= new Nodo(arreglo[0],arreglo[1],arreglo[2]);
        prueba.add(paciente);
        String resultado = prueba.remove().toString();
        //System.out.println(resultado);
        int x = 0;
        if(resultado.equals("Ramon Samayoa,  papiloma humano,  B")){
			x = 1;
		}
        assertTrue(x==1);
		
	}
}
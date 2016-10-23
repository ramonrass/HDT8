/* 	
 *  Diego Rivera 15085
 *  Ramon Samayoa 15497
 *  Main
*/

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.PriorityQueue;

/**
 *
 * @author diego
 */
public class main {

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        
    	// Ruta del documento a leer y objetos varios
        File pacientes = new File("C:\\Users\\diego\\Desktop\\Diego Rivera\\texto\\prueba heap.txt");
        VectorHeap V_Heap = new VectorHeap();
        PriorityQueue<Nodo> P_Queue = new PriorityQueue();
        Nodo paciente;
        String [] atributos;
        
        /**
         * 
         * Try-catch para leer el documento 
         */
        try{
            BufferedReader br = new BufferedReader(new FileReader(pacientes));
            
            /**
             * 
             * Try-catch para imprimir los pacientes
             * Agregar los pacientes al vector de VectorHeap
             */
            try {
                for(String line; (line = br.readLine()) != null;){
                    atributos = line.split(",");
                    paciente = new Nodo(atributos[0],atributos[1],atributos[2]);
                    V_Heap.add(paciente);
                    P_Queue.add(paciente);
                }
            }
            catch(IOException ex) {
            	System.out.println("No se encuentra el documento");
            }
            
            
            System.out.println("\nLista de pacientes (En orden de atencion):\n");
            
            /**
             * 
             * Obtiene el tamano PriorityQueue, imprime los pacientes en orden de urgencia
             */
            int y = P_Queue.size();
            while(y !=0){
                System.out.println("   "+P_Queue.remove().toString());
		    y--;
            }
        }
        catch(FileNotFoundException ex) {
        	System.out.println("No se encuentra el documento");
        }
    }
}
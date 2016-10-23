
/**	
 *  Diego Rivera 15085
 *  Ramon Samayoa 15497
*/

public class Nodo implements Comparable<Nodo>{ 
	/**
     * atributos String codigo,nombre,sintoma
     */
    protected String codigo,nombre,sintoma;

    /**
     * Constructor
     * @param nombre
     * @param sintoma
     * @param codigo
     *    recibe los atributos de cada persona, los pasa a atributos locales
     */
    
    public Nodo(String nombre, String sintoma, String codigo){
        this.nombre=nombre;
        this.sintoma=sintoma;
        this.codigo=codigo;
    }
    
    /**
     * @param p
     *    devuelve el valor de prioridad de cada persona
     * @return int
     */
    @Override
    public int compareTo(Nodo p){
        Nodo enfermo = (Nodo)p;
        return codigo.compareTo(enfermo.getCodigo());
    }
    /**
     * 
     *    devuelve el codigo de urgencia de cada persona
     * @return String
     */
    public String getCodigo(){
        return codigo;
    }
    
    /**
     *    devuelve el los atributos de cada persona concatenados
     * @return String
     */
    public String toString(){
        return (nombre+", "+sintoma+", "+codigo);
    }
}

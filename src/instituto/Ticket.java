
package instituto;

/**
 *
 * @author jomel
 */
public class Ticket {
    private String Pasajero;
    private double Total;

    public String getPasajero() {
        return Pasajero;
    }

    public double getTotal() {
        return Total;
    }
    
    public Ticket(String Pasajero, double Total){
        this.Pasajero = Pasajero;
        this.Total = Total;
    }
    
    public String Print(){
        return "Nombre: " + Pasajero + "\nPagado: L." + Total;
    }
    
}

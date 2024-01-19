
package instituto;

import javax.swing.JOptionPane;

/**
 *
 * @author Johnny & Juan
 */
public class PalindromoAir {
    Ticket[] asiento = new Ticket[30];
    
    public int firstAvailable(){
        return firstAvailable(0);
    }
    
    private int firstAvailable(int pos){
        if(pos < asiento.length){
            if (asiento[pos] == null) {
                return pos;
            }
            return firstAvailable(pos + 1);
        }
        return -1;
    }
    
    private int searchPassenger(String name, int pos){
        if(pos < asiento.length){
            if(asiento[pos] != null && 
                    asiento[pos].getPasajero().equals(name)){
                return pos;
            }
            
            return searchPassenger(name ,pos + 1);
        }
        return -1;
    }
    
    public int searchPassenger(String name){
        return searchPassenger(name, 0);
    }
    
    private boolean esPali(String palabra, int inicio, int fin){
         
        if(inicio != fin){
            if(palabra.charAt(inicio) == palabra.charAt(fin)){
                return esPali(palabra, inicio + 1, fin - 1);
            }else{
                return false;
            }
        }
        return true;
    }
    
    public boolean isPalindromo(String palabra){
        return esPali(palabra, 0, palabra.length() - 1);
    }
    
    public void reset(){
        reset(0);
    }
    
    private void reset(int pos){
        if(pos < asiento.length){
            asiento[pos] = null;
            reset(pos + 1);
        }
    }
    
    public double income() {
        return income(0, 0);
    }
    
    private double income(double numero, int posicion) {
        if (posicion >= asiento.length) {
            return numero;
        }
        if (asiento[posicion] != null) {
            numero += asiento[posicion].getTotal();
        }
        return income(numero, posicion + 1);
    }

    
    public boolean cancelTicket(String name){
        int pos = searchPassenger(name);
        if( pos != -1){
            asiento[pos] = null;
            return true;
        }
        return false;
    }
    
    public void printPassengers() {
        String passengersInfo = "";
        printPassengers(passengersInfo, 0);
    }
    //El verdadero void printPassengers
    private void printPassengers(String passengersInfo, int posicion) {
        if (posicion < asiento.length) {
            if (asiento[posicion] != null) {
                passengersInfo = asiento[posicion].Print();
            }
            printPassengers(passengersInfo, posicion + 1);
        }
        JOptionPane.showMessageDialog(null, "Pasajeros: \n" + passengersInfo);
    }
    
    public void sellTicket(String name){
        int pos = searchPassenger(name);
        if( pos != -1){
            double Total = 800;
            if(isPalindromo(name) == true){
                Total = Total - (Total * 0.2);
            }
            Ticket ticket = new Ticket(name, Total);
            asiento[pos] = ticket;
            JOptionPane.showMessageDialog(null, "El monto Total es L. " + Total);
        }
    }


}

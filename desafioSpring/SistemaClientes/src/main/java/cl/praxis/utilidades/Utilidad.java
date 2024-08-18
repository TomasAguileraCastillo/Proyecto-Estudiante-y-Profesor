package cl.praxis.utilidades;

public class Utilidad {


    public void esperar() {
        int tiempoEspera = 20;
        try {
            for(int i = 0; i < tiempoEspera; i++) {
                Thread.sleep(150);
            }
        }catch(InterruptedException ie) {
            System.out.println("    Error en timer");
        }
    }

    public  void limpiarPantalla() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {

        }
    }

    public void limpiaresperar() {
        esperar();
        limpiarPantalla ();
    }




}

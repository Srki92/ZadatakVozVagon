package zadaci;

import model.Vagon;

/**
 * Created by androiddevelopment on 25.4.17..
 */
public class VagonNit extends Thread {

    private String oznaka;
    private Vagon vagon;


    public VagonNit(String oznaka){
        this.oznaka = oznaka;
    }


    public static void syncPrint (String s) {
        synchronized (System.out) {
            System.out.println(s);
        }
    }

    private void utovar() {
        System.out.println("Teret se utovara u vagon " + oznaka);
        do {
            try {
                this.sleep(1000 + 1000);
                synchronized (Vagon.trenutnaTezina) {
                    if (Vagon.trenutnaTezina += 1) {
                        Vagon.syncPrint("Teret utovaren , trenutna tezina je " + Vagon.trenutnaTezina);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } while (Vagon.trenutnaTezina < 10000);

    }

    public void run() {



    }





}


import java.util.ArrayList;


public class Operaciones {
    public void union() {
        System.out.println("?????????");
        boolean repetido = false;
        Ventana.conRes = Ventana.conjt1;
        for (int i = 0; i < Ventana.conjt2.size(); i++) {
            Ventana.conRes.add(Ventana.conjt2.get(i));
        }
        for (int i = 0; i < Ventana.conRes.size(); i++) {
            for (int j = 0; j < Ventana.conRes.size(); j++) {
                if (i != j && Ventana.conRes.get(i).equals(Ventana.conRes.get(j))) {
                    Ventana.conRes.remove(j);
                }
            }
        }
    }

    public void diferenciaSimetrica() {
        ArrayList auxiliar = new ArrayList();
        for (int i = 0; i < Ventana.conjt1.size(); i++) {
            for (int j = 0; j < Ventana.conjt2.size(); j++) {
                if (Ventana.conjt1.get(i).equals(Ventana.conjt2.get(j))) {
                    auxiliar.add(Ventana.conjt1.get(i));
                }

            }
        }
        Ventana.conRes = Ventana.conjt1;
        for (int i = 0; i < Ventana.conjt2.size(); i++) {
            Ventana.conRes.add(Ventana.conjt2.get(i));
        }
        
        try{
            for (int i = 0; i < Ventana.conRes.size(); i++) {
            for (int j = 0; j < auxiliar.size(); j++) {
                if(Ventana.conRes.get(i).equals(auxiliar.get(j))){
                    Ventana.conRes.remove(i);
                }
            }
        }
        }
            catch(Exception args){}
        

    }

    public void interseccion() {
        boolean repetido = false;
        for (int i = 0; i < Ventana.conjt1.size(); i++) {
            for (int j = 0; j < Ventana.conjt2.size(); j++) {
                if (Ventana.conjt1.get(i).equals(Ventana.conjt2.get(j))) {
                    for (int x = 0; x < Ventana.conRes.size(); x++) {
                        if (Ventana.conRes.get(x).equals(Ventana.conjt1.get(i))) {
                            repetido = true;
                            break;
                        }
                    }
                    if (!repetido) {
                        Ventana.conRes.add(Ventana.conjt1.get(i));
                    }
                    repetido = false;
                }
            }
        }
    }

    public void diferencia() {
        Ventana.conRes = Ventana.conjt1;
        for (int i = 0; i < Ventana.conRes.size(); i++) {
            for (int j = 0; j < Ventana.conRes.size(); j++) {
                if (i != j && Ventana.conRes.get(i).equals(Ventana.conRes.get(j))) {
                    Ventana.conRes.remove(j);
                }
            }
        }
        for (int i = 0; i < Ventana.conjt2.size(); i++) {
            for (int j = 0; j < Ventana.conRes.size(); j++) {
                if (Ventana.conRes.get(j).equals(Ventana.conjt2.get(i))) {
                    Ventana.conRes.remove(j);
                }
            }
        }
    }
}

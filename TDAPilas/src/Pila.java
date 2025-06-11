import javax.swing.*;

public class Pila { //las pilas se aplican en procesos complementarios
    public Nodo cima;
    public int tam;

    public Pila() { //vacío para que la pila crezca dinámicamente
        cima = null;
        tam = 0;
    }

    public void apilar(int dato, JTextArea txtCont){
        Nodo nuevo = new Nodo(dato);
        nuevo.sig = cima;
        cima = nuevo;
        tam++;
        actualizarContenedor(txtCont);
    }

    public int desapilar(JTextArea txtCont){
       if(estaVacia()){
           JOptionPane.showMessageDialog(null, "Pila vacia!");
           return -1; //ausencia de elementos
       }

       int dato = cima.dato;
       cima = cima.sig;
       tam--;
       actualizarContenedor(txtCont);
       return dato;
    }

    public boolean estaVacia(){
        return cima == null;
    }

    public void mostrarPila(JTextArea txtCont){
        if (estaVacia()){
            txtCont.setText("Pila vacia!");
        }else {
            StringBuilder pilaStr = new StringBuilder();
            Nodo actual = cima;
            while(actual != null){
                pilaStr.append(actual.dato)
                        .append("\n");
                actual = actual.sig;
                txtCont.setText(pilaStr.toString());
            }
        }
    }

    public void actualizarContenedor(JTextArea txtCont){ //metodo para simular refrescar con el F5
        mostrarPila(txtCont);
    }
}

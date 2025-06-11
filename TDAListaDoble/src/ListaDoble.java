import javax.swing.*;

public class ListaDoble {
    public NodoDoble inicio, fin;
    public int tam;

    public ListaDoble() {
        inicio = null; //reserva dinamica de memoria
        fin = null;
        tam = 0;
    }

    public void agregar(int dato, JTextArea cont){
        NodoDoble nuevoNodo = new NodoDoble(dato);
        if (inicio == null){
            inicio = fin = nuevoNodo;
        }else {
            fin.siguiente = nuevoNodo;
            nuevoNodo.anterior = fin;
            fin = nuevoNodo;
        }

        tam++;
        actualizarLista(cont);
    }

    public void mostrarLista(JTextArea txtArea){
        if (inicio == null){
            txtArea.setText("Lista vacia!");
            return; //no hace nada
        }

        StringBuilder listaStr = new StringBuilder();
        NodoDoble actual = inicio;
        while (actual != null) {
            listaStr.append(actual.dato).append("\n");
            actual = actual.siguiente;
        }

        listaStr.append("\n Lista en orden inverso");
        actual = fin;
        while (actual != null){
            listaStr.append(actual.dato).append("\n");
            actual = actual.anterior;
        }

        txtArea.setText(listaStr.toString());
    }

    public void actualizarLista(JTextArea txtArea){
        mostrarLista(txtArea);
    }

    public void ordenarBurbuja(JTextArea txtArea){
        if (inicio == null || inicio.siguiente == null)
            return;
        boolean swapped;

        do {
           swapped = false;
           NodoDoble actual = inicio;
           while (actual.siguiente != null){
               if (actual.dato > actual.siguiente.dato){
                   int temp = actual.dato;
                   actual.dato = actual.siguiente.dato;
                   actual.siguiente.dato = temp;
                   swapped = true;
               }

               actual = actual.siguiente;
           }
        }while (swapped);
        actualizarLista(txtArea);
    }

    public int buscar(int dato){
        NodoDoble actual = inicio;
        int posicion = 0;
        while (actual != null){
            if (actual.dato == dato){
                return posicion;
            }

            actual = actual.siguiente;
            posicion++;

        }
        return -1;
    }

    public boolean eliminar(int dato, JTextArea cont){
        if (inicio == null){
            JOptionPane.showMessageDialog(null, "Lista vacia!");
            return false;
        }

        NodoDoble actual = inicio;
        while (actual != null && actual.dato != dato){
            actual = actual.siguiente;
        }

        if (actual == null){
            JOptionPane.showMessageDialog(null, "Elemento no encontrado!");
            return false;
        }

        if (actual == inicio){
            inicio = inicio.siguiente;
            if (inicio != null){
                inicio.anterior = null;
            }else if(actual == fin){
                fin = fin.anterior;
                if (fin != null){
                    fin.siguiente = null;
                }
            }else{
                actual.anterior.siguiente = actual.siguiente;
                actual.siguiente.anterior = actual.anterior;
            }
        }
        tam--;
        actualizarLista(cont);
        return true;
    }
}
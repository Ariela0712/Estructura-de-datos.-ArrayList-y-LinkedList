public class Nodo<E> {
    protected E dato;
    protected Nodo<E> sig;

    public Nodo(E dato) {
        this.dato = dato;
        this.sig = null;
    }

    public Nodo(E dato, Nodo<E> sig) {
        this.dato = dato;
        this.sig = sig;
    }

    public E getDato() {
        return dato;
    }

    public void setDato(E dato) {
        this.dato = dato;
    }

    public Nodo<E> getSig() {
        return sig;
    }

    public void setSig(Nodo<E> sig) {
        this.sig = sig;
    }
}

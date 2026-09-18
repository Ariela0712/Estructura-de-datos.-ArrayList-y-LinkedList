public class LinkedList<E> implements List<E> {
    private Nodo<E> head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    private void validarIndiceAcceso(int indice) {
        if (indice < 0 || indice >= size) {
            throw new IndexOutOfBoundsException("Indice fuera de rango: " + indice + " (tamano actual: " + size + ")");
        }
    }

    private void validarIndiceInsercion(int indice) {
        if (indice < 0 || indice > size) {
            throw new IndexOutOfBoundsException("Indice fuera de rango: " + indice + " (tamano actual: " + size + ")");
        }
    }

    private boolean elementosIguales(E primero, E segundo) {
        return primero == null ? segundo == null : primero.equals(segundo);
    }

    @Override
    public void add(E e) {
        Nodo<E> node = new Nodo<>(e);
        if (isEmpty()) {
            head = node;
        } else {
            Nodo<E> actual = head;
            while (actual.getSig() != null) {
                actual = actual.getSig();
            }
            actual.setSig(node);
        }
        size++;
    }

    @Override
    public void add(E e, int indice) {
        validarIndiceInsercion(indice);
        if (indice == 0) {
            head = new Nodo<>(e, head);
        } else {
            Nodo<E> actual = head;
            for (int i=0;i<indice - 1;i++) {
                actual = actual.getSig();
            }
            Nodo<E> node = new Nodo<>(e);
            node.setSig(actual.getSig());
            actual.setSig(node);
        }
        size++;
    }

    @Override
    public E remove(int indice) {
        validarIndiceAcceso(indice);
        Nodo<E> aux;
        if (indice == 0) {
            aux = head;
            head = head.getSig();
        } else {
            Nodo<E> actual = head;
            for (int i=0;i<indice - 1;i++) {
                actual = actual.getSig();
            }
            aux = actual.getSig();
            actual.setSig(aux.getSig());
        }
        size--;
        return aux.getDato();
    }

    @Override
    public E get(int indice) {
        validarIndiceAcceso(indice);
        Nodo<E> actual = head;
        for (int i=0;i<indice;i++) {
            actual = actual.getSig();
        }
        return actual.getDato();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public void mostrar() {
        Nodo<E> actual = head;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSig();
        }
    }


    public void invertir() {
        Nodo<E> anterior = null;
        Nodo<E> actual = head;

        while (actual != null) {
            Nodo<E> siguiente = actual.getSig();
            actual.setSig(anterior);
            anterior = actual;
            actual = siguiente;
        }
        head = anterior;
    }

    public boolean contiene(E e){
        Nodo<E> actual = head;
        while (actual != null) {
            if (elementosIguales(actual.getDato(), e)) {
                System.out.println("\nEl elemento "+e+" se encuentra en la lista.");
                return true;
            }
            actual = actual.getSig();
        }
        System.out.println("El elemento "+e+" no se encuentra en la lista.");
        return false;
    }

    public int indexOf(E e) {
        Nodo<E> actual = head;
        int indice = 0;
        while (actual != null) {
            if (elementosIguales(actual.getDato(), e)) {
                return indice;
            }
            actual = actual.getSig();
            indice++;
        }
        return -1;
    }
}

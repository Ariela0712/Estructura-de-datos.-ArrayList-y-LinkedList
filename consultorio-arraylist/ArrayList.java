public class ArrayList<E> implements List<E>  {
    private Object[] elementos;
    private int tam;
    private int cap;

    public ArrayList() {
        this.tam = 0;
        this.cap = 10;
        this.elementos = new Object[cap];
    }

    protected void extender() {
        Object[] aux = new Object[cap+10];
        System.arraycopy(elementos, 0, aux, 0, tam);
        cap += 10;
        elementos = aux;
    }

    protected boolean isFull() {
        return cap == tam;
    }

    private void validarIndiceAcceso(int indice) {
        if (indice<0 || indice>=tam) {
            throw new IndexOutOfBoundsException("Indice fuera de rango: " + indice + " (tamano actual: " + tam + ")");
        }
    }

    private void validarIndiceInsercion(int indice) {
        if (indice<0 || indice>tam) {
            throw new IndexOutOfBoundsException("Indice fuera de rango: " + indice + " (tamano actual: " + tam + ")");
        }
    }

    @Override
    public void add(E e) {
        if (isFull()) {
            extender();
        }
        elementos[tam++] = e;
    }

    @Override
    public void add(E e, int indice) {
        validarIndiceInsercion(indice); 
        if (isFull()) {
            extender();
        }
        for (int i=tam;i>indice;i--) {
            elementos[i] = elementos[i-1];
        }
        elementos[indice] = e;
        tam++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E remove(int indice) {
        validarIndiceAcceso(indice);
        E removido = (E) elementos[indice];
        for (int i=indice;i<tam - 1;i++) {
            elementos[i] = elementos[i + 1];
        }
        elementos[tam-1] = null;
        tam--;
        return removido;
        
    }

    @Override
    @SuppressWarnings("unchecked")
    public E get(int indice) {
        validarIndiceAcceso(indice);
        return (E) elementos[indice];
    }

    @Override
    public int size() {
        return tam;
    }

    @Override
    public void clear() {
        cap = 10;
        elementos = new Object[cap];
        tam = 0;
    }

    @Override
    public boolean isEmpty() {
        return tam == 0;
    }

    public void mostrar() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder resultado = new StringBuilder("[");
        for (int i=0;i<tam;i++) {
            if (i > 0) {
                resultado.append(", ");
            }
            resultado.append(elementos[i]);
        }
        return resultado.append("]").toString();
    }

    
}

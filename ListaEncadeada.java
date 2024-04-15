public class ListaEncadeada implements ListaEncadeada_IF {

    private ListaEncadeada head;
    private ListaEncadeada next;
    private Integer value;

    public ListaEncadeada getNext() {
        return next;
    }

    public Integer getValue() {
        return value;
    }

    public ListaEncadeada(){
        next = null;
        value = null;
    }

    @Override
    public boolean isEmpty() {
        return isNil();
    }

    @Override
    public int size() {
        if(isEmpty()) return 0;

        return 1+next.size();
    }

    @Override
    public Integer search(Integer element) throws Exception {
        if (isEmpty()) {
            throw new Exception("Lista Vazia");
        }
    
        if (value.equals(element)) {
            return value;
        }
    
        if (!isNil()) {
            Integer result = next.search(element);
            if (result != null) {
                return result;
            }
        }
        
        return null;
    }
    

    @Override
    public void insert(Integer element) {
        ListaEncadeada aux = new ListaEncadeada();
        aux.value = value;
        aux.next = next;

        next = aux;
        value = element;
    }

    @Override
    public void remove(Integer element) {
        if (isEmpty()) {
            return;
        }

        if (value.equals(element)) {
            value = next.value;
            next = next.next;
        } else {
            if (next != null) {
                next.remove(element);
            }
        }
    }

    public boolean isNil(){
        return next == null && value == null;
    }
    
}

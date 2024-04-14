public class ListaEncadeadaIterativa implements ListaEncadeada_IF {

    private ListaEncadeadaIterativa next;
    private Integer value;
    private ListaEncadeadaIterativa head;

    public ListaEncadeadaIterativa(){
        head = new ListaEncadeadaIterativa();
    }

    public ListaEncadeadaIterativa getNext() {
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
        /*
        if(head.isNil())
           return true
        else
            return false
        */
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
        
        ListaEncadeadaIterativa auxHead = head;
        if(head.isNil()){
            ListaEncadeadaIterativa newHead = new ListaEncadeadaIterativa();
            newHead.next = head;
            head = newHead;
        }
        else{
            while(!auxHead.next.isNil()){
                auxHead = auxHead.next;
            }
        }
        ListaEncadeadaIterativa newNode = new ListaEncadeadaIterativa();
        newNode.next = auxHead.next;
        auxHead.next = newNode;
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

    @Override
    public int[] toArray() {
        int tam = size();
        int[] array = new int[tam];

        toArrayRecursivo(this, array, 0);

        return array;
    }
    public void toArrayRecursivo(ListaEncadeadaIterativa lista, int[] array, int inicio){
        if(lista.isEmpty()) return;
        array[inicio] = lista.value;
        toArrayRecursivo(lista.next, array, ++inicio);
    }

    public boolean isNil(){
        return next == null && value == null;
    }
    
}

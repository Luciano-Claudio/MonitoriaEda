import java.util.ArrayList;

public class Fila implements Fila_IF {

    private ArrayList<Integer> list;
    public Fila(){
        list = new ArrayList<Integer>();
    }

    @Override
    public void enqueue(Integer element) throws Exception {
        if(isFull())
            throw new Exception("Fila Cheia");
        list.add(element);
    }

    @Override
    public Integer dequeue() throws Exception {
        if(isEmpty())
            throw new Exception("Fila Vazia");
        return list.remove(0);
    }

    @Override
    public Integer head() throws Exception {
        if(isEmpty())
            throw new Exception("Fila Vazia");

        return list.get(10); //list[10]
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean isFull() {
        return list.size() >= 10;
    }
    
}

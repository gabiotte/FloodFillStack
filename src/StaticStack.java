public class StaticStack {

    private int top = -1;
    private Coordenada[] data;

    public StaticStack(int size) {
        this.data = new Coordenada[size];
    }

    public boolean isFull() {
        if(top == data.length - 1) {
            return true;
        }
        return false;
    }

    public boolean isEmpty() {
        if(top == -1) {
            return true;
        }
        return false;
    }

    public void push(Coordenada coordenada) {
        if (isFull()) {
            throw new StackOverflowError("Stack cheia");
        } else {
            top++;
            data[top] = coordenada;
        }
    }

    public Coordenada pop() {
        if (isEmpty()) {
            throw new StackOverflowError("Stack já vazia");
        }
        Coordenada pop = data[top];
        data[top] = null;
        top--;
        return pop;
    }

    public void clear() {
        for (int i = 0; i <= top; i++) {
            data[i] = null;
        }
        top = -1;
    }

}

package it.itis.cuneo;

public class Thread extends java.lang.Thread {

    private Buffer buffer;

    public Thread(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.setFatt(buffer.getFatt() * buffer.getNum());
        //System.out.println("Fattoriale di " + buffer.getNum() + ": " + buffer.getFatt());

        buffer.setNum(buffer.getNum() + 1);
    }
}

import java.util.Deque;
import java.util.ArrayDeque;

public class EjecutarPan {
    public static void main(String[] args) {
        Deque<String> sandwich1 = new ArrayDeque<>();
        sandwich1.add("pan blanco");
        sandwich1.add("lechuga");
        sandwich1.add("pan blanco");

        Deque<String> sandwich2 = new ArrayDeque<>();
        sandwich2.add("pan ");
        sandwich2.add("tomate");
        sandwich2.add("pan ");

        Pansimilar pan = new Pansimilar();
        System.out.println(pan.verificar(sandwich1, sandwich2)); 
    }
}
import java.util.Deque;
import java.util.ArrayDeque;

public class Pansimilar {
    public boolean verificar(Deque<String> s1, Deque<String> s2) {
        // Tomamos el primer y último pan de cada sandwich
        String primero1 = s1.peekFirst();
        String ultimo1  = s1.peekLast();

        String primero2 = s2.peekFirst();
        String ultimo2  = s2.peekLast();

        // Si los extremos coinciden, retornamos true
        if (primero1.equals(primero2) && ultimo1.equals(ultimo2)) {
            return true;
        } else {
            return false;
        }
    }
}
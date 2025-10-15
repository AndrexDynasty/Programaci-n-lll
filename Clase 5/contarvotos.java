import java.util.ArrayDeque;
import java.util.Queue;

public class contarvotos {
    public int contarvotos(int upvotes,int downvotes) {
// 1) Crear una cola para contar los votos
        Queue<Integer> VotosPos = new ArrayDeque<>();
        Queue<Integer> VotosNeg = new ArrayDeque<>();
        for(int i =1;i<=upvotes;i++){
            VotosPos.add(1);
        }
         for(int i =1;i<=downvotes;i++){
            VotosNeg.add(1);
        }
    return VotosPos.size()-VotosNeg.size();
    }


    

    
        
    
}
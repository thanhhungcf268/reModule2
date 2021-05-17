import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionUtilsAdapter{
    Client collectionOperations;
    public CollectionUtilsAdapter(Client collectionOperations){
        this.collectionOperations = collectionOperations;
    }
    public int findMax(List<Integer> numbers) {
        Set<Integer> s = new HashSet<>();
        s.addAll(numbers);
        collectionOperations.printMaxValue(s);
        return 2;
    }
}

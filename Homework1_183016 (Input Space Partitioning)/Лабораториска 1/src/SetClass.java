import java.util.HashSet;
import java.util.Set;

public class SetClass<E> {
    public Set<E> setDifference(Set<E> set1, Set<E> set2){
        if(set1==null || set2==null)
            throw new NullPointerException();
        Set<E> result=new HashSet<>(set1);
        result.removeAll(set2);
        if(result.size()>0)
            return result;
        return null;
    }

    public static void main(String[] args) {
        SetClass<Integer> setClass=new SetClass<>();
        Set<Integer> set1=new HashSet<>();
        set1.add(2);
        set1.add(6);
        set1.add(4);
        set1.add(1);
        set1.add(11);
        Set<Integer> set2=new HashSet<>();
        set2.add(4);
        set2.add(2);
        set2.add(6);

        Set<Integer> result =setClass.setDifference(set1,set2);
        if(result!=null)
         System.out.println(result.size());
        else
            System.out.println("null");

    }
}

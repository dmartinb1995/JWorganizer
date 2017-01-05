import java.util.LinkedList;
import java.util.Collections;

public class PublisherPairer {

    LinkedList<Publisher> men;
    LinkedList<Publisher> women;
    LinkedList<Publisher> men_ua;
    LinkedList<Publisher> women_ua;
    LinkedList<PublisherPair> pairedList;
    LinkedList<Publisher> preList;
    static boolean MAN = true;
    static boolean WA = true;
    static boolean WOMAN = false;
    static boolean UA = false;

    public PublisherPairer(LinkedList<Publisher> pL){
        men = new LinkedList<Publisher>();
        women = new LinkedList<Publisher>();
        men_ua = new LinkedList<Publisher>();
        women_ua = new LinkedList<Publisher>();
        pairedList = new LinkedList<PublisherPair>();
        preList = new LinkedList<Publisher>();
        this.preList = pL;
        separator();
    }

    public void separator(){
        while (preList.size() != 0){
            // get element from list
            Publisher tmp = preList.remove();
            if(tmp.sex && tmp.independant){
                // working age man
                men.add(tmp);
            } else if(!tmp.sex && tmp.independant){
                // working age woman
                women.add(tmp);
            } else if(tmp.sex && !tmp.independant){
                // underage man
                men_ua.add(tmp);
            } else {
                women_ua.add(tmp);
            }
        }
        Collections.shuffle(men);
        Collections.shuffle(women);
        Collections.shuffle(men_ua);
        Collections.shuffle(women_ua);
    }

    public void pairFemale(){
        if(women_ua.size() <= women.size()){
            pairHelper(women_ua, women, WOMAN);
        } else {
            pairHelper(women, women_ua, WOMAN);
        }
    }
    public void pairMale(){
        if(men_ua.size() <= men.size()){
            pairHelper(men_ua, men, MAN);
        } else {
            pairHelper(men, men_ua, MAN);
        }
    }
    public void pairHelper(LinkedList<Publisher> v1, LinkedList<Publisher> v2, boolean sx){
        while (v1.size() != 0) {
            pairedList.add(new PublisherPair(v1.remove(), v2.remove()));
        }
        LinkedList<Publisher> tmp;
        if (sx) {tmp = men;} else {tmp = women;}
        if (tmp.size() >= 2){
            Publisher t1, t2;
            while (tmp.size() != 0){
                t1 = tmp.remove();
                t2 = tmp.remove();
                pairedList.add(new PublisherPair(t1, t2));
            }
        }
    }
    public static void hel(LinkedList<Publisher> tmp){
      tmp.remove();
      tmp.remove();
    }
    public static void main(String[] args){
        LinkedList<Publisher> test = new LinkedList<Publisher>();
        test.add(new Publisher("Rene", "Rodriguez", MAN, WA ));
        test.add(new Publisher("Melissa", "Rodriguez", WOMAN, UA));
        test.add(new Publisher("Bryan", "Rodriguez", MAN, UA));
        test.add(new Publisher("Susana", "Rodriguez", WOMAN, WA));
        test.add(new Publisher("David", "Zazueta", MAN, WA));
        test.add(new Publisher("David", "Zazueta Jr", MAN, UA));
        test.add(new Publisher("Rut", "Zazueta", WOMAN, WA));

    }
    // Given a list of Publisher, separate into
    // four lists

}

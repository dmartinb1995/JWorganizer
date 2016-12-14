import java.util.LinkedList;
import java.util.Collections;

public class PublisherPairer {

    LinkedList<Publisher> men;
    LinkedList<Publisher> women;
    LinkedList<Publisher> men_ua;
    LinkedList<Publisher> women_ua;
    LinkedList<PublisherPair> pairedList;
    LinkedList<Publisher> preList;

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
    public static void main(String[] args){
        LinkedList<Publisher> test = new LinkedList<Publisher>();
        test.add(new Publisher("Rene", "Rodriguez", true, true ));
    }
    // Given a list of Publisher, separate into
    // four lists

}

public class PublisherPair {
    Publisher p1;
    Publisher p2;
    public PublisherPair (Publisher p1, Publisher p2){
        this.p1 = p1;
        this.p2 = p2;
    }

    public String toString(){
        return "::: " + p1.toName() + " <==> " + p2.toName() + " :::\n";
    }

}

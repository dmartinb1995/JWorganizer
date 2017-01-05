

public class Publisher {

    String firstName;
    String lastName;
    Boolean sex;
    Boolean independant;

    public Publisher (String firstName, String lastName,
                      Boolean sex, Boolean independant) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.sex = sex;
        this.independant = independant;
    }
    public String toString(){
        String ms;
        if (sex) {ms = "male";} else {ms = "female";}
        return "::: " + firstName + " " + lastName + " ::: Sex -> " + ms + " ::: OverAge => " + independant + "\n";
    }
    public String toName(){
        return firstName + " " + lastName;
    }


}

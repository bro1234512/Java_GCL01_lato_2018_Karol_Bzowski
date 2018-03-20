package User;

public class User {


    private long id;
    private String name;
    private long numberOfStars;
    private long numberOfSentMessages;

    public String getName() {
        return name;
    }

    public long getNumberOfStars() {
        return numberOfStars;
    }

    public long getNumberOfSentMessages() {
        return numberOfSentMessages;
    }
    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberOfStars(int i) {
        if(i == 1){
            this.numberOfStars++;
        }
        else{
            if(this.numberOfStars == 0){
                System.out.println("0 gwiazdek");
            }
            else{
                this.numberOfStars--;
            }
        }
    }

    public void setNumberOfSentMessages(long numberOfSentMessages) {
        this.numberOfSentMessages = numberOfSentMessages;
    }

    public void setId(long id) {
        this.id = id;
    }
    public User(String name){

        this.numberOfStars = 0;
        this.numberOfSentMessages = 0;
        this.name = name;

    }
}

/*
a. long id
        b. String name
        c. long numberOfStars – dodatnie lub ujemne punkty wystawione przez użytkowników
        d. long numberOfSentMessages – ilość wysłanych przez użytkownika wiadomości

        */
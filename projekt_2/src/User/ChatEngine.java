package User;

import Exceptions.*;


import java.util.LinkedHashMap;
import java.util.Map;

public class ChatEngine {
    Map<Long, User> mapaUserow = new LinkedHashMap<>();
    public static int counter = 0;

    public void loginUser(User user) throws UserLoginException {
        if (mapaUserow.containsValue(user.getName())) {
            throw new UserLoginException();
        }
        else{
            mapaUserow.put(user.getId(),user);
            counter++;
            user.setId(counter);
        }

    }
    void logoutUser(long userId) throws UserRemoveException{

        if(mapaUserow.remove(userId)==null){
            throw new UserRemoveException();
        }
        else{
            counter--;
        }

    }
    int getNumberOfUsers(){
        return mapaUserow.size();
    }
    void addUserStar(String userName){
        for (Map.Entry<Long, User> entry : mapaUserow.entrySet()){
            if(entry.getValue().getName().equals(userName)){
                entry.getValue().setNumberOfStars(1);
            }
        }
    }
    void removeUserStar(String userName){
        for (Map.Entry<Long, User> entry : mapaUserow.entrySet()){
            if(entry.getValue().getName().equals(userName)){
                entry.getValue().setNumberOfStars(0);

            }
        }
    }
    boolean hasUser(long userId){
       return mapaUserow.containsKey(userId);
    }
    boolean hasUser(String userName){
        for (Map.Entry<Long, User> entry : mapaUserow.entrySet()){
            if(entry.getValue().getName().equals(userName)){
                return true;
            }
        }
        return false;
    }


}

/*
Zestaw zadań v2 - chat
1. Stwórz główną klasę wyjątku ChatException dla całego chat’u – po niej dziedziczyć będą pozostałe wyjątki.
2. Stwórz klasę User z polami:
a. long id
b. String name
c. long numberOfStars – dodatnie lub ujemne punkty wystawione przez użytkowników
d. long numberOfSentMessages – ilość wysłanych przez użytkownika wiadomości
// oraz getter’ami i setter’ami.
3. Zaimplementuj klasę ChatEngine, która posiadać będzie:
a. użytkowników przechowywanych tylko i wyłącznie na obiekcie/obiektach typu Map<K,V>.
b. następujące metody publiczne:
• void loginUser(User user) throws UserLoginException – jeśli użytkownik o podanej nazwie już
istnieje to powinna rzucić wyjątek; powinna nadawać identyfikatory użytkownikom; powinna
przypisywać użytkownikom czasy utworzenia.
• void logoutUser(long userId) throws UserRemoveException – jeśli wylogowywanie się nie
powiedzie to powinna rzucić wyjątek
• int getNumberOfUsers() – zwracającą ilość zalogowanych użytkowników,
• void addUserStar(String userName) – dodająca gwiazdkę konkretnemu użytkownikowi.
• void removeUserStar(String userName) – usuwająca gwiazdkę konkretnemu użytkownikowi
• boolean hasUser(long userId) – sprawdzającą bez iterowania po użytkownikach czy użytkownik
już istnieje
• boolean hasUser(String userName) – sprawdzającą bez iterowania po użytkownikach czy
użytkownik już istnieje
// ocena 3.0
• boolean broadcastMessage(long userId, String message) – która wypisze w konsoli informacje o
wysłaniu wiadomości do wszystkich użytkowników wyświetlając ich id i nazwę w kolejności
dodania.
// ocena 3.5
• void printStatistics() – wypisującą minimalną, średnią i maksymalną ilość wysłanych wiadomości
(wykorzystaj tutaj Collections), listę użytkowników wraz z zdobytymi gwiazdami/punktami.
// ocena 4.0
• List<User> listUsers( Criteria criteria ) – listującą rosnąco i malejąco po identyfikatorze, nazwie
użytkownika, ilości zdobytych gwiazdek i ilości wysłanych wiadomości; typ Criteria będzie
enum’em.
// ocena 4.5
4. Wewnątrz funkcji void main() utwórz obiekt typu ChatEngine i przeprowadź testowanie dla wszystkich
dodanych funkcjonalności pamiętając o obsłudze wyjątków.
// ocena 5.0
Pamiętamy o przeładowaniu hashCode(), equals(…), itp. */
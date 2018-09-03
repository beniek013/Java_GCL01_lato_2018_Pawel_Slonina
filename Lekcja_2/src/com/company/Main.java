package com.company;
import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.util.*;

public class Main {
    public static Map<Long, User> zalogowani = new HashMap<Long, User>();
    public static void main(String[] args) {
        User us_1 = new User();
        us_1.name = "Paweł Słonina";
        User us_2 = new User();
        us_2.name = "Test user";
        User us_3 = new User();
        us_3.name = "Test user22";
        User us_4 = new User();
        us_4.name = "user22";
        loginUser(us_1);
        loginUser(us_2);
        loginUser(us_3);
        loginUser(us_4);
        System.out.println(getNumberOfUsers());
        loginUser(us_1);
        logoutUser(us_1.id);
        System.out.println(getNumberOfUsers());
        logoutUser(us_1.id);

        loginUser(us_1);
        addUserStar("Paweł Słonina");
        removeUserStar("Paweł Słonina");
        addUserStar("Paweł Słonina");
        System.out.println(us_1.numberofStars);
        if(hasUser(us_1.id))
            System.out.println("jest");
        if(hasUser("Paweł Słonina"))
            System.out.println("jestjest");
        System.out.println(getNumberOfUsers());
        broadcastMessage(us_1.id, "Wiadomosc testowa");
        broadcastMessage(us_1.id, "Wiadomosc testowa2");
        printStatistics();
    }
    public static void loginUser(User user){
        try{
            if(!zalogowani.values().contains(user)) {
                user.id = zalogowani.size() + 1;
                zalogowani.put(user.id, user);
                System.out.println("pomyślnie zalogowano");
            }
            else
                throw new Exception("user juz zalogowany");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public static void logoutUser(Long userId){
        try{
            if(zalogowani.keySet().contains(userId)) {
                zalogowani.remove(userId);
                System.out.println("Pomyślnie wylogowano");
            }
            else
                throw new Exception("Wylogowanie nie powiodło się");
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    public static int getNumberOfUsers(){
        return zalogowani.size();
    }
    public static void addUserStar(String userName){
        for(User osoba : zalogowani.values()){
            if(osoba.name == userName) {
                osoba.numberofStars += 1;
            }
        }
    }
    public static void removeUserStar(String userName){
        for(User osoba : zalogowani.values()){
            if(osoba.name == userName) {
                osoba.numberofStars -= 1;
            }
        }
    }
    public static boolean hasUser(long userId){
        if(zalogowani.containsKey(userId))
            return true;
        else
            return false;
    }
    public static boolean hasUser(String userName){
        boolean wyn = false;
        for(User osoba : zalogowani.values()){
            if(osoba.name == userName) {
                wyn = true;
            }
        }
        return wyn;
    }
    public static boolean broadcastMessage(long userId, String message){
        User wysylajacy = zalogowani.get(userId);
        for(User osoba : zalogowani.values()){
            if(osoba.name != wysylajacy.name) {
                System.out.println("Hej, " + osoba.name + ": " + message);
            }
        }
        wysylajacy.numberofSendMessage += 1;
        return  false;
    }
    public static void printStatistics(){
        long minsend = -1, srsend =0, maxsend =0;
        long sum = 0;
        for(User osoba : zalogowani.values()){
                if(osoba.numberofSendMessage > maxsend)
                    maxsend = osoba.numberofSendMessage;
                if(minsend == -1)
                    minsend = osoba.numberofSendMessage;
                sum += osoba.numberofSendMessage;

                System.out.println("Osoba: " + osoba.name + ", wiadomosci:" + osoba.numberofSendMessage + ", gwiazdki:" + osoba.numberofStars);
            }
            srsend = sum / zalogowani.size();
        System.out.println("MIN: " + minsend);
        System.out.println("AVG: " + srsend);
        System.out.println("MAX: " + maxsend);
        }
}
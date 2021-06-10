package com.company;
import java.util.ArrayList;
import java.util.List;

public class Main {

public static void main(String[] args) {
        InternetPublic ip = new InternetPublic();
        Dashboard db = new Dashboard(ip);

        ip.changeData(1000, 2000, 3000);
        ip.changeData(1500, 3100, 4200);
        ip.changeData(1900, 3500, 4500);
    }
}
interface Notifier{
    public void addObserver(Observer obs);
    public void removeObserver(Observer obs);
    public void notifyObserver();
}
class InternetPublic implements Notifier{
    private List observers;
    private int Followers1;
    private int Followers2;
    private int Followers3;

public InternetPublic(){
        observers = new ArrayList();
    }

public void addObserver(Observer obs){
        observers.add(obs);
    }

public void removeObserver(Observer obs){
        int i = observers.indexOf(obs);
        if (i >= 0){
            observers.remove(i);
        }
    }

public void notifyObserver(){
        for (int i = 0; i < observers.size(); i++){
            Observer obs = (Observer) observers.get(i);
            obs.update(Followers1 , Followers2 , Followers3);
        }
    }

public void changeData( int Followers1 , int Followers2 , int Followers3){
        this.Followers1 = Followers1;
        this.Followers2 = Followers2;
        this.Followers3 = Followers3;
        notifyObserver();
    }

}
interface Observer{
    public void update(int Followers1 , int Followers2 , int Followers3 );
}

class Dashboard implements Observer {
    private Notifier notifier;
    private int Followers1;
    private int Followers2;
    private int Followers3;

public Dashboard(Notifier notifier) {
        this.notifier = notifier;
        notifier.addObserver(this);
    }

public void update(int Followers1, int Followers2, int Followers3) {
        this.Followers1 = Followers1;
        this.Followers2 = Followers2;
        this.Followers3 = Followers3;
        show();
    }

    public void show() {
        System.out.println("Followers of public One: " + Followers1 + ", Followers of public Two: " + Followers2 + ", Followers of public Three: " + Followers3);

    }
}

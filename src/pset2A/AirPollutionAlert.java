package pset2A;

import java.util.ArrayList;
import java.util.List;

interface Subject{
    void register(Observer o);
    void unregister(Observer o);
    void notifyObservers();
}
//-------------------------------------------------------

//TODO: modify AirPollutionAlert to implement interface Subject, under Observer design pattern
class AirPollutionAlert implements Subject{
    private double airPollutionIndex;
    private static List<Observer> subjects = new ArrayList<>();

    public void setAirPollutionIndex(double airPollutionIndex) {
        this.airPollutionIndex = airPollutionIndex;
        if (airPollutionIndex > 100) {
            notifyObservers();
        }
    }

    @Override
    public void register(Observer o) {
        subjects.add(o);
    }

    @Override
    public void unregister(Observer o) {
        int a = subjects.indexOf(o);
        subjects.remove(a);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : subjects){
            o.update(airPollutionIndex);
        }
    }
}

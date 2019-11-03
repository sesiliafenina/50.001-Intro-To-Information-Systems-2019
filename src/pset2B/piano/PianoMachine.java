package pset2B.piano;

import javax.sound.midi.MidiUnavailableException;

import pset2B.midi.Instrument;
import pset2B.midi.Midi;
import pset2B.music.NoteEvent;
import pset2B.music.Pitch;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PianoMachine {
	
	private Midi midi;
    private Set<Integer> pitch = new HashSet<>();
    private int tr = 0;
    private static int record = 0;
    private List<NoteEvent> nel = new ArrayList<>();


    /**
	 * constructor for PianoMachine.
	 * 
	 * initialize midi device and any other state that we're storing.
	 */
    public PianoMachine() {
    	try {
            midi = Midi.getInstance();
        } catch (MidiUnavailableException e1) {
            System.err.println("Could not initialize midi device");
            e1.printStackTrace();
            return;
        }
    }
    
    //TODO write method spec
    public void beginNote(Pitch rawPitch) {
        rawPitch = rawPitch.transpose(tr);
        if (pitch.add(rawPitch.toMidiFrequency())){
            pitch.add(rawPitch.toMidiFrequency());
            midi.beginNote(rawPitch.toMidiFrequency());
        }
        if (record == 1){
            long time = (new Date()).getTime();
            NoteEvent ne = new NoteEvent(rawPitch, time, Midi.DEFAULT_INSTRUMENT, NoteEvent.Kind.start);
            nel.add(ne);
        }
    }
    
    //TODO write method spec
    public void endNote(Pitch rawPitch) {
        rawPitch = rawPitch.transpose(tr);
        if (pitch.remove(rawPitch.toMidiFrequency())){
            pitch.remove(rawPitch.toMidiFrequency());
            midi.endNote(rawPitch.toMidiFrequency());
        }
        if (record == 1){
            long time = (new Date()).getTime();
            NoteEvent ne = new NoteEvent(rawPitch, time, Midi.DEFAULT_INSTRUMENT, NoteEvent.Kind.stop);
            nel.add(ne);
        }
    }
    
    //TODO write method spec
    public void changeInstrument() {
       	//TODO: implement for question 2
        Midi.DEFAULT_INSTRUMENT = Midi.DEFAULT_INSTRUMENT.next();
    }
    
    //TODO write method spec
    public void shiftUp() {
    	//TODO: implement for question 3
        if (tr <= 12) {
            tr += 12;
        }
    }
    
    //TODO write method spec
    public void shiftDown() {
    	//TODO: implement for question 3
        if (tr >= -12) {
            tr -= 12;
        }
    }
    
    //TODO write method spec
    public boolean toggleRecording() {
    	//TODO: implement for question 4
        if (record == 0){
            record = 1;
        }
        else if (record == 1){
            record = 0;
        }
        return true;
    }
    
    //TODO write method spec
    public void playback() {
        List<Integer> restTime = new ArrayList<>();
        int counter = 1;
        long startTime = nel.get(counter).getTime();
        for (NoteEvent e : nel){
            if (counter <= nel.size()) {
                //System.out.println(e.getPitch().toMidiFrequency());
                //System.out.println(startTime - e.getTime());
                restTime.add((int)Math.round((startTime - e.getTime())/10.0));
                counter += 1;
                if (counter < nel.size()) {
                    startTime = nel.get(counter).getTime();
                }
            }
        }
        System.out.println(restTime);
        int newcounter = 0;
        for (NoteEvent e : nel) {
            if (e.getKind() == NoteEvent.Kind.start) {
                midi.beginNote(e.getPitch().toMidiFrequency(), e.getInstr());
            }
            else if (e.getKind() == NoteEvent.Kind.stop) {
                midi.endNote(e.getPitch().toMidiFrequency(), e.getInstr());
            }
            if (newcounter < restTime.size() - 1){
                Midi.rest(restTime.get(newcounter));
                newcounter++;
            }
        }
        nel = new ArrayList<>();
    }
}

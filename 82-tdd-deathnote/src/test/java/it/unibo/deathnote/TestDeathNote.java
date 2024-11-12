package it.unibo.deathnote;

import it.unibo.deathnote.api.DeathNote;
import it.unibo.deathnote.impl.DeathNoteImplementation;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class TestDeathNote {
    static final DeathNoteImplementation deathNote= new DeathNoteImplementation();
    public static void main(String... args){
        try{

        
            
            

            //print rules
           

            deathNote.writeName("a");
            deathNote.writeDeathCause("a");
            deathNote.writeDetails("a");

            String deathCause = deathNote.getDeathCause("A");
            String deathDetails = deathNote.getDeathDetails("A");
            boolean isWritten = deathNote.isNameWritten("a");
        }
        catch(Exception e){
            System.err.println(e.getMessage());
        }
    }

    @Test
    public void TestGetRules(){
        try{
            int index = 1;
            deathNote.getRule(index);
        }catch(Exception e){
            assertInstanceOf(IllegalArgumentException.class, e.getMessage());
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isEmpty());
            assertFalse(e.getMessage().isBlank());
        }

    }

    @Test
    public void TestHumanInDeathNote(){
        String name= "mario rossi";
        assertTrue(deathNote.isNameWritten(name));
        deathNote.writeName(name);
        assertFalse(deathNote.isNameWritten(name));
        assertTrue(deathNote.isNameWritten("luigi bianchi"));
        assertTrue(deathNote.isNameWritten(""));
    }

    @Test
    public void TestDeath(){
        
    }
}

package it.unibo.deathnote;

import it.unibo.deathnote.impl.DeathNoteImplementation;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDeathNote {
    static final DeathNoteImplementation deathNote= new DeathNoteImplementation();
    long millis;

    //test punto 1-2
    @SuppressWarnings("")
    @Test
    public void TestGetRules(){
        try{

            for(int i=0;i<deathNote.getRules().size();i++){   
                assertNotNull(deathNote.getRule(i));
                assertFalse(deathNote.getRule(i).isEmpty());
                assertFalse(deathNote.getRule(i).isBlank());
            }
        }catch(Exception e){
            assertInstanceOf(IllegalArgumentException.class, e.getMessage());
            
        }

    }

    //test punto 3
    @Test
    public void TestHumanInDeathNote(){
        
        String name= "mario rossi";
        assertTrue(deathNote.isNameWritten(name));
        deathNote.writeName(name);
        assertTrue(deathNote.isNameWritten(name));
        assertFalse(deathNote.isNameWritten("luigi bianchi"));
        assertFalse(deathNote.isNameWritten(""));
        millis = System.currentTimeMillis();
        
    }

    //test punto 4
    @Test
    public void TestDeath() throws InterruptedException{
        assertTrue(System.currentTimeMillis()-millis <= 40);
        assertFalse(deathNote.writeDeathCause("cause"));
        deathNote.writeName("francesco neri");
        assertTrue(deathNote.isNameWritten("francesco neri"));
        assertSame(deathNote.getDeathCause("francesco neri"),"heart attack");
        String name2="enrico rossi";
        String deathCauseName2="karting accident";
        String newDeathCause="new death cause";
        deathNote.writeName(name2);
        assertTrue(deathNote.isNameWritten(name2));
        assertTrue(deathNote.writeDeathCause(deathCauseName2));
        Thread.sleep(100);
        assertTrue(deathNote.changeDeathCause(name2,newDeathCause));
        assertFalse(deathNote.getDeathCause(name2).equals(newDeathCause));
    }

    //test punto 5
    @SuppressWarnings({"", "UseSpecificCatch"})
    @Test
    public void TestDeathWithDeathDetails(){
        try {
            assertTrue(deathNote.writeDetails("details"));
            assertTrue(deathNote.writeDetails("details before the name"));
            String name="alessio rossi";
            deathNote.writeName(name);
            assertTrue(deathNote.getDeathDetails(name).isEmpty());
            deathNote.writeDeathCause("heart attack");
            assertTrue(deathNote.writeDetails("ran for too long"));
            assertEquals(deathNote.getDeathDetails(name),"ran for too long");
            String name2 = "davide bianchi";
            String newDeathDetails="new details";
            deathNote.writeName(name2);
            Thread.sleep(6100);
            assertTrue(deathNote.changeDeathDetails(name2, newDeathDetails));
            assertFalse(deathNote.getDeathCause(name).equals(newDeathDetails));
        } catch (Exception e) {
            assertInstanceOf(RuntimeException.class,e.getMessage());
            assertInstanceOf(IllegalStateException.class,e.getMessage());
        }
        
    }
}

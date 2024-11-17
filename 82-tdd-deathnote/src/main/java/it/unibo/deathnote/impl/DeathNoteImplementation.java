package it.unibo.deathnote.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.unibo.deathnote.api.DeathNote;

public final class DeathNoteImplementation implements DeathNote{
    // protected final List<String> names;
    // protected final List<String> causes;
    protected final Map<String,Death> book;


    public DeathNoteImplementation(){
        book=new HashMap<>();
        // names=new ArrayList<>();
        // causes =new ArrayList<>();
    }

    public Collection<String> getKeySet(){
        return book.keySet();
    }

    @Override
    public String getRule(int ruleNumber) {
        // TODO Auto-generated method stub
        if(ruleNumber <= 0 || ruleNumber > RULES.size())
            throw new IllegalArgumentException("error");
        else
            return RULES.get(ruleNumber);
    }

    @Override
    public void writeName(String name) {
        // TODO Auto-generated method stub
        if(name.isEmpty() || name.isBlank()){
            
            throw new NullPointerException("error");
        }

        book.put(name,null);

    }

    @Override
    public boolean writeDeathCause(String cause) {
        // TODO Auto-generated method stub
        if(book.values().size()>=book.keySet().size()){
            throw new IllegalStateException("error");
        }
        
        for(String s : book.keySet()){
            if(book.get(s)==null){
                    
                book.put(s,new Death(cause));
            }
        }
        return true;
    }

    @Override
    public boolean writeDetails(String details) {
        // TODO Auto-generated method stub
        if(details.isEmpty() || details.isBlank()){
            
            throw new IllegalStateException("error");
        }

        for(Death s : book.values()){
            if(s.getDetails()==null){
                    
                s.setDetails(details);
                return true;
            }
        }

        return false;
    }

    @Override
    public String getDeathCause(String name) {
        // TODO Auto-generated method stub
        if(name.isEmpty() || name.isBlank()){
            
            throw new IllegalArgumentException("error");
        }
        return book.get(name).getDeathCause();
    }

    @Override
    public String getDeathDetails(String name) {

        if(name.isEmpty() || name.isBlank()){
            
            throw new IllegalArgumentException("error");
        }
        return book.get(name).getDetails();
    }

    @Override
    public boolean isNameWritten(String name) {
        // TODO Auto-generated method stub
        if(name.isEmpty() || name.isBlank()){
            throw new UnsupportedOperationException("error");
        }
        
        for(String s : book.keySet()){
            if(s.equals(name)){
                return true;
            }
        }

        return false;
    }
    
    public boolean changeDeathCause(String name, String s2){
        for(String n : book.keySet()){
            if(n.equals(name)){
                Death d = book.get(n);
                d.setDeathCause(s2);
                return true;
            }
        }

        return false;
    }
    
    public boolean changeDeathDetails(String name, String s2){
        for(String n : book.keySet()){
            if(n.equals(name)){
                Death d = book.get(n);
                d.setDetails(s2);
                return true;
            }
        }

        return false;
    }

    public List<String> getRules(){
        return RULES;
    }
    private static class Death{
        private String deathCause;
        private String details;
        private long time;

        @SuppressWarnings("unused")
        private Death(){
            deathCause = "undefined";
            time =System.currentTimeMillis();
        }

        private Death(String cause){
            deathCause = cause;
            time =System.currentTimeMillis();
        }

        @SuppressWarnings("unused")
        private Death(String cause, String details){
            this(cause);
            this.details=details;
        }

        private void setDetails(String details){
            if((System.currentTimeMillis() - time) <= 6040){
                this.details=details;
            }
            else{
                throw new RuntimeException("too late");
            }
        }

        private void setDeathCause(String cause){
            this.deathCause=cause;
            time =System.currentTimeMillis();
        }

        private String getDeathCause(){
            return deathCause;
        }

        private String getDetails(){
            return details;
        }


    }
}
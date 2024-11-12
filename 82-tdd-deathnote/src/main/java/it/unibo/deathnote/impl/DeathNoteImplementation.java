package it.unibo.deathnote.impl;

import java.util.*;

import it.unibo.deathnote.api.DeathNote;

public class DeathNoteImplementation implements DeathNote{
    protected final List<String> names;


    public DeathNoteImplementation(){
        names=new ArrayList<>();
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
        throw new NullPointerException("error");
    }

    @Override
    public boolean writeDeathCause(String cause) {
        // TODO Auto-generated method stub
        throw new IllegalStateException("error");
    }

    @Override
    public boolean writeDetails(String details) {
        // TODO Auto-generated method stub
        throw new IllegalStateException("error");
    }

    @Override
    public String getDeathCause(String name) {
        // TODO Auto-generated method stub
        throw new IllegalArgumentException("error");
    }

    @Override
    public String getDeathDetails(String name) {
        // TODO Auto-generated method stub
        throw new IllegalArgumentException("error");
    }

    @Override
    public boolean isNameWritten(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("error");
    }
    

    
}

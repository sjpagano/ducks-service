package iu.edu.sjpagano.ducksservice.model;

public enum DuckType {
    MALLARD,REDHEAD,RUBBER_DUCK,DECOY_DUCK,ANY;

    public String toString() {
        switch(this) {
            case MALLARD: return "Mallard";
            case REDHEAD: return "Redhead";
            case RUBBER_DUCK: return "Rubber Duck";
            case DECOY_DUCK: return "Decoy Duck";
            default: return "Unspecified";
        }
    }
}

package io.pivotal.pal.tracker;

public class IdGenerator {

    private static long idGenerator = 1L;


    public static synchronized long getGeneratedId(){
        return idGenerator++;
    }

    public static synchronized void reset(){
        idGenerator=1L;
    }
}

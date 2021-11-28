package commandHandler.utils;

import DOM.Ticket;

import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

/**
 * Manages the collection
 * **/
public class CollectionManager {
    private Map<Integer, Ticket> collection = new TreeMap<>();
    private Date creationDate = new Date();

    public CollectionManager(Map<Integer, Ticket> collection){
        this.collection = collection;
    }
    public int getSize(){
        return this.collection.size();
    }
    public Class getCollectionClass(){
        return this.collection.getClass();
    }
    public Date getCreationDate(){
        return this.creationDate;
    }
    /**
     * Create new entry in collection with id generated automatically
     * @see Ticket
     * **/
    public void create(Ticket ticket){
        this.collection.put(ticket.getId(), ticket);
    }
    /**
     * Create new entry in collection with specified id
     * @see Ticket
     * **/
    public void create(Integer key, Ticket ticket){
        this.collection.put(key, ticket);
    }
    /**
     * Get the ticket by its id
     * @see Ticket
     * **/
    public Ticket read(Integer key){
        return this.collection.get(key);
    }
    /**
     * Get all tickets
     * **/
    public Ticket[] readAll(){
        return this.collection.values().toArray(new Ticket[this.collection.values().size()]);
    }
    /**
     * Update information about ticket by its key
     * **/
    public void update(Integer key, Ticket ticket){
        this.collection.replace(key, ticket);
    }
    /**
     * Delete ticket by its key
     * **/
    public void delete(Integer key){
        this.collection.remove(key);
    }
    /**
     * Clear the collection
     * **/
    public void deleteAll(){
        this.collection.clear();
    }
    /**
     * @returns true is collection contains such key
     * **/
    public boolean contains(Integer key){
        return this.collection.containsKey(key);
    }
    /**
     * @returns iterator of collection
     * **/
    public Iterator getIterator(){
        return this.collection.entrySet().iterator();
    }
    /**
     * @returns stream of collection
     * **/
    public Stream<Ticket> getStream(){
        return this.collection.values().stream();
    }
}

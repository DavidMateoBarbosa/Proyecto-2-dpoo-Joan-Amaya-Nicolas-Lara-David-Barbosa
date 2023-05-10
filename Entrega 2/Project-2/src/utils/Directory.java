package utils;

import core.*;

import java.io.*;
import java.util.*;

public final class Directory extends Utils {
    public Directory(String path){
        //Accounts
        _administrators = new HashMap<>();
        _receptionists = new HashMap<>();
        _employees = new HashMap<>();
        loadAccounts(path);
        //Services
        _hotel = new Hotel();
        _groups = new HashMap<>();
    }
    //Accounts
    public final HashMap<String, String> _administrators;
    public final HashMap<String, String> _receptionists;
    public final HashMap<String, String> _employees;
    private void loadAccounts(String path) {
        BufferedReader reader = read(path);
        assert reader != null;
        for (Iterator<String> lines = reader.lines().iterator(); lines.hasNext();){
            String[] line = lines.next().split(",");
            switch (line[2]){
                case "admin" -> _administrators.put(line[0], line[1]);
                case "receptionist" -> _receptionists.put(line[0], line[1]);
                case "employee" -> _employees.put(line[0], line[1]);
            }
        }
        try{ reader.close(); } catch (IOException error) { error.printStackTrace(); }
    }
    public boolean isAdministrator(String user, String passwd){
        return Objects.equals(_administrators.getOrDefault(user, null), passwd);
    }
    public boolean isReceptionist(String user, String passwd){
        return Objects.equals(_receptionists.getOrDefault(user, null), passwd);
    }
    public boolean isEmployee(String user, String passwd){
        return Objects.equals(_employees.getOrDefault(user, null), passwd);
    }

    //Services
    private final Restaurant _restaurant=new Restaurant(new TimeRange("10:00:00-14:00:00"));
    private Spa _spa;
    private TourGuide _tourGuide;
    private final Hotel _hotel;
    private final HashMap<Long, Group> _groups;
    public Restaurant restaurant(){
        return _restaurant;
    }
    public Spa spa(){
        return _spa;
    }
    public TourGuide tourGuide(){
        return _tourGuide;
    }
    public Hotel hotel() {
        return _hotel;
    }
    public HashMap<Long, Group> groups(){
        return _groups;
    }
    public void addGroup(Group group){
        _groups.put(group.id(), group);
    }
    public void spa(Spa spa){
        _spa = spa;
    }
    public void tourGuide(TourGuide tourGuide){
        _tourGuide = tourGuide;
    }
}

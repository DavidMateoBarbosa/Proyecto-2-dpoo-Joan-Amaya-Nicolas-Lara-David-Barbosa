package core;

import utils.TimeRange;
import utils.Utils;

import java.io.*;
import java.util.*;

public class Restaurant {
    private final HashMap<String, Drink> _drinks;
    private final HashMap<String, Plate> _plates;
    private final TimeRange _range;
    public Restaurant(TimeRange range){
        _drinks = new HashMap<>();
        _plates = new HashMap<>();
        _range = range;
    }
    public void loadDrinks(File drinksFile) throws IOException {
        BufferedReader reader = Utils.read(drinksFile);
        assert reader != null;
        for (String row: reader.lines().toList()) {
            String[] line = row.split(";");
            _drinks.put(line[0], new Drink(line[0], Double.parseDouble(line[1]), new ArrayList<>(List.of(line[2].split(","))), new TimeRange(line[3], line[4])));
        }
        reader.close();
    }
    public void loadPlates(File platesFile) throws IOException {
        BufferedReader reader = Utils.read(platesFile);
        assert reader != null;
        for (String row: reader.lines().toList()) {
            String[] line = row.split(";");
            _plates.put(line[0], new Plate(line[0], Double.parseDouble(line[1]), new ArrayList<>(List.of(line[2].split(","))), new TimeRange(line[3], line[4])));
        }
        reader.close();
    }
    public void addPlates(String name, double Price, ArrayList<String> lugares, TimeRange rango )
    {
    	Plate dish= new Plate(name,Price,lugares,rango);
    	_plates.put(name, dish);
    	
    }
    public void addDrinks(String name, double Price, ArrayList<String> lugares, TimeRange rango )
    {
    	Drink drink= new Drink(name,Price,lugares,rango);
    	_drinks.put(name, drink);
    	
    }
    public boolean canSellDrinks(String name){
        return _range.rangeInRange(_drinks.get(name).timeRange());
    }
    public boolean canSellPlates(String name){
        return _range.rangeInRange(_plates.get(name).timeRange());
    }
    public HashMap<String, Drink> drinks(){
        return _drinks;
    }
    public HashMap<String, Plate> plates(){
        return _plates;
    }
    public TimeRange timeRange(){
        return _range;
    }

}

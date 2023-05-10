package core;

import java.util.*;
import java.io.*;

public class Hotel {
    private final HashMap<Long, Room> _rooms;
    public Hotel(){
        _rooms = new HashMap<>();
    }
    public void loadRooms(File rooms) throws IOException{
        BufferedReader reader = new BufferedReader(new FileReader(rooms));
        for (String row: reader.lines().toList()){
            String[] line = row.split(";");
            Room room = new Room(Double.parseDouble(line[0]), Integer.parseInt(line[1]), line[2]);
            _rooms.put(room.id(), room);
        }
        reader.close();
    }
    public HashMap<Long, Room> rooms(){
        return _rooms;
    }


}

package com.luciano.saladereuniao.saladereuniao.controller;

import com.luciano.saladereuniao.saladereuniao.exception.ResourceNotFoundException;
import com.luciano.saladereuniao.saladereuniao.model.Room;
import com.luciano.saladereuniao.saladereuniao.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://locahost:4200")
@RestController
@RequestMapping(value = "/api")
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @GetMapping("/rooms")
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @GetMapping("/rooms/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable(value = "id") long roomId)
        throws ResourceNotFoundException{
            Room room = roomRepository.findById(roomId).orElseThrow(() -> new ResourceNotFoundException(
                    "Room not found: " + roomId));
            return ResponseEntity.ok().body(room);
    }

    @PostMapping("/rooms")
    public Room createRoom (@Valid @RequestBody Room room) {
        return roomRepository.save(room);
    }
}

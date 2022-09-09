package org.sunglowsys.resource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.sunglowsys.domain.RoomType;
import org.sunglowsys.service.RoomTypeService;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RoomTypeResource {
    private final RoomTypeService roomTypeService;

    public RoomTypeResource(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }
    @PostMapping("/room-type")
    public ResponseEntity<RoomType> createRoomType(@RequestBody RoomType roomType) {
        RoomType result = roomTypeService.save(roomType);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @PutMapping("/room-type")
    public ResponseEntity<RoomType> updateRoomType(@RequestBody RoomType roomType) {
        if (roomType.getId() == null) {
            throw new RuntimeException("it not be must null");
        }
        RoomType result = roomTypeService.update(roomType);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @GetMapping("/room-type")
    public ResponseEntity<Page<RoomType>> finalAll(Pageable pageable) {
        Page<RoomType> result = roomTypeService.finalAll(pageable);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/room-type/{id}")
    public ResponseEntity<Optional<RoomType>> findOne(@PathVariable Long id){
        Optional<RoomType> result = roomTypeService.findOne(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/room-type/{id}")
    public ResponseEntity<Void> deleteRoomType(@PathVariable Long id) {
        roomTypeService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

}

package org.sunglowsys.resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(RoomTypeResource.class);
    private final RoomTypeService roomTypeService;

    public RoomTypeResource(RoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }
    @PostMapping("/room-type")
    public ResponseEntity<RoomType> createRoomType(@RequestBody RoomType roomType) {
        logger.debug("REST request to create roomtype :{}",roomType);
        RoomType result = roomTypeService.save(roomType);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @PutMapping("/room-type")
    public ResponseEntity<RoomType> updateRoomType(@RequestBody RoomType roomType) {
        logger.debug("REST request to update roomtype :{}",roomType);
        if (roomType.getId() == null) {
            throw new RuntimeException("it not be must null");
        }
        RoomType result = roomTypeService.update(roomType);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @GetMapping("/room-type")
    public ResponseEntity<Page<RoomType>> findAll(Pageable pageable) {
        logger.debug("REST request to findAll roomtypes :{}",pageable);
        Page<RoomType> result = roomTypeService.findAll(pageable);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/room-type/{id}")
    public ResponseEntity<Optional<RoomType>> findOne(@PathVariable Long id){
        logger.debug("REST request to findOne roomtype :{}",id);
        Optional<RoomType> result = roomTypeService.findOne(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/room-type/{id}")
    public ResponseEntity<Void> deleteRoomType(@PathVariable Long id) {
        logger.debug("REST request to delete roomtype :{}",id);
        roomTypeService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();

    }

}

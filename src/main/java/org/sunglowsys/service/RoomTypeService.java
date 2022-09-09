package org.sunglowsys.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.sunglowsys.domain.RoomType;

import java.util.Optional;

public interface RoomTypeService {
    RoomType save(RoomType roomType);
    RoomType update(RoomType roomType);
    Page<RoomType> finalAll(Pageable pageable);
    Optional<RoomType> findOne(Long id);
    void delete(Long id);
}

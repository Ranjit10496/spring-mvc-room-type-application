package org.sunglowsys.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sunglowsys.domain.RoomType;
import org.sunglowsys.repository.RoomTypeRepository;

import java.util.Optional;

@Service
@Transactional
public class RoomTypeServiceImpl implements RoomTypeService{

    private final RoomTypeRepository roomTypeRepository;

    public RoomTypeServiceImpl(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }

    @Override
    public RoomType save(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    @Override
    public RoomType update(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    @Override
    public Page<RoomType> finalAll(Pageable pageable) {
        return roomTypeRepository.findAll(pageable);
    }

    @Override
    public Optional<RoomType> findOne(Long id) {
        return roomTypeRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        roomTypeRepository.deleteById(id);

    }
}

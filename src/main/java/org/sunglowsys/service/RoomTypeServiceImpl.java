package org.sunglowsys.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger = LoggerFactory.getLogger(RoomTypeServiceImpl.class);
    private final RoomTypeRepository roomTypeRepository;

    public RoomTypeServiceImpl(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }

    @Override
    public RoomType save(RoomType roomType) {
        logger.debug("request to save roomType :{}",roomType);
        return roomTypeRepository.save(roomType);
    }

    @Override
    public RoomType update(RoomType roomType) {
        logger.debug("request to update roomType :{}",roomType);
        return roomTypeRepository.save(roomType);
    }

    @Override
    public Page<RoomType> findAll(Pageable pageable) {
        logger.debug("request to findAll roomTypes :{}",pageable);
        return roomTypeRepository.findAll(pageable);
    }

    @Override
    public Optional<RoomType> findOne(Long id) {
        logger.debug("request to findOne roomType :{}",id);
        return roomTypeRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        logger.debug("request to delete roomType :{}",id);
        roomTypeRepository.deleteById(id);

    }
}

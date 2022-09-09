package org.sunglowsys.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sunglowsys.domain.RoomType;

@Repository
public interface RoomTypeRepository  extends JpaRepository<RoomType, Long> {
}

package com.roomsWithBulb.repos;

import com.roomsWithBulb.domain.Rooms;
import org.springframework.data.repository.CrudRepository;

public interface RoomsRepo extends CrudRepository<Rooms, Long> {
    Rooms findById(int id);
}

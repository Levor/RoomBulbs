package com.roomsWithBulb;

import com.roomsWithBulb.domain.Rooms;
import com.roomsWithBulb.repos.RoomsRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BulbControllerTest {

    @MockBean
    private RoomsRepo roomsRepo;

    @Test
    public void add() {

        String name = "Комната 1";
        String country = "Беларусь";

        Mockito.verify(roomsRepo, Mockito.times(0)).save(new Rooms(name, country, false));

    }

    @Test
    public void index() {
        Mockito.verify(roomsRepo, Mockito.times(0)).findAll();

    }
}
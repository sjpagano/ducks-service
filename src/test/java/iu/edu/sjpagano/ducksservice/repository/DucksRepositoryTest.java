package iu.edu.sjpagano.ducksservice.repository;

import iu.edu.sjpagano.ducksservice.model.Duck;
import iu.edu.sjpagano.ducksservice.model.DuckData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DucksRepositoryTest {

    @Test
    void addDuck() throws IOException {
        DuckData data1 = new DuckData(1, "Mallard");
        DuckData data2 = new DuckData(5, "Mallard");
        assertEquals(true,DucksRepository.addDuck(data1));
        assertEquals(true,DucksRepository.addDuck(data2));
    }

    @Test
    void getAllDucks() throws IOException {
        List<DuckData> expected = new ArrayList<>();
        DuckData data1 = new DuckData(1, "Mallard");
        DuckData data2 = new DuckData(5, "Mallard");
        expected.add(data1);
        expected.add(data2);
        assertEquals(expected,DucksRepository.getAllDucks());
    }

    @Test
    void getDuck() throws IOException {
        DuckData data2 = new DuckData(5, "Mallard");
        assertEquals(data2,DucksRepository.getDuck(5));
    }

    @Test
    void search() throws IOException {
        List<DuckData> expected = new ArrayList<>();
        DuckData data1 = new DuckData(1, "Mallard");
        DuckData data2 = new DuckData(5, "Mallard");
        expected.add(data1);
        expected.add(data2);
        String type = "Mallard";
        assertEquals(expected,DucksRepository.search(type));
    }
}
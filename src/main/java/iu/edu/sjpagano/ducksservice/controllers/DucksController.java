package iu.edu.sjpagano.ducksservice.controllers;

import iu.edu.sjpagano.ducksservice.model.Duck;
import iu.edu.sjpagano.ducksservice.model.DuckData;
import iu.edu.sjpagano.ducksservice.repository.DucksRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.sampled.AudioFileFormat;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ducks")
public class DucksController {

    private DucksRepository ducksRepository;

    public DucksController(DucksRepository ducksRepository) {
        this.ducksRepository = ducksRepository;
    }
    @PostMapping
    public boolean addDuck(@RequestBody DuckData duck) {
        try {
            return ducksRepository.addDuck(duck);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping
    public List<DuckData> getAllDucks() {
        try {
            return ducksRepository.getAllDucks();
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<DuckData> getDuck(@PathVariable int id) {
        try {
            DuckData duck = ducksRepository.getDuck(id);
            if(duck != null) {
                return ResponseEntity
                        .status(HttpStatus.FOUND)
                        .body(duck);
            } else {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(null);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/{id}/image")
    public boolean uploadImage(@PathVariable int id,@RequestParam MultipartFile image) {
        try {
            return ducksRepository.uploadImage(id,image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}/image")
    public ResponseEntity<?> downloadImage(@PathVariable int id) {
        try {
            byte[] image = ducksRepository.downloadImage(id);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .contentType(MediaType.IMAGE_PNG)
                    .body(image);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @PostMapping("/{id}/audio")
    public boolean uploadAudio(@PathVariable int id,@RequestParam MultipartFile audio) {
        try {
            return ducksRepository.uploadAudio(id, audio);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/{id}/audio")
    public ResponseEntity<?> downloadAudio(@PathVariable int id) {
        String fileExtension = ".mp3";
        try {
            byte[] audio = ducksRepository.downloadAudio(id);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .contentType(MediaType.parseMediaType(Files.probeContentType(Paths.get("ducks/audio/" + id + fileExtension))))
                    .body(audio);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @GetMapping("/search")
    public List<DuckData> search(@RequestParam String type) {
        try {
            return ducksRepository.search(type);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}

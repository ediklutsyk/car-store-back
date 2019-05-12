package com.store.car.controller;

import com.store.car.service.img.ImgService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api")
public class ImageController {
    private final ImgService imgService;

    public ImageController(ImgService imgService) {
        this.imgService = imgService;
    }

    @PostMapping(value = "/upload-file")
    public Integer uploadFile(@RequestPart(value = "file") MultipartFile file) {
        return imgService.save(file).getId();
    }

    @RequestMapping(value = "/get-image/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable("id") Integer id) {
        byte[] image = imgService.findById(id).get().getData();
        return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(image);
    }
}

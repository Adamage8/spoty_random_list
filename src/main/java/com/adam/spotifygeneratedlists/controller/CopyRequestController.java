package com.adam.spotifygeneratedlists.controller;

import com.adam.spotifygeneratedlists.entity.CopyRequest;
import com.adam.spotifygeneratedlists.service.CopyRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/copyRequests")
@CrossOrigin("http://localhost:4200")
public class CopyRequestController {

    @Autowired
    private CopyRequestService copyRequestService;

    @GetMapping("/")
    public ResponseEntity<List<CopyRequest>> getAll() {
        return new ResponseEntity<>(copyRequestService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CopyRequest> getCopyRequest(@PathVariable Long id) {
        return new ResponseEntity<>(copyRequestService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<CopyRequest> postCopyRequest(@RequestBody CopyRequest copyRequest) {
        return new ResponseEntity<>(copyRequestService.create(copyRequest), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CopyRequest> patchCopyRequest(@PathVariable Long id, @RequestBody CopyRequest copyRequest) {
        return new ResponseEntity<>(copyRequestService.update(id, copyRequest), HttpStatus.OK);
    }

}

package uniper.poc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uniper.poc.model.ModelPojo;
import uniper.poc.model.Models;
import uniper.poc.service.ModelService;

@RestController
public class ModelController {

    @Autowired
    private ModelService modelService;

    @GetMapping("/models")
    public ResponseEntity<Models> getAllModels() {
        return ResponseEntity.ok().body(modelService.getAllModels());
    }

    @GetMapping("/models/{id}")
    public ResponseEntity<ModelPojo> getModelById(@PathVariable long id) {
        return ResponseEntity.ok().body(modelService.getModelById(id));
    }

    @PostMapping("/models")
    public ResponseEntity<ModelPojo> createModel(@RequestBody ModelPojo modelPojo) {
        return ResponseEntity.ok().body(modelService.createModel(modelPojo));
    }
    @PostMapping("/models/dummy")
    public ResponseEntity<ModelPojo> createDummyModel() {
        ModelPojo modelPojo = new ModelPojo();
        modelPojo.setColumn1("Abhijit");
        modelPojo.setColumn2("Mishra");
        modelPojo.setColumn3("SA Projects");
        return ResponseEntity.ok().body(modelService.createModel(modelPojo));
    }

    @PutMapping("/models/{id}")
    public ResponseEntity<ModelPojo> updateModel(@PathVariable long id, @RequestBody ModelPojo modelPojo) {
        modelPojo.setId(id);
        return ResponseEntity.ok().body(modelService.updateModel(modelPojo));
    }

    @DeleteMapping("/models/{id}")
    public HttpStatus deleteModel(@PathVariable long id) {
        modelService.deleteModel(id);
        return HttpStatus.OK;
    }
}

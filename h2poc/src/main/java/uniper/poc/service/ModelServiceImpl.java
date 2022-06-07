package uniper.poc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uniper.poc.exception.ResourceNotFoundException;
import uniper.poc.model.COMPANY_ALIAS;
import uniper.poc.model.ModelPojo;
import uniper.poc.model.Models;
import uniper.poc.repository.CompanyRepository;
import uniper.poc.repository.ModelRepository;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class ModelServiceImpl implements ModelService{
    @Autowired
    private ModelRepository modelRepository;

    @Override
    public ModelPojo createModel(ModelPojo modelPojo) {
        return modelRepository.save(modelPojo);
    }

    @Override
    public ModelPojo updateModel(ModelPojo modelPojo) {
        log.info("update this model"+modelPojo);

        return null;
    }

    @Override
    public Models getAllModels() {
        List<ModelPojo> modelPojos = modelRepository.findAll();
        return new Models(modelPojos);
    }

    @Override
    public ModelPojo getModelById(long modelId) {
        Optional<ModelPojo> modelPojoOptionalDB = modelRepository.findById(modelId);
        if (modelPojoOptionalDB.isPresent()){
            return modelPojoOptionalDB.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : "+modelId);
        }
    }

    @Override
    public void deleteModel(long id) {
        Optional<ModelPojo> modelPojoOptionalDB = modelRepository.findById(id);
        if (modelPojoOptionalDB.isPresent()){
            modelRepository.delete(modelPojoOptionalDB.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : "+id);
        }
    }

}

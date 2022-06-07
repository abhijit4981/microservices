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
import uniper.poc.model.COMPANY_ALIASs;
import uniper.poc.model.ModelPojo;
import uniper.poc.repository.CompanyRepository;

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
public class ComponyServiceImpl implements CompanyService{

    @Autowired
    private CompanyRepository companyRepository;
    @Override
    public COMPANY_ALIAS createCOMPANY_ALIAS(COMPANY_ALIAS company_alias) {
        log.info("will insert this record"+company_alias.toString());
        return companyRepository.save(company_alias);
    }

    @Override
    public COMPANY_ALIAS updateCOMPANY_ALIAS(COMPANY_ALIAS company_alias) {
        log.info("+++++++++++++++++++++++++++++++++++++++++++++++++++");
        log.info("Updated data comming is "+company_alias);
        return companyRepository.save(company_alias);
    }

    @Override
    public COMPANY_ALIASs getAllCOMPANY_ALIASs() {
        List<COMPANY_ALIAS> company_aliasList = companyRepository.findAll();
        COMPANY_ALIASs company_aliaSs = new COMPANY_ALIASs();
        company_aliaSs.setCompanyAliasList(company_aliasList);
        return company_aliaSs;
    }

    @Override
    public COMPANY_ALIAS getCOMPANY_ALIASById(Float comapnyId) {
        Optional<COMPANY_ALIAS> modelPojoOptionalDB = companyRepository.findById(comapnyId);
        if (modelPojoOptionalDB.isPresent()){
            return modelPojoOptionalDB.get();
        } else {
            throw new ResourceNotFoundException("Record not found with id : "+comapnyId);
        }
    }

    @Override
    public void deleteCOMPANY_ALIAS(Float id) {
        Optional<COMPANY_ALIAS> modelPojoOptionalDB = companyRepository.findById(id);
        if (modelPojoOptionalDB.isPresent()){
            companyRepository.delete(modelPojoOptionalDB.get());
        } else {
            throw new ResourceNotFoundException("Record not found with id : "+id);
        }
    }

    @Override
    public String saveAllCompanyDetailsToDB() {
        String jsonString = readLargeFile();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        System.out.println("read of json success..");
        String msg = "";
        try {
            List<COMPANY_ALIAS> company_aliasList = objectMapper.readValue(jsonString, new TypeReference<List<COMPANY_ALIAS>>(){});
            company_aliasList.stream()
                    .forEach(s->{
                        System.out.println("Each entry"+s);
                        companyRepository.save(s);
                    });
            msg="Success..";
        } catch (JsonProcessingException e) {
            System.out.println("Parsing issue"+e.getMessage());
            msg="Failed to update db";
        }
        return msg;
    }
    private String readLargeFile() {
        Path path = null;
        try {
            path = Paths.get(getClass().getClassLoader()
                    .getResource("demo.txt").toURI());
        } catch (URISyntaxException e) {
            System.out.println("Not able to find the path specified..1.");
        } catch (Exception e){
            System.out.println("Not able to find the path specified..0.");
        }

        System.out.println("Path found..");
        Stream<String> lines = null;
        try {
            lines = Files.lines(path);
        } catch (IOException e) {
            System.out.println("Not able to find the path specified..2.");
        }
        String data = lines.collect(Collectors.joining("\n"));
        return data;
    }
}

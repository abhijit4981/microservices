package uniper.poc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uniper.poc.model.COMPANY_ALIAS;
import uniper.poc.model.COMPANY_ALIASs;
import uniper.poc.model.ModelPojo;
import uniper.poc.service.CompanyService;

@RestController
@RequestMapping("/company")
public class CompanyController {
    @Autowired
    private CompanyService companyService;

    @GetMapping("/dummy")
    public String saveAllCompanyDetailsToDB(){
        return companyService.saveAllCompanyDetailsToDB();
    }
    @GetMapping("/{id}")
    public COMPANY_ALIAS getCOMPANY_ALIASById(@PathVariable Float id) {
        return companyService.getCOMPANY_ALIASById(id);
    }

    @GetMapping
    public COMPANY_ALIASs getAllCOMPANY_ALIASs() {
        return companyService.getAllCOMPANY_ALIASs();
    }
    @PostMapping
    public COMPANY_ALIAS createCOMPANY_ALIAS(@RequestBody COMPANY_ALIAS company_alias) {
        return companyService.createCOMPANY_ALIAS(company_alias);
    }
    @PutMapping("/{id}")
    public ResponseEntity<COMPANY_ALIAS> updateCOMPANY_ALIAS(@PathVariable Float id, @RequestBody COMPANY_ALIAS company_alias) {
        company_alias.setId(id);
        return ResponseEntity.ok().body(companyService.updateCOMPANY_ALIAS(company_alias));
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteCOMPANY_ALIAS(@PathVariable Float id) {
        companyService.deleteCOMPANY_ALIAS(id);
        return HttpStatus.OK;
    }

}

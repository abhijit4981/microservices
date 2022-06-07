package uniper.poc.service;


import uniper.poc.model.COMPANY_ALIAS;
import uniper.poc.model.COMPANY_ALIASs;

public interface CompanyService {
    COMPANY_ALIAS createCOMPANY_ALIAS(COMPANY_ALIAS company_alias);

    COMPANY_ALIAS updateCOMPANY_ALIAS(COMPANY_ALIAS company_alias);

    COMPANY_ALIASs getAllCOMPANY_ALIASs();

    COMPANY_ALIAS getCOMPANY_ALIASById(Float comapnyId);

    void deleteCOMPANY_ALIAS(Float id);

    String saveAllCompanyDetailsToDB();
}

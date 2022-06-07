package uniper.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uniper.poc.model.COMPANY_ALIAS;

public interface CompanyRepository extends JpaRepository<COMPANY_ALIAS,Float> {
}

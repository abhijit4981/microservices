package uniper.poc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Generated;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="COMPANY_ALIAS")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class COMPANY_ALIAS {
    @Id
    @Column(name ="ALIAS_ID")
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private float id;
    private String ENTITY_TYPE_NAME;

    private String UPSTREAM_APP;
    private String COMPANY_NAME;
    private String UPSTREAM_ALIAS;
    private String DOWNSTREAM_APP;
    private String DOWNSTREAM_ALIAS;
    private String INSTRUMENT_NAME;
    private String INSTRUMENT_ID;
    private String UPDATED_BY;
    private LocalDate UPDATED_DATE;
    private boolean IS_ACTIVE;
}

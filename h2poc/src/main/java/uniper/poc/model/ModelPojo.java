package uniper.poc.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "model")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ModelPojo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String column1;
    private String column2;
    private String column3;
}

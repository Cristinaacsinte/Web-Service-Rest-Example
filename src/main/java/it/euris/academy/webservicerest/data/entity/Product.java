package it.euris.academy.webservicerest.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import it.euris.academy.webservicerest.data.dto.ProductDTO;
import it.euris.academy.webservicerest.data.dto.archetype.Dto;
import it.euris.academy.webservicerest.data.dto.archetype.Model;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static it.euris.academy.webservicerest.utility.DataConversionUtils.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product implements Model {

  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "price", nullable = false)
  private BigDecimal price;

  @Builder.Default
  @Column(name = "in_stock")
  private Boolean inStock = true;

  @Builder.Default
  @Column(name = "deleted")
  private Boolean deleted = false;

  @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
  @JsonIgnore
  @Builder.Default
  private List<OrderDetail> orderDetails = new ArrayList<>();

  @Override
  public ProductDTO toDto() {
    return ProductDTO
        .builder()
        .id(numberToString(id))
        .name(name)
        .description(description)
        .price(bigDecimalToString(price))
        .inStock(booleanToString(inStock))
        .build();
  }
}

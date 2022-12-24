package murraco.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Basket {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long id;

  @ManyToMany
  public List<Product> products;

}

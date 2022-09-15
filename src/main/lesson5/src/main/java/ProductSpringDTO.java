import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "products")
@NamedQueries({
        @NamedQuery(name = "findAllProducts", query = "Select u from Products u"),
        @NamedQuery(name = "countAllProducts", query = "Select count(u) from Products u"),
        @NamedQuery(name = "deleteProductById", query = "delete from Products u where u.id = :id")
})
public class ProductSpringDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false, unique = true)
    private String productTitle;
    @Column(nullable = false, unique = true)
    private int cost;
    private int amount;
    private String origin;


    public ProductSpringDTO(String productTitle, long id, int cost, int amount){
        this.productTitle = productTitle;
        this.id = id;
        this.cost = cost;
        this.amount = amount;

    }

    public ProductSpringDTO(String productTitle) {
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = this.id;
    }
    public String getProductTitle(){
        return productTitle;
    }
    public void setProductTitle(){
        this.productTitle = productTitle;
    }
    public void setCost(){
        this.cost = cost;
    }
    public int getCost(){
        return cost;
    }

    public void put(Long id, ProductSpringDTO products) {
    }
}




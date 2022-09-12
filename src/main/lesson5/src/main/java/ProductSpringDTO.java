import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductSpringDTO {
    private Long id;
    @NotBlank
    private String productTitle;
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




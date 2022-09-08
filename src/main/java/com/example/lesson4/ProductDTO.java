package com.example.lesson4;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long id;
    @NonNull
    private String productTitle;
    @JsonIgnore
    private int cost;
    @NotBlank
    private int amount;
    private String origin;


    public ProductDTO(String productTitle, long id, int cost, int amount){
        this.productTitle = productTitle;
        this.id = id;
        this.cost = cost;
        this.amount = amount;

    }

    public ProductDTO(String productTitle) {
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

    public void put(Long id, ProductDTO products) {
    }
}




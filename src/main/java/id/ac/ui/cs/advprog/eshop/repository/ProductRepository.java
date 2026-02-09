package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product){
        productData.add(product);
        return product;
    }

    public Product findById(String productId){
        for (Product p : productData) {
            if (p.getProductId().equals(productId)) return p;
        }
        return null;
    }

    public Product edit(Product product) {
        Product newProd = findById(product.getProductId());
        if(newProd != null){
            newProd.setProductName(product.getProductName());
            newProd.setProductQuantity(product.getProductQuantity());
        }

        return newProd;
    }

    public Iterator<Product> findAll(){
        return productData.iterator();
    }
}

package ch.diego.demo1;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ProductServiceController {
    private static final Map<String, Product> productRepo = new HashMap<>();
    static {
        Product honey = new Product();
        honey.setId("1");
        honey.setName("Honey");
        productRepo.put(honey.getId(), honey);

        Product almond = new Product();
        almond.setId("2");
        almond.setName("Almond");
        productRepo.put(almond.getId(), almond);
    }
    @RequestMapping(value = "/products")
    public ResponseEntity<Object> getProduct() {
        System.out.println("----product requested ------");
        return new ResponseEntity<>(productRepo.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/product")
    public ResponseEntity<Object> getProductByParam(@RequestParam(value="id",required=false,defaultValue="1") String id) {
        System.out.println("----product requested Id=" + id);
        return new ResponseEntity<>(productRepo.get(id), HttpStatus.OK);
    }


    @RequestMapping(path="/product/{id}")
    public ResponseEntity<Object> getProductByPathVariable(@PathVariable("id") String id) {
        System.out.println("----product by Path variable requested Id=" + id);
        return new ResponseEntity<>(productRepo.get(id), HttpStatus.OK);
    }


    @RequestMapping(value = "/products", method = RequestMethod.POST)
    public ResponseEntity<Object> createProduct(@RequestBody Product product) {
        productRepo.put(product.getId(), product);
        return new ResponseEntity<>("Product is created successfully", HttpStatus.CREATED);
    }


}
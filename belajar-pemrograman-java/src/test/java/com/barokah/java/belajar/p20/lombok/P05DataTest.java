package com.barokah.java.belajar.p20.lombok;

import com.barokah.java.belajar.p20.lombok.data.Product;
import com.barokah.java.belajar.p20.lombok.data.ProductOverWrite;
import org.junit.jupiter.api.Test;

//@Data is @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode bundled in one annotation
public class P05DataTest {
    @Test
    void testData(){
        Product product1 = new Product("001", "bunga", 100L);
        ProductOverWrite product2 = new ProductOverWrite("001","bunga",100L);

        System.out.println(product1);
        System.out.println(product2);
    }
}

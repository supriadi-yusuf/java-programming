package com.barokah.java.belajar.p20.lombok.data;

import lombok.Data;
import lombok.NonNull;

@Data // this class automatically has @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode
public class Product {
    @NonNull private String id;
    @NonNull private String name;
    @NonNull private Long price;

}

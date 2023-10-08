package com.barokah.java.belajar.p20.lombok.data;

import lombok.Data;
import lombok.NonNull;
import lombok.ToString;

@Data // this class automatically has @Getter, @Setter, @RequiredArgsConstructor, @ToString, @EqualsAndHashCode
@ToString(exclude = {"price"}) // but we can overwrite
public class ProductOverWrite {
    @NonNull private String id;
    @NonNull private String name;
    @NonNull private Long price;
}

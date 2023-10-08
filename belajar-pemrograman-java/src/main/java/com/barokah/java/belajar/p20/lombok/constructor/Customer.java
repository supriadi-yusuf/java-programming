package com.barokah.java.belajar.p20.lombok.constructor;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Customer {
    @NonNull // for @RequiredArgsConstructor
    private String id;
    private String name;
}

package com.barokah.java.belajar.p20.lombok.nonnull;

import lombok.*;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Member {
    @NonNull // mark this field should be put on required args constructor and check if this field is not null on constructor and setter
    private String id;
    private String name;

    // make parameter (in this case name) non null
    public void sayHello(@NonNull String name){
        System.out.println("Hello " + name);
    }
}

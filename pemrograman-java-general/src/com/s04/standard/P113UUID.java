package com.s04.standard;

import java.util.UUID;

public class P113UUID {
    public static void main(String[] args) {
        for (var i = 1; i <= 100; i++) {
            UUID uuid = UUID.randomUUID();
            String strUuid = uuid.toString();
            System.out.println(strUuid);
        }
    }
}

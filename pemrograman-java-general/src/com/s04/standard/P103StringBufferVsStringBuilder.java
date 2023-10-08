package com.s04.standard;

// StringBuilder is not thread safe
// StringBuffer  is thread safe so it is slower than StringBuilder

public class P103StringBufferVsStringBuilder {
    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        builder.append("Saya");
        builder.append(" ");
        builder.append("programmer");
        builder.append(" ");
        builder.append("java");

        String string = builder.toString();
        System.out.println(string);
    }
}

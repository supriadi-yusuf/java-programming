package com.s14.internationalization;

import java.text.MessageFormat;
import java.util.Date;
import java.util.Locale;

public class P283MessageFormatType {
    public static void main(String[] args) {
        // https://docs.oracle.com/javase/8/docs/api/java/text/MessageFormat.html
        Locale localeIndonesia = new Locale("id", "ID");
        String pattern="Halo {0}, sekarang {1,date,EEEE, dd MMMM yyyy}, saldo anda adalah {2,number,currency}";
        MessageFormat messageFormat = new MessageFormat(pattern, localeIndonesia);
        String format = messageFormat.format(new Object[]{"supriadi", new Date(), 1000000});
        System.out.println(format);
    }
}

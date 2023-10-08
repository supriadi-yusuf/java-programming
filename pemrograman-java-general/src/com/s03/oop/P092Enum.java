package com.s03.oop;

public class P092Enum {

    public static enum LevelEnumGeneral{
        STANDARD,
        PREMIUM,
        // we can add description
        VIP;
    }

    public static interface LevelEnumInterface{
        void printInfo();
    }

    public static enum LevelEnumComplex
            implements LevelEnumInterface // enum can implement interface but it cannot extend class
    {
        STANDARD("level standard", 0),
        PREMIUM("level Premium", 1),
        VIP("Vice President", 2);

        private String info; // enum can have field
        private int sequence;

        LevelEnumComplex(String info, int sequence) { // enum can also has constructor
            this.info = info;
            this.sequence=sequence;
        }

        public String getInfo() {
            return info;
        }

        public int getSequence() {
            return sequence;
        }

        @Override
        public void printInfo() {
            System.out.println(this.info);
        }
    }

    public static void main(String[] args) {

        LevelEnumGeneral levelEnumGeneral = LevelEnumGeneral.PREMIUM;
        System.out.println(levelEnumGeneral);

        levelEnumGeneral = LevelEnumGeneral.STANDARD;
        System.out.println(levelEnumGeneral);

        LevelEnumComplex levelEnumComplex = LevelEnumComplex.PREMIUM;
        levelEnumComplex.printInfo();
        System.out.println(levelEnumComplex);

    }
}

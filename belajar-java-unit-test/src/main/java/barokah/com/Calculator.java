package barokah.com;

public class Calculator {
    public Integer add(Integer first, Integer second){
        return first + second;
    }

    public Integer divide(Integer first, Integer second){
        if (second == 0){
            throw new IllegalArgumentException("Can not devide by zero");
        }

        return first / second;
    }
}

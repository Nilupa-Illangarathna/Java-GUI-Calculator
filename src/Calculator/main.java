package Calculator;

class Main {

    public double format(double value){
        return (double)Math.round(value + 1000000)/1000000;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println(java.lang.Math.atan(0.57735)*180/Math.PI); //Radian walin denna on


    }
}

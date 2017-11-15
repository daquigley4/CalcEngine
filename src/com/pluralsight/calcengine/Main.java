//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pluralsight.calcengine;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
//        double[] leftVal = new double[]{100.0d, 25.0d, 225.0d, 11.0d};
//        double[] rightVal = new double[]{50.0d, 92.0d, 17.0d, 3.0d};
//        char[] opCodes = new char[]{'d', 'a', 's', 'm'};
//        double[] results = new double[opCodes.length];

        MathEquation testEquation = new MathEquation();
        testEquation.execute();
        System.out.println(testEquation.getResult());

        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 100.0d, 50.0d);
        equations[1] = new MathEquation('a', 25.0d, 92.0d);
        equations[2] = new MathEquation('s', 225.0d, 17.0d);
        equations[3] = new MathEquation('m', 11.0d, 3.0d);
//        equations[0] = create(100.0d, 50.0d, 'd');
//        equations[1] = create(25.0d, 92.0d, 'a');
//        equations[2] = create(225.0d, 17.0d, 's');
//        equations[3] = create(11.0d, 3.0d, 'm');

        for (MathEquation equation : equations) {
            equation.execute();
            System.out.println("result = ");
            System.out.println(equation.getResult());
        }

        System.out.println();
        System.out.println("Using Overloads");
        System.out.println();

        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        int leftInt = 9;
        int rightInt = 4;

        MathEquation equationOverload = new MathEquation('d');
        equationOverload.execute(leftDouble, rightDouble);

        System.out.println();
        System.out.println("results = " + equationOverload.getResult());
        System.out.println();

        equationOverload.execute(leftInt, rightInt);

        System.out.println();
        System.out.println("results = " + equationOverload.getResult());
        System.out.println();

        equationOverload.execute(leftDouble, rightInt);

        System.out.println();
        System.out.println("results = " + equationOverload.getResult());
        System.out.println();


    }

    public static MathEquation create(double leftVal, double rightVal, char opCode) {
        MathEquation equation = new MathEquation();
        equation.setLeftVal(leftVal);
        equation.setRightVal(rightVal);
        equation.setOpCode(opCode);
        return equation;
    }
}

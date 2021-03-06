//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package com.pluralsight.myapp;


import com.pluralsight.calcengine.Adder;
import com.pluralsight.calcengine.CalculateBase;
import com.pluralsight.calcengine.CalculateHelper;
import com.pluralsight.calcengine.Divider;
import com.pluralsight.calcengine.DynamicHelper;
import com.pluralsight.calcengine.InvalidStatementException;
import com.pluralsight.calcengine.MathEquation;
import com.pluralsight.calcengine.MathProcessing;
import com.pluralsight.calcengine.Multiplier;
import com.pluralsight.calcengine.PowerOf;
import com.pluralsight.calcengine.Subtractor;

import java.util.Arrays;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
//        useMathEquation();
//        useCalculateBase();
//        useCalculateHelper();

//        double[] leftVal = new double[]{100.0d, 25.0d, 225.0d, 11.0d};
//        double[] rightVal = new double[]{50.0d, 92.0d, 17.0d, 3.0d};
//        char[] opCodes = new char[]{'d', 'a', 's', 'm'};
//        double[] results = new double[opCodes.length];

        String[] statements = {
                "add 25.0 92.0", // 25.0 + 92.0 = 117.0
                "power 5.0 2.0", // 5.0 ^ 2.0 = 25.0
                "subtract 225.0 17.0", // 225.0 - 17.0 = 208.0
                "divide 100.0 25.0", // 100.0 / 25.0 = 4.0
                "multiply 11.0 3.0" //11.0 * 3.0 = 33.0
        };

        DynamicHelper helper = new DynamicHelper(new MathProcessing[] {
                new Adder(),
                new PowerOf(),
                new Subtractor(),
                new Divider(),
                new Multiplier()
        });

        for (String statement : statements) {
            String output = helper.process(statement);
            System.out.println(output);
        }


    }

    static void useCalculateHelper() {
        String[] statements = {
                "add 1.0",
                "add xx 25.0",
                "addX 0.0 0.0",
                "divide 100.0d 25.0d",
                "add 25.0d 92.0d",
                "subtract 225.0d 17.0d",
                "multiply 11.0d 3.0d"
        };

        CalculateHelper helper = new CalculateHelper();
        for (String statement : statements) {
            try {
                helper.process(statement);
                System.out.println(helper);
            } catch (InvalidStatementException e) {
                System.out.println(e.getMessage());
                if (e.getCause() != null) {
                    System.out.println("   Original Exception: " + e.getCause().getMessage());
                }
            }
        }
    }

    static void useMathEquation() {
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

    static void useCalculateBase() {
        System.out.println();
        System.out.println("Using Inheritance");
        System.out.println();

        CalculateBase[] calculators = {
                new Divider(100.0d, 50.0d),
                new Adder(25.0d, 92.0d),
                new Subtractor(225.0d, 17.0d),
                new Multiplier(11.0d, 3.0d)
        };

        for (CalculateBase calculator : calculators) {
            calculator.calculate();
            double result = calculator.getResult();
            System.out.println("Inheritance result = " + result);
        }
    }

    public static MathEquation create(double leftVal, double rightVal, char opCode) {
        MathEquation equation = new MathEquation();
        equation.setLeftVal(leftVal);
        equation.setRightVal(rightVal);
        equation.setOpCode(opCode);
        return equation;
    }
}

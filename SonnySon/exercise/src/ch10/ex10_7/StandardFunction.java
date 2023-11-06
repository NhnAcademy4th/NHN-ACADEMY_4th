package ch10.ex10_7;


import java.awt.geom.QuadCurve2D;

public class StandardFunction {
    Functions functionCode;
    StandardFunction(Functions code) {
        functionCode = code;
    }
    double evaluate(double x) {
        // (This uses the "switch expression" syntax)
        return switch(functionCode) {
            case SIN -> Math.sin(x);
            case COS -> Math.cos(x);
            case TAN -> Math.tan(x);
            case ABS -> Math.abs(x);
            case SQRT -> Math.sqrt(x);
            default -> Math.log(x);
        };
    }
}
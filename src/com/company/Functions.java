package com.company;

public class Functions {
    public int funcNo;
    public float a, b, c, step, xs, xe;

    //Constructors
    public Functions(int funcNo, float xs, float xe, float a, float b, float c, float step) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.step = step;
        this.xs = xs;
        this.xe = xe;
        this.funcNo = funcNo;
    }

    public String getResult() {
        StringBuilder result = new StringBuilder("x:      y:\n");
        for (float i = xs; i <= xe; i += step) {
            float y = 0;
            switch (funcNo) {
                case 1:
                    y = (a * (i * i)) + (b * i) + c;
                    break;
                case 2:
                    y = (a * (i * i * i)) + (b * i * i) + c;
                    break;
                case 3:
                    y = (2 * a * i) + (b * i) + c;
                    break;
            }
            result.append(i).append("     ").append(y).append("\n");
        }
        return result.toString();
    }
}

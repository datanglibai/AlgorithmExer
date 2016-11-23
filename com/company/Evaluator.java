package com.company;

import java.util.Stack;

public class Evaluator
{
    public static double Evaluate(String expression)
    {
        Stack<String> ops  = new Stack<String>();
        Stack<Double> vals = new Stack<Double>();
        String[] ovs = expression.split(" ");
        for (int i=0; i < ovs.length; i++)
        {  // Read token, push if operator.
            String s = ovs[i];
            if      (s.equals("("));
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*"))  ops.push(s);
            else if (s.equals("/"))  ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);
            else if (s.equals(")"))
            {  // Pop, evaluate, and push result if token is ")".
                String op = ops.pop();
                double v = vals.pop();
                if      (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                System.out.println(v);
                vals.push(v);
            }  // Token not operator or paren: push double value.
            else vals.push(Double.parseDouble(s));
        }
        double result = vals.pop();
        System.out.println(result);
        return result;
    }
}
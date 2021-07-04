/**
 * this class has an association between FunctionBehavior to call methods easily
 * @author Can BEYAZNAR
 */
public abstract class LinearEquationSolver {


    /**
     * this is our association to use methods of FunctionBehavior interface
     */
    private FunctionBehavior functionbehavior;

    /**
     * We can select our method that we use dynamically
     * @param input_functionbehavior Dynamically determines which method is FunctionBehavior.
     */
    public LinearEquationSolver(FunctionBehavior input_functionbehavior){
        functionbehavior = input_functionbehavior;
    }

    public void calculate_equations(double[][] Input_2D) throws Exception {
        functionbehavior.calculate(Input_2D);
    }

    /**
     * We can set our method that we use dynamically
     * @param functionbehavior Dynamically determines which method is FunctionBehavior.
     */
    public void setFunctionbehavior(FunctionBehavior functionbehavior) {
        this.functionbehavior = functionbehavior;
    }

    public FunctionBehavior getFunctionbehavior() {
        return functionbehavior;
    }

    @Override
    public String toString() {
        return functionbehavior.toString();
    }
}

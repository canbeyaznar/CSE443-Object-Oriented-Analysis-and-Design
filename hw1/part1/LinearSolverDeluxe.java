/**
 *
 * Which method is dynamically determined as FunctionBehavior an the existing methods are selected
 * this is our subclass for LinearEquationSolver
 * so we can add new subclass to LinearEquationSolver class if we need
 * This class will only call super function of LinearEquationSolver class
 * @author Can BEYAZNAR
 */
public class LinearSolverDeluxe extends LinearEquationSolver {
    public LinearSolverDeluxe(FunctionBehavior input_functionbehavior) {
        super(input_functionbehavior);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

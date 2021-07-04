/**
 * Discrete Cosine Transform class
 */

import java.util.ArrayList;

public class DCT_WithHook extends DiscreteTransformTemplate{

    public DCT_WithHook(){
        // empty constructor
    }

    /**
     *
     * @param input user input that read from file
     * @return returns DCT (DCT-II) result with ArrayList form
     * https://en.wikipedia.org/wiki/Discrete_cosine_transform
     */
    @Override
    public ArrayList<Double> makeTransform(ArrayList<Double> input) {
        ArrayList<Double> X = new ArrayList<>();
        int N = input.size();
        for(int k=0; k<N; k++){
            double res =0;
            for(int n=0; n<N; n++){
                res += input.get(n) * (Math.cos( ( (Math.PI / N) * (n + 0.5) *  k))) ;
            }
            X.add(res);
        }
        return X;
    }

}

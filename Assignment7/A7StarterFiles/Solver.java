import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 * Solver.java
 *
 * Static method to solve reordering of train cars using a Stack
 *
 */
public class Solver {
    /*
     * Purpose: determines whether the given carOrder can be reordered to
     *  increasing order (1 to the number of cars in carOrder) using one spur.
     *  The CarMoves that enable this reordering are stored in carOrder.
     * Parameters: List<Integer> carOrder, List<CarMove> moves
     * Preconditions: list and moves are not null.
     * Returns: boolean - true if reordering is possible, false otherwise
     */
    public static boolean reorderTrains(List<Integer> carOrder, List<CarMove> moves) {


        StackRefBased<Integer> input = new StackRefBased<Integer>(carOrder);
        StackRefBased<Integer> output = new StackRefBased<Integer>();
        StackRefBased<Integer> spur = new StackRefBased<Integer>();

        try{
            int i = carOrder.size();
            while(output.isEmpty() && !input.isEmpty()) {
                if (input.peek() == i) {
                    output.push(input.pop());
                    moves.add(new CarMove("in", "out"));
                } else {
                    spur.push(input.pop());
                    moves.add(new CarMove("in", "spur"));
                } 

            }
            
            if (!input.isEmpty() && input.peek() > i){
                moves.clear();
                return false;
            } else if (input.isEmpty() && output.isEmpty()){
                moves.clear();
                return false;
            }

            while (output.size() != i ) {
                if(!input.isEmpty() && (input.peek() == output.peek() - 1)){
                    output.push(input.pop());
                    moves.add(new CarMove("in", "out"));
                } else if ((input.isEmpty() || !input.isEmpty()) && (spur.peek() == output.peek() - 1)) {
                    output.push(spur.pop());
                    moves.add(new CarMove("spur", "out"));
                } else if (!input.isEmpty() && (spur.peek() != output.peek() - 1)) {
                    spur.push(input.pop());
                    moves.add(new CarMove("in", "spur"));
                } else if (input.isEmpty()  && spur.peek() != output.peek() - 1) {
                    moves.clear();
                    return false;
                } else if (input.isEmpty() && spur.isEmpty() && output.peek() != 1) {
                    moves.clear();
                    return false;
                } 
            }


        } catch (StackEmptyException e){
            System.out.println("The stack is empty");
        }
        return true;
    }
}


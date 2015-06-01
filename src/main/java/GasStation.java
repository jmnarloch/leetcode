/**
 * Created by jakubnarloch on 01.04.15.
 */
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {

        // input: the array of 'gas stations' and array of cost of traveling from gas station from i to i + 1
        // output: the index of the first element that allows to travel full cycle
        // edge cases: gas is null, cost is null, gas is empty, gas is empty
        if(gas == null || cost == null) {
            return -1;
        }
        if(gas.length == 0 || cost.length == 0
                || gas.length != cost.length) {
            return -1;
        }

        int totalCost = 0;
        int totalGas = 0;
        for(int ind = 0; ind < gas.length; ind++) {
            totalCost += cost[ind];
            totalGas += gas[ind];
        }

        if(totalGas < totalCost) {
            return -1;
        }

        int i = 0;
        while(i < gas.length) {

            int sum = 0;
            int count = 0;
            int j = i;
            while(count < gas.length) {
                sum += gas[j];

                if(sum < cost[j]) {
                    i = j + 1;
                    break;
                }
                sum -= cost[j];

                j = (j  + 1) % gas.length;
                count++;
            }

            if(count == gas.length) {
                return i;
            }
        }

        return -1;
    }
}

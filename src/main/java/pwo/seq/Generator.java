package pwo.seq;

import java.math.BigDecimal;
import pwo.utils.SequenceGenerator;

abstract class Generator implements SequenceGenerator {

    protected int lastIndex = 0;
    protected BigDecimal current = null,
            f_1 = null,
            f_2 = null,
            f_3 = null;

    @Override
    public void reset() {
        lastIndex = 0;
    }

    @Override
    public final BigDecimal getTerm(int i) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        int start = lastIndex;
        int end = i;

        // Adjust the loop direction based on the comparison of start and end
        int step = start <= end ? 1 : -1;

        if (start > end) {
            reset();
        }

        for (int index = start; index != end + step; index += step) {
            nextTerm();
        }
        return current;
    }
}

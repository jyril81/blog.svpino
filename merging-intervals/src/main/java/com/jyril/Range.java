package com.jyril;

import com.google.common.base.MoreObjects;
import net.jcip.annotations.Immutable;

/**
 * Created by jyril81 on 26.05.2015.
 */
@Immutable
public class Range {
    private final int start;
    private final int end;

    public Range(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public boolean intersects(Range another) {
        // [1, 10] [15, 17]
        // [1, 3] [2, 6]
        // [2, 6] [1, 3]
        return another.start <= this.end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Range range = (Range) o;

        if (start != range.start) return false;
        return end == range.end;

    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + end;
        return result;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("start", start)
                .add("end", end)
                .toString();
    }
}

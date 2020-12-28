package com.ark.algo.greedy;

import java.time.LocalTime;
import java.util.*;

/**
 * Given n pairs of start and end time, find those maximum pairs that does not overlap.
 */
public class SchedulingProblem {
    /**
     * <p> 1) Sort the list of pairs by end time,
     *     2) Selected = first pair
     *     3) Iterate over all pairs except first
     *     4) If (selected start < current end)
     *         a- move current to selected
     *         b- add it to selected list
     *     5) Return List of selected pairs.
     *  </p>
     * @param pairs List of Pairs.
     * @return List of maximum sub set without overlap.
     */
    public List<Pair> getMaximumSubset(List<Pair> pairs) {
        List<Pair> maximumSubset = new ArrayList<>(pairs.size());
        Collections.sort(pairs);
        Pair selected = pairs.get(0);
        maximumSubset.add(selected);
        for (int i = 1; i < pairs.size(); i++) {
            Pair current = pairs.get(i);
            if (selectedStartLessThanCurrentEnd(selected, current)) {
                // No Overlap add it to selected Pairs
                selected = current;
                maximumSubset.add(selected);
            }
        }
        return maximumSubset;
    }

    private boolean selectedStartLessThanCurrentEnd(Pair selected, Pair current) {
        return selected.getEnd().compareTo(current.getStart()) < 0;
    }

    public static void main(String[] args) {
        List<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(localTime(9, 30), localTime(9, 45)));
        pairs.add(new Pair(localTime(9, 0), localTime(10, 0)));
        pairs.add(new Pair(localTime(5, 0), localTime(7, 0)));
        pairs.add(new Pair(localTime(10, 0), localTime(11, 30)));
        pairs.add(new Pair(localTime(11, 0), localTime(12, 0)));
        List<Pair> maxSubset = new SchedulingProblem().getMaximumSubset(pairs);
        maxSubset.forEach(System.out::println);
    }

    private static LocalTime localTime(int hour, int min) {
        return LocalTime.of(hour, min);
    }
}

class Pair implements Comparable<Pair> {
    private final LocalTime start;
    private final LocalTime end;

    Pair(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(start, pair.start) &&
                Objects.equals(end, pair.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
    }

    @Override
    public int compareTo(Pair other) {
        return this.end.compareTo(other.end);
    }
}

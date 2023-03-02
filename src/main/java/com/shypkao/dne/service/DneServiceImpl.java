package com.shypkao.dne.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

@Service
@Slf4j
public class DneServiceImpl implements DneService {

    public static final int MIN_ARRAY_LENGTH = 3;

    public boolean hasDneSequence(int[] arr) {
        log.info("Start searching for DNE sequence in: " + Arrays.toString(arr));
        if (arr.length < MIN_ARRAY_LENGTH) {
            return false;
        }
        int localMin = arr[0];
        int localMax = arr[0];
        TreeSet<Interval> treeSet = new TreeSet<>(Comparator.comparingInt(Interval::getStart));
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] >= localMax) {
                localMax = arr[i];
            } else {
                if (localMin != localMax) {
                    treeSet.add(new Interval(localMin, localMax));
                }
                if (localMin > arr[i]) {
                    localMin = arr[i];
                    localMax = arr[i];
                }
            }
            for (Interval interval : treeSet.subSet(new Interval(Integer.MIN_VALUE, arr[i]), new Interval(arr[i], Integer.MAX_VALUE))) {
                if (interval.getStart() < arr[i] && interval.getStop() > arr[i]) {
                    log.info("Found sequence where a[i]:" + interval.getStart() + " a[j]:" + interval.getStop() + " and a[k]:"+arr[i]);
                    return true;
                }
            }
        }
        log.info("No DNE sequence found");
        return false; // no DNE sequence found
    }
}

class Interval implements Comparable<Interval> {
    private final int start;
    private final int stop;

    public Interval(int start, int stop) {
        this.start = start;
        this.stop = stop;
    }

    public int getStart() {
        return start;
    }

    public int getStop() {
        return stop;
    }

    public int compareTo(Interval other) {
        if (this.start != other.start) {
            return this.start - other.start;
        } else {
            return this.stop - other.stop;
        }
    }

    public String toString() {
        return "[" + start + ", " + stop + "]";
    }

}

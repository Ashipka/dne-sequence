package com.shypkao.dne.service;

import org.springframework.stereotype.Service;

@Service
public class DneServiceImpl implements DneService {

    public static final int MIN_ARRAY_LENGTH = 3;

    public boolean hasDneSequence(int[] arr) {
        if (arr.length < MIN_ARRAY_LENGTH) {
            return false;
        }
        int[] mins = new int[arr.length];
        int[] maxs = new int[arr.length];

        // populate mins array
        mins[0] = arr[0];
        maxs[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            mins[i] = Math.min(mins[i - 1], arr[i]);
            if (mins[i]<mins[i-1]) {
                maxs[i] = mins[i];
            } else {
                maxs[i] = Math.max(maxs[i - 1], arr[i]);
            }
        }

        // check for DNE sequence
        for (int i = 2; i <= arr.length - 1; i++) {
            if (mins[i - 1] < arr[i] && arr[i] < maxs[i - 1]) {
                return true; // DNE sequence found
            }
        }
        return false; // no DNE sequence found
    }
}

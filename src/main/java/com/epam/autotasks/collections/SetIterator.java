package com.epam.autotasks.collections;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SetIterator<Integer> implements Iterator<Integer> {
    private int index = 0;
    Integer[] values;
    SetIterator(Integer[] values)
    {
        this.values = values;
    }
    @Override
    public boolean hasNext() {
        return this.index<this.values.length;
    }

    @Override
    public Integer next() {
        if(index<this.values.length)
            return this.values[this.index++];
        throw new NoSuchElementException();
    }
}

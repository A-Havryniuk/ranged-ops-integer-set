package com.epam.autotasks.collections;

import java.util.*;

class RangedOpsIntegerSet extends AbstractSet<Integer> {
    private Integer[] array = new Integer[0];
    int sizeOfArray;
    public boolean add(int fromInclusive, int toExclusive) {
        int count = 0;
        for(int i = fromInclusive; i < toExclusive; ++i)
        {
            if(!Arrays.asList(this.array).contains(i))
            {
                resize(i);
                count++;
            }
        }
        return count!=0;
    }

    public boolean remove(int fromInclusive, int toExclusive) {
        int count = 0;
        for(int i = fromInclusive; i < toExclusive; ++i)
        {
            if(Arrays.asList(this.array).contains(i))
            {
                count++;
                delete(i);
            }
        }
        return count!=0;
    }

    @Override
    public boolean add(final Integer integer) {
        if(integer == null)
            return false;
        if(!Arrays.asList(this.array).contains(integer)) {
            resize(integer);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(final Object o) {
        if(o == null)
            return false;
        if(!(o instanceof Integer))
            return false;
        delete((Integer)o);
        return true;
    }

    @Override
    public Iterator<Integer> iterator() {
        Iterator<Integer> iter = new Iterator<Integer>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return this.index<array.length;
            }

            @Override
            public Integer next() {
                if(index<array.length)
                    return array[index++];
                throw new NoSuchElementException();
            }
        };
        return iter;
    }

    @Override
    public int size() {
        return this.array.length;
    }
    private void resize(int elem)
    {
        this.sizeOfArray++;
        int length = this.array.length + 1;
        Integer[] newArray = new Integer[length];
        System.arraycopy(this.array, 0, newArray, 0, this.array.length);
        newArray[this.array.length] = elem;
        Arrays.sort(newArray);
        array = newArray;
    }
    private void delete(int elem)
    {
        sizeOfArray--;
        Integer[] newArray = new Integer[this.array.length-1];
        for(int i = 0, j = 0; i < array.length && j < array.length-1; ++i, ++j)
        {
            if(this.array[i] == elem)
            {
                j--;
                continue;
            }
            newArray[j] = this.array[i];
        }
        this.array = newArray;
    }
}

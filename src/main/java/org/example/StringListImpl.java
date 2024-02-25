package org.example;

import java.util.Arrays;
import java.util.List;

public class StringListImpl implements StringList {
    public String [] countries;
    private int size = 0;
    public StringListImpl() {

        countries = new String[6];
    }
    public StringListImpl (int initsize){
        countries = new String[initsize];
    }

    @Override
    public String add(String item) {
        validateItem(item);
        checkMemory();
        countries[size] = item;
        size++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateIndex(index);
        validateItem(item);
        if (index==size){
            countries[size]=item;
            size++;
            return item;
        }
        System.arraycopy(countries,index,countries,index+1,size-index);
        countries[index]=item;
        size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        validateIndex(index);
        validateItem(item);
        countries[index]=item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);
        int index = indexOf(item);
        if (index==-1) {
            throw new DontFindElementException();
        }
        if (index==size) {
            countries[size--] = null;
            return item;
        }
        System.arraycopy(countries, index + 1, countries, index, size - index-1);
        size--;
        return item;
    }

    @Override
    public String remove(int index) {
        validateIndex(index);
        String item = countries[index];
        if (index==size) {
            countries[size--] = null;
            return item;
        }
        System.arraycopy(countries, index + 1, countries, index, size - index-1);
        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item)>-1;
    }

    @Override
    public int indexOf(String item){
        validateItem(item);
        int result = -1;
        for (int i = 0; i < size; i++) {
            if (countries[i].equals(item)){
                result = i;
            }
        }
        return result;
    }

    @Override
    public int lastIndexOf(String item) {
        validateItem(item);
        int result = -1;
        for (int i = size - 1; i >= 0; i--){
            if (countries[i].equals(item)){
                result = i;
            }
        }
        return result;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return countries[index];
    }

    @Override
    public boolean equals(List<String> stringList) {
        return Arrays.equals(countries, stringList.toArray());
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return (size==0);
    }
    @Override
    public void clear() {
        for (int i = 0; i < countries.length; i++) {
            countries[i]=null;
        }
        size=0;
    }
    @Override
    public String[] toArray() {
        String[] newArray = Arrays.copyOf(countries,size);
        return newArray;
    }
    private void validateItem (String item){
        if (item == null){
            throw new CanNotAddNullException();
        }
    }
    private void validateIndex (int index) {
        if (index < 0 || index > size) {
            throw new IllegalIndexException();
        }
    }
    private void checkMemory(){
        if (size>= countries.length) {
            throw new MemoryIsFullException();
        }
    }
}

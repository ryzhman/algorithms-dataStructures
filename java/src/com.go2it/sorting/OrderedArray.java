package com.go2it.sorting;

public class OrderedArray {
    private int[] m_array;
    private int maxSize;
    private int numElements;

    public OrderedArray(int size) {
        this.maxSize = size;
        this.m_array = new int[size];
        this.numElements = 0;
    }

    public void addInOrder(int item) {
        if (this.numElements == 0) {
            //add the first elem
            this.m_array[numElements++] = item;
        } else if (this.numElements < 0 || this.numElements >= maxSize) {
            return;
        } else if (this.binarySearch(item) >= 0) {
            System.out.println("Element :" + item + " already added");
            return;
        } else {
            this.m_array[numElements++] = item;
            this.insertionSortAsc();
        }
    }

    private void addInOrderSortInPlace(int item) {
        if (this.numElements == 0) {
            //add the first elem
            this.m_array[numElements++] = item;
        } else if (this.numElements < 0 || this.numElements >= maxSize) {
            return;
        } else {
            for (int i = 0; i < this.numElements; i++) {
                // find the place for a new item - search if the current element is bigger than the item
                if (this.m_array[i] > item) {
                    // shift all the rest of elements to the right
                    for (int j = numElements; j >= i; j--) {
                        m_array[j + 1] = m_array[j];
                    }
                    // copy the new item to the i index (proper place), currently, it has the copy of the next elem value
                    this.m_array[i] = item;
                    this.numElements++;
                    break;
                } else {

                    continue;
                }
            }
        }
    }

    private void insertionSortAsc() {
        int n = numElements;
        for (int currentIndex = 1; currentIndex < n; ++currentIndex) {
            int value = m_array[currentIndex];
            int previousElemIndex = currentIndex - 1;

            /* Move elements of arr[0..currentIndex-1], that are
               greater than value, to one position ahead
               of their current position */
            while (previousElemIndex >= 0 && m_array[previousElemIndex] > value) {
                m_array[previousElemIndex + 1] = m_array[previousElemIndex];
                previousElemIndex = previousElemIndex - 1;
            }
            m_array[previousElemIndex + 1] = value;
        }
    }

    public void mergeSortAsc() {
        mergeSortWorker(0,numElements-1);
    }

    private void mergeSortWorker(int lowerBound, int upperBound){
        int mid;
        if (lowerBound<upperBound){
            mid = (lowerBound+upperBound) /2;
            mergeSortWorker(lowerBound,mid) ;
            mergeSortWorker(mid+1,upperBound);
            merge(lowerBound,mid,upperBound);
        }
    }

    private void merge (int low, int mid, int upper){
        int i,j,k;
        int[] temp = new int[upper - low +1];
        i= low; k=0; j=mid+1;
        while (i <= mid && j<=upper){
            if (m_array[i]<m_array[j]){
                temp[k] = m_array[i];
                i++;
            }else{
                temp[k] = m_array[j];
                j++;
            }
            k++;
        }
        while (i<=mid){
            temp[k]=m_array[i];
            k++;i++;
        }
        while (j<=upper){
            temp[k]=m_array[j];
            k++;j++;
        }
        // copy back
        for (i=low;i<=upper;i++){
            m_array[i]=temp[i-low];
        }
    }

    public boolean removeByIndex(int index) {
        if (index < 0 || index >= numElements) {
            return false;
        }
        for (int i = index; i < numElements - 1; i++) {
            m_array[i] = m_array[i + 1];
        }
        numElements--;
        return true;
    }

    public boolean removeItem(int item) {
        int index = this.binarySearch(item);
        if (index == -1) {
            return false;
        } else {
            this.removeByIndex(index);
            return true;
        }
    }

    public int linearSearch(int item) {
        for (int i = 0; i < numElements; i++) {
            if (m_array[i] == item) {
                return i;
            }
        }
        return -1;
    }

    public String listItems() {
        String output = " List :";
        for (int index = 0; index < numElements; index++) {
            output += " " + m_array[index];
        }
        return output;
    }

    public int binarySearch(int item) {
        int left = 0;
        int right = this.m_array.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (this.m_array[middle] == item)
                return middle;

            if (this.m_array[middle] < item) {
                left = middle + 1;

                // If x is smaller, ignore right half
            } else {
                right = middle - 1;
            }
        }

        // if we reach here, then element was
        // not present
        return -1;
    }


    public static void main(String[] args) {
        final OrderedArray orderedArray = new OrderedArray(10);
        orderedArray.addInOrder(10);
        orderedArray.addInOrder(2);
//        System.out.println(orderedArray.listItems());

        orderedArray.addInOrder(11);
        orderedArray.addInOrder(1);
//        System.out.println(orderedArray.listItems());

        orderedArray.addInOrder(0);
        orderedArray.addInOrder(22);
        orderedArray.addInOrder(-1);
        orderedArray.addInOrder(5);
        orderedArray.addInOrder(0);
        orderedArray.addInOrder(77);
        orderedArray.addInOrder(22);
        orderedArray.addInOrder(23);
        System.out.println(orderedArray.listItems());

        orderedArray.mergeSortAsc();
//        orderedArray.removeItem(-1);
        System.out.println(orderedArray.listItems());

    }
}

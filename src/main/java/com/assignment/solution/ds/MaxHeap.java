package com.assignment.solution.ds;

public class MaxHeap implements Heap {

	private int[] heap;
	private int size;

	/**
	 * Instantiates MaxHeap with given capacity
	 * 
	 * @param capacity
	 */
	public MaxHeap(int capacity) {
		this.size = 0;
		heap = new int[capacity];
	}

	/**
	 * Evaluates parent index for given index in the array 
	 * 
	 * @param index
	 * @return
	 */
	private int parent(int index) { 
		return index / 2; 
	}

	/**
	 * Evaluates left child index for given index in the array
	 *  
	 * @param index
	 * @return
	 */
	private int leftChild(int index) { 
		return (2 * index) + 1; 
	}

	/**
	 * Evaluates right child index for given index in the array 
	 * 
	 * @param index
	 * @return
	 */
	private int rightChild(int index) {
		return (2 * index) + 2;
	}

	/**
	 * Evaluates if given index is for a leaf node in the heap
	 * 
	 * @param index
	 * @return
	 */
	private boolean isLeaf(int index) {
		if (index >= (size / 2) && index < size) {
			return true;
		}
		return false;
	}

	/**
	 * Swaps values at specified nodes
	 * 
	 * @param firstindex
	 * @param secondindex
	 */
	private void swap(int firstindex, int secondindex) {
		int temp;
		temp = heap[firstindex];

		heap[firstindex] = heap[secondindex];
		heap[secondindex] = temp;
	}

	/**
	 * Rebalances heap after removal of largest element, if children nodes are 
	 * bigger than parent node, they are swapped
	 * 
	 * @param index
	 */
	private void heapify(int index) {
		if (!isLeaf(index) && (heap[index] < heap[leftChild(index)] || heap[index] < heap[rightChild(index)])) {
			if (heap[leftChild(index)] > heap[rightChild(index)]) {
				swap(index, leftChild(index));
				heapify(leftChild(index));
			} else {
				swap(index, rightChild(index));
				heapify(rightChild(index));
			}
		}
	}

	/**
	 * Used by external clients to insert element into heap
	 */
	@Override
	public void insert(int element) {
		int current = size;
		heap[size++] = element;

		while (heap[current] > heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	/**
	 * Used by external clients to remove largest element from heap
	 */
	@Override
	public int poll() {
		int min = heap[0];
		heap[0] = heap[--size];
		heapify(0);

		return min;
	}

}

package com.assignment.solution.ds;

public class MinHeap implements Heap {
		 
	private int[] heap;
	private int size;

	/**
	 * Instantiates MinHeap with given capacity
	 * 
	 * @param capacity
	 */
	public MinHeap(int capacity) {
		this.size = 0;
		heap = new int[capacity];
	}

	/**
	 * Evaluates parent index for given index in the array 
	 * 
	 * @param index
	 * @return
	 */
	private int parent(int pos) { 
		return pos / 2; 
	}

	/**
	 * Evaluates left child index for given index in the array
	 *  
	 * @param index
	 * @return
	 */
	private int leftChild(int pos) { 
		return (2 * pos) + 1; 
	}

	/**
	 * Evaluates right child index for given index in the array 
	 * 
	 * @param index
	 * @return
	 */
	private int rightChild(int pos) {
		return (2 * pos) + 2;
	}

	/**
	 * Evaluates if given index is for a leaf node in the heap
	 * 
	 * @param index
	 * @return
	 */
	private boolean isLeaf(int pos) {
		if (pos >= (size / 2) && pos < size) {
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
	private void swap(int firstPos, int secondPos) {
		int temp;
		temp = heap[firstPos];

		heap[firstPos] = heap[secondPos];
		heap[secondPos] = temp;
	}

	/**
	 * Rebalances heap after removal of smallest element, if children nodes are 
	 * smaller than parent node, they are swapped
	 * 
	 * @param index
	 */
	private void heapify(int pos) {
		if (!isLeaf(pos) && (heap[pos] > heap[leftChild(pos)] || heap[pos] > heap[rightChild(pos)])) {
			if (heap[leftChild(pos)] < heap[rightChild(pos)]) {
				swap(pos, leftChild(pos));
				heapify(leftChild(pos));
			} else {
				swap(pos, rightChild(pos));
				heapify(rightChild(pos));
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

		while (heap[current] < heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}

	/**
	 * Used by external clients to remove smallest element from heap
	 */
	@Override
	public int poll() {
		int min = heap[0];
		heap[0] = heap[--size];
		heapify(0);

		return min;
	}

}

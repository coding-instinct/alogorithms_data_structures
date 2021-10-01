// Jump Search

// Includes
#include <bits/stdc++.h>

// Function prototyping
int search(int arr[], int n, int x);
int linearSearch(int arr[], int l, int n, int x);

// Main function
int main() {
	int arr[] = {3,4,5,6,7};
	int n = sizeof(arr)/sizeof(arr[0]);
	int x = 7;
	int result = search(arr, n, x);
	std::cout << result;
	return 0;
}

// Jump search function
// optimal step is square root of n
// jumps everytime with step and checks if the value at step
// is less than the element to be found
// if it greater the block between prev and step is finally searched
// using linear search but if element to be found is not in the array
// -1 is returned
// in linear search if element is found index is returned otherwise
// -1 is returned
int search(int arr[], int n, int x) {
	int index = -1, result = 0;
	int step = sqrt(n);

	int prev = 0;

	while(arr[std::min(step, n) - 1] < x) {
		prev = step;
		step += sqrt(n);
		if(prev >= n) {
			return index;
		}
	}

	result = linearSearch(arr, prev, std::min(step, n), x);

	return result;
}


// Linear search from linear-search.cpp with some modification
int linearSearch(int arr[], int l, int n, int x) {
	int index = -1, i = 0;
	for(i=l;i<n;i++) {
		if(arr[i] == x) {
			index = i+1;
			return index;
		}
	}
	return index;
}
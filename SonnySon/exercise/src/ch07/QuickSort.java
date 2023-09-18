package ch07;
public class QuickSort {

    public static void sort(int[] a) {
        l_pivot_sort(a, 0, a.length - 1);
    }

    private static void l_pivot_sort(int[] a, int lo, int hi) {

        if(lo >= hi) {
            return;
        }

        int pivot = partition(a, lo, hi);

        l_pivot_sort(a, lo, pivot - 1);
        l_pivot_sort(a, pivot + 1, hi);
    }

    private static int partition(int[] a, int left, int right) {

        int lo = left;
        int hi = right;
        int pivot = a[left];		// 부분리스트의 왼쪽 요소를 피벗으로 설정

        while(lo < hi) {

            while(a[hi] > pivot && lo < hi) {
                hi--;
            }

            while(a[lo] <= pivot && lo < hi) {
                lo++;
            }

            swap(a, lo, hi);
        }

        swap(a, left, lo);

        return lo;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

package cn.keaper.p912;

/**
 * https://leetcode.com/problems/sort-an-array/
 */
public class Solution {

    public int[] sortArray(int[] nums) {
        return quickSort(nums);
    }

    /**
     * 冒泡排序
     *
     * 数组分为两部分，(有序区，无序区)
     * 无序区中从后向前依次比较相邻元素
     * 一轮比较完成后，无序区中第一个位置就是无序区中最小的位置，即可以变为有序区中的最后一个元素
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定，因为我们始终交换相邻的元素，只要相等元素不交换位置就可以保证稳定，如果相等位置也交换则不稳定
     */
    public int[] bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                if(nums[j] < nums[j - 1]){
                    swap(nums, j, j - 1);
                }
            }
        }
        return nums;
    }

    /**
     * 选择排序
     * 数组分为两部分，(有序区，无序区)
     * 从无序区中找出一个最小的元素，并将其与第一个元素交换，最小的元素即可归到有序区中
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定，不稳定的因素在于选出最小值后被交换的值可能交换到与其相等的值之后
     *          比如，5 8 5 2 9，交换第一个5和2之后就破坏了稳定性
     */
    public int[] selectSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i; j < nums.length; j++) {
                if(nums[min] > nums[j]){
                    min = j;
                }
            }
            if(min != i){
                swap(nums, min, i);
            }
        }
        return nums;
    }

    /**
     * 插入排序
     * 数组分为两部分，(有序区，无序区)
     * 将无序区中的第一个元素插入到有序区中对应位置，需要在有序区中从后往前将元素后移直到找到一个合适位置
     *
     * 时间复杂度：O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：稳定
     *
     */
    public int[] insertSort(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            int key = nums[i];
            int j = i - 1;
            while ((j >= 0) && key < nums[j]){
                nums[j + 1] = nums[j];
                j --;
            }
            nums[j + 1] = key;
        }
        return nums;
    }

    /**
     * 快速排序
     * 分为三步：
     * 1. 将第一个元素作为基准值base
     * 2. 将大于base的值放到数组右边，将小于base的值放到数组左边。实现上，可以使用另一个数组来存排好序的数，
     *      也可以直接使用原数组交换两种元素的位置
     * 3. 递归排序两个子区间的元素
     *
     *
     * 时间复杂度：最好O(N*LongN),最坏O(N^2),平均O(N*LongN),取决于base的选取方式
     * 空间复杂度：取决于实现方式，可以是O(1)
     * 稳定性：不稳定
     */
    public int[] quickSort(int[] nums){
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int l, int r){
        if(l >= r){
            return;
        }
        int i = l, j = r, base = nums[l];
        while (i < j){
            while (i < j && nums[j] > base) j--;
            if(i < j) nums[i++] = nums[j];
            while (i < j && nums[i] < base) i++;
            if(i < j) nums[j--] = nums[i];
        }
        nums[i] = base;
        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);
    }

    /**
     * 归并排序
     * 将数组从中间分开，先递归将左右两边排好序，然后将两个区间合并
     *
     * 时间复杂度：O(N*LogN)
     * 空间复杂度：O(N*LogN),每次递归都要申请O(N)的空间，需要递归LogN次
     * 稳定性：稳定，合并两个区间时，如果元素相等，保证前面区间中的在前即可
     */
    public int[] mergeSort(int[] nums){
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void mergeSort(int[] nums, int l, int r){
        if(l >= r){
            return;
        }
        int m = (l + r) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);
        int[] temp = new int[r - l + 1];
        int i = l, j = m + 1, k = 0;
        while (i <= m && j <= r){
            temp[k++] = nums[i] > nums[j] ? nums[j++] : nums[i++];
        }
        while (i <= m){
            temp[k++] = nums[i++];
        }
        while (j <= r){
            temp[k++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, l, k);
    }


    /**
     * 堆排序
     * 构造一个最大堆，然后将第一个元素也就是最大值排到最后，同时保持堆的结构
     * 依次排好第N个，第N-1个，第N-2个... 直到全部完成
     *
     * 时间复杂度：O(N*LogN)，每次向下调整需要LogN，共需要调整N轮
     * 空间复杂度：O(1)
     * 稳定性：不稳定
     */
    public int[] heapSort(int[] nums){
        // 构造一个最大堆,从最后一个非叶子节点开始向下调整
        for (int i = (nums.length - 1) / 2; i >= 0; i--){
            shiftDown(nums, nums.length, i);
        }

        // 第一个元素已经是最大值，将其交换至最后，并排出堆，对交换后的第一个元素向下调整
        for (int size = nums.length - 1; size >= 0; size--){
            swap(nums, 0, size);  // 将堆顶(最大值)移动到末尾
            shiftDown(nums, size, 0);
        }
        return nums;
    }

    /**
     * 向下调整堆
     * @param size 堆的大小
     */
    public void shiftDown(int[] nums, int size, int index){
        int target = nums[index];
        int father = index, child;
        while ((child = father * 2 + 1) < size){
            if(child + 1 < size && nums[child + 1] > nums[child]) child ++;
            if(target > nums[child]) break;
            nums[father] = nums[child];
            father = child;
        }
        nums[father] = target;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}

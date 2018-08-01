package Base;
//　　堆排序是一种树形选择排序方法，它的特点是：在排序的过程中，将array[0，...，n-1]看成是一颗完全二叉树的顺序存储结构，利用
// 完全二叉树中双亲节点和孩子结点之间的内在关系，在当前无序区中选择关键字最大（最小）的元素。
//
//1. 若array[0，...，n-1]表示一颗完全二叉树的顺序存储模式，则双亲节点指针和孩子结点指针之间的内在关系如下：
//
//　　任意一节点指针 i：父节点：i==0 ? null : (i-1)/2
//
//　　　　　　　　　　  左孩子：2*i + 1
//
//　　　　　　　　　　  右孩子：2*i + 2
//
//2. 堆的定义：n个关键字序列array[0，...，n-1]，当且仅当满足下列要求：(0 <= i <= (n-1)/2)
//
//　　　　　　① array[i] <= array[2*i + 1] 且 array[i] <= array[2*i + 2]； 称为小根堆；
//
//　　　　　　② array[i] >= array[2*i + 1] 且 array[i] >= array[2*i + 2]； 称为大根堆；
//
//3. 建立大根堆：
//
//　　n个节点的完全二叉树array[0，...，n-1]，最后一个节点n-1是第(n-1-1)/2个节点的孩子。对第(n-1-1)/2个节点为根的子树调整，使
// 该子树称为堆。
//
//　　对于大根堆，调整方法为：若【根节点的关键字】小于【左右子女中关键字较大者】，则交换。
//
//　　之后向前依次对各节点（(n-2)/2 - 1）~ 0为根的子树进行调整，看该节点值是否大于其左右子节点的值，若不是，将左右子节点中较大
// 值与之交换，交换后可能会破坏下一级堆，于是继续采用上述方法构建下一级的堆，直到以该节点为根的子树构成堆为止。反复利用上述调整
// 堆的方法建堆，直到根节点。
//
//4.堆排序：（大根堆）
//
//　　①将存放在array[0，...，n-1]中的n个元素建成初始堆；
//
//　　②将堆顶元素与堆底元素进行交换，则序列的最大值即已放到正确的位置；
//
//　　③但此时堆被破坏，将堆顶元素向下调整使其继续保持大根堆的性质，再重复第②③步，直到堆中仅剩下一个元素为止。
//
//堆排序算法的性能分析：
//
//　　空间复杂度:o(1)；
//
//　　时间复杂度:建堆：o(n)，每次调整o(log n)，故最好、最坏、平均情况下：o(n*logn);
//
//　　稳定性：不稳定
public class HeapSort {
    //构建大根堆
    public int[] buidMaxHeap(int[] array) {
        //从最后一个节点array.length-1的父节点(array.length-1-1)/2开始 直到根节点 反复调整堆
        for (int i = (array.length - 2) / 2; i >= 0; i--) {
            adjustDownToUp(array, i, array.length);
        }
        return array;
    }

    //自下向上逐步调整树形结构
    public void adjustDownToUp(int[] array, int k, int length) {
        int tmp = array[k];
        //注意选取左节点，范围是小于length-1
        for (int i = 2 * k + 1; i < length - 1; i = 2 * i + 1) {//i初始化为节点k的左孩子 沿节点较大子节点向下调整
            if (i < length && array[i] < array[i + 1]) {//取节点较大的子节点下标
                i++;
            }
            if (tmp >= array[i]) {//根节点大于等于子节点中较大值 调整结束
                break;
            } else {
                array[k] = array[i];//将较大子节点调整至父节点
                k = i;//关键 修改k值 继续向下调整
            }
        }
        array[k] = tmp;//被调整节点放入最终位置
    }

    public int[] heapsort(int[] array) {
        array = buidMaxHeap(array);//初始大根堆
        //注意最后 i > 1, 最后三数值时无需继续调整
        for (int i = array.length - 1; i > 1; i--) {
            int tmp = array[0];//将堆顶元素和堆底元素交换 最大元素在正确的排序位置
            array[0] = array[i];
            array[i] = tmp;
            adjustDownToUp(array, 0, i);//将剩余元素整理成堆
        }
        return array;
    }

    public void toString(int[] array) {
        for (int i : array) {
            System.out.print(i + "");
        }
    }

    public static void main(String[] args) {
        HeapSort hs = new HeapSort();
        int[] array = new int[]{5, 9, 6, 2, 4, 8, 3, 1, 7};
        hs.toString(hs.heapsort(array));
    }
}

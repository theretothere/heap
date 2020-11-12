import java.util.Arrays;

/**
 * @Version 1.0
 * @Author: Hu
 * @DATE: 2020/11/10 14:28
 * Content:
 */
public class TestHeap {
    public int[] elem;
    public int usedSize;

    public TestHeap(){
        this.elem = new int[10];
    }

    public void adjustDown (int parent,int len){
        int child = 2*parent+1;

        //1、判断是否有左孩子存在
        while(child < len){
            //判断是否有右孩子 如果有 child 保存左右孩子最大值的下标

            if(child +1 <len && elem[child] < elem[child+1]){
                child++;
            }
            //这时候。child中保存的就是最大值的下标
            if(elem[child] > elem[parent]){
                int tmp = 0;
                tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = tmp;
                parent = child;
                child = 2*parent+1;
            }else{
                break;
            }
        }
    }
//    public void adjusUp (int parent,int len){
//        int child = 2*parent+1;
//
//        //1、判断是否有左孩子存在
//        while(child < len){
//            //判断是否有右孩子 如果有 child 保存左右孩子最大值的下标
//
//            if(child +1 <len && elem[child] > elem[child+1]){
//                child++;
//            }
//            //这时候。child中保存的就是最大值的下标
//            if(elem[child] < elem[parent]){
//                int tmp = 0;
//                tmp = elem[child];
//                elem[child] = elem[parent];
//                elem[parent] = tmp;
//                parent = child;
//                child = 2*parent+1;
//            }else{
//                break;
//            }
//        }
//    }
    public void adjustUp(int child){
        int parent = (child-1)/2;
        while(parent >= 0){
            if(elem[child] > elem[parent]){
                int tmp = elem[child];
                elem[child] = elem[parent];
                elem[parent] = elem[child];
                child = parent;
                parent = (child-1)/2;
            }else{
                break;
            }
        }
    }
    public void initHeap (int[] array){
        for (int i = 0; i < array.length; i++) {
            this.elem[i] = array[i];
            this.usedSize++;
        }
        for (int i = (usedSize-1-1)/2; i >= 0 ; i--) {
            adjustDown(i,usedSize);
        }
    }

    public void push(int val){
        if(isFull()){
            this.elem = Arrays.copyOf(this.elem,2*this.elem.length);
            this.elem[this.usedSize] = val;
            this.usedSize++;//11
            adjustUp(this.usedSize-1);
        }
    }
    public boolean isFull(){
        return this.usedSize == this.elem.length;
    }
    public void pop(){
        //0、判空
        if(isEmpty()) return;
        //1、交换堆顶和最后一个元素
        int tmp = this.elem[0];
        this.elem[0] = this.elem[this.usedSize-1];
        this.elem[this.usedSize-1] = tmp;
        this.usedSize--;
        adjustDown(0,usedSize);
    }
    public boolean isEmpty (){
        return this.usedSize == 0;
    }
    public void heapSort(){
        int end = this.usedSize-1;
        while(end > 0){
            int tmp = this.elem[0];
            this.elem[0] = this.elem[end];
            this.elem[end] = tmp;
            adjustDown(0,end);
            end--;
        }
    }
    public void show(){
        for (int i = 0; i < this.usedSize ; i++) {
            System.out.print(this.elem[i]+" ");
        }
        System.out.println();
    }
}

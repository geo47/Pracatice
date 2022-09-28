# Heap Data Structure

[original post](https://asyncq.com/how-to-implement-a-heap-data-structure-in-java)

Heap is a tree-based data structure, and they are a complete binary tree.

The heap data structure is a complete binary tree that satisfies the heap property for the root and the children. This heap is also called a **binary heap**.

There are generally two types of Heap:

#### Max heap:
In Max heap, the root should always be maximum compared to the left and right child, and this is true for all subtrees as well.

![alt text](E:\Development\Java\algorithms\Pracatice\src\figs\max_heap.png)

#### Min heap:
In Min heap, the root should always be minimum, and it is the same for all subtrees as well.

![alt text](E:\Development\Java\algorithms\Pracatice\src\figs\min_heap.png)

- So in general for any ith node in the binary heap array representation, A[i], we can represent the indices of other nodes as shown below.

| Indices         | 	Description                    |
|-----------------|-----------------------------------|
| **A [(i-1)/2]** | 	Represents the parent node     |
| **A[(2*i)+1]**  | 	Represents the left child node |
| **A[(2*i)+2]**  | 	Represents the right child node|

### Use Cases
- When we need quick access to the highest or lowest element from **N** numbers of elements we can achieve it in the **O(1)** operation.
- Heap is optimized for operations such as _Insert_, Find _Min/Max_, and _deletion_ operations compared to other data structures such as LinkedList and Array.

![alt text](E:\Development\Java\algorithms\Pracatice\src\figs\heap_complexity.png)

- Let’s consider one example where we have List of Jobs in the queue where each job has been assigned priority number.
- In this case we can always keep the max priority job at the root and find it in **O(1)** time, while we can remove it as soon as we finish the job and hepify our heap in **O(Log N)** time to get the next max priority Job.


### Heap Implementation In Java
- In Java one of the common ways to build a heap is to use a _PriorityQueue_ implementation.
- PriorityQueue expects the comparator where we can define how we plan to prioritize our element.
- Default ordering is increasing the order of the element. For example, if we keep adding integers to PriorityQueue then the root element will have a min value and it is true for all the subtrees.


#### Min Heap

In the below example we are adding integers to our **PriorityQueue**. Since the default order is increasing order, our root will have a minimum number that is **0** in the below case.

```java
Queue<Integer> pq0 = new PriorityQueue<>();
pq0.add(1);
pq0.add(2);
pq0.add(0);

System.out.println("min element -> "+pq0.peek());
```

- If we remove the top element which is our current min, then the heapify will be performed with **O(log N)** complexity and the second minimum will become the minimum element.

```java
Queue<Integer> pq0 = new PriorityQueue<>();
pq0.add(1);
pq0.add(2);
pq0.add(0);

System.out.println("min element -> "+pq0.peek());
pq0.remove();
System.out.println("min element -> "+pq0.peek());
```

#### Max Heap
- The next type of heap is the Max heap, where root elements keep the max element, and it's also true for its subtrees.
- Since the natural order is increasing order in PriorityQueue, hence we need to create comparator logic for returning the max of two elements.
- Once we have comparator logic we can pass it as a constructor parameter in PriorityQueue.
- Now our PriorityQueue will keep the elements as Max heap.

```java
public static void main(String[] args) {
    Queue<Integer> logic = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer i1, Integer i2){
            return i2-i1;
        }
    });

    Queue<Integer> pq = new PriorityQueue<>(logic);
    pq.add(1);
    pq.add(2);
    pq.add(0);

    System.out.println("max element -> "+pq.peek());
}
```

- If we remove the root element, then the next max will become the root element and will be returned.

```java
Queue<Integer> logic = new PriorityQueue<>(new Comparator<Integer>() {
    @Override
    public int compare(Integer i1, Integer i2){
        return i2-i1;
    }
});

Queue<Integer> pq = new PriorityQueue<>(logic);
pq.add(1);
pq.add(2);
pq.add(0);

System.out.println("max element -> "+pq.peek());
pq.remove();
System.out.println("max element -> "+pq.peek());
```

#### Using Lambda

We can also replace comparator boilerplate code with one-liner crisp lambda.

```java
// using lambda
Queue<Integer> pq1 = new PriorityQueue<>((a,b)-> b - a);
pq1.add(2);
pq1.add(1);
pq1.add(3);
pq1.add(4);

System.out.println("pq max-> "+pq.peek());
```

### Conclusion
- Heap is important data structure to know about since it has good time complexity for insertion/finding/deletion operation compared to other data structures like array and LinkedList,
- Java provides PriorityQueue implementation which we can use to keep the data in the Heap data structure.
- We can pass comparator logic as a lambda function to the PriorityQueue to define the element's priority.
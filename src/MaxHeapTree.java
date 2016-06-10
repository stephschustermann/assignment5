import javax.management.RuntimeErrorException;


public class MaxHeapTree {

	Point[] arr;
	int Size;//number of elements in the heap
	public MaxHeapTree(Point[] arr,int numOfElements,int arrayLength){
		arr= new Point[arrayLength];
		Size=numOfElements;
		
		for (int i=Size/2;i>0;i--)
			Heapify(i);
		
	}
	
	private void Heapify(int index){
		int l=Left(index),r=Right(index);
		int max=index;
		
		if (l<Size && (arr[l].getY() > arr[max].getY()))
			max=l;
		if( r<=Size && (arr[r].getY() > arr[max].getY()))
			max=r;
		if (max!= index)
			UtilsClass.swap(arr, index, max);
			Heapify(max);
	}
	public Point ExtractMax(){
		if (Size==0)
			throw new RuntimeException("Empty Heap");
		Point max=new Point(arr[1]);
		arr[1]=new Point(arr[Size]);
		Size--;
		Heapify(1);
		return max;
	}
	
	private void IncreaseKey(int i, Point key){
		if (key.getY()<arr[i].getY())
			throw new RuntimeException("New key is smaller than current key");
		arr[i]= new Point(key);
		while (i>1 && arr[Parent(i)].getY()< arr[i].getY()){
			UtilsClass.swap(arr, i, Parent(i));
			i=Parent(i);
		}
			
	}
	
	public void HeapInsert(Point key){
		Size++;
		arr[Size]= new Point(Integer.MIN_VALUE,Integer.MIN_VALUE);
		IncreaseKey(Size, key);
	}
	public Point HeapMax(){
		return arr[1]; 
	}
	private int Left(int i){
		return 2*i;
	}
	private int Right(int i){
		return 2*i +1;
	}
	private int Parent(int i){
		return i/2;
	}
}

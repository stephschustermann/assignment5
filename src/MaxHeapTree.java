import javax.management.RuntimeErrorException;


public class MaxHeapTree {
	//TODO :private
	Point[] arr;
	//number of elements in the heap
	int Size;
	public MaxHeapTree(Point[] newArr,int numOfElements,int arrayLength){
		arr= new Point[arrayLength+1];
		Size=numOfElements;
		
		
		for(int i=0;i<numOfElements;i++){
			arr[i+1]=newArr[i];
		}
		
		for (int i=(int) Math.ceil(Size/2);i>0;i--){
			Heapify(i);
		}
	}
	
	private void Heapify(int index){
		int l=UtilsClass.Left(index),r=UtilsClass.Right(index);
		int max=index;
		
		
		if (l<Size && (arr[l].getY() > arr[max].getY())){
			max=l;
		
		}
		if( r<=Size && (arr[r].getY() > arr[max].getY())){
			max=r;

		}
		if (max!= index){
			UtilsClass.swap(arr, index, max);
			Heapify(max);

		}
			
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
		while (i>1 && arr[UtilsClass.Parent(i)].getY()< arr[i].getY()){
			UtilsClass.swap(arr, i, UtilsClass.Parent(i));
			i=UtilsClass.Parent(i);
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
	
	
//	
//	public static void main(String args[]){
//		Point[] points = {
//				new Point(5, 100), 
//				new Point(3, 69),
//				new Point(2, 84),
//				new Point(1, 2),
//				new Point(4, 50),
//				};
//		MaxHeapTree myh=new MaxHeapTree(points, 5, 9);
//		UtilsClass.printarr(myh.arr, 6);
//		myh.HeapInsert(new Point(9,70));
//		UtilsClass.printarr(myh.arr, 7);
//		myh.HeapInsert(new Point(9,105));
//		UtilsClass.printarr(myh.arr, 8);
//		myh.ExtractMax();
//		UtilsClass.printarr(myh.arr, 7);
//	}
}

public class solution{
	
	public static void mergersort(int[] array){

		mergersort(array, 0, array.length-1);
	}

	public static void mergersort(int[] array, int leftStart, int rightEnd){
		if(leftStart >= rightEnd){
			return;
		}
		int middle = (left + right)/2;
		mergersort(array, left, middle);
		mergersort(array, middle+1, rightEnd);
		mergeHalves(array, leftStart, rightEnd);
	}

	public static void mergeHalves(int[] array, int leftStart, int rightEnd){
		int temp = new int[array.length];

		int size = rightEnd - leftStart + 1;

		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
	}
}
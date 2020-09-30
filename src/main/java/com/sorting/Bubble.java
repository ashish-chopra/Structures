public class Bubble
{
	static void bubblesort(int[] arr)
	{
		int n=arr.length,i,j;
		int temp=0;
		for(i=0;i<n-1;i++)
		{
			for(j=1;j<n-i;j++)
			{
				if(arr[j-1]>arr[j])
				{
					temp=arr[j-1];
					arr[j-1]=arr[j];
					arr[j]=temp;
				}
			}
		}
	}
	public static void main(String[] args) {
		int arr[]= {6,3,9,1,78,2,5};
		System.out.println("Before bubble sort");
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
		bubblesort(arr);
		System.out.println("After bubble sort");
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
}

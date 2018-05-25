public class mergeSort{
	static int arr[]={3,1,4,1,5,9,2,6,5};
	static boolean sorted=false;
	static int sort_(){
		int count=0;//=arr.length-1;
			int left=0;//left array position;
			int right=0;//right array position;
			int grThanHalf=0;//the int to count if the right pointer is at 0, if the right pointer is at half, and if the right pointer is at the end;
		while(sorted==false){
			if(count==0){
				if(arr.length%2==0){
					right=1;
				}
				else{
					right=2;
				}
			}
			System.out.print("\t"+left+"||"+right);//THIS IS WHERE THE LEFT AND RIGHT POINTER IS FOR THE SEPARATION AND COMBINATION;
			for(int n=left;n<=right;n++){
				int temp=0;
				if(left!=0&&n==left){n+=1;}
				if(n>0){
					while(arr[n]<arr[n-1]){
						temp=arr[n-1];
						arr[n-1]=arr[n];
						arr[n]=temp;
						if(n>left+1){
							n-=1;
						}
					}
				}
			}
			if(left==0&&right==arr.length-1){
				sorted=true;break;
			}
			count+=1;
			right+=2;
			left=right-1;
			if(right>arr.length){
				right=arr.length;
			}
			if(grThanHalf==2){
				grThanHalf=3;
			}
			if(right>(int)(arr.length*.5)&&grThanHalf==0){
				left=0;
				if(arr.length%2==0){
					right=(int)(arr.length/2)-1;
				}
				else{
					right=(int)(arr.length/2);
				}
				grThanHalf=1;
			}
			if(right>arr.length-1&&grThanHalf==1){
				right=arr.length-1;
				if(arr.length%2==0){
					left=(int)(arr.length/2);
				}
				else{
					left=(int)(arr.length/2)+1;
				}
				grThanHalf=2;
			}
			if(grThanHalf==3){
				left=0;
				right=arr.length-1;
			}
		}
		return 1;
	}
	static public void main(String[] args){
		if(sorted==false){
			for(int n=0;n<arr.length;n++){
				if(n==0){System.out.println("The unsorted array is: ");}
				System.out.print(arr[n]+", ");
			}System.out.print("\nThis is where the left and right pointer is to show the steps of separation and combination per the rules of Merge Sort: ");
			sort_();
		}
		if(sorted==true){
			for(int n=0;n<arr.length;n++){
				if(n==0){System.out.println("\nThe sorted array is: ");}
				System.out.print(arr[n]+", ");
			}
		}
	}
}
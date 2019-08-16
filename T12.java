import java.util.*;

public class T12{
// —°‘Ò≈≈–Ú
    public static void main(String[] args){
	    int[] num = {14,25,6,78,31};
		for(int i=0;i<num.length-1;i++){
		    for(int j=i+1;j<num.length;j++){
			    if(num[i] > num[j]){
				    int temp = num[i];
					num[i] = num[j];
					num[j] =temp;
				}
			}                      
		}
		System.out.print(Arrays.toString(num));
	}
}
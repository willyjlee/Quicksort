package code;

import java.util.Scanner;

/**
 * Created by william_lee on 7/22/16.
 */
public class qsort {

    private static long cnt=0;

    public static void main(String[]args){
        Scanner in = new Scanner(System.in);


        int[]arr=new int[10000];
        for(int i=0;i<arr.length;i++){
            arr[i]=in.nextInt();
        }

        sort(arr, 0, arr.length-1);

//        for(int i=0;i<arr.length;i++){
//            System.out.print(arr[i]+", ");
//        }
        //System.out.println();

        System.out.println(cnt);

    }

    public static void sort(int[]a, int l, int r){
        if(r<=l){
            return;
        }

        cnt+=r-l;

//        int temp=a[l];
//        a[l]=a[r];
//        a[r]=temp;

        int mind = (r -l)/2 + l;
        int mide = a[mind];
        int lefe = a[l];
        int rie = a[r];
        int max = Math.max(mide, Math.max(lefe, rie));
        int min = Math.min(mide, Math.min(lefe, rie));

        int temp = a[l];

        if(mide!=max && mide!= min){
            a[l]=a[mind];
            a[mind]=temp;
        }
        else if(rie!=max && rie!=min){
            a[l]=a[r];
            a[r]=temp;
        }


        int ind = part(a,l,r);

        sort(a, l, ind-1);
        sort(a, ind+1,r);

    }

    public static int part(int[]a, int l, int r){
        //TODO: r > l already
        int p = a[l];
        int i = l+1;
        for(int j=l+1;j<=r;j++){
            if(a[j]<p){
                int tmp = a[i];
                a[i]=a[j];
                a[j]=tmp;
                i++;
            }
        }
        int tmp = a[l];
        a[l]=a[i-1];
        a[i-1]=tmp;
        //cnt+=a.length-1;
        return i-1;
    }

}

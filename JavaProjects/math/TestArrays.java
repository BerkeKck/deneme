import java.math.*;

public class TestArrays {
    public static void main(String[] args) {
         
        int myArray[] = {65,38,46,72,88,35,26};
        int yourArray[] = new int[10];
        String Student []= {"Metin","Onur","Fatma","Ahmet","Yasemin"};

        for(int i=0; i<myArray.length;i++)
            System.out.printf("myArray[i]", myArray[i],"\t");
            System.out.print(" ");
        
        for(int i=0; i<myArray.length;i++)
            yourArray[i]=(int) (Math.random())*100;
            System.out.printf("yourArray[d]=d:",yourArray[i]);

        
        System.out.print(" ");
        for(int j=0; j<Student.length; j++)
            System.out.printf("Students:",Student[j],"\t");
            
} 

    public static int findMax(int a[]) {
        int max=a [0];
        for(int i=1; i<a.length;i++)
            if(a[i]>max)
                max=a[i];
        return max;       
    }

    public static void bubble_sort(int a[]) {
        int i,j,temp;
        for(i=0; i<a.length-1;i++)
            for(j=0;a.length-1;j++)
            if(a[j])
        


        
    }
}


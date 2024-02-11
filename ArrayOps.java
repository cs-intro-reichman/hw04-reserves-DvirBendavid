public class ArrayOps {
    public static void main(String[] args) {
        int [] check =  {10,9,8,7,6,8};
        System.out.println(isSorted(check));
    }
    
    //added contains function.
    public static boolean contains(int [] array , int value){

        for (int i = 0; i < array.length; i++) {
            if(array[i] == value)
                return true;

        }

        return false;

    }

    public static void printArr(int[] arr){
        String ans = "{";
        for (int i = 0; i <arr.length ; i++) {
            ans = (arr.length - 1 == i)? ans+ arr[i] + "}" :ans + arr[i] + ", ";
        }
        System.out.println(ans);
    }

    public static int findMissingInt (int [] array) {

        int num = 1;

        //runs through integers and checks if they appear in the array, break if missing.
        for (int i = 0; i <= array.length; i++) {
            if(!contains(array, i)){
                num = i;
                break;
            }

        }

        return num;
    }

    public static int secondMaxValue(int [] array) {

        int max = array[0];
        int secondMax = 0;
        //goes through the array and check the max and second max values.
        for (int i = 0; i < array.length; i++) {

            if(max <= array[i]){
                secondMax = max;
                max = array[i];
            }

            if(array[i] < max && array[i] > secondMax)
                secondMax = array[i];

        }
        return secondMax;
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {

        //establish bool variables to check whos bigger and for the return value.
        boolean bigger = (array1.length >= array2.length);
        boolean ans = true;

        //if array1 is longer, runs through his elements and check if they appear in array2
        if(bigger) {
            for (int i = 0; i < array1.length; i++) {
                ans = contains(array2, array1[i]);
                if (!ans)
                    break;
            }
        }

        //else runs through array2 elements and check if they appear in array1
        else{

                for (int i = 0; i < array2.length ; i++) {
                    ans = contains(array1, array2[i]);
                    if (!ans)
                        break;
                }
        }

         return ans;
    }

    public static boolean isSorted(int [] array) {

        //assign to booleans whether the first two elements are increasing or decreasing
        boolean incOrder = array[1] >= array[0];
        boolean decOrder = array[1] <= array[0];

        //checks if the array continues to increase/ decrease.
        for (int i = 2; i < array.length; i++) {
            if (incOrder)
                incOrder = array[i] >= array[i - 1];
            if (decOrder)
                decOrder = array[i] <= array[i - 1];
        }
        return (incOrder || decOrder);
    }

}

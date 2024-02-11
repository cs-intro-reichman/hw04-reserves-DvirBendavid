public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        String s = "Hello World";
        int[] arr = allIndexOf(s , 'l');
        ArrayOps.printArr(arr);

    }

    //check if a string contains a specific char
    public static boolean contains(String s , char c){

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == c)
                return true;

        }

        return false;

    }
        // remove all of a given char apearences in a given string.
    public static String removeChar(String s, char c){
        String ans = "";
        for (int i = 0; i <s.length(); i++) {
            char curr = s.charAt(i);
            ans = curr == c? ans: ans+curr;
        }
        return ans;
    }

    //turns a given string to lower case
    public static String Lower(String s){
        String ans ="";
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) >= 97)
                ans += s.charAt(i);
            else
                ans += (char)(s.charAt(i) +32);
        }
        return  ans;
    }

        //turns given char to upper case
    public static char upper(char c){
        if(c >= 97)
            c = (char)(c-32);

        return c;
    }

    //turns given char to lower case
    public static char lower(char c){
        if(c <= 97)
            c = (char)(c+32);

        return c;
    }






    public static String capVowelsLowRest (String string) {

        //establish variables for the return val and vowels
        String ans = "";
        String vow ="aeiou";

        //checks every char and adds it to the answer string
        for (int i = 0; i <string.length() ; i++) {
            char curr = string.charAt(i);

            if(contains(vow , curr)){
               ans = (curr >=97) ? ans + (char)(curr-32) : ans + curr;
            }
            else {
                if(curr == ' ')
                    ans+= ' ';
                else
                    ans = (curr >=97)? ans + curr : ans + (char)(curr+32);
            }
        }
        return ans;
    }

    public static String camelCase (String s) {

        //establish variables for answer, current index and current char.
        String ans ="";
        int j =0;
        char curr = s.charAt(0);

        //avoid space before the words.
        while(curr == ' '){
            j++;
            curr = s.charAt(j);
        }

        // adds the first word all in lower case to the answer.
        while(curr != ' ') {
            ans +=lower(curr);
            j++;
            curr = s.charAt(j);
        }

        //adds the rest of the words, without spaces and capitilizing first chars.
        for(int i = j; i<s.length(); i++){
            curr = s.charAt(i);
            if(curr != ' ' && s.charAt(i-1) == ' ')
                ans+= upper(curr);
            if(curr != ' ' && s.charAt(i-1) != ' ')
                ans+= lower(curr);

        }

        return ans;
    }



    public static int[] allIndexOf (String s, char c) {
        int count =0;
        for (int i = 0; i <s.length(); i++) {
          count = s.charAt(i) == c ? count+1: count;
        }

        int[] arr = new int[count];
        int arrIndex = 0;
        for (int i = 0; i <s.length(); i++) {
            if(s.charAt(i) == c){
                arr[arrIndex] = i;
                arrIndex++;
            }
        }

        return arr;
    }
}

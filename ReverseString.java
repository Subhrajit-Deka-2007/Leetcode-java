public class ReverseString {


    public static void main(String[] args) {
        char[] c ={'h','e','l','o'};
        reverseString(c);
    }
        public static void reverseString(char[] s) {
            int i =0;
            int j = s.length-1;
            char temp;
            while(i<j){
                temp = s[i];
                s[i]=s[j];
                s[j]=temp;
                i++;
                j--;
            }

        }

}

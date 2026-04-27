import java.util.Stack;
public class ReverseWord {
    public static void main(String[] args) {
        String s =" Reverse these word";
        reverseWords(s);
    }
    // Solved with StringBuilder and Stack.
    public static String reverseWords(String s) {

        Stack<String> y = new Stack<>();
        StringBuilder x = new StringBuilder("");

        s = s.trim();
        int i =0;

        for( ; i<s.length() ; i++ )
        {
            if( s.charAt(i) == ' ' )
            {
                if( x.length() == 0 ) continue;
                y.add( x+"" );
                x.setLength( 0 );
            }

            else x.append( s.charAt(i) );

        }

        y.add( x.toString() );
        x.setLength( 0 );

        while ( !y.isEmpty() )
        {
            if ( y.peek().equals("") || y.peek().equals(" ") ) y.pop();

            else if ( y.size() == 1 ) x.append ( y.pop() );

            else x.append( y.pop()+" " );
        }


        String ans = x.toString();
        return ans;
    }
    /*
    Time complexity = O( N + N + SIZE OF THE STACK +N (CONVERSION INTO STRING ) ) { WHERE ZIE OF STACK < S.LENGTH()}
    SPACE COMPLEXITY =O(FOR STRING BUILDER THE MAXIMUM SIZE IS THE ONGEST WORD + STACK SIZE === NUMBER OF WORKDS WHICH IS LESS THEN S.LENGTH()) AND 1<=S.LENGTH()<=10^4 IN WORST CASE
    WHERE THERE ARE 10^4 SIZE LENGTH OF STRING SINCE IT IS A 10^4 SIZE IN THESE CASE WE ARE CONSIDERING
    ONE CHARACTER AND A SPACE BETWEEN EACH ACHARACTER SO NUMBER OF SPACES IN THE STRING WILL BE 10^4/2
    SO NUMBER OF SPACES WILL BE 5000 SINCE 10^4 IS AN EVEN SO NUMBER OF SPACES === NUMBER OF CHARACTERDS IN THESE CASE THERE IS A SINGLE CHARACTER AND THEN SPACE AND THEN SINGLE CHARACTER AND THEN SPACE SO
    STACK SIZE WILL BE MAXIMUM O(5000+ STRINGBUILDER SIZE WHICH IS ONE FOR EACH FOR THESE CASE )
    SO SPCAE COMPLEXITY IS O(N/2) WHEN N = EVEN AND FOR ODD IT IS O(N/2) BUT IN CASE OF ODD WE WILL NOT CODIDER THE DECIMAL
    SO OVERALL TIME COMPLEXITY IS O(N)
    AND SPACE COMPLEXITY IS O(N)
    */
}
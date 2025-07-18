import java.util.Queue;
import java.util.LinkedList;

public class Frog {

    public int count=0;
    public Node S0 = new Node(0,"222-111");
    public Queue<Node> queue = new LinkedList<>();

    public Frog (){
        queue.add(S0);

        while ( !queue.isEmpty()){

            func(queue.poll());


        }
    }

    public void func (Node n){
        checker(n.data,n);
    }


    public void checker(String s, Node n ){
        // Split the string by space
        // Split the string into an array of characters
        char[] characters = s.toCharArray();

        // Print each character
        if (characters[0]=='2' && characters[2]=='-'){
            count++;

            String ss = swap(0,2,s);

            n.children.add(new Node(count ,ss));
            queue.add(new Node(count ,ss ));

            System.out.println(ss);

        }
        if (characters[1]=='2' && characters[3]=='-') {
            count++;

            String ss = swap(1,3,s);

            n.children.add(new Node(count ,ss));
            queue.add(new Node(count ,ss ));
            System.out.println(ss);
        }

        if (characters[2]=='2' && characters[4]=='-') {
            count++;

            String ss = swap(2,4,s);

            n.children.add(new Node(count ,ss));
            queue.add(new Node(count ,ss ));

            System.out.println(ss);

        }
        if (characters[3]=='2' && characters[5]=='-') {
            count++;


            String ss = swap(3,5,s);

            n.children.add(new Node(count ,ss));
            queue.add(new Node(count ,ss ));

            System.out.println(ss);

        }
        if (characters[4]=='2' && characters[6]=='-') {
            count++;


            String ss = swap(4,6,s);

            n.children.add(new Node(count ,ss));
            queue.add(new Node(count ,ss ));
            System.out.println(ss);

        }



        if (characters[0]=='2' && characters[1]=='-') {
            count++;


            String ss = swap(0,1,s);

            n.children.add(new Node(count ,ss));
            queue.add(new Node(count ,ss ));
            System.out.println(ss);

        }
        if (characters[1]=='2' && characters[2]=='-') {
            count++;


            String ss = swap(1,2,s);

            n.children.add(new Node(count ,ss));
            queue.add(new Node(count ,ss ));

            System.out.println(ss);

        }
        if (characters[2]=='2' && characters[3]=='-') {
            count++;


            String ss = swap(2,3,s);

            n.children.add(new Node(count ,ss));
            queue.add(new Node(count ,ss ));

            System.out.println(ss);

        }
        if (characters[3]=='2' && characters[4]=='-') {
            count++;


            String ss = swap(3,4,s);

            n.children.add(new Node(count ,ss));
            queue.add(new Node(count ,ss ));
            System.out.println(ss);



        }
        if (characters[4]=='2' && characters[5]=='-') {
            count++;



            String ss = swap(4,5,s);

            n.children.add(new Node(count ,ss));
            queue.add(new Node(count ,ss ));
            System.out.println(ss);


        }
        if (characters[5]=='2' && characters[6]=='-') {
            count++;

            String ss = swap(5,6,s);

            n.children.add(new Node(count ,ss));
            queue.add(new Node(count ,ss ));

            System.out.println(ss);
        }





        if (characters[6]=='1' && characters[5]=='-') {
            count++;

            String ss = swap(6,5,s);

            n.children.add(new Node(count ,ss));
            queue.add(new Node(count ,ss ));

            System.out.println(ss);

        }
        if (characters[5]=='1' && characters[4]=='-') {
            count++;

            String ss = swap(5,4,s);

            n.children.add(new Node(count ,ss));
            queue.add(new Node(count ,ss ));

            System.out.println(ss);

        }
        if (characters[4]=='1' && characters[3]=='-') {
            count++;

            String ss = swap(4,3,s);

            n.children.add(new Node(count ,ss));
            queue.add(new Node(count ,ss ));
            System.out.println(ss);


        }
        if (characters[3]=='1' && characters[2]=='-') {
            count++;
            String ss = swap(3,2,s);







            n.children.add(new Node(count ,ss ));
            queue.add(new Node(count ,ss ));

            System.out.println(ss);
        }
        if (characters[2]=='1' && characters[1]=='-') {
            count++;
            String ss = swap(2,1,s);

            n.children.add(new Node(count , ss));
            queue.add(new Node(count ,ss ));
            System.out.println(ss);

        }
        if (characters[1]=='1' && characters[0]=='-') {
            count++;
            String ss = swap(1,0,s);


            n.children.add(new Node(count ,ss ));

            queue.add(new Node(count ,ss ));
            System.out.println(ss);

        }




        if (characters[6]=='1' && characters[4]=='-') {
            count++;
            String ss = swap(6,4,s);


            n.children.add(new Node(count ,ss ));

            queue.add(new Node(count ,ss ));
            System.out.println(ss);

        }
        if (characters[5]=='1' && characters[3]=='-') {
            count++;
            String ss = swap(5,3,s);


            n.children.add(new Node(count ,ss ));

            queue.add(new Node(count ,ss ));
            System.out.println(ss);

        }
        if (characters[4]=='1' && characters[2]=='-') {
            count++;
            String ss = swap(4,2,s);


            n.children.add(new Node(count ,ss ));

            queue.add(new Node(count ,ss ));
            System.out.println(ss);

        }
        if (characters[3]=='1' && characters[1]=='-') {
            count++;
            String ss = swap(3,1,s);


            n.children.add(new Node(count ,ss ));

            queue.add(new Node(count ,ss ));

            System.out.println(ss);

        }
        if (characters[2]=='1' && characters[0]=='-') {
            count++;
            String ss = swap(2,0,s);


            n.children.add(new Node(count ,ss ));

            queue.add(new Node(count ,ss ));
            System.out.println(ss);

        }








    }
    public String swap (int one , int two,String s ){
        char[] charArray = stringToCharArray(s);
        char temp =charArray[one];
        charArray[one]=charArray[two];
        charArray[two]=temp;

        String f = charArrayToString(charArray);

        return f;






    }
    public  String charArrayToString(char[] charArray) {
        // Create a StringBuilder to concatenate characters
        StringBuilder sb = new StringBuilder();

        // Append each character from the array to the StringBuilder
        for (char c : charArray) {
            sb.append(c);
        }

        // Convert StringBuilder to String and return
        return sb.toString();
    }
    public  char[] stringToCharArray(String str) {
        // Create a character array with the same length as the string
        char[] charArray = new char[str.length()];

        // Copy each character from the string to the array
        for (int i = 0; i < str.length(); i++) {
            charArray[i] = str.charAt(i);
        }

        return charArray;
    }
    public static String swapCharacters(String str, int index1, int index2) {
        if (str == null || index1 < 0 || index2 < 0 || index1 >= str.length() || index2 >= str.length()) {
            // Handle invalid indices or null string
            return str;
        }

        // Convert the string to a StringBuilder
        StringBuilder sb = new StringBuilder(str);

        // Swap characters at index1 and index2
        char temp = sb.charAt(index1);
        sb.setCharAt(index1, sb.charAt(index2));
        sb.setCharAt(index2, temp);

        // Convert StringBuilder back to String
        return sb.toString();
    }




}

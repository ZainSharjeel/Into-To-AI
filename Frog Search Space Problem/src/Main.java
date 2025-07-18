public class Main {
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
    public static void main(String[] args) {
        System.out.println("States Explored:");

        Frog f = new Frog();

    }
}
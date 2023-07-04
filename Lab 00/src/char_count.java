public class char_count {
    public int charCount(char c, String s){
        int count = 0;
        char[] charArray = s.toCharArray();
        for (int i=0; i< charArray.length;i++){
            if(c==charArray[i]){
                count++;
            }
        }
        return count;
    }
}

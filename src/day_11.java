public class day_11 {
    public static void main(String[] args) {
        String name = "abhishek";
        removeA("",name);
    }
     static void removeA(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        if (ch != 'a') {
            p = p + ch;
        }
        removeA(p,up.substring(1));
    }
}

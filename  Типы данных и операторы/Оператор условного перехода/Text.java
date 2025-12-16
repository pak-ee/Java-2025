public class Practice1 {
    public static void main(String[] args) {
        int a = 2; // для проверки просто меняй a: 1, 2, 5...
        
        // То же самое, что if/else if/else из задания:
        // - если a == 1, то i = 1
        // - иначе если a == 2, то i = 2
        // - иначе i = 3
        int i = (a == 1) ? 1 : (a == 2) ? 2 : 3;

        System.out.println("a = " + a + ", i = " + i);
    }
}


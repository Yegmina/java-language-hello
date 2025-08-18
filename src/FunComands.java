public class FunComands {
    public static void say(String... local_lines) {
        if  (local_lines.length == 0){
            System.out.println("There is nothing to say. Error, kinda. The code was silent...");
        }
        else if  (local_lines.length == 1){
            System.out.println(local_lines[0]);

        }
        else {
            for (String localLine : local_lines) {
                System.out.println(localLine);
            }
        }
    }
    public static void adventofcodetype(int n) {
        // n is number of lines in Christmas tree
        String local_line="";

        for (int i=0; i<n; i++){
            local_line=" ".repeat(n-i) + "*".repeat(1+i*2);
            FunComands.say(local_line);

        }

    }

}

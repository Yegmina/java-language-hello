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

}

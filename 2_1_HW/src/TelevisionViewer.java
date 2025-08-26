public class TelevisionViewer {
    public static void main(String[] args) {
        Television myTV = new Television();
        myTV.setCurrentChannel(1);

        for (int day = 1; day <= 10; day++) {
            System.out.println("Woke up, day " + day);

            boolean tired = false;

            if (!myTV.isOn())
                myTV.pressOnOff();

            while (!tired) {
                myTV.printWatchinChannel();
                myTV.setNextChannel();
                if (myTV.getChannel() % 4 == 0)
                    tired = true;
            }

            myTV.pressOnOff();

            System.out.println("Falling asleep");
        }
    }
}
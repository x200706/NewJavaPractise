import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

//代碼指導：ChatGPT
public class SnakeGame {
  public void result() { // throws IOException, InterruptedException
    System.out.println("該程式不提供預覽：");
    System.out.println("該支程式由於JLine非阻塞輸入一直搞不定，決定改用Swing製作，玩家也應該會有比較好視覺跟操作體驗");
    System.out.println("");
    // Terminal terminal = TerminalBuilder.builder()
    // .jna(true)
    // .system(true)
    // .build();
    // terminal.enterRawMode();
    // LineReader reader = LineReaderBuilder.builder()
    // .terminal(terminal)
    // .build();

    // final int WIDTH = 40; // 遊戲區寬度
    // final int HEIGHT = 20; // 遊戲區高度

    // int snakeX = WIDTH / 2; // 蛇頭的x座標
    // int snakeY = HEIGHT / 2; // 蛇頭的y座標
    // int[] snakeXs = new int[WIDTH * HEIGHT]; // 蛇身體每個部分的x座標
    // int[] snakeYs = new int[WIDTH * HEIGHT]; // 蛇身體每個部分的y座標

    // int appleX = (int) (Math.random() * WIDTH); // 蘋果的x座標
    // int appleY = (int) (Math.random() * HEIGHT); // 蘋果的y座標
    // int direction = 1; // 蛇的移動方向（1：向右，2：向下，3：向左，4：向上）
    // int snakeLength = 3; // 蛇的初始長度

    // while (true) {
    // clearConsole();

    // // 繪製遊戲區
    // for (int i = 0; i < HEIGHT + 2; i++) {
    // for (int j = 0; j < WIDTH + 2; j++) {
    // if (i == 0 || i == HEIGHT + 1 || j == 0 || j == WIDTH + 1) {
    // System.out.print("#");
    // } else if (i == snakeY && j == snakeX) {
    // System.out.print("O");
    // } else if (i == appleY && j == appleX) {
    // System.out.print("@");
    // } else {
    // System.out.print(" ");
    // }
    // }
    // System.out.println();
    // }

    // // 接收方向輸入
    // String[] cmd = {"/bin/sh", "-c", "stty raw -echo"};
    // Runtime.getRuntime().exec(cmd).waitFor();
    // if (System.in.available() > 0) {
    // char key = reader.readLine(""); //用空字串當遮罩？
    // if (key == 'w' && direction != 2) {
    // direction = 4;
    // } else if (key == 's' && direction != 4) {
    // direction = 2;
    // } else if (key == 'a' && direction != 1) {
    // direction = 3;
    // } else if (key == 'd' && direction != 3) {
    // direction = 1;
    // }
    // }
    // String[] cmd2 = {"/bin/sh", "-c", "stty cooked"};
    // Runtime.getRuntime().exec(cmd2).waitFor();

    // // 更新蛇的位置
    // for (int i = snakeLength - 1; i > 0; i--) {
    // snakeXs[i] = snakeXs[i - 1];
    // snakeYs[i] = snakeYs[i - 1];
    // }

    // snakeXs[0] = snakeX;
    // snakeYs[0] = snakeY;

    // // 更新蛇頭的位置
    // switch (direction) {
    // case 1:
    // snakeX++;
    // break;
    // case 2:
    // snakeY++;
    // break;
    // case 3:
    // snakeX--;
    // break;
    // case 4:
    // snakeY--;
    // break;
    // }

    // // 檢查是否吃到蘋果
    // if (snakeX == appleX && snakeY == appleY) {
    // snakeLength++;
    // appleX = (int) (Math.random() * WIDTH);
    // appleY = (int) (Math.random() * HEIGHT);
    // }

    // // 檢查是否撞牆或撞到自己
    // if (snakeX < 1 || snakeX > WIDTH || snakeY < 1 || snakeY > HEIGHT) {
    // break;
    // }

    // // 檢查是否撞到自己
    // if (snakeLength > 3) {
    // for (int i = 1; i < snakeLength; i++) {
    // if (snakeX == snakeXs[i] && snakeY == snakeYs[i]) {
    // break;
    // }
    // }
    // }

    // Thread.sleep(100); // 調整此數值以控制遊戲速度
    // }

    // System.out.println("遊戲結束");
    // terminal.close();
  }

  // public void clearConsole() throws IOException {
  // if (System.getProperty("os.name").contains("Windows")) {
  // try {
  // new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
  // } catch (InterruptedException e) {
  // e.printStackTrace();
  // }

  // } else {
  // System.out.print("\033\143");
  // }
  // }
}

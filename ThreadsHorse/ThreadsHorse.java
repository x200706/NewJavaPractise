import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

class ThreadsHorse {
  public void result() {
    String horseBanner = """
                                                         #    #
                                                    %%% ##   ##
                                                 %%%%% ###%%###
                                                %%%%% ### %%% #
                                              %%%%%% ### %%% ###
                                               %%%% ## %% #######
                                              %%%%% # %% #O#####
                                            %%%%%% # % #########
                                           %%%%% ##### #########
                                 ###        %% ####### #########
                        %%% ############    ########### ########
                     %%%% ############################### #######
                   %%%%% ################################## ######
                 %%%%%% #################################### #C###
                %%%%%% #####################################  ###
                %%%%% #######################################
               %%%%%% ###########【多執行緒賽馬v1.0】#########
            % %%%%%%% ########################################
             %%%%%%%%% #######################################
            %%%%%%%%%% ########################################
         %%% %%%%%%%%   ###### ################################
           %%%%%%%%      ###### #################### ##########
        % %%%%%%%%        ####### ########### ###### ##########
         %%%%%%%%%         #######  ########### ###### ########
        %%%%%%%%%%          ##### ###  ######### ####### ######
         %%%%%%%%%%          #### ##               ####### ####
         %%%%%%%%%%%           ## #                  ##### ###
          %%  %% % %%         # ##                      ## ###
            %   %    %        # ###                      # ###
                               # ###                     ## ###
                               # ###                     ## ###
                               # ####                   #### ##
                              ### ###                  ##### ###
                             ####  ###                 ####   ##
                            #####   ###                 ##    ##
                           #####    ####                      ###
                            ##        ###                     ###
                                       ####                     ##
                                        ####                    ###
                                                                ####
                                                                 ##
         開始遊戲，請輸入一個你看好的馬匹編號（有1, 2, 3, 4, 5）：
                                """;
    System.out.println(horseBanner);

    // 遊戲正題
    Scanner scanner = new Scanner(System.in);
    String userInputHN = scanner.nextLine();
    // 檢查輸入是否為1~5的數字
    while (!(userInputHN.equals("1") ||
        userInputHN.equals("2") ||
        userInputHN.equals("3") ||
        userInputHN.equals("4") ||
        userInputHN.equals("5"))) {
      System.out.println("沒有這匹馬，請重新輸入：");
      userInputHN = scanner.nextLine();
    }

    // 過場動畫，賽馬競賽中
    try {
      int anime = 1;
      for (int j = 0; j <= 5; j++) { // 動畫會進行影格前進4次欸
        switch (anime) {
          case 1:
            System.out.print("\r/うま 彡^･∋\\");
            break;
          case 2:
            System.out.print("\r \\うま 彡^･∋/");
            break;
          case 3:
            System.out.print("\r  /うま 彡^･∋\\");
            break;
          case 4:
            System.out.print("\r   \\うま 彡^･∋/");
            break;
          case 5:
            System.out.print("\r    /うま 彡^･∋\\");
            break;
          default:
            anime = 0;
            System.out.print("\r結果出爐         ");
        }
        anime++;
        Thread.sleep(400);
      }
      System.out.println("");

      // 執行緒池建造
      ExecutorService executorService = Executors.newFixedThreadPool(5);

      // 紀錄賽馬過終點線順序的List
      ArrayList<String> horsePassGoal = new ArrayList<String>();

      // 創造馬並隨機干擾賽馬的行為
      IntStream.rangeClosed(1, 5).parallel().forEach(i -> {
        try {
          String horseNum = executorService.submit(() -> {
            Thread.currentThread().sleep((int)(Math.random()*100)+1); //其實這邊不太合理欸，哪有賽馬會在場上睡覺== 比較接近的是設置優先權？
            Thread.currentThread().setName(Integer.toString(i));
            return Thread.currentThread().getName();
          }).get(); // 這邊是利用Future取得Runnable的回傳值
          horsePassGoal.add(horseNum);
        } catch (Exception e) {
          e.printStackTrace();
        }
      });

      // 遊戲結果
      String winHorse = horsePassGoal.get(0);
      for (int i = 0; i < 5; i++) {
        System.out.println("第" + (i + 1) + "名是：" + horsePassGoal.get(i) + "號碼匹");
      }
      System.out.println("");
      System.out.println("勝利的馬匹是：" + winHorse + "號");
      if (userInputHN.equals(winHorse)) {
        System.out.println("中獎啦！遊戲結束");
      } else {
        System.out.println("銘謝惠顧，下次再來");
      }
      System.out.println("");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
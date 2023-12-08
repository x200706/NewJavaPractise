class HorseAnimeTest {
  public void result() throws InterruptedException {
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
  }
}
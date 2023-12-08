class AnimeTest {
  public void result() throws InterruptedException {
    int anime = 1;
    for (int j = 0; j <= 3; j++) { // 動畫會進行影格前進4次欸
      switch (anime) {
        case 1:
          System.out.print("\rA");
          break;
        case 2:
          System.out.print("\rAB");
          break;
        case 3:
          System.out.print("\rABC");
          break;
        default:
          anime = 0;
          System.out.print("\r   ");
      }
      anime++;
      Thread.sleep(400);
    }
    System.out.println("");
  }
}
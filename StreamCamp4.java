import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.*;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

class StreamCamp4 { // 情境題：分類傳來消息的人是否非聯絡人
  public void result() {
    // 這是一個收到訊息的API傳來的內容物
    String receiverId = "1"; // 收件人ID及當前登入者本人，假裝來自session
    String senderId = "6"; // 寄件人ID
    String messege = "你好啊！"; // 訊息內容

    // 查出當前會員資料
    List<UserDetails> getAllUserDetails = Arrays.asList( // 這邊只是模擬DB假資料列
        new UserDetails("1", "Vivi", "2,3,4,5"), // 要互為好友才能加入contact
        new UserDetails("2", "Sam", "1,3,4,6"),
        new UserDetails("3", "Gaga", "1,2,5,4,6"),
        new UserDetails("4", "Kiki", "1,2,3,5,6"),
        new UserDetails("5", "Paul", "1,3,4,6"),
        new UserDetails("6", "Tom", "2,3,4,5"));

    // 查出當前登入者會員資料
    UserDetails receiverDetail = getAllUserDetails.stream().filter(user -> user.getId().equals(receiverId)).findFirst()
        .get();
    // 以上雖然有用Stream但跟練習無關，只是模擬DAO查出這個人的會員資訊方法結果，一般用ORM可能是findById()這種方法

    // 中間想法飄掉了，Stream應該是無法或得兩個條件不同的兩個資料...？自然也沒有幻想中跑遍整座森林的疑慮了...

    // 判斷是否非聯絡人
    Boolean isStranger = Stream.of(receiverDetail.getContact()) // 創造聯絡人Stream
        .map(contact -> contact.split("")) // 先切聯絡人
        .flatMap(Arrays::stream) // 創造新Stream才能繼續中間操作
        .noneMatch(id -> id.equals(senderId));

    // 印結果
    String isOrNot = isStranger ? "是" : "不是";
    System.out.println(receiverId + "跟" + senderId + isOrNot + "陌生人");

  } // 我是result方法的結尾

} // 我是Class結尾

@Data
@AllArgsConstructor
@NoArgsConstructor
class UserDetails {
  private String id;
  private String name;
  private String contact; // 聯絡人 如1,2,3
}

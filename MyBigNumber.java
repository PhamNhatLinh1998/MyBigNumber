/**
 * Tác giả: Phạm Nhật Linh.
 * Desrciption.
 * Class MyBigNumber là lớp để tính tổng của 2 số s1 và s2.
 * Hàm sum trong Class MyBigNumber là hàm để thực hiện phép cộng 2 chuỗi số.
 */
 
public class MyBigNumber {
    
    /**
     * Khi thực hiện cộng 2 số, ta cần 2 chuỗi làm tham số cho hàm sum khi đó:
     * 2 chuỗi này chứa các kí số từ '0' đến '9'.
     * @param s1 chuỗi số thứ nhất.
     * @param s2 chuỗi số thứ hai.
     * @return chuỗi có giá trị là tổng của hai số s1 và s2 được truyền vào.
     */
    
    public String sum(final String s1,final String s2) {
        // Khai báo biến
        
        String finalResult = "";// biến nhận kết quả trả về                    
        int len1 = s1.length();// độ dài chuỗi thứ nhất                     
        int len2 = s2.length();// độ dài chuỗi thứ hai                      
        int maxlen = (len1 > len2) ? len1 : len2;// so sánh độ dài chuỗi
        int index1;// Vị trí chuỗi 1                                   
        int index2;// Vị trí chuỗi 2
        char c1;// Lấy kí tự ở vị trí cuối cùng của chuỗi s1
        char c2;// Lấy kí tự ở ví trí cuối cùng của chuỗi s2
        int sonho = 0;// biến ghi lại số nhớ khi cộng 2 số lớn hơn 9                                   
        int s = 0;// Khởi tạo biến tổng bằng 0                                        
        // Vòng lặp từ 0 đến chuỗi có độ dài lớn nhất
        for (int i = 0; i < maxlen; i++) {
            index1 = len1 - i - 1;// Lấy vị trí của chuỗi s1                       
            index2 = len2 - i - 1;// Lấy vị trí của chuỗi s2 
            c1 = (index1 >= 0) ? s1.charAt(index1) : '0';// Lấy kí tự từ phải sang trái của chuỗi s1
            c2 = (index2 >= 0) ? s2.charAt(index2) : '0';// Lấy kí tự từ phải sang trái của chuỗi s2
            s = (c1 - '0') + (c2 - '0') + sonho;// Biến đổi kí tự thành số rồi cộng                 
            finalResult = (s % 10) + finalResult;// Lấy s chia dư rồi cộng vào kết quả                               
            sonho = s / 10;// Cập nhật lại số nhớ
        }
        if (sonho >= 1) {                              
            finalResult = 1 + finalResult;// Nếu cuối cùng còn số nhớ thì ghép vào trước kết quả          
        }
        
        return finalResult;// Trả về kết quả cuối cùng
    }
}
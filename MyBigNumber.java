import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tác giả: Phạm Nhật Linh.
 * Desrciption.
 * Class MyBigNumber là lớp để tính tổng của 2 số s1 và s2.
 * Hàm sum trong Class MyBigNumber là hàm để thực hiện phép cộng 2 chuỗi số.
 */
 
public class MyBigNumber {
	
    private IReceiver ireceiver;

    public MyBigNumber(final IReceiver ireceiver) {
        this.ireceiver = ireceiver;
    }
	
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
        String msg = "";// Chuoi msg se lam tham so cho ham send cua interface IReceiver		
        int len1 = s1.length();// độ dài chuỗi thứ nhất                     
        int len2 = s2.length();// độ dài chuỗi thứ hai                      
        int maxlen = (len1 > len2) ? len1 : len2;// so sánh độ dài chuỗi
        int index1;// Vị trí chuỗi 1                                   
        int index2;// Vị trí chuỗi 2
        char c1;// Lấy kí tự ở vị trí cuối cùng của chuỗi s1
        char c2;// Lấy kí tự ở ví trí cuối cùng của chuỗi s2
        int sonho = 0;// biến ghi lại số nhớ khi cộng 2 số lớn hơn 9                                   
        int s = 0;// Khởi tạo biến tổng bằng 0  
        // Dùng Matcher kết hợp với pattern để tìm các kí tự đặc biết trong 2 chuỗi
        Pattern pattern1 = Pattern.compile("[!@#$%&*()_+=|<>?{}\\\\[\\\\]~]");
        final Matcher matcher1 = pattern1.matcher(s1);
        Pattern pattern2 = Pattern.compile("[!@#$%&*()_+=|<>?{}\\\\[\\\\]~]");
        final Matcher matcher2 = pattern1.matcher(s2);
        int hieu = 0;
        
        // Kiểm tra số âm
        if (s1.charAt(0) == '-') {
            throw new NumberFormatException("Chưa hỗ trợ số âm s1: " + s1);
        } 
        
        if (s2.charAt(0) == '-') {
            throw new NumberFormatException("Chưa hỗ trợ số âm s2: " + s2);
        }

        // Kiểm tra từng kí tự của 2 chuỗi s1 và s2 có chữ không 
        for (int i = 0; i < len1; i++) {

            if (Character.isLetter(s1.charAt(i))) {
                // Nếu chuỗi s1 có chữ hoặc kí tự thì sẽ có NumberFormatException
                throw new NumberFormatException("Vị trí " + (i + 1) + " trong chuỗi " + s1
                        + " không phải là số");
            }
        }

        for (int i = 0; i < len2; i++) {

            if (Character.isLetter(s2.charAt(i))) {
                // Nếu chuỗi s2 có chữ hoặc kí tự thì sẽ có NumberFormatException
                throw new NumberFormatException("Vị trí " + (i + 1) + " trong chuỗi " + s2
                        + " không phải là số");
            }
        }

        // Nếu hàm matcher.find() là đúng tức là trong chuỗi s1 có kí tự đặc biệt
        if (matcher1.find()) {
            throw new NumberFormatException("Vị trí " + (matcher1.start() + 1) + " trong chuỗi " + s1
                    + " không phải là số");
        }

        if (matcher2.find()) {
            throw new NumberFormatException("Vị trí " + (matcher2.start() + 1) + " trong chuỗi " + s2
                    + " không phải là số");
        }
		
        // Vòng lặp từ 0 đến chuỗi có độ dài lớn nhất
        for (int i = 0; i < maxlen; i++) {
            index1 = len1 - i - 1;// Lấy vị trí của chuỗi s1                       
            index2 = len2 - i - 1;// Lấy vị trí của chuỗi s2 
            c1 = (index1 >= 0) ? s1.charAt(index1) : '0';// Lấy kí tự từ phải sang trái của chuỗi s1
            c2 = (index2 >= 0) ? s2.charAt(index2) : '0';// Lấy kí tự từ phải sang trái của chuỗi s2
            s = (c1 - '0') + (c2 - '0') + sonho;// Biến đổi kí tự thành số rồi cộng                 
            finalResult = (s % 10) + finalResult;// Lấy s chia dư rồi cộng vào kết quả                               
            sonho = s / 10;// Cập nhật lại số nhớ
			
			msg = "Step " + (i + 1) + ": " + c1 + " + " + c2 + " = "
                    + (tong - nho) + " + " + nho + " = " + tong + " . Write " + (tong % 10) + " remember " + nho;
            this.ireceiver.send(msg);
			
        }
        if (sonho >= 1) {                              
            finalResult = 1 + finalResult;// Nếu cuối cùng còn số nhớ thì ghép vào trước kết quả          
        }
        
        return finalResult;// Trả về kết quả cuối cùng
    }
}
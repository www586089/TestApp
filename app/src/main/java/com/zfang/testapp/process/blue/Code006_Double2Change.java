package com.zfang.testapp.process.blue;


import com.zfang.testapp.process.util.LogUtil;

/**
 * P8 题6: 0~1间浮点实数的二进制表示
 * 给定一个介于0和1之间的实数，(如0.625) ，类型为double,
 * 打印它的二进制表示(0.101,因为小数点后的二进制分别表示0.5,0.25.0.12.....)。
 * 如果该数字无法精确地用32位以内的二进制表示，则打印“ERROR”
 */
public class Code006_Double2Change {
    private static final Code006_Double2Change app = new Code006_Double2Change();

    public static void main(String[] args) {
        app.result();
    }

    private void result() {
        String result = numberSwap(0.625);
        LogUtil.println("result1 = " + result);

        result = numberSwap(0.3);
        LogUtil.println("result2 = " + result);

        result = numberSwap(0.6875);
        LogUtil.println("result3 = " + result);
    }

    /**
     *
     * @param x
     * @return
     */
    private String numberSwap(double x) {
        StringBuilder result = new StringBuilder("0.");
        while (x > 0) {
            x *= 2;
            if (x >= 1) {
                x = x - 1;
                result.append("1");
            } else {
                result.append("0");
            }
            if (result.length() > 34) {
                return "ERROR";
            }
        }
        return result.toString();
    }
}

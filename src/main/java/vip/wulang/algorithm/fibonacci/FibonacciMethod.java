package vip.wulang.algorithm.fibonacci;

import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FibonacciMethod {
    public static void main(String[] args) throws Exception {
        Path path = Paths.get(URI.create("file:///Users/wulang/IdeaProjects/Algorithm/src/vip/wulang/algorithm/fibonacci/FibonacciMethod.txt"));
        double[] f = new double[Integer.MAX_VALUE >> 16];
        f[0] = f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i - 1] + f[i - 2];
            String str = "当前 " + i + " 项：" + (f[i - 1] / f[i]) + "\r\n";
            Files.writeString(path, str, Charset.defaultCharset(), StandardOpenOption.APPEND);
        }
    }
}

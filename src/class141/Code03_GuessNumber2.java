package class141;

// 猜数字(扩展中国剩余定理解决)
// 测试链接 : https://www.luogu.com.cn/problem/P3868

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;

public class Code03_GuessNumber2 {

	public static int MAXN = 11;

	public static long modular[] = new long[MAXN];

	public static long remainder[] = new long[MAXN];

	// 扩展中国剩余定理模版
	public static long excrt(int n) {
		long m1 = modular[1], r1 = remainder[1], m2, r2, c, tmp;
		for (int i = 2; i <= n; i++) {
			m2 = modular[i];
			r2 = remainder[i];
			exgcd(m1, m2);
			c = ((r2 - r1) % m2 + m2) % m2;
			if (c % d != 0) {
				return -1;
			}
			x = multiply(x, c / d, m2 / d);
			tmp = r1 + x * m1;
			m1 = m2 / d * m1;
			r1 = (tmp % m1 + m1) % m1;
		}
		return r1;
	}

	// 讲解139 - 扩展欧几里得算法
	public static long d, x, y, px, py;

	public static void exgcd(long a, long b) {
		if (b == 0) {
			d = a;
			x = 1;
			y = 0;
		} else {
			exgcd(b, a % b);
			px = x;
			py = y;
			x = py;
			y = px - py * (a / b);
		}
	}

	// 讲解033 - 位运算实现乘法
	// a*b过程每一步都%mod，这么写是防止溢出，也叫龟速乘
	public static long multiply(long a, long b, long mod) {
		long ans = 0;
		while (b != 0) {
			if ((b & 1) != 0) {
				ans = (ans + a) % mod;
			}
			a = (a + a) % mod;
			b >>= 1;
		}
		return ans;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer in = new StreamTokenizer(br);
		PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
		in.nextToken();
		int n = (int) in.nval;
		for (int i = 1; i <= n; i++) {
			in.nextToken();
			remainder[i] = (long) in.nval;
		}
		for (int i = 1; i <= n; i++) {
			in.nextToken();
			modular[i] = (long) in.nval;
		}
		// 题目输入的余数可能为负所以转化成正数
		for (int i = 1; i <= n; i++) {
			remainder[i] = (remainder[i] % modular[i] + modular[i]) % modular[i];
		}
		out.println(excrt(n));
		out.flush();
		out.close();
		br.close();
	}

}

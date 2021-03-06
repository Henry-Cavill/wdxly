/*
【程序 50 文件 IO】
题目：有五个学生，每个学生有 3 门课的成绩，从键盘输入以上数据（包括学生号，姓名，三门课成
绩），计算出平均成绩，将原有的数据和计算出的平均分数存放在磁盘文件"stud"中。

学号    姓名    课1    课2    课3
001		小明		90    90    90
002		小芳		100   100   100
003     小张    80    80    80
004     小李    90    90    90
005     小王    90    90    90
                90    90    90
*/


import java.io.*;
import java.util.Scanner;

public class Ex50 {
	public static void main(String[] args) throws IOException {
		// 学生信息用 4 个数组保存
		String[] studentId = new String[5];	// 学号
		String[] studentName = new String[5];	// 姓名
		int[][] studentCourse = new int[5][3];	// 三门课
		float[] averageScore = new float[3];	// 每门课的平均成绩

		// 输入
		Scanner sc = new Scanner(System.in);
		int i, j;
		for (i = 0; i < 5; i++) {
			System.out.printf("现在输入第 %d 个学生的信息\n学号：", i+1);
			studentId[i] = sc.nextLine();

			System.out.print("姓名：");
			studentName[i] = sc.nextLine();

			for (j = 0; j < 3; j++) {
				System.out.printf("课 %d 的成绩：", j + 1);
				studentCourse[i][j] = sc.nextInt();
			}
			sc.nextLine();	// nextInt 后回车，会跳过一个 nextLine
		}

		// 计算
		System.out.println();
		for (i = 0; i < 3; i++) {
			averageScore[i] = 0;
			for (j = 0; j < 5; j++) {
				averageScore[i] += studentCourse[j][i];
			}
			averageScore[i] /= 5;
			System.out.printf("课 %d 的平均成绩为：%.2f\n", i + 1, averageScore[i]);
		}

		// 写入文件
		File file = new File("stud.txt");
		file.createNewFile();
		FileWriter out = new FileWriter(file);

		// String 是最大的类型，由小到大可以自动转换
		out.write("学号\t姓名\t课1\t课2\t课3\n");
		for (i = 0; i < 5; i++) {
			out.write(studentId[i] + "\t" + studentName[i] + "\t");
			for (j = 0; j < 3; j++) {
				out.write(studentCourse[i][j] + "\t");
			}
			out.write("\n");
		}
		for (i = 0; i < 3; i++) {
			out.write("课 " + (i + 1) + " 的平均成绩：" + averageScore[i] + "\n");
		}
		out.flush();
		out.close();
	}
}
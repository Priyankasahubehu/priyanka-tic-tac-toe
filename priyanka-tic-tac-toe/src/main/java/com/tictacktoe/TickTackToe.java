package com.tictacktoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class TickTackToe {
	static char[][] enteredset = { { '-', '-', '-' }, { '-', '-', '-' },
			{ '-', '-', '-' } };
	static List enterednumbers = new ArrayList();

	public static void main(String[] args) {

		System.out.println("TicTacToe");
		System.out.println("---------");

		boolean flag = false;
		Scanner sc = new Scanner(System.in);
		int count = 0;
		boolean GameOver = false;
		while (GameOver == false) {

			System.out.println("Enter Input number-");
			int a = sc.nextInt();
			while (true) {

				if (inputlogic(a, '*')) {
					break;
				} else {
					System.out.println("Please give another number-");
					a = sc.nextInt();

				}
			}

			if (comparisonlogic()) {
				GameOver = true;
				break;
			}

			while (true) {
				int systeminput = (int) (Math.random() * 100);
				systeminput = systeminput % 10;
				System.out.println(systeminput);

				System.out.println("Sysytem Input-" + systeminput);
				if (inputlogic(systeminput, '0')) {
					break;
				}
			}
			count = count + 2;
			if (comparisonlogic()) {
				GameOver = true;
				break;
			}
			if (count == 10 && GameOver == false) {
				System.out.println("Draw Match!");
			}
		}
	}

	public static boolean comparisonlogic() {
		boolean flag = false;

		for (int i = 0; i < 3; i++) {
			int userCount = 0;
			int compCount = 0;
			for (int j = 0; j < 3; j++) {
				if (enteredset[i][j] == '*') {
					userCount++;
				}
				if (enteredset[i][j] == '0') {
					compCount++;
				}
				if (userCount == 3) {
					System.out.println("User Won!");
					return true;
				}
				if (compCount == 3) {
					System.out.println("System Won!");
					return true;
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			int userCount = 0;
			int compCount = 0;
			for (int j = 0; j < 3; j++) {
				if (enteredset[j][i] == '*') {
					userCount++;
				}
				if (enteredset[j][i] == '0') {
					compCount++;
				}
				if (userCount == 3) {
					System.out.println("User Won!");
					return true;
				}
				if (compCount == 3) {
					System.out.println("System Won!");
					return true;
				}
			}
		}
		int userCount = 0;
		int compCount = 0;
		for (int i = 0, j = 0; i < 3; i++, j++) {
			if (enteredset[i][j] == '*') {
				userCount++;
			}
			if (enteredset[i][j] == '0') {
				compCount++;
			}
			if (userCount == 3) {
				System.out.println("User Won!");
				return true;
			}
			if (compCount == 3) {
				System.out.println("System Won!");
				return true;
			}
		}
		if (enteredset[0][2] == '*' && enteredset[1][1] == '*'
				&& enteredset[2][0] == '*') {
			System.out.println("User Won!");
			return true;
		}

		if (enteredset[0][2] == '0' && enteredset[1][1] == '0'
				&& enteredset[2][0] == '0') {
			System.out.println("System Won!");
			return true;
		}

		return false;

	}

	public static boolean inputlogic(int input, char move) {
		if (enterednumbers.contains(input)) {
			return false;
		} else {
			enterednumbers.add(input);
			switch (input) {
			case 0:
				System.out.println("Invalid number");
				return false;

			case 1:
				enteredset[0][0] = move;
				break;
			case 2:
				enteredset[0][1] = move;
				break;
			case 3:
				enteredset[0][2] = move;
				break;
			case 4:
				enteredset[1][0] = move;
				break;
			case 5:
				enteredset[1][1] = move;
				break;
			case 6:
				enteredset[1][2] = move;
				break;
			case 7:
				enteredset[2][0] = move;
				break;
			case 8:
				enteredset[2][1] = move;
				break;
			case 9:
				enteredset[2][2] = move;
				break;
			}
		}

		for (int i = 0; i < enteredset.length; i++) {
			for (int j = 0; j < enteredset[i].length; j++) {

				System.out.print(enteredset[i][j] + "|");
			}
			System.out.println("");
		}

		return true;
	}

}

package com.bonjourcs.java.ejc.io;

import java.util.Date;
import java.util.Scanner;

/**
 * @author Liang Chenghao
 * Description: a mock console application which emulates Linux ternimal
 * Date: 2018/5/15
 */
public class MockConsole {

	/**
	 * exit operation
	 */
	private static final String EXIT = "exit";
	/**
	 * clear operation
	 */
	private static final String CLEAR = "clear";
	/**
	 * su operation
	 */
	private static final String SU = "su";
	/**
	 * clear rows
	 */
	private static final int ROW = 5;
	/**
	 * scanner to receive input
	 */
	private static final Scanner SCANNER = new Scanner(System.in);
	/**
	 * root password
	 */
	private static final String ROOT_PASSWORD = "ROOT";
	/**
	 * current user
	 */
	private static boolean isRoot = false;
	/**
	 * root session count
	 */
	private static int count = 0;

	public static void main(String[] args) {

		// show login banner
		login();

		// normal user login
		preNormal(RoleEnum.NORMAL);

	}

	/**
	 * loop info
	 *
	 * @param role login user role
	 */
	private static void preNormal(RoleEnum role) {
		infoBanner(role);
		String str;
		while ((str = SCANNER.next()) != null) {
			handle(role, str);
		}
	}

	/**
	 * show user info
	 *
	 * @param role login role
	 */
	private static void infoBanner(RoleEnum role) {
		switch (role) {
			case NORMAL:
				System.out.print("[bonjourcs@localhost ~]$ ");
				break;
			case ROOT:
				System.out.print("[root@localhost /home/root]# ");
				break;
			default:
				break;
		}
	}

	/**
	 * normal user login
	 */
	private static void login() {
		try {
			System.out.println("Connecting to localhost:21...");
			Thread.sleep(500);
			System.out.println("Connection established.");
			Thread.sleep(500);
			System.out.println("Last login: " + new Date(System.currentTimeMillis()) + " from 127.0.0.1");
		} catch (Exception e) {
			System.out.println("Error happened.");
		}
	}

	/**
	 * logout banner
	 */
	private static void logout(RoleEnum role) {
		switch (role) {
			case NORMAL:
				try {
					System.out.println("logout");
					Thread.sleep(500);
					System.out.println("Connecting closing...Socket close.");
					Thread.sleep(500);
					System.out.println("Connection closed by foreign host..");
					Thread.sleep(500);
					System.out.println("Disconnected from remote host(bonjourcs@localhost) at " + new Date(System.currentTimeMillis()));
					Thread.sleep(500);
					System.exit(0);
				} catch (Exception e) {
					System.out.println("Error happened.");
				}
				break;
			case ROOT:
				count--;
				if (count == 0) {
					System.out.println("exit");
					preNormal(RoleEnum.NORMAL);
				} else {
					preNormal(RoleEnum.ROOT);
				}
				break;
			default:
				break;
		}
	}

	/**
	 * handle input string
	 *
	 * @param str input string
	 */
	private static void handle(RoleEnum role, String str) {
		if (EXIT.equalsIgnoreCase(str)) {
			logout(role);
		} else if (CLEAR.equalsIgnoreCase(str)) {
			clear(role);
		} else if (SU.equalsIgnoreCase(str)) {
			su();
		} else {
			normal(role, str);
		}

	}

	/**
	 * handle normal string
	 *
	 * @param str input string
	 */
	private static void normal(RoleEnum role, String str) {
		switch (role) {
			case NORMAL:
				System.out.println("-bash: " + str + ": command not found");
				System.out.print("[bonjourcs@localhost ~]$ ");
				break;
			case ROOT:
				System.out.println("-bash: " + str + ": command not found");
				System.out.print("[root@localhost /home/root]# ");
				break;
			default:
				break;
		}
	}

	/**
	 * clear
	 *
	 * @param role user role
	 */
	private static void clear(RoleEnum role) {
		for (int i = 0; i < ROW; i++) {
			System.out.println();
		}
		infoBanner(role);
	}

	/**
	 * su operation
	 */
	private static void su() {

		// if current user is root, don't need to input password
		if (!isRoot) {
			System.out.print("Password: ");
			String str = SCANNER.next();

			// thread sleeps for 1s
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// do nothing
			}

			if (ROOT_PASSWORD.equals(str)) {
				System.out.println("su: Authentication failure.");
				preNormal(RoleEnum.NORMAL);
			} else {
				isRoot = true;
				count++;
				preNormal(RoleEnum.ROOT);
			}
		} else {
			count++;
			infoBanner(RoleEnum.ROOT);
		}
	}

	/**
	 * enum for system roles
	 */
	private enum RoleEnum {
		/**
		 * root user
		 */
		ROOT,
		/**
		 * normal user
		 */
		NORMAL
	}

}

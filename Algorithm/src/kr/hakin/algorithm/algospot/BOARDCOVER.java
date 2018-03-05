package kr.hakin.algorithm.algospot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOARDCOVER {
	private int width;
	private int height;
	private char[][] board;
	private int countOfEmpty;
	private int countOfCase;
	private int numOfBlock;
	private int[][][] blocks = { { { 0, 0 }, { 1, 0 }, { 0, 1 } }, { { 0, 0 }, { 0, 1 }, { 1, 1 } },
			{ { 0, 0 }, { 1, 0 }, { 1, 1 } }, { { 0, 0 }, { 1, 0 }, { 1, -1 } }, };

	public BOARDCOVER(int width, int height, char[][] board) {
		this.width = width;
		this.height = height;
		this.board = board;
		this.countOfEmpty = countEmptyBoard();

		if ((countOfEmpty % 3) != 0) {
			System.out.println("0");
			return;
		} else {
			this.numOfBlock = countOfEmpty / 3;
			countOfCase = cover();
			System.out.println(countOfCase);
		}
	}	
	
	public int cover() {
		int x = -1;
		int y = -1;
		
		for(int i = 0; i < height; i++) {
			for(int j = 0; j < height; j++) {
				if(board[i][j] == '.') {
					x = j;
					y = i;
					break;
				}
			}
			
			if(y != -1) {
				break;
			}
		}
		//System.out.println("x : " + x + " / y : " + y);
		if(y == -1) {
			return 1;
		}
		
		int cnt = 0;
		
		for(int i = 0; i < blocks.length; i++) {
			if(isSet(y, x, i)) {
				setBlockOnBoard(y, x, i, '#');
				cnt += cover();
				setBlockOnBoard(y, x, i, '.');
			}
			
		}
		
		return cnt;
	}
	
	public void setBlockOnBoard(int y, int x, int typeOfBlock, char isSet) {
		for(int i = 0; i < 3; i++) {
			int ny = y + blocks[typeOfBlock][i][0];
			int nx = x + blocks[typeOfBlock][i][1];
			//System.out.println(nx + "/" + ny);
			board[ny][nx] = isSet;
		}
	}
	
	public boolean isSet(int y, int x, int typeOfBlock) {
		for(int i = 0; i < 3; i++) {
			int ny = y + blocks[typeOfBlock][i][0];
			int nx = x + blocks[typeOfBlock][i][1];
			
			if(ny < 0 || nx < 0 || ny >= height || nx >= width) {
				return false;
			} else if (board[ny][nx] == '#') {
				return false;
			}
		}
		
		return true;
	}


	public int countEmptyBoard() {
		int tempCount = 0;

		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (board[i][j] == '.') {
					tempCount++;
				}
			}
		}

		return tempCount;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		try {
			int numOfTestCase = Integer.parseInt(br.readLine().trim());

			if (numOfTestCase > 30) {
				return;
			}

			while ((numOfTestCase--) > 0) {
				String[] inputSizeData = br.readLine().trim().split(" ");
				int height = Integer.parseInt(inputSizeData[0]);
				int width = Integer.parseInt(inputSizeData[1]);

				char[][] board = new char[height][width];

				for (int i = 0; i < height; i++) {
					board[i] = br.readLine().trim().toCharArray();
				}

				BOARDCOVER b = new BOARDCOVER(width, height, board);
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

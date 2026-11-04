package piece;

import java.awt.Graphics2D;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import main.Board;

public class Piece {
	public int x, y;
	public int col, row, preCol, preRow;
	public int color;
	FlatSVGIcon image;
	
	public Piece(int color, int col, int row){
		this.color = color;
		this.col = col;
		this.row = row;
		x = getX(col);
		y = getY(row);
		preCol = col;
		preRow = row;
	}
	
	public int getX(int col) {
		return (int)col * Board.SQUARE_SIZE;
	}
	
	public int getY(int row) {
		return (int)row * Board.SQUARE_SIZE;
	}
	
	public int getCol(int x) {
		return (x + Board.HALF_SQUARE_SIZE)/Board.SQUARE_SIZE;
	}
	
	public int getRow(int y) {
		return (y + Board.HALF_SQUARE_SIZE)/Board.SQUARE_SIZE;
	}
	
	public void updatePosition() {
		x = getX(col);
		y = getY(row);
		preCol = getCol(x);
		preRow = getRow(y);
	}

	public FlatSVGIcon getImage(String imagePath) {
		FlatSVGIcon svgIcon = null;
		svgIcon = new FlatSVGIcon(getClass().getResource(imagePath)).derive(Board.SQUARE_SIZE, Board.SQUARE_SIZE);
		return svgIcon;
	}
	
	public void draw(Graphics2D g) {
		image.paintIcon(null, g, x, y);
	}
}

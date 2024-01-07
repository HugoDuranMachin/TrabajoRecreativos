import java.util.Arrays;

public class Map {
    private static char[][] mapArray;
    private static int rowLen = 0;
    private static int colLen = 0;

    public static void initEmptyMap(char[][] m) {
        for (int i = 0; i < m.length; i++) {
            Arrays.fill(m[i], ' ');
        }
    }

    public static void fillBorders(char[][] m) {

        if (colLen*rowLen == rowLen*rowLen) {
            for (int row = 0; row<=rowLen; row++) {
                m[row][0] = Tileset.WALL;
                m[row][rowLen] = Tileset.WALL;
                m[0][row] = Tileset.WALL;
                m[rowLen][row] = Tileset.WALL;
            }
        }  else {
            for (int row = 0; row<=rowLen; row++) {
                m[row][0] = Tileset.WALL;
                m[row][colLen] = Tileset.WALL;
            }

            for (int col = 0; col <= colLen; col++) {
                m[0][col] = Tileset.WALL;
                m[rowLen][col] = Tileset.WALL;
            }
        }
    }


    public char[][] getMap() {
        return mapArray;
    }

    public static void printMap(char[][] m) {

        for (int i = 0; i < m.length; i++) {
            System.out.println();
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
        }
    }

    Map(int rows, int cols){
        mapArray = new char[rows][cols];
        rowLen = mapArray.length -1;
        colLen = mapArray[0].length -1;
        initEmptyMap(mapArray);
        fillBorders(mapArray);
    }

}

import java.util.Arrays;

public class Map {
    private static char[][] mapArray;
    private static int rowLen = 0;
    private static int colLen = 0;

    Map(int rows, int cols){
        mapArray = new char[rows][cols];
        rowLen = mapArray.length -1;
        colLen = mapArray[0].length -1;
        initEmptyMap(mapArray);
        fillBorders(mapArray);
    }

    public static void initEmptyMap(char[][] m) {
        for (int i = 0; i < m.length; i++) {
            Arrays.fill(m[i], ' ');
        }
    }

    public static void fillBorders(char[][] m) {

        if (colLen*rowLen == rowLen*rowLen) {
            for (int row = 0; row<=rowLen; row++) {
                m[row][0] = Tileset.BOXVBAR;
                m[row][rowLen] = Tileset.BOXVBAR;
                m[0][row] = Tileset.BOXHBAR;
                m[rowLen][row] = Tileset.BOXHBAR;
            }
        }  else {
            for (int row = 0; row<=rowLen; row++) {
                m[row][0] = Tileset.BOXVBAR;
                m[row][colLen] = Tileset.BOXVBAR;
            }

            for (int col = 0; col <= colLen; col++) {
                m[0][col] = Tileset.BOXHBAR;
                m[rowLen][col] = Tileset.BOXHBAR;
            }
        }
        m[0][0] = Tileset.BOXNW;
        m[0][colLen] = Tileset.BOXNE;
        m[rowLen][0] = Tileset.BOXSW;
        m[rowLen][colLen] = Tileset.BOXSE;
    }

    public char[][] getMap() {
        return this.mapArray;
    }

    public static void printMap(char[][] m) {
        for (int i = 0; i < m.length; i++) {
            System.out.println();
            for (int j = 0; j < m[i].length; j++) {
                System.out.print(m[i][j] + " ");
            }
        }
    }


}

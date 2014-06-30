
import java.util.Scanner;

public class EasyMode {

    public static boolean x;
    private static int i;
    private static int j;
    private static boolean markerCheckCorrectMyMove;
    protected static char[][] areaMode;

    public EasyMode(char[][] area, int a){
        areaMode = area;
        whoFirstMove(areaMode, a);
    }

    public EasyMode(){
    }

    protected char[][] me(char[][] meArea){
        markerCheckCorrectMyMove = true;
        while (markerCheckCorrectMyMove){
            Consol.show(meArea);
            System.out.println("Введите цифру от 1 до 9, соответствующую ячейке. Например:");
            Consol.showPrimer();
            Scanner input = new Scanner(System.in);
            int inputInt = input.nextInt();
            // transformation(inputInt);
            if(checkCorrectMyMove(meArea, inputInt)){
                meArea[i][j] = 'X';
                areaMode = meArea;
                checkWinAndDraw(areaMode, "gamer");
                return areaMode;
            }
            else{
                System.out.println("=========Ячейка занята!=========");
                //markerCheckCorrectMyMove = false;
            }
        }
        return areaMode;
    }


    private  boolean checkCorrectMyMove(char[][] a, int b){
        transformation(b);
        if(a[i][j]==' '){
            markerCheckCorrectMyMove = false;
            return true;
        }
        else return false;
    }

    private void pc(char[][] pcArea){
        randomMove(pcArea);
        pc(me(areaMode));
    }

    protected void randomMove(char[][] a){
        randomMode();
        if(a[EasyMode.i][EasyMode.j] != ' ') randomMove(a);
        else{
            a[EasyMode.i][EasyMode.j] = 'O';
            areaMode=a;
            checkWinAndDraw(areaMode, "pc");
        }
    }

    private void randomMode(){ //генерирует 2 рандомных числа из диапозонов [0-2]
        EasyMode.i = Main.random(0, 2);
        EasyMode.j = Main.random(0, 2);
    }

    private void transformation(int a){
        if(a == 1){EasyMode.i=0; EasyMode.j=0;}
        if(a == 2){EasyMode.i=0; EasyMode.j=1;}
        if(a == 3){EasyMode.i=0; EasyMode.j=2;}
        if(a == 4){EasyMode.i=1; EasyMode.j=0;}
        if(a == 5){EasyMode.i=1; EasyMode.j=1;}
        if(a == 6){EasyMode.i=1; EasyMode.j=2;}
        if(a == 7){EasyMode.i=2; EasyMode.j=0;}
        if(a == 8){EasyMode.i=2; EasyMode.j=1;}
        if(a == 9){EasyMode.i=2; EasyMode.j=2;}
    }

    private boolean checkEndGame(char[][] areaCheck){
        int[][] areaCheckInt = changeAreaCharToInt(areaCheck);
        if(((areaCheckInt[0][0]+areaCheckInt[0][1]+areaCheckInt[0][2])==3)||((areaCheckInt[1][0]+areaCheckInt[1][1]+areaCheckInt[1][2])==3)||((areaCheckInt[2][0]+areaCheckInt[2][1]+areaCheckInt[2][2])==3)||((areaCheckInt[0][0]+areaCheckInt[1][0]+areaCheckInt[2][0])==3)||((areaCheckInt[0][1]+areaCheckInt[1][1]+areaCheckInt[2][1])==3)||((areaCheckInt[0][2]+areaCheckInt[1][2]+areaCheckInt[2][2])==3)||((areaCheckInt[0][0]+areaCheckInt[1][1]+areaCheckInt[2][2])==3)||((areaCheckInt[0][2]+areaCheckInt[1][1]+areaCheckInt[2][0])==3)){
            return true;
        }
        if(((areaCheckInt[0][0]+areaCheckInt[0][1]+areaCheckInt[0][2])==12)||((areaCheckInt[1][0]+areaCheckInt[1][1]+areaCheckInt[1][2])==12)||((areaCheckInt[2][0]+areaCheckInt[2][1]+areaCheckInt[2][2])==12)||((areaCheckInt[0][0]+areaCheckInt[1][0]+areaCheckInt[2][0])==12)||((areaCheckInt[0][1]+areaCheckInt[1][1]+areaCheckInt[2][1])==12)||((areaCheckInt[0][2]+areaCheckInt[1][2]+areaCheckInt[2][2])==12)||((areaCheckInt[0][0]+areaCheckInt[1][1]+areaCheckInt[2][2])==12)||((areaCheckInt[0][2]+areaCheckInt[1][1]+areaCheckInt[2][0])==12)){
            return true;
        }
        return false;
    }

    private boolean checkDraw(char[][] areaCheckDraw){
        int c=9;//счетчик не пустых ячеек. по достижению 9 будет ничья
        for(int a=0; a<areaCheckDraw.length; a++){
            for(int b=0; b<areaCheckDraw[a].length; b++){
                if(areaCheckDraw[a][b]==' '){
                    c--;
                }
            }
        }
        if(c==(Main.ROW_COLUMN_SIZE*Main.ROW_COLUMN_SIZE)){
            return true;
        }
        return false;
    }

    protected void whoFirstMove(char[][] a, int wf){
        if(wf == 1){
            pc(a);
        }
        pc(me(a));

    }

    protected int[][] changeAreaCharToInt(char[][] c){
        int[][] areaInt = new int[Main.ROW_COLUMN_SIZE][Main.ROW_COLUMN_SIZE];
        for(int a=0; a<c.length; a++){
            for(int b=0; b<c[a].length; b++){
                if(c[a][b]=='X'){areaInt[a][b]=4;}
                if(c[a][b]=='O'){areaInt[a][b]=1;}
                if(c[a][b]==' '){areaInt[a][b]=0;}
            }
        }
        return areaInt;
    }

    protected void checkWinAndDraw(char[][] a, String b){
        if(checkEndGame(a)){
            Consol.show(a);
            Main.win(b);
        }
        if(checkDraw(a)){
            Consol.show(a);
            Main.win("draw");
        }
    }

}

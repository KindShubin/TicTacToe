
public class Consol{
    public static void show(char[][] area){
        for(int i=0; i<area.length; i++){
            row();
            for(int j=0; j<area[i].length; j++){
                System.out.print(" ["+ area[i][j] +"] ");
                if(j < area[i].length-1){
                    System.out.print("|");
                }
            }
            System.out.println();
            if(i < area.length-1){
                rowDownLine();
            } else row();
        }
    }

    public static void showPrimer(){
        int area[][] = new int[Main.ROW_COLUMN_SIZE][Main.ROW_COLUMN_SIZE];
        int a = 1;//значение от 1 до 9, которое будет вписано в ячейку
        for(int i=0; i<area.length; i++){
            for(int j=0; j<area[i].length; j++){
                area[i][j] = a;
                System.out.print("["+ area[i][j] +"]");
                if(j < area[i].length-1){
                    System.out.print(" ");
                }
                a++;
            }
            System.out.println();
            if(i < area.length-1){
                System.out.println("           ");
                //System.out.println("---|---|---");
            } //else row();
        }
    }

    private static void row(){
        System.out.println("     |     |     ");
    }

    private static void rowDownLine(){
        System.out.println("_____|_____|_____");
    }
}

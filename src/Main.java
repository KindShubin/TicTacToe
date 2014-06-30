import java.util.Scanner;

public class Main {

    public static final int ROW_COLUMN_SIZE = 3;
    private static int i;
    private static int j;
    private static char[][] staff;
    private static int level;
    private static int whoFirst;

    public static void main(String[] args){

        choiceLevel();
        choiceWhoFirst();
    }

    public static int random(int a, int b){
        return a + (int)(Math.random()*((b-a)+1));
        //return x;
    }

    private static void createGame(char[][] a, int b, int c){// на вход приходит значение b - уровень игры и с - кто первый ходит
        if(b == 1){EasyMode gameE = new EasyMode(a, c);}
        if(b == 2){MiddleMode gameE = new MiddleMode(a, c);}
        if(b == 3){HardMode gameE = new HardMode(a, c);}
    }

    private static void createMatrix(){
        staff = new char[ROW_COLUMN_SIZE][ROW_COLUMN_SIZE];
        for(i = 0; i <staff.length; i++){
            for(j = 0; j <staff[i].length; j++){
                staff[i][j]=' ';
            }
        }
    }

    private static void choiceLevel(){
        System.out.println("Выберите уровень сложности:");
        System.out.println("1 - легкий");
        System.out.println("2 - средний");
        System.out.println("3 - сложный");
        System.out.print("Введите цифру: ");
        Scanner cifra = new Scanner(System.in);
        level = cifra.nextInt();
        createMatrix();
    }

    private static void choiceWhoFirst(){
        System.out.println("Выберите кто будет ходить первым");
        System.out.println("1 - компьютер");
        System.out.println("2 - Вы");
        System.out.println("3 - Случайный выбор");
        System.out.print("Введите цифру: ");
        Scanner cifra1 = new Scanner(System.in);
        whoFirst = cifra1.nextInt();
        if (whoFirst == 3){
            whoFirst = random(1,2);
        }
        if (whoFirst == 1){
            System.out.println("Первый ходит компьютер");
            createGame(staff, level, whoFirst);
        }
        else{
            System.out.println("Первым ходите Вы");
            createGame(staff, level, whoFirst);
        }
    }

    public static void win(String a){
        if(a == "gamer"){
            System.out.println("Вы выиграли!");
            regame();
        }
        if(a == "pc"){
            System.out.println("Компьютер выиграл");
            regame();
        }
        if(a == "draw"){
            System.out.println("Ничья");
            regame();
        }
    }

    private static void regame(){
        System.out.println("Хотите сиграть еще?");
        System.out.print("y/n; ");
        Scanner reg = new Scanner(System.in);
        String regameString = reg.next();
        if((regameString.equals("y"))||(regameString.equals("д"))){
            createMatrix();
            createGame(staff, level, whoFirst);
        }
        if((regameString.equals("n"))||(regameString.equals("н"))){
            choiceLevel();
            choiceWhoFirst();
        }
        if((!regameString.equals("n"))&&(!regameString.equals("н"))&&(!regameString.equals("y"))&&(!regameString.equals("д"))){
            System.out.println("Ошибка");
            regame();
        }
    }
}

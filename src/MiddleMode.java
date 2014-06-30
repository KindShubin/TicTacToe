
public class MiddleMode extends HardMode {

    private static char[][] areaMiddleMode;

    public MiddleMode(char[][] a, int b){
        super();
        System.out.println("запуск конструкторе middle");
        areaMiddleMode = a;
        whoFirstMove(areaMiddleMode, b);
    }

    @Override
    protected void whoFirstMove(char[][] a, int wf){
        System.out.println("whoFirstMove начал работу");
        if( wf == 1){
            pc(a);
        }
        pc(me(a));
    }
    @Override
    protected void pc(char[][] a){
        System.out.println("pc в MiddleMode начал работу");
        if(checkFirstMove(a)){
            firstMove(a);
        }
        System.out.println("firstMove не сработал");
        chekToWin(a);
        System.out.println("checkToWin не сработал");
        checkToProtection(a);
        System.out.println("chackToProtection не сработал");
        System.out.println("randomMove....");
        randomMove(a);
        areaMiddleMode=areaMode;
        System.out.println("метод pc поностью пройден. переход к me()");
        pc(me(areaMiddleMode));
    }
}

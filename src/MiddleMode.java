
public class MiddleMode extends HardMode {

    private static char[][] areaMiddleMode;

    public MiddleMode(char[][] a, int b){
        super();
        areaMiddleMode = a;
        whoFirstMove(areaMiddleMode, b);
    }

    @Override
    protected void whoFirstMove(char[][] a, int wf){
        if( wf == 1){
            pc(a);
        }
        pc(me(a));
    }
    @Override
    protected void pc(char[][] a){
        if(checkFirstMove(a)){
            firstMove(a);
        }
        chekToWin(a);
        checkToProtection(a);
        randomMove(a);
        areaMiddleMode=areaMode;
        pc(me(areaMiddleMode));
    }
}


public class HardMode extends EasyMode {

    private static char[][] areaHardMode;

    public  HardMode(){
    }

    public HardMode(char[][] area, int a){
        super();
        //System.out.println("запуск конструкторе хард");
        areaHardMode = area;
        whoFirstMove(areaHardMode,a);
    }

    protected void firstMove(char[][] area){ //первый ход ПК. Если [1][1] занято, то что угодно по углам
        areaHardMode = area;
        if(areaHardMode[1][1]==' '){
            areaHardMode[1][1]='O';
            pc(me(areaHardMode));
        }
        else{
            areaHardMode[randomTwoValue(0, 2)][randomTwoValue(0,2)]='O';
            pc(me(areaHardMode));
        }
    }

    protected boolean checkFirstMove(char[][] a){
        int c=9;//счетчик не пустых ячеек. по достижению 0 или 1, будет означать первый ход для ПК
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[i].length; j++){
                if(a[i][j]==' '){
                    c--;
                }
            }
        }        return((c==0)||(c==1));
    }

    private int randomTwoValue(int a, int b){
        if(Main.random(0,1) == 0){
            return a;
        }
        else return b;
    }

    protected void pc(char[][] pcArea){
        //System.out.println("pc начал работу");
        if(checkFirstMove(pcArea)){
            firstMove(pcArea);
        }
        //System.out.println("firstMove не сработал");
        chekToWin(pcArea);
        //System.out.println("checkToWin не сработал");
        checkToProtection(pcArea);
        //System.out.println("chackToProtection не сработал");
        checkToAllFreeAngularFields(pcArea);
        //System.out.println("checkToAllFreeAngularFields не сработала");
        checkTo3FreeAngularFields(pcArea);
        //System.out.println("checkTo3FreeAngularFields не сработал");
        checkOpposite2Fields(pcArea);
        //System.out.println("checkOpposite2Fields не сработал");
        check2FreeAngularFields(pcArea);
        //System.out.println("check2FreeAngularFields не сработал");
        checkOnCorrectAngularField(pcArea);
        //System.out.println("checkOnCorrectAngularField не сработала");
        checkAllAreaOnOnePcField(pcArea);
        //System.out.println("randomMove....");
        randomMove(pcArea);
        areaHardMode=areaMode;
        //System.out.println("метод pc поностью пройден. переход к me()");
        pc(me(areaHardMode));
    }

    protected void chekToWin(char[][] a){
        if(pereborFirstPart(a, 2, 0)==1){
            if(a[0][0]==' '){areaHardMode[0][0]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[0][1]==' '){areaHardMode[0][1]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[0][2]==' '){areaHardMode[0][2]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            //else System.out.println("ОШИБКА chekToWin 1");
        }
        if(pereborFirstPart(a, 2, 0)==2){
            if(a[1][0]==' '){areaHardMode[1][0]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[1][1]==' '){areaHardMode[1][1]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[1][2]==' '){areaHardMode[1][2]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            //else System.out.println("ОШИБКА chekToWin 2");
        }
        if(pereborFirstPart(a, 2, 0)==3){
            if(a[2][0]==' '){areaHardMode[2][0]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[2][1]==' '){areaHardMode[2][1]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[2][2]==' '){areaHardMode[2][2]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            //else System.out.println("ОШИБКА chekToWin 3");
        }
        if(pereborFirstPart(a, 2, 0)==4){
            if(a[0][0]==' '){areaHardMode[0][0]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[1][0]==' '){areaHardMode[1][0]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[2][0]==' '){areaHardMode[2][0]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            //else System.out.println("ОШИБКА chekToWin 4");
        }
        if(pereborFirstPart(a, 2, 0)==5){
            if(a[0][1]==' '){areaHardMode[0][1]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[1][1]==' '){areaHardMode[1][1]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[2][1]==' '){areaHardMode[2][1]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            //else System.out.println("ОШИБКА chekToWin 5");
        }
        if(pereborFirstPart(a, 2, 0)==6){
            if(a[0][2]==' '){areaHardMode[0][2]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[1][2]==' '){areaHardMode[1][2]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[2][2]==' '){areaHardMode[2][2]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            //else System.out.println("ОШИБКА chekToWin 6");
        }
        if(pereborFirstPart(a, 2, 0)==7){
            if(a[0][0]==' '){areaHardMode[0][0]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[1][1]==' '){areaHardMode[1][1]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[2][2]==' '){areaHardMode[2][2]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            //else System.out.println("ОШИБКА chekToWin 7");
        }
        if(pereborFirstPart(a, 2, 0)==8){
            if(a[0][2]==' '){areaHardMode[0][2]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[1][1]==' '){areaHardMode[1][1]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[2][0]==' '){areaHardMode[2][0]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            //else System.out.println("ОШИБКА chekToWin 8");
        }
    }

    protected void checkToProtection(char[][] a){//проверяет горизонтали/вертикали и диагонали на наличие полей с двумя 'X' и ходит в этом поле. X| |X
        if(pereborFirstPart(a, 8, 0)==1){
            if(a[0][0]==' '){areaHardMode[0][0]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[0][1]==' '){areaHardMode[0][1]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[0][2]==' '){areaHardMode[0][2]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            //else System.out.println("ОШИБКА chekToProtection 1");
        }
        if(pereborFirstPart(a, 8, 0)==2){
            if(a[1][0]==' '){areaHardMode[1][0]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[1][1]==' '){areaHardMode[1][1]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[1][2]==' '){areaHardMode[1][2]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            //else System.out.println("ОШИБКА chekToProtection 2");
        }
        if(pereborFirstPart(a, 8, 0)==3){
            if(a[2][0]==' '){areaHardMode[2][0]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[2][1]==' '){areaHardMode[2][1]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[2][2]==' '){areaHardMode[2][2]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            //else System.out.println("ОШИБКА chekToProtection 3");
        }
        if(pereborFirstPart(a, 8, 0)==4){
            if(a[0][0]==' '){areaHardMode[0][0]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[1][0]==' '){areaHardMode[1][0]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[2][0]==' '){areaHardMode[2][0]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            //else System.out.println("ОШИБКА chekToProtection 4");
        }
        if(pereborFirstPart(a, 8, 0)==5){
            if(a[0][1]==' '){areaHardMode[0][1]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[1][1]==' '){areaHardMode[1][1]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[2][1]==' '){areaHardMode[2][1]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            //else System.out.println("ОШИБКА chekToProtection 5");
        }
        if(pereborFirstPart(a, 8, 0)==6){
            if(a[0][2]==' '){areaHardMode[0][2]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[1][2]==' '){areaHardMode[1][2]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[2][2]==' '){areaHardMode[2][2]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            //else System.out.println("ОШИБКА chekToProtection 6");
        }
        if(pereborFirstPart(a, 8, 0)==7){
            if(a[0][0]==' '){areaHardMode[0][0]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[1][1]==' '){areaHardMode[1][1]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[2][2]==' '){areaHardMode[2][2]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            //else System.out.println("ОШИБКА chekToProtection 7");
        }
        if(pereborFirstPart(a, 8, 0)==8){
            if(a[0][2]==' '){areaHardMode[0][2]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[1][1]==' '){areaHardMode[1][1]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[2][0]==' '){areaHardMode[2][0]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            //else System.out.println("ОШИБКА chekToProtection 8");
        }
    }

    private  void checkToAllFreeAngularFields(char[][] a){
        int[][] aInt = changeAreaCharToInt(a);
        if((aInt[0][0]+aInt[0][2]+aInt[2][0]+aInt[2][2])==0){
            a[randomTwoValue(0,2)][randomTwoValue(0,2)]='O';
            areaHardMode = a;
            pc(me(areaHardMode));
        }
    }

    private void checkOnCorrectAngularField(char[][] a){
        System.out.println("ряд" + pereborFirstPart(a, 4, 0) + "ряд" + pereborFirstPart(a, 4, pereborFirstPart(a, 4, 0)));
        int[][] aInt = changeAreaCharToInt(a);
        if(((aInt[0][1]==4)||(aInt[0][2]==4))&&((aInt[1][0]==4)||(aInt[2][0]==4))){
            if(a[0][0]==' '){
                a[0][0]='O';
                pc(me(a));
            }
        }
        if(((aInt[0][0]==4)||(aInt[0][1]==4))&&((aInt[1][2]==4)||(aInt[2][2]==4))){
            if(a[0][2]==' '){
                a[0][2]='O';
                pc(me(a));
            }
        }
        if(((aInt[0][0]==4)||(aInt[1][0]==4))&&((aInt[2][1]==4)||(aInt[2][2]==4))){
            if(a[2][0]==' '){
                a[2][0]='O';
                pc(me(a));
            }
        }
        if(((aInt[0][2]==4)||(aInt[1][2]==4))&&((aInt[2][0]==4)||(aInt[2][1]==4))){
            if(a[2][2]==' '){
                a[2][2]='O';
                pc(me(a));
            }
        }
    }

    private void checkTo3FreeAngularFields(char[][] a){//проверка угловых полей а[0][0] a[0][2] a[2][0] a[2][2] на наличие одного поля 'X' и запись в одно из двух непротивоположных полей 'O'
        int[][] aInt = changeAreaCharToInt(a);
        if((aInt[0][0]+aInt[0][2]+aInt[2][0]+aInt[2][2])==4){
            if((a[0][0]=='X')||(a[2][2]=='X')){
                if(Main.random(0,1)==0){areaHardMode[0][2]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
                else {areaHardMode[2][0]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            }
            if((a[0][2]=='X')||(a[2][0]=='X')){
                if(Main.random(0,1)==0){areaHardMode[0][0]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
                else {areaHardMode[2][2]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            }
        }
        //else System.out.println("Проверка на углы не прошла");
    }

    private void check2FreeAngularFields(char[][] a){
        int[][] aInt = changeAreaCharToInt(a);
        if(((aInt[0][0]+aInt[0][2]+aInt[2][0]+aInt[2][2])==5)||((aInt[0][0]+aInt[0][2]+aInt[2][0]+aInt[2][2])==8)){
            int b = randomTwoValue(0,2);
            int c = randomTwoValue(0,2);
            if(a[b][c]==' '){
                a[b][c]='O';
                areaHardMode=a;
                pc(me(areaHardMode));
            } else check2FreeAngularFields(a);
        }
    }

    private void checkOpposite2Fields(char[][] a){
        int[][] aInt = changeAreaCharToInt(a);
        if(((aInt[0][0]==4)&&(aInt[2][2])==4)||((aInt[0][2]==4)&&(aInt[2][0])==4)){
            int b = randomTwoValue(0,1);
            if(b==0){
                int c = randomTwoValue(0,2);
                if(a[c][1]==' '){
                    a[c][1]='O';
                    pc(me(a));
                }
                else{
                    if(a[Math.abs(c-2)][1]==' '){
                        a[c][1]='O';
                        pc(me(a));
                    }
                }
            }
            if(b==1){
                int c = randomTwoValue(0,2);
                if(a[1][c]==' '){
                    a[1][c]='O';
                    pc(me(a));
                }
                else{
                    if(a[1][Math.abs(c-2)]==' '){
                        a[1][c]='O';
                        pc(me(a));
                    }
                }
            }
        }
    }

    private void checkAllAreaOnOnePcField(char[][] a){//проверка всех возможных полей(горизонтали, вертикали, диагонали) на то, чтобы из 3х ячеек была одна заполненная меткой ПК
        if(pereborFirstPart(a, 1, 0)==1){
            if(a[0][0]=='O'){areaHardMode[0][randomTwoValue(1,2)]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[0][1]=='O'){areaHardMode[0][randomTwoValue(0,2)]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[0][2]=='O'){areaHardMode[0][randomTwoValue(0,1)]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            //else System.out.println("ОШИБКА chekAllAreaOnOnePcField 1");
        }
        if(pereborFirstPart(a, 1, 0)==2){
            if(a[1][0]=='O'){areaHardMode[1][randomTwoValue(1,2)]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[1][1]=='O'){areaHardMode[1][randomTwoValue(0,2)]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[1][2]=='O'){areaHardMode[1][randomTwoValue(0,1)]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            //else System.out.println("ОШИБКА chekAllAreaOnOnePcField 2");
        }
        if(pereborFirstPart(a, 1, 0)==3){
            if(a[2][0]=='O'){areaHardMode[2][randomTwoValue(1,2)]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[2][1]=='O'){areaHardMode[2][randomTwoValue(0,2)]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[2][2]=='O'){areaHardMode[2][randomTwoValue(0,1)]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            //else System.out.println("ОШИБКА chekAllAreaOnOnePcField 3");
        }
        if(pereborFirstPart(a, 1, 0)==4){
            if(a[0][0]=='O'){areaHardMode[randomTwoValue(1,2)][0]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[1][0]=='O'){areaHardMode[randomTwoValue(0,2)][0]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[2][0]=='O'){areaHardMode[randomTwoValue(0,1)][0]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            //else System.out.println("ОШИБКА chekAllAreaOnOnePcField 4");
        }
        if(pereborFirstPart(a, 1, 0)==5){
            if(a[0][1]=='O'){areaHardMode[randomTwoValue(1,2)][1]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[1][1]=='O'){areaHardMode[randomTwoValue(0, 2)][1]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[2][1]=='O'){areaHardMode[randomTwoValue(0,1)][1]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            //else System.out.println("ОШИБКА chekAllAreaOnOnePcField 5");
        }
        if(pereborFirstPart(a, 1, 0)==6){
            if(a[0][2]=='O'){areaHardMode[randomTwoValue(1,2)][2]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[1][2]=='O'){areaHardMode[randomTwoValue(0,2)][2]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[2][2]=='O'){areaHardMode[randomTwoValue(0,1)][2]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            //else System.out.println("ОШИБКА chekAllAreaOnOnePcField 6");
        }
        if(pereborFirstPart(a, 1, 0)==7){
            if(a[0][0]=='O'){int x = randomTwoValue(1,2); areaHardMode[x][x]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[1][1]=='O'){int x = randomTwoValue(0,2); areaHardMode[x][x]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            if(a[2][2]=='O'){int x = randomTwoValue(0,1); areaHardMode[x][x]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
            //else System.out.println("ОШИБКА chekAllAreaOnOnePcField 7");
        }
        if(pereborFirstPart(a, 1, 0)==8){
            if(a[0][2]=='O'){if(randomTwoValue(0,1)==0) {areaHardMode[1][1]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
                                else {areaHardMode[2][0]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}}
            if(a[1][1]=='O'){if(randomTwoValue(0,1)==0) {areaHardMode[0][2]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
                                else {areaHardMode[2][0]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}}
            if(a[2][0]=='O'){if(randomTwoValue(0,1)==0) {areaHardMode[0][2]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}
                                else {areaHardMode[1][1]='O'; checkWinAndDraw(areaHardMode, "pc"); pc(me(areaHardMode));}}
            //else System.out.println("ОШИБКА chekAllAreaOnOnePcField 8");
        }
    }

    private int pereborFirstPart(char[][] a, int b, int d){//находит нужный ряд(горизонталь, вертикаль, диагональ) по заданым параметрам, например 1 'X' в ряде или 1'X' и 1'O' или 2 'X' и прочее
        int[][] aInt = changeAreaCharToInt(a);                          // возвращает число соответствующее ряду, например, если 1, то верхни горизонтальный ряд, 2 - средний горизонтальный... 4 - левый вертикальный ряд
        int c = 1;                                                      // 5 - средний вертикальный ряд.... 7 - диагональ начиная с левого верхнего угла вниз на право, 8 - диагонль начиная с верхнего правого угла вниз на лево
        if(d!=1){
            if((aInt[0][0]+aInt[0][1]+aInt[0][2])==b)
                return c; else c++;
        }
        else c++;
        if(d!=2){
            if((aInt[1][0]+aInt[1][1]+aInt[1][2])==b)
                return c; else c++;
        }
        else c++;
        if(d!=3){
            if((aInt[2][0]+aInt[2][1]+aInt[2][2])==b)
                return c; else c++;
        }
        else c++;
        if(d!=4){
            if((aInt[0][0]+aInt[1][0]+aInt[2][0])==b)
                return c; else c++;
        }
        else c++;
        if(d!=5){
            if((aInt[0][1]+aInt[1][1]+aInt[2][1])==b)
                return c; else c++;
        }
        else c++;
        if(d!=6){
            if((aInt[0][2]+aInt[1][2]+aInt[2][2])==b)
                return c; else c++;
        }
        else c++;
        if(d!=7){
            if((aInt[0][0]+aInt[1][1]+aInt[2][2])==b)
                return c; else c++;
        }
        else c++;
        if(d!=8){
            if((aInt[0][2]+aInt[1][1]+aInt[2][0])==b)
                return c; else return 0;
        }
        return 0;
    }

    @Override
    protected void whoFirstMove(char[][] a, int wf){
        //System.out.println("whoFirstMove начал работу");
        if( wf == 1){
            pc(a);
        }
        pc(me(a));
    }

}

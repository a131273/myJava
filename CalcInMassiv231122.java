import java.lang.Throwable;
import java.util.Scanner;

public class CalcInMassiv231122 {
    public static void main(String[] calc) throws Throwable{
        System.out.println("Введите выражение!");
        Scanner scan=new Scanner(System.in);
        String text = scan.nextLine();
        String vvvbezp = text.replaceAll("\\s", "");//удаляем все пробелы
        int plus1 = 0, mi1 = 0, um1 = 0, de1 = 0, mZ = 0;
        char massa1[] = vvvbezp.toCharArray();//создаем символьный массив
        int dlina = vvvbezp.length();
        if (dlina<3){throw new Exception("строка не является математической операцией");}
        int i1 = 0,a=0,b=0;
        char plus = '+', minus = '-', umn = '*', del = '/';
        while (i1 < dlina) {
            if (massa1[i1] == plus) {plus1++;mZ = i1;}//ищем место оператора и колл-во
            if (massa1[i1] == minus){mi1++;mZ = i1;}//ищем место оператора и колл-во
            if (massa1[i1] == umn) {um1++;mZ = i1;}//ищем место оператора и колл-во
            if (massa1[i1] == del) {de1++;mZ = i1;}//ищем место оператора и колл-во
            i1++;        }
        int koll = plus1 + mi1 + um1 + de1;
        if (koll > 1 | koll == 0) {throw new Exception("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");}

        if (mZ == 0 | mZ == dlina - 1) {throw new Exception("строка не является математической операцией");}

        String levo = vvvbezp.substring(0, mZ);
        String prav = vvvbezp.substring(mZ + 1);
        boolean levop = levo.matches("[0-9]+");//только ли арабские цифры в левом операнде
        boolean pravop = prav.matches("[0-9]+");//только ли арабские цифры в правом операнде
        boolean levoR=levo.matches("[I,V,X]+");//только ли римские цифры в левом операнде
        boolean pravR=prav.matches("[I,V,X]+");//только ли римские цифры в правом операнде
        if (levop && pravR){throw new Exception("Выражение должно быть либо из арабских либо из римских чисел!");}
        if (pravop && levoR){throw new Exception("Выражение должно быть либо из арабских либо из римских чисел!");}
        if(levop && pravop){// проверка операндов (не должны быть больше 10)
            a = Integer.parseInt(levo.trim());
            b = Integer.parseInt(prav.trim());
            if (a>10 | b>10|a==0|b==0){throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");}
        }
        String rim[]={"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        int aRim=0,bRim=0,sr=0,resr=0,res=0;
        if (levoR &&pravR){// проверяем операнды на римские числа
            for ( sr=0;sr<10;sr++) {
                if (levo.equals(rim[sr])) {
                    aRim = sr + 1;
                }
                if (prav.equals(rim[sr])) {
                    bRim = sr +1;
                }
            } }
        if (levoR &&pravR){if (aRim==0 |bRim==0){throw new Exception("Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.");}}
        if (aRim!=0 && bRim!=0 && plus1==1){ resr=aRim+bRim;}
        if (aRim!=0 && bRim!=0 && mi1==1){  resr=aRim-bRim;
            if (resr<0){throw new Exception("т.к. ответ не может быть отрицательным");}
            }
        if (aRim!=0 && bRim!=0 && um1==1){ resr=aRim*bRim;}
        if (aRim!=0 && bRim!=0 && de1==1){ resr=aRim/bRim;}
        if (levop && pravop && plus1 == 1) {
            res = a + b;
            System.out.println(res);
        }
        if (levop && pravop && mi1 == 1) {
            res = a - b;
            System.out.println(res);
        }
        if (levop && pravop && um1 == 1) {
            res= a * b;
            System.out.println(res);
        }
        if (levop && pravop && de1 == 1) {
            res = a / b;
            System.out.println(res);
                }
        if (levoR &&pravR){
            String nRim= "";
            StringBuilder xxx= new StringBuilder(nRim);
            if (resr-100==0){nRim=nRim+"C";resr=resr-100;}
            if (resr-90>=0){nRim=nRim+"XC";resr=resr-90;}
            if (resr-50>=0){nRim=nRim+"L";resr=resr-50;}
            if (resr-40>=0){nRim=nRim+"XL";resr=resr-40;}
            if (resr-40>=0){nRim=nRim+"XL";resr=resr-40;}
            if (resr-10>=0){nRim=nRim+"X";resr=resr-10;}
            if (resr-10>=0){nRim=nRim+"X";resr=resr-10;}
            if (resr-10>=0){nRim=nRim+"X";resr=resr-10;}
            if (resr-9>=0){nRim=nRim+"IX";resr=resr-9;}
            if (resr-9>=0){nRim=nRim+"IX";resr=resr-9;}
            if (resr-5>=0){nRim=nRim+"V";resr=resr-5;}
            if (resr-5>=0){nRim=nRim+"V";resr=resr-5;}
            if (resr-4>=0){nRim=nRim+"IV";resr=resr-4;}
            if (resr-4>=0){nRim=nRim+"IV";resr=resr-4;}
            if (resr-1>=0){nRim=nRim+"I";resr=resr-1;}
            if (resr-1>=0){nRim=nRim+"I";resr=resr-1;}
            if (resr-1>=0){nRim=nRim+"I";resr=resr-1;}
                        System.out.println(nRim);

        }

        }
    }



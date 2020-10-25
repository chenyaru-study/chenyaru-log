/**
 * Created by c_chenyaru on 2020/10/18.
 */
public class StructureDemoMain {
    public static void main(String[] args) {
        StructureDemoMain structureDemoMain = new StructureDemoMain();
        structureDemoMain.multiplicationTable();
    }

    /**
     * ¾Å¾Å³Ë·¨±í
     */
    public void multiplicationTable(){
        for (int i=1; i<=9; i++){
            for (int j=1; j<=i; j++){
                System.out.print(i + "*" + j + "=" + i * j + "\t");
            }
            System.out.println("\n");
        }
    }

    /**
     *
     */

}
